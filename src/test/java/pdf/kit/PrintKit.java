package pdf.kit;

import com.google.common.collect.Lists;
import freemarker.template.utility.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.time.DateUtils;
import pdf.kit.component.PDFHeaderFooter;
import pdf.kit.component.PDFKit;
import pdf.kit.component.chart.ScatterPlotChart;
import pdf.kit.component.chart.impl.DefaultLineChart;
import pdf.kit.component.chart.model.XYLine;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ray.wang
 */
@Slf4j
public class PrintKit {

    public  String createPDF(String templatePath,Object data, String fileName){
        //pdf保存路径
        try {
            //设置自定义PDF页眉页脚工具类
            PDFHeaderFooter headerFooter=new PDFHeaderFooter();
            PDFKit kit=new PDFKit();
            kit.setHeaderFooterBuilder(headerFooter);
            //设置输出路径
            kit.setSaveFilePath(templatePath+fileName);

            String saveFilePath=kit.exportToFile(fileName,data);
            return  saveFilePath;
        } catch (Exception e) {
            log.error("PDF生成失败{}", ExceptionUtils.getFullStackTrace(e));
            return null;
        }

    }

    public static void main(String[] args) {
        PrintKit kit=new PrintKit();
        PickingBO templateBO=new PickingBO();
        templateBO.setTitle("拣货单");
        templateBO.setImageUrl("https://i1.wp.com/www.lovemybaby.com.tw/wp-content/uploads/2017/08/WEBLOGO-e1503294289334.png");
        templateBO.setDatetime(new Date().toString());
        PickingDetail p;
        List<PickingDetail> pickingDetails = Lists.newArrayList();
        for (int i = 0; i < 200; i++) {
            p = new PickingDetail();
            p.setBatchNo("123456"+i);
            p.setCargoNo("10-29-3"+i);
            p.setInventory("20"+i);
            p.setPickingDetail(i + "(1)");
            p.setQuantity(1);
            p.setSkuNo("20-23-"+i);
            p.setSpecification("Red/xl");
            pickingDetails.add(p);
        }
        templateBO.setDetails(pickingDetails);

        String templatePath="/Users/raywang/Downloads/";
        String path= kit.createPDF(templatePath,templateBO,"pickingList.pdf");
        System.out.println(path);
    }
}

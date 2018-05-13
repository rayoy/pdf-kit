package pdf.kit;

import lombok.Data;

@Data
public class PickingDetail {
    private String batchNo;		// 批次号
    private String cargoNo;		// 货架编号
    private String skuNo;		// 商家编码
    private String specification;		// 规格属性
    private Integer quantity;		// 数量
    private String inventory;		// 库存
    private String pickingDetail;		// 拣货明细
}

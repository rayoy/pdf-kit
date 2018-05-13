package pdf.kit;

import lombok.Data;

import java.util.List;

@Data
public class PickingBO {
    private String title;
    private String imageUrl;
    private String datetime;
    private List<PickingDetail> details;
}

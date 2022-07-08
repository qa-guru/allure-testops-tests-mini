package models.lombok.testcase.create.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Layer {
    private Integer createdDate;
    private Integer lastModifiedDate;
    private String createdBy;
    private String lastModifiedBy;
    private String name;
    private Integer id;
}

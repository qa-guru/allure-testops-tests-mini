package models.lombok.testcase.create.request;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Workflow {
    private Integer createdDate;
    private Integer lastModifiedDate;
    private String createdBy;
    private String lastModifiedBy;
    private String name;
    private List<StatusesItem> statuses;
    private Integer id;
}
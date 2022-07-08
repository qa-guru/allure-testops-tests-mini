package models.lombok.testcase.create.request;

import lombok.Data;

@Data
public class StatusesItem {
    private Integer createdDate;
    private String color;
    private Integer lastModifiedDate;
    private String createdBy;
    private String lastModifiedBy;
    private String name;
    private Integer id;
}

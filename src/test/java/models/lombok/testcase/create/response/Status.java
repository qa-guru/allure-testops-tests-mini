package models.lombok.testcase.create.response;

import lombok.Data;

@Data
public class Status{
	private Long createdDate;
	private String color;
	private Long lastModifiedDate;
	private String createdBy;
	private String lastModifiedBy;
	private String name;
	private Integer id;
}

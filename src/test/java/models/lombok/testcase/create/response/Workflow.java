package models.lombok.testcase.create.response;

import lombok.Data;

import java.util.List;

@Data
public class Workflow{
	private Long createdDate;
	private Long lastModifiedDate;
	private String createdBy;
	private String lastModifiedBy;
	private String name;
	private List<StatusesItem> statuses;
	private Integer id;
}
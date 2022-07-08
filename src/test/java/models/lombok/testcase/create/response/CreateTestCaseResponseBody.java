package models.lombok.testcase.create.response;

import lombok.Data;

import java.util.List;

@Data
public class CreateTestCaseResponseBody {
	private Workflow workflow;
	private Long lastModifiedDate;
	private Boolean editable;
	private String lastModifiedBy;
	private String fullName;
	private String description;
	private String precondition;
	private Boolean automated;
	private Boolean external;
	private String preconditionHtml;
	private Boolean deleted;
	private Long createdDate;
	private String expectedResult;
	private String createdBy;
	private String expectedResultHtml;
	private String name;
	private String descriptionHtml;
	private String style;
	private List<LinksItem> links;
	private Integer id;
	private Integer projectId;
	private Status status;
}
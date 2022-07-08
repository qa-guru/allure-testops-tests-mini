package models.lombok.testcase.create.request;

import com.google.gson.Gson;
import lombok.Data;

import java.util.List;

@Data
public class CreateTestCaseRequestBody {
    private String description;
    private Layer layer;
    private String expectedResultHtml;
    private List<LinksItem> links;
    private Integer id;
    private Workflow workflow;
    private Integer lastModifiedDate;
    private Boolean editable;
    private String lastModifiedBy;
    private String fullName;
    private String precondition;
    private List<TagsItem> tags;
    private Boolean automated;
    private Boolean external;
    private String preconditionHtml;
    private Boolean deleted;
    private Integer createdDate;
    private String expectedResult;
    private String createdBy;
    private String name;
    private String descriptionHtml;
    private String style;
    private String projectId;
    private String hash;
    private Status status;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
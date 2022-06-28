package models.lombok;

import lombok.Data;

@Data
public class TestCaseTreeLeafResponseBodyLombok {

    private Boolean automated;
    private Boolean external;
    private Long createdDate;
    private String statusColor;
    private String name;
    private String statusName;
    private Integer id;

    @Override
    public String toString() { // todo improve
        return "{\"name\":\"" + name + "\"}";
    }
}

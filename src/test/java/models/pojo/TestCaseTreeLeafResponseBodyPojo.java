package models.pojo;

public class TestCaseTreeLeafResponseBodyPojo {

    private Boolean automated;
    private Boolean external;
    private Long createdDate;
    private String statusColor;
    private String name;
    private String statusName;
    private Integer id;

    public Boolean getAutomated() {

        return automated;

    }

    public void setAutomated(Boolean automated) {

        this.automated = automated;

    }

    public Boolean getExternal() {

        return external;

    }

    public void setExternal(Boolean external) {

        this.external = external;

    }

    public Long getCreatedDate() {

        return createdDate;

    }

    public void setCreatedDate(Long createdDate) {

        this.createdDate = createdDate;

    }

    public String getStatusColor() {

        return statusColor;

    }

    public void setStatusColor(String statusColor) {

        this.statusColor = statusColor;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getStatusName() {

        return statusName;

    }

    public void setStatusName(String statusName) {

        this.statusName = statusName;

    }

    public Integer getId() {

        return id;

    }

    public void setId(Integer id) {

        this.id = id;

    }

    @Override
    public String toString() { // todo improve
        return "{\"name\":\"" + name + "\"}";
    }
}

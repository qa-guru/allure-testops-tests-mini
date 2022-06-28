package models.pojo;

import lombok.Data;

@Data
public class TestCaseTreeLeafRequestBodyPojo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\"}";
    }
}
package models.lombok;

import lombok.Data;

@Data
public class TestCaseTreeLeafRequestBodyLombok {
    private String name;

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\"}";
    }
}

package org.library.demo.dtos;

import org.library.demo.models.TypeTitle;
import org.springframework.stereotype.Component;

@Component
public class TitleDto {

    private String titleId;
    private String name;
    private TypeTitle type;

    public TitleDto() {
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeTitle getType() {
        return type;
    }

    public void setType(TypeTitle type) {
        this.type = type;
    }
}

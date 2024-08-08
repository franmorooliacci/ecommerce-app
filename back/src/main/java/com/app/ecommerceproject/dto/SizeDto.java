package com.app.ecommerceproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeDto {

    private int id;
    private String description;

    public SizeDto(int id, String description) {
        this.id = id;
        this.description = description;
    }
}

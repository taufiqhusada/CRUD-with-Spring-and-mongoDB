package com.demo.company.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    public static final String FIELD_ADDR_NAME = "addressName";
    public static final String FIELD_ADDR = "address";
    public static final String FIELD_CITY = "city";

    @Field(value = Address.FIELD_ADDR_NAME)
    private String addressName;

    @Field(value = Address.FIELD_ADDR)
    private String address;

    @Field(value = Address.FIELD_CITY)
    private String city;

}
package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Address {

    @JsonProperty("street")
    private String street;
    @JsonProperty("post_office")
    private String postOffice;
    @JsonProperty("post_code")
    private int postCode;
}

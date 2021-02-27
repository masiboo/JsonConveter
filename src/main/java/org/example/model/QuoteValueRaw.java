package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class QuoteValueRaw {
    @JsonProperty("tLabel")
    private String tLabel;
    private String value;
}

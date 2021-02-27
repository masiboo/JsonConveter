package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class QuoteRaw {
    @JsonProperty("date_applied")
    private Long dateApplied;
    @JsonProperty("personal_info")
    private PersonalInfo personalInfo;
    @JsonProperty("values")
    private List<QuoteValueRaw> quoteValues;
}

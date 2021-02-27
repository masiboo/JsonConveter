package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QuoteValue {
    Integer hour;
    Integer order;
    Double netVolume;
    Double price;
}

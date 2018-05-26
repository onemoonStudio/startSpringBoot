package com.startsb.webservice.domain;

import lombok.Data;
import lombok.ToString;

@Data
// data 는 확실히 편리 하지만 ORM에서 주의 해야 한다!
@ToString(exclude = {"val3"})
public class Sample2 {
    private String val1;
    private String val2;
    private String val3;
}

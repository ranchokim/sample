package com.neibus.model.member;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UnNickname implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idx;
    private String nickNm;
    private String type;
}

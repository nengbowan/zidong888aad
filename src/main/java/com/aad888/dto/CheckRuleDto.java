package com.aad888.dto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckRuleDto {
    private String uid;

    private String gtype;

    private String pageSize;


}

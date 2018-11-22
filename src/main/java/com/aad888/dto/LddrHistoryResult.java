package com.aad888.dto;
import lombok.*;



//{"start":"left","stairs":"4","end":"odd"} odd 奇数
//{"start":"left","stairs":"3","end":"even"} even 偶数


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LddrHistoryResult {

    private String start;

    private String stairs;

    private String end;
}

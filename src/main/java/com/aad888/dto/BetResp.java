package com.aad888.dto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetResp {
    private boolean result;

    private String remain_balance;
}

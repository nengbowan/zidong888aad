package com.aad888.dto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LddrUserResp {
    private String user_name;
    private LddrUserBalanceResp balance;
    private String payway;
}

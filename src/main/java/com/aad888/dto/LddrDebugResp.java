package com.aad888.dto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LddrDebugResp {
    private String line ;

    private String opening_game;

    private String next_game;
    private String recent_game;
    private String game_switch;
    private String odds;
    private String disable_odds;
    private String user;

    private String distribution;
}

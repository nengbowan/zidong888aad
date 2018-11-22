package com.aad888.dto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LddrResp {

    private Float server_time;

    private Integer timezone_offset;

    private String line;

    private LddrDebugResp debug;

    private LddrNextGameResp next_game;

    private LddrNextGameResp recent_game;
    private String game_switch;

    private LddrUserResp user;

    private String execute_time;

    private LddrOpeningGameResp opening_game;

}

package com.aad888.dto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LddrOpeningGameResp {
    private String game_id;
    private String num;
    private String type;
    private String state;
    private String result;
    private String open_timestamp;
    private String close_timestamp;
    private String official_open_timestamp;
    private String official_close_timestamp;
    private String official_result_timestamp;
    private String created_at;
    private String result_time;
}

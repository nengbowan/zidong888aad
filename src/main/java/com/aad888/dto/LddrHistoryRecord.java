package com.aad888.dto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LddrHistoryRecord {

    private String game_id;

    private String num;

    private String num_alias;

    private LddrHistoryResult result;

    private String state;

    private LddrHistoryDistribution distribution;
}

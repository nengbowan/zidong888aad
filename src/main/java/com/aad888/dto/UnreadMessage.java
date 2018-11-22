package com.aad888.dto;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnreadMessage {
    private String message;

    private String status;

    private String maintain;

    private Integer Number;

    private String IsReset;
}

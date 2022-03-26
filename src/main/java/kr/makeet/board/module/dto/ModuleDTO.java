package kr.makeet.board.module.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class ModuleDTO {
    private Long bno;
    private String first;
    private String last;
    private LocalDateTime regTime;
}

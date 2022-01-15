package kr.co.thysoft.thyme.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
//builder 메서드를 이용해서 생성 가능
@Builder(toBuilder = true)
public class SampleVO {
    private Long sno;
    private String first;
    private String last;
    private LocalDateTime regTime;


}

package kr.co.thysoft.thyme.controller;

import kr.co.thysoft.thyme.domain.SampleVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Controller
public class SampleController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute(
                "data","helloThyme"
        );
        return "home";
    }
    @GetMapping("/ex")
    public String ex(Model model){
        List<SampleVO> list = new ArrayList<>();
        for(int i=0; i<20; i++){
            SampleVO vo = SampleVO.builder()
                    .first("First - "+ i)
                    .last("Last -" +i)
                    .sno(Long.valueOf(i))
                    .regTime(LocalDateTime.now())
                    .build();
            list.add(vo);
        }
        model.addAttribute("list",list);
        return "ex";
    }
}
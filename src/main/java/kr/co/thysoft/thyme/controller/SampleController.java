package kr.co.thysoft.thyme.controller;

import kr.co.thysoft.thyme.domain.SampleVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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
    @GetMapping("/inline")
    public String inline(Model model, HttpSession session
                         , RedirectAttributes rattr){
        SampleVO vo = SampleVO.builder()
                .sno(100L)
                .first("daj")
                .last("soft")
                .regTime(LocalDateTime.now())
                .build();
        //모델은 포워딩 할 대 사용
        model.addAttribute("vo",vo);
        //이 경우는 세션이 소멸되거나 강제로 삭제할 때까지 유지
        session.setAttribute("vo1",vo);
        //한번의 이동에서만 데이터를 유지 - 자동 소멸
        rattr.addFlashAttribute("vo2",vo);
        return "redirect:ex1";
    }
    @GetMapping("/ex1")
    public String ex1(){

        return "ex1";
    }
}
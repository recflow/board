package kr.makeet.board.module.controller;

import kr.makeet.board.module.dto.ModuleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/module")
@Log4j2
public class ModuleController {
    @GetMapping("/ex1")
    public void ex1() {
        log.info("ex1....");
    }

    @GetMapping({"/ex2", "/exLink"})
    public void exModel1(Model model) {
        List<ModuleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i ->
                ModuleDTO.builder()
                        .bno(i)
                        .first("First..." + i)
                        .last("Last..." + i)
                        .regTime(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
        model.addAttribute("list", list);
    }
    /* * * * * * * *
    *   Page 96    *
    * * * * * * * */
    @GetMapping({"/exInline"})
    public String exInline(RedirectAttributes redirectAttributes) {
        log.info("exInline...........");
        ModuleDTO dto = ModuleDTO.builder()
                .bno(100L)
                .first("First...100")
                .last("Last...100")
                .regTime(LocalDateTime.now())
                .build();
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);
        return "redirect:/module/ex3";
    }
    @GetMapping("/ex3")
    public void ex3(){
        log.info("ex3");
    }

    @GetMapping("/exLayout1")
    public void exLayout1(){
        log.info("exLayout.........");
    }
}
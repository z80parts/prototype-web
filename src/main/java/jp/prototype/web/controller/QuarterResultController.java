package jp.prototype.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.prototype.domain.model.QuarterResult;
import jp.prototype.domain.service.QuarterResultService;
import lombok.AllArgsConstructor;

@RequestMapping("/quarter_result")
@AllArgsConstructor
@Controller
public class QuarterResultController {

  private QuarterResultService service;

  @GetMapping("/")
  String index(Model model, Pageable pageable) {
    return "/quarter_result/search";
  }

  @GetMapping("/search")
  String search(Model model, Pageable pageable) {

//    QuarterResult entity = new QuarterResult();
//    Page<QuarterResult> page = service.find(entity, pageable);
    Page<QuarterResult> page = service.findAll(pageable.getPageNumber(), 30);
    model.addAttribute("page", page);
    model.addAttribute("quaterResults", page.getContent());
    return "/quarter_result/search";
  }

}

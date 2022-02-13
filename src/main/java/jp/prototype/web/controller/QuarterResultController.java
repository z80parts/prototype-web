package jp.prototype.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.prototype.domain.model.QuarterResult;
import jp.prototype.domain.service.QuarterResultService;
import jp.prototype.web.controller.form.QuarterResultSearchForm;
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
  String search(@ModelAttribute("quarterResultSearchForm") QuarterResultSearchForm form,
          Model model, Pageable pageable) {

    QuarterResult entity = new QuarterResult();
    entity.setCode(form.getCode());
    entity.setName(form.getName());

    Page<QuarterResult> page = service.find(entity, pageable);
    model.addAttribute("page", page);
    model.addAttribute("quaterResults", page.getContent());
    return "/quarter_result/search";
  }

}

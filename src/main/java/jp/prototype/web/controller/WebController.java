package jp.prototype.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.prototype.common.model.Company;
import jp.prototype.common.service.CompanyService;
import jp.prototype.web.controller.form.InputForm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class WebController {

  private CompanyService service;

  @GetMapping(value = "/index")
  public String index() {
    return "index";
  }

  @GetMapping(value = "/companies")
  public ModelAndView showCompanies() {

    final List<Company> companies = service.find();

    final Map<String, Object> params = new HashMap<>();
    params.put("companies", companies);

    return new ModelAndView("companies", params);
  }

  @GetMapping(value = "/input")
  public String input(final Model model) {
    final InputForm form = new InputForm();
    model.addAttribute(form);
    return "input";
  }

  @PostMapping(value = "/echo")
  public String echo(@Valid final InputForm form, final BindingResult result) {
    String str = null;
    str.toLowerCase();
    if (result.hasErrors()) {
      return "input";
    }
    return "echo";
  }

}

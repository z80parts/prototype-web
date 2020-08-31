package jp.prototype.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.prototype.common.model.Company;
import jp.prototype.common.service.CompanyService;
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

    List<Company> companies = service.find();

    Map<String, Object> params = new HashMap<>();
    params.put("companies", companies);

    return new ModelAndView("companies", params);
  }

  @GetMapping(value = "/input")
  public String input() {
    return "input";
  }

}

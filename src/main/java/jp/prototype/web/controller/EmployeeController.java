package jp.prototype.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.prototype.domain.model.Employee;
import jp.prototype.domain.service.EmployeeService;
import jp.prototype.web.controller.form.EmployeeForm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/employee")
@SessionAttributes(types = EmployeeForm.class)
public class EmployeeController {

  private EmployeeService service;

  @ModelAttribute("")
  public EmployeeForm createForm() {
    return new EmployeeForm();
  }

  @GetMapping(value = "/list")
  public ModelAndView list() {
    List<Employee> employees = service.findAll();
    final Map<String, Object> params = new HashMap<>();
    params.put("employees", employees);
    return new ModelAndView("employee/list", params);
  }

  @GetMapping(value = "/{id}")
  public ModelAndView get(@PathVariable("id") String id) {
    Employee employee = service.get(id);
    final Map<String, Object> params = new HashMap<>();
    params.put("employee", employee);
    return new ModelAndView("employee/detail", params);
  }

  @GetMapping(value = "/register")
  public String input(EmployeeForm form) {
    return "employee/register/input";
  }

  @PostMapping(value = "/register/confirm")
  public String input(@Validated EmployeeForm form, BindingResult result,
          RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      return "employee/register/input";
    }
    return "employee/register/confirm";
  }

  @GetMapping(value = "/register/redo")
  public String redo() {
    return "employee/register/input";
  }

  @PostMapping(value = "/register/execute")
  public String create(@Validated EmployeeForm form) {
//    public String create(@Validated EmployeeForm form, BindingResult result,
//            RedirectAttributes redirectAttributes) {
    System.out.println(form.getName());
    return "redirect:complete";
  }

  @GetMapping(value = "/register/complete")
  public String complete(SessionStatus sessionStatus) {
    sessionStatus.setComplete();
    return "employee/register/complete";
  }

}

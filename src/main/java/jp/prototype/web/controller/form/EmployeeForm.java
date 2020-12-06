package jp.prototype.web.controller.form;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EmployeeForm implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotBlank
  private String name;

  private String jobCd;

  private String deptId;

//  @NotNull
  private LocalDate hireDate;

  private LocalDate retireDate;

}

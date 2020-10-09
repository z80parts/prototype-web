package jp.prototype.web.controller.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class InputForm implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotBlank
  public String text;

}

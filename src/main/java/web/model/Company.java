package web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nikkei")
public class Company {

  @Id
  private String code;

  private String name;

  private String category;

}

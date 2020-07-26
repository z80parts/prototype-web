package web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import web.model.Company;
import web.repository.CompanyRepository;

@AllArgsConstructor
@Service
public class CompanyService {

  private CompanyRepository repository;

  public List<Company> find() {

    return repository.findAll();
  }
}

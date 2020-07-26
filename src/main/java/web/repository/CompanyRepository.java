package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {
// <==> CrudRepository JpaRepository
  
//  List<Company> findAll();
//
//  Company findByCode(String code);
}

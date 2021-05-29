package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}

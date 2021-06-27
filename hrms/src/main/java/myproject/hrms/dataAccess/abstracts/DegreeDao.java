package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.Degree;

public interface DegreeDao extends JpaRepository<Degree, Integer> {

}

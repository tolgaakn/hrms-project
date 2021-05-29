package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.ConfirmByEmployee;

public interface ConfirmByEmployeeDao extends JpaRepository<ConfirmByEmployee, Integer> {

	ConfirmByEmployee findByEmployerId(int employerId);
}

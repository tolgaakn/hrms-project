package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.AdvertisementConfirmByEmployee;

public interface AdvertisementConfirmByEmployeeDao extends JpaRepository<AdvertisementConfirmByEmployee, Integer> {
	AdvertisementConfirmByEmployee getByAdvertisementId(int advertisementId);
}

package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}

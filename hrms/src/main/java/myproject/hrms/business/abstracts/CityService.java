package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
}

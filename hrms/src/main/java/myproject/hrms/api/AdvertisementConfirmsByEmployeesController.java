package myproject.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.business.abstracts.AdvertisementConfirmByEmployeeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.entities.concretes.AdvertisementConfirmByEmployee;

@RestController
@RequestMapping("/api/advertisementConfirmsByEmployees")
@CrossOrigin
public class AdvertisementConfirmsByEmployeesController {

	private AdvertisementConfirmByEmployeeService advertisementConfirmByEmployeeService;

	@Autowired
	public AdvertisementConfirmsByEmployeesController(
			AdvertisementConfirmByEmployeeService advertisementConfirmByEmployeeService) {
		super();
		this.advertisementConfirmByEmployeeService = advertisementConfirmByEmployeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<AdvertisementConfirmByEmployee>> getAll(){
		return advertisementConfirmByEmployeeService.getAll();
	}
	
	@GetMapping("/activateAdvertisement")
	public Result activateAdvertisement(@RequestParam int advertisementId, @RequestParam int employeeId) {
		return advertisementConfirmByEmployeeService.activateAdvertisement(advertisementId, employeeId);
	}
	
}

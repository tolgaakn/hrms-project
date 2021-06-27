package myproject.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.hrms.business.abstracts.ActivationCodeService;
import myproject.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activateuser")
@CrossOrigin
public class ActivationCodesController {

	private ActivationCodeService activationCodeService;

	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	
	@GetMapping("/activate/{activationCode}")
	public Result activateUser(@PathVariable String activationCode) {
		return activationCodeService.activateUser(activationCode);
	}
}

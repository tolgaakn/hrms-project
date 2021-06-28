package myproject.hrms.business.abstracts;

import java.util.List;

import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getAll();
}

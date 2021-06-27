package myproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.hrms.business.abstracts.DegreeService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.dataAccess.abstracts.DegreeDao;
import myproject.hrms.entities.concretes.Degree;

@Service
public class DegreeManager implements DegreeService {

	private DegreeDao degreeDao;
	
	@Autowired
	public DegreeManager(DegreeDao degreeDao) {
		super();
		this.degreeDao = degreeDao;
	}


	@Override
	public DataResult<List<Degree>> getAll() {
		return new SuccessDataResult<List<Degree>>(this.degreeDao.findAll());
	}
	
}

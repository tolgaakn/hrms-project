package myproject.hrms.business.concretes;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import myproject.hrms.business.abstracts.CurriculumVitaeService;
import myproject.hrms.core.utilities.helpers.imageHelper.ImageService;
import myproject.hrms.core.utilities.results.DataResult;
import myproject.hrms.core.utilities.results.Result;
import myproject.hrms.core.utilities.results.SuccessDataResult;
import myproject.hrms.core.utilities.results.SuccessResult;
import myproject.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import myproject.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private ImageService imageService;
	long millis = System.currentTimeMillis();
	Date date = new Date(millis);
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, ImageService imageService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		
		curriculumVitae.setCreatedDate(date);
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("CV eklendi.");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "CV'ler listelendi.");
	}

	@Override
	public Result addImage(int id, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.getOne(id);
		curriculumVitae.setImagePath(result.get("url"));
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Image Added!");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.getByCandidateId(candidateId));
	}

	@Override
	public DataResult<CurriculumVitae> getById(int id) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getById(id));
	}



}

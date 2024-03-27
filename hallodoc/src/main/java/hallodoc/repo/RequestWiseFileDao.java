package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.RequestWiseFile;

@Repository
public class RequestWiseFileDao {
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void requestWiseFileSave(RequestWiseFile requestWiseFile) {
		template.save(requestWiseFile);
	}
	

}

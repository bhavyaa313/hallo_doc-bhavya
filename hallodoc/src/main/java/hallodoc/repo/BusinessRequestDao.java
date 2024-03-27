package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.RequestBusiness;

@Repository
public class BusinessRequestDao {

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void businessSave(RequestBusiness requestBusiness) {
		template.save(requestBusiness);
	}

}

package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Business;

@Repository
public class BusinessDao {
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void businessSave(Business business) {
		template.save(business);
	}
	
	@Transactional
	public void businessUpdate(Business business) {
		template.update(business);
	}
	

}

package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import hallodoc.model.RequestConcierge;

@Repository
public class RequestConciergeDao {
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void requestConciergeSave(RequestConcierge requestConcierge) {
		template.save(requestConcierge);
	}
	

}

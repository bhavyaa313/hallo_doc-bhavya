package hallodoc.repo;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Concierge;


@Repository
public class CoincergeDao {

	@Autowired
	private HibernateTemplate template;
	
	
	
	@Transactional
	public void conciergedaoSave(Concierge concierge) {
		template.save(concierge);
	}
	
	@Transactional
	public void conciergedaoUpdate(Concierge concierge) {
		template.update(concierge);
	}
	
}

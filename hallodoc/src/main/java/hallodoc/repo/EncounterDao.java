package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.EncounterForm;
import hallodoc.model.HealthProfessionals;
import hallodoc.model.Request;

@Repository
public class EncounterDao {
	

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void encounterFormUpdate(EncounterForm encounterForm) {
		template.update(encounterForm);
	}
	
	@Transactional
	public void EncounterSave(EncounterForm encounterForm) {
		template.save(encounterForm);
	}

	
	public List getformList(Request rId) {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.EncounterForm E where requestId=:rId";
				
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);
		List list = query.list();
		System.out.println(list);
		
		return list;


}
}

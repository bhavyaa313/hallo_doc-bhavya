package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.util.Removal;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.HealthProfessionalType;
import hallodoc.model.HealthProfessionals;
import hallodoc.model.Request;

@Repository
public class HealthProfessionalsDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void healthProfessionalsUpdate(HealthProfessionals healthProfessionals) {
		template.update(healthProfessionals);
	}
	
	@Transactional
	public void healthProfessionalsSave(HealthProfessionals healthProfessionals) {
		template.save(healthProfessionals);
	}

	
	public List getProfessionalsList(int typeId) {

		Session session = sessionFactory.openSession();

		
		String hqlString = "select P.vendorId, P.vendorName, P.faxNumber, P.email, P.businessContact from hallodoc.model.HealthProfessionals P where profession=:typeId and isDeleted=0";
				
		Query query = session.createQuery(hqlString);
		query.setParameter("typeId", typeId);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}
	
	public List<HealthProfessionals> getProfessionalsList1(int Id) {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.HealthProfessionals where vendorId=:Id";
				
		Query query = session.createQuery(hqlString);
		query.setParameter("Id", Id);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}
	
	public List<HealthProfessionalType> getProfessionalstype(int Id) {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.HealthProfessionalType where healthProfessionalId=:Id";
				
		Query query = session.createQuery(hqlString);
		query.setParameter("Id", Id);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}
	
	public List<HealthProfessionals> getProfessionalsList2() {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.HealthProfessionals where isDeleted=0 ";
				
		Query query = session.createQuery(hqlString);
		
		List list = query.list();
		System.out.println(list);
		
		return list;

	}
	

}

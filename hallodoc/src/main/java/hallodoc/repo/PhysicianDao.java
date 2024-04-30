package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Physician;
import hallodoc.model.Request;



@Repository
public class PhysicianDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	
	
	

	@Transactional
	public void physicianSave(Physician physician) {
		template.save(physician);
	}

	@Transactional
	public void physicianUpdate(Physician physician) {
		template.update(physician);
	}
	
	public List getPhysicians(int rId) {

		Session session = sessionFactory.openSession();

		System.out.println("requestsssssssssssss");
		System.out.println(rId);
		String hqlString = "select P.firstName, P.lastName, P.physicianId from hallodoc.model.Physician P where P.regionId=:rId";
				
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}
	
	public List<Physician> getPhysiciansAll(int pId) {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.Physician where physicianId=:pId";
				
		Query query = session.createQuery(hqlString);
		query.setParameter("pId", pId);
		List<Physician> list = query.list();
		System.out.println(list);
		
		return list;

	}
	
	public List<Physician> getPhysiciansAll() {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.Physician ";
				
		Query query = session.createQuery(hqlString);
		
		List<Physician> list = query.list();
		System.out.println(list);
		
		return list;

	}
	

}

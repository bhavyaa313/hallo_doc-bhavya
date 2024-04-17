package hallodoc.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class PhysicianDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	
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
	
	public List getPhysiciansAll(int pId) {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.Physician where physicianId=:pId";
				
		Query query = session.createQuery(hqlString);
		query.setParameter("pId", pId);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}
	

}

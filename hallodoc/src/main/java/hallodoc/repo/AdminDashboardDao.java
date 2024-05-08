package hallodoc.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Request;
import hallodoc.model.User;

@Repository
public class AdminDashboardDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	
	
	public List getRequests() {

		Session session = sessionFactory.openSession();

		System.out.println("requests");
		
		String hqlString = "from hallodoc.model.Request A where isDeleted=0 ";
		Query query = session.createQuery(hqlString);
		
		List list = query.list();
		System.out.println(list);
		
		return list;

	}
	
	
	public List getRequestsByphyID(int phyID) {

		Session session = sessionFactory.openSession();

		System.out.println("requests");
		
		String hqlString = "from hallodoc.model.Request A where A.isDeleted=0 and A.physicianId.physicianId=:phyID ";
		Query query = session.createQuery(hqlString);
		query.setParameter("phyID", phyID);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}
	
	
	
	public List getRequestClients(Request rId ) {
		
		Session session = sessionFactory.openSession();
		String hqlString = "from hallodoc.model.RequestClient A where A.requestId=:rId";
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);
		
		List list = query.list();
		System.out.println(list);
		
		return list;
		
		
	}

}

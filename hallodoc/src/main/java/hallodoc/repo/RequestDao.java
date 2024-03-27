package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Request;


@Repository
public class RequestDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void requestSave(Request request) {
		template.save(request);
	}
	
	public List getRequests(int uId) {

		Session session = sessionFactory.openSession();

		System.out.println("requestsssssssssssss");
		System.out.println(uId);
		String hqlString = "SELECT A.createdDate, A.firstName from hallodoc.model.Request A where A.userId=:uId";
		Query query = session.createQuery(hqlString);
		query.setParameter("uID", uId);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}

	

}

package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Request;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;

@Repository
public class RequestWiseFileDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void requestWiseFileSave(RequestWiseFile requestWiseFile) {
		template.save(requestWiseFile);
	}
	
	@Transactional
	public void requestWiseFileUpdate(RequestWiseFile requestWiseFile) {
		template.update(requestWiseFile);
	}
	
	public List getRequestsWiseFileList(Request rId) {

		Session session = sessionFactory.openSession();

		System.out.println("requestsssssssssssss");
		System.out.println(rId);
		String hqlString = "from hallodoc.model.RequestWiseFile A where A.requestId=:rId";
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}

	

}

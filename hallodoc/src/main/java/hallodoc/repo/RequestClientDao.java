package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.User;

@Repository
public class RequestClientDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	


	@Transactional
	public void requestClientSave(RequestClient requestClient) {
		template.save(requestClient);
	}
	
	@Transactional
	public void requestClientUpdate(RequestClient requestClient) {
		template.update(requestClient);
	}
	
	
	public List getRequests(Request rId) {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.RequestClient A where A.requestId=:rId ";
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);
		List list = query.list();
		System.out.println(list);
		
		return list;

	}

}

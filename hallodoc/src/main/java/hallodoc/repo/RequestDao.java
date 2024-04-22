package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Request;
import hallodoc.model.User;

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

	@Transactional
	public void requestUpdate(Request request) {
		template.update(request);
	}

	public List getRequests(User uId) {

		Session session = sessionFactory.openSession();

		System.out.println("requestsssssssssssss");
		System.out.println(uId);
		String hqlString = "from hallodoc.model.Request A where A.userId=:uId";
		Query query = session.createQuery(hqlString);
		query.setParameter("uId", uId);
		List list = query.list();
		System.out.println(list);

		return list;

	}

	public List getRequestss(User uId) {

		Session session = sessionFactory.openSession();

		System.out.println("requestsssssssssssss");
		System.out.println(uId);
		String hqlString = "from hallodoc.model.Request A where A.userId=:uId and A.requestTypeId=2";
		Query query = session.createQuery(hqlString);
		query.setParameter("uId", uId);
		List list = query.list();
		System.out.println(list);

		return list;

	}

	public List<Request> getRequests(int rId) {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.Request A where A.requestId=:rId";
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);
		List<Request> list = query.list();
		System.out.println(list);

		return list;

	}

	public List<Request> getRequests() {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.Request ";
		Query query = session.createQuery(hqlString);

		List<Request> list = query.list();
		System.out.println(list);

		return list;

	}

	public List<Request> getRequestsByRequestType(String sql) {

		Session session = sessionFactory.openSession();

		String hqlString = sql;
		Query query = session.createQuery(hqlString);
		List<Request> list = query.list();
		System.out.println(list);

		return list;

	}

}

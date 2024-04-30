package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.EmailLog;
import hallodoc.model.Request;
import hallodoc.model.RequestNotes;
import hallodoc.model.RequestStatusLog;

@Repository
public class RequestStatusLogDao {

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void requestStatusLogSave(RequestStatusLog requestStatusLog) {
		template.save(requestStatusLog);
	}

	public List<RequestStatusLog> getRequests(Request rId) {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.RequestStatusLog A where A.requestId=:rId ";
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);
		List<RequestStatusLog> list = query.list();
		System.out.println(list);

		return list;

	}

	public List<RequestStatusLog> getRequestStatusLogsAdmin(Request rId) {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.RequestStatusLog A where A.requestId=:rId and status=3";
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);

		List<RequestStatusLog> list = query.list();
		System.out.println(list);

		return list;

	}
	
	public List<RequestStatusLog> getRequestStatusLogsPatient(Request rId) {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.RequestStatusLog A where A.requestId=:rId and status=7";
		Query query = session.createQuery(hqlString);
		query.setParameter("rId", rId);

		List<RequestStatusLog> list = query.list();
		System.out.println(list);

		return list;

	}

}

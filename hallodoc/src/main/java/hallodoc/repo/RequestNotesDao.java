package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Request;
import hallodoc.model.RequestNotes;


@Repository
public class RequestNotesDao {
	
@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void requestNotesSave(RequestNotes requestNotes ) {
		template.save(requestNotes);
	}
	
	@Transactional
	public void businessUpdate(RequestNotes requestNotes ) {
		template.update(requestNotes);
	}
	

	public List<RequestNotes> getRequests(int reqId) {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.RequestNotes A where A.requestId.requestId=:reqId";
		Query query = session.createQuery(hqlString);
		query.setParameter("reqId", reqId);
		List<RequestNotes> list = query.list();
		System.out.println(list);
		session.close();
		return list;

	}
	


}

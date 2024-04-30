package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.EmailLog;

@Repository
public class EmailLogDao {

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void emailLogSave(EmailLog emailLog) {
		template.save(emailLog);
	}

	public List<EmailLog> getLogs(String sql) {

		Session session1 = sessionFactory.openSession();

		Query query = session1.createQuery(sql);
		List<EmailLog> list = query.list();
		session1.close();
		return list;

	}

}

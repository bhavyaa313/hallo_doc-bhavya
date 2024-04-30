package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.EmailLog;
import hallodoc.model.SMSLog;

@Repository
public class SMSLogDao {
	

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void SMSLogSave(SMSLog smsLog) {
		template.save(smsLog);
	}
	
	public List<SMSLog> getLogs(String sql) {

		Session session1 = sessionFactory.openSession();

		
		Query query = session1.createQuery(sql);
		List<SMSLog> list = query.list();
		session1.close();
		return list;

	}

}

package hallodoc.repo;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.EmailLog;


@Repository
public class EmailLogDao {
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void emailLogSave(EmailLog emailLog) {
		template.save(emailLog);
	}
	
	
	

}

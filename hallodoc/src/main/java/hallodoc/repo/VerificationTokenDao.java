package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Request;
import hallodoc.model.VerificationToken;

@Repository
public class VerificationTokenDao {
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void verificationTokenSave(VerificationToken verificationToken) {
		template.save(verificationToken);
	}
	
	@Transactional
	public void verificationTokenUpdate(VerificationToken verificationToken) {
		template.update(verificationToken);
	}
	
	
	
	


}

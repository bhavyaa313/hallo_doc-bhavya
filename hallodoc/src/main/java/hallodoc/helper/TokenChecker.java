package hallodoc.helper;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TokenChecker {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List checkMailStatusList(String email) {
		Session session = sessionFactory.openSession();
		String hqlString = "from hallodoc.model.VerificationToken where email = :email";
		Query query = session.createQuery(hqlString);
		query.setParameter("email" , email);
		List list = query.getResultList();
		session.close();
		return list;
		
		
		
		
	}

}

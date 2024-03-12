package hallodoc.service;

import java.util.Iterator;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class UserService implements LoginCheck {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	
	private  SessionFactory sessionFactory;
	@Override
	public boolean checkEmail(String mail, String password) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Query mailQuery  = session.createQuery("select password_hash from hallodoc.model.asp_net_users where email= :mail");
		mailQuery.setParameter("mail", mail);
		List<Object> list = mailQuery.list();
		
		if (list.size()==0) {
			return false;
		} else {
			String passhash = (String) list.get(0);
			System.out.println(passhash);
			System.out.println();
			System.out.println(password);
			session.close();
			if (passhash.trim().equals(password.trim())) {
				return true;
			} else
				return false;
		}
	

		

	}

	


	
	


}

package hallodoc.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.AspNetUsers;
import hallodoc.model.Business;
import hallodoc.model.Concierge;
import hallodoc.model.User;
import hallodoc.model.Users;
import hallodoc.service.UsersService;

@Repository
public class UsersDao {

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	public List<AspNetUsers> checkEmail(String mail) {

		Session session = sessionFactory.openSession();

			System.out.println(mail);
		String hqlString = "from hallodoc.model.AspNetUsers A where A.email=:mail";
		org.hibernate.Query query = session.createQuery(hqlString);
		query.setParameter("mail", mail);
		List<AspNetUsers> list = query.list();
		session.close();
		return list;

	}

	public List checkEmail5(String mail) {

		Session session = sessionFactory.openSession();

		System.out.println("This is check mail running");
		System.out.println(mail);
		String hqlString = "SELECT A.passwordHash from hallodoc.model.AspNetUsers A where A.email=:mail";
		org.hibernate.Query query = session.createQuery(hqlString);
		query.setParameter("mail", mail);
		List list = query.list();
		session.close();
		return list;

	}

	public List<User> checkEmail1(String mail) {

		Session session = sessionFactory.openSession();

		System.out.println("This is check mail running");
		System.out.println(mail);
		String hqlString = "from hallodoc.model.User U where U.email=:mail";
		org.hibernate.Query query = session.createQuery(hqlString);
		query.setParameter("mail", mail);
		List<User> list = query.list();
		session.close();
		return list;

	}

	public List<Concierge> checkEmail12(String mail) {

		Session session = sessionFactory.openSession();

		System.out.println("This is check mail running");
		System.out.println(mail);
		String hqlString = "from hallodoc.model.Concierge C where C.email=:mail";
		org.hibernate.Query query = session.createQuery(hqlString);
		query.setParameter("mail", mail);
		List<Concierge> list = query.list();
session.close();
		return list;
	}

	public List<Business> checkEmail13(String mail) {

		Session session = sessionFactory.openSession();

		System.out.println("This is check mail running");
		System.out.println(mail);
		String hqlString = "from hallodoc.model.Business C where C.email=:mail";
		org.hibernate.Query query = session.createQuery(hqlString);
		query.setParameter("mail", mail);
		List<Business> list = query.list();
		session.close();
		return list;
	}
	
	public List checkname(String mail) {

		Session session = sessionFactory.openSession();

		System.out.println("This is check mail running");
		System.out.println(mail);
		String hqlString = "SELECT A.firstName from hallodoc.model.User A where A.email=:mail";
		Query query = session.createQuery(hqlString);
		query.setParameter("mail", mail);
		List list = query.list();
		session.close();
		return list;

	}
	


	

}

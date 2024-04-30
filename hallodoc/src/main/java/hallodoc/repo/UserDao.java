package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.AspNetUsers;
import hallodoc.model.Request;
import hallodoc.model.User;

@Repository
public class UserDao {

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void userSave(User user) {
		template.save(user);
	}

	@Transactional
	public void userUpdate(User user) {
		template.update(user);
	}

	public List<User> getUser(String mail) {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.User A where A.email=:mail";
		Query query = session.createQuery(hqlString);
		query.setParameter("mail", mail);
		List<User> list = query.list();
		System.out.println(list);

		return list;

	}

	public List<User> getUserIDList(int uID) {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.User A where A.userID=:uID";
		Query query = session.createQuery(hqlString);
		query.setParameter("uID", uID);
		List<User> list = query.list();
		System.out.println(list);

		return list;

	}

	public List<User> getUserst() {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.User ";
		Query query = session.createQuery(hqlString);

		List<User> list = query.list();

		return list;

	}
	
	public List<User> getUserByReqType(String sql) {

		Session session = sessionFactory.openSession();

		String hqlString = sql;
		Query query = session.createQuery(hqlString);
		List<User> list = query.list();
		System.out.println(list);

		return list;

	}
}

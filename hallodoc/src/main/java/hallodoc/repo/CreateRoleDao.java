package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Menu;
import hallodoc.model.Role;
import hallodoc.model.User;

@Repository
public class CreateRoleDao {

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate template;

	public List<Menu> getRole(int accountType) {

		Session session = sessionFactory.openSession();

		String hqlString = "";
		if (accountType == 0) {
			hqlString = "from hallodoc.model.Menu";
			Query query = session.createQuery(hqlString);
			List<Menu> list = query.list();

			System.out.println(list);

			return list;
		} else {
			hqlString = "from hallodoc.model.Menu A where A.accountType =:accountType";
			Query query = session.createQuery(hqlString);
			query.setParameter("accountType", accountType);
			List<Menu> list = query.list();

			System.out.println(list);

			return list;
		}

	}

	public List<Menu> getMenu(List<Integer> menu) {
		Session session = sessionFactory.openSession();

		String x = "from hallodoc.model.Menu A where A.menuId In (:menu)";
		Query query = session.createQuery(x);
		query.setParameter("menu", menu);
		List<Menu> list = query.list();
		session.close();
		System.out.println(list);
		return list;
	}

	public List<Role> getRole() {
		Session session = sessionFactory.openSession();

		String x = "from hallodoc.model.Role r where r.isDeleted=0";
		Query query = session.createQuery(x);

		List<Role> list = query.list();
		session.close();

		return list;
	}
	
	public List<Role> getRoleByRoleId(int roleId) {
		Session session = sessionFactory.openSession();

		String x = "from hallodoc.model.Role where roleId=:roleId";
		Query query = session.createQuery(x);
		query.setParameter("roleId", roleId);
		List<Role> list = query.list();
		session.close();

		return list;
	}

}

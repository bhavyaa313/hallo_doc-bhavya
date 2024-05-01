package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Menu;
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
		if(accountType==0)
		{
			hqlString="from hallodoc.model.Menu" ;
			Query query = session.createQuery(hqlString);
			List<Menu> list = query.list();
			System.out.println(list);

			return list;
		}
		else {
			hqlString = "from hallodoc.model.Menu A where A.accountType =:accountType" ;
			Query query = session.createQuery(hqlString);
			query.setParameter("accountType",accountType);
			List<Menu> list = query.list();
			System.out.println(list);

			return list;
		}
		
		

	}


}

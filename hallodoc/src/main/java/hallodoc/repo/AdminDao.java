package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.util.Removal;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Admin;
import hallodoc.model.AspNetUsers;
import hallodoc.model.Request;
import hallodoc.model.User;

@Repository
public class AdminDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void adminSave(Admin admin) {
		template.save(admin);
	}

	@Transactional
	public void adminUpdate(Admin admin) {
		template.update(admin);
	}

	public List<Admin> getAdmin(AspNetUsers Id) {

		Session session = sessionFactory.openSession();

		
		String hqlString = "from hallodoc.model.Admin A where A.aspnetUserId=:Id";
		Query query = session.createQuery(hqlString);
		query.setParameter("Id", Id);
		List<Admin> list = query.list();
		System.out.println(list);

		return list;

	}


}

package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.AspNetUsers;
import hallodoc.model.User;

@Repository
public class AspNetUsersDao {
	

	

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	

	

	@Autowired
	private HibernateTemplate template;
	
	
	
	@Transactional
	public void aspSave(AspNetUsers aspNetUsers) {
		template.save(aspNetUsers);
	}
	
	
	@Transactional
	public void aspUpdate(AspNetUsers aspNetUsers)
	{
		template.update(aspNetUsers);
	}

	
	public List<AspNetUsers> getAsplist(int ID) {

		Session session = sessionFactory.openSession();

		
	
		String hqlString = "from hallodoc.model.AspNetUsers A where A.id=:ID";
		Query query = session.createQuery(hqlString);
		query.setParameter("ID", ID);
		List<AspNetUsers> list = query.list();
		System.out.println(list);
		
		return list;

	}
	

	    
	    
	



}


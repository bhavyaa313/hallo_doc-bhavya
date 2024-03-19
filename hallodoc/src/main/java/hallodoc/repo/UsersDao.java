package hallodoc.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.service.UsersService;


@Repository
public class UsersDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	public List checkEmail(String mail) {
		
	
		String hql = "select passwordHash from hallodoc.model.AspNetUsers where email= :mail";

		
	    List list =  hibernateTemplate.findByNamedParam(hql, "mail", mail );
	    
	    
	
return list;


}
	
}
	





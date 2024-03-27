package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.AspNetUsers;
import hallodoc.model.User;

@Repository
public class AspNetUsersDao {
	

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

	

	    
	    
	



}


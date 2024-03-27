package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.AspNetUsers;
import hallodoc.model.User;


@Repository
public class UserDao {
	

	@Autowired
	private HibernateTemplate template;
	

	
	@Transactional
	public void userSave(User user) {
		template.save(user);
	}
	
	
	@Transactional
	public void  userUpdate(User user) {
		template.update(user);
	}


}

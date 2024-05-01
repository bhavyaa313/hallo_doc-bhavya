package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Role;



@Repository
public class RoleDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void roleSave(Role role) {
		template.save(role);
	}

	@Transactional
	public void roleUpdate(Role role) {
		template.update(role);
	}


}

package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.RequestClient;

@Repository
public class RequestClientDao {
	
	@Autowired
	private HibernateTemplate template;
	


	@Transactional
	public void requestClientSave(RequestClient requestClient) {
		template.save(requestClient);
	}
	

}

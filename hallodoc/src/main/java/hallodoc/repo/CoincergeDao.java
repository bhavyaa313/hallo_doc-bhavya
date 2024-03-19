package hallodoc.repo;

import javax.management.loading.PrivateClassLoader;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.Concierge;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestWiseFile;

@Repository
public class CoincergeDao {

	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void requestdao(Request request) {
		template.save(request);
	}
	
	@Transactional
	public void requestClientdao(RequestClient requestClient) {
		template.save(requestClient);
	}
	
	@Transactional
	public void requestWiseFiledao(RequestWiseFile requestWiseFile) {
		template.save(requestWiseFile);
	}
	
	@Transactional
	public void conciergedao(Concierge concierge) {
		template.save(concierge);
	}
	
}

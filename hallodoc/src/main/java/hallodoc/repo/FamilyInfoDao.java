package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.AspNetUsers;
import hallodoc.model.Request;
import hallodoc.model.RequestClient;
import hallodoc.model.RequestWiseFile;
import hallodoc.model.User;


@Repository
public class FamilyInfoDao {

	
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
	
	
	
	
	
}

package hallodoc.repo;

import java.util.List;

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
public class PatientInfoDao {

	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void savingdao(User user) {
		template.save(user);
	}
	
	
	@Transactional
	public void savedao(AspNetUsers aspNetUsers) {
		template.save(aspNetUsers);
	}
	
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
	
	public List checkEmail(String mail) {
		
	
		String passString = "select email from hallodoc.model.AspNetUsers where email = :mail";
		
	    List list =  template.findByNamedParam(passString, "mail", mail );
	    
	    
	
return list;


}
	
	
	
}

package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.BlockRequests;
@Repository
public class BlockRequestDao {
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void blockRequestSave(BlockRequests blockRequests) {
		template.save(blockRequests);
	}
	
	
	

}

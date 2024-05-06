package hallodoc.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.BlockRequests;

@Repository
public class BlockRequestDao {

	@Autowired
	private HibernateTemplate template;

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Transactional
	public void blockRequestSave(BlockRequests blockRequests) {
		template.save(blockRequests);
	}
	
	@Transactional
	public void blockRequestUpdate(BlockRequests blockRequests) {
		template.update(blockRequests);
	}

	public List getBlockList(int bId) {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.BlockRequests b where b.blockRequestId=:bId";

		Query query = session.createQuery(hqlString);
		query.setParameter("bId", bId);
		List list = query.list();
		System.out.println(list);

		return list;

	}
	
	public List getBlockList(String sql) {

		Session session = sessionFactory.openSession();

		

		Query query = session.createQuery(sql);

		List list = query.list();
		System.out.println(list);

		return list;

	}

}

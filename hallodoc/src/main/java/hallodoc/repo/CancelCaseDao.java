package hallodoc.repo;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.CaseTag;
import hallodoc.model.User;

@Repository
public class CancelCaseDao {

	@Autowired
	private org.hibernate.SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate template;

	public List<CaseTag> getReasons() {

		Session session = sessionFactory.openSession();

		String hqlString = "from hallodoc.model.CaseTag";
		Query query = session.createQuery(hqlString);
		
		List<CaseTag> list = query.list();
		System.out.println("------------");
		System.out.println("aa ja bhaiiiiiiiiiiiiiii");
		System.out.println(list);


		return list;

	}

}

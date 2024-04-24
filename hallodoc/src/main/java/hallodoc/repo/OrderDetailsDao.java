package hallodoc.repo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import hallodoc.model.OrderDetails;


@Repository
public class OrderDetailsDao {
	
	@Autowired
	private org.hibernate.SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public void healthProfessionalsUpdate(OrderDetails orderDetails) {
		template.update(orderDetails);
	}
	
	@Transactional
	public void orderDetailsSave(OrderDetails orderDetails) {
		template.save(orderDetails);
	}

}

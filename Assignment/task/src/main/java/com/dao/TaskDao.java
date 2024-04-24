package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.Task;

@Repository
public class TaskDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateTemplate template;

	@Transactional
	public void taskSave(Task task) {
		template.save(task);
	}

	@Transactional
	public void taskUpdate(Task task) {
		template.update(task);
	}
	
	public List<Task> gettasks() {

		Session session = sessionFactory.openSession();

		String hqlString = "from com.model.Task t where t.isDeleted=0 ";
		Query query = session.createQuery(hqlString);

		List<Task> list = query.list();
		System.out.println(list);

		return list;

	}
	
	
	
	
	public List<Task> gettasksbyId(int id) {

		Session session = sessionFactory.openSession();

		String hqlString = "from com.model.Task t WHERE t.id=:id ";
		Query query = session.createQuery(hqlString);
		query.setParameter("id", id);

		List<Task> list = query.list();
		System.out.println(list);

		return list;

	}
}

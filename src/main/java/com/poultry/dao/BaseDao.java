package com.poultry.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDao<T> {

	public BaseDao() {
	}

	@Autowired
	private SessionFactory sessionFactory;

	public void save(T t) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
	}

	public void update(T t) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
	}

	public void delete(T t) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public T getById(Integer id) {
		Session session = sessionFactory.openSession();
		return (T) session.get(getPersistanceClass(), id);
	}

	public abstract Class<T> getPersistanceClass();
	
	public List<T> getAll(){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(getPersistanceClass());
		return criteria.list();
	}

}

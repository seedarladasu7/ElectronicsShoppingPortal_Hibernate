package com.portal.shopping.electronics.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.shopping.electronics.entity.User;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "deprecation" })
	public User findById(Integer userId) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("userId", userId)).uniqueResult();
	}

}

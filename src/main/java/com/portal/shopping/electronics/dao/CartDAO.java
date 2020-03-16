package com.portal.shopping.electronics.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.shopping.electronics.entity.Cart;
import com.portal.shopping.electronics.entity.Product;

@Repository
@Transactional
public class CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void saveAndFlush(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
	}

	@SuppressWarnings({ "deprecation" })
	public Cart findById(Integer cartId) {
		return (Cart) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.add(Restrictions.eq("cartId", cartId)).uniqueResult();
	}

}

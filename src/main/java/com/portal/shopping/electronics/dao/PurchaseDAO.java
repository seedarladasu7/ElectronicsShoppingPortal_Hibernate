package com.portal.shopping.electronics.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.shopping.electronics.entity.Product;
import com.portal.shopping.electronics.entity.Purchase;
import com.portal.shopping.electronics.entity.User;

@Repository
@Transactional
public class PurchaseDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void saveAndFlush(Purchase purchase) {
		sessionFactory.getCurrentSession().save(purchase);
	}

	@SuppressWarnings({ "deprecation" })
	public Purchase findById(Integer purchaseId) {
		return (Purchase) sessionFactory.getCurrentSession().createCriteria(Purchase.class)
				.add(Restrictions.eq("purchaseId", purchaseId)).uniqueResult();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Purchase> findByUserId(Integer userid) {
		return sessionFactory.getCurrentSession().createCriteria(Purchase.class)
				.add(Restrictions.eq("userId", userid)).list();

	}

}

package com.portal.shopping.electronics.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.shopping.electronics.entity.DeliveryMode;

@Repository
@Transactional
public class DeliveryModeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "deprecation" })
	public DeliveryMode findById(Integer deliveryModeId) {
		return (DeliveryMode) sessionFactory.getCurrentSession().createCriteria(DeliveryMode.class)
				.add(Restrictions.eq("deliveryModeId", deliveryModeId)).uniqueResult();
	}

}

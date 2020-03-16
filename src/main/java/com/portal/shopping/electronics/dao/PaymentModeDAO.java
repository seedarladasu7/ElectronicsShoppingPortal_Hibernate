package com.portal.shopping.electronics.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.shopping.electronics.entity.PaymentMode;
import com.portal.shopping.electronics.entity.Product;

@Repository
@Transactional
public class PaymentModeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "deprecation" })
	public PaymentMode findById(Integer paymentModeId) {
		return (PaymentMode) sessionFactory.getCurrentSession().createCriteria(PaymentMode.class)
				.add(Restrictions.eq("paymentModeId", paymentModeId)).uniqueResult();
	}

}

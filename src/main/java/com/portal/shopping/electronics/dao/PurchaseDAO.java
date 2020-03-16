package com.portal.shopping.electronics.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.shopping.electronics.entity.Purchase;

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
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Purchase> searchCriteria = criteriaBuilder.createQuery(Purchase.class);
		Root<Purchase> rootPurchase = searchCriteria.from(Purchase.class);
		javax.persistence.criteria.Predicate pres = criteriaBuilder.equal(rootPurchase.get("userId"), userid);
		searchCriteria.select(rootPurchase).where(criteriaBuilder.and(pres));

		return sessionFactory.getCurrentSession().createQuery(searchCriteria).getResultList();

	}

}

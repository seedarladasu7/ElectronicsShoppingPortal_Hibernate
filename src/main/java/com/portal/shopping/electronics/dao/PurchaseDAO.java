package com.portal.shopping.electronics.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.shopping.electronics.entity.Purchase;
import com.portal.shopping.electronics.entity.User;
import com.portal.shopping.electronics.exceptionclasses.RecordNotFoundException;

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

	public List<Purchase> findByUser(User user) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Purchase> criteriaQuery = criteriaBuilder.createQuery(Purchase.class);

			Root<Purchase> from = criteriaQuery.from(Purchase.class);
			Join<Purchase, User> join = from.join("user", JoinType.LEFT);
			criteriaQuery.where(criteriaBuilder.equal(join.get("userId"), user.getUserId()));
			TypedQuery<Purchase> tq = session.createQuery(criteriaQuery);

			List<Purchase> users = tq.getResultList();

			return users;
		} catch (Exception exDesc) {
			throw new RecordNotFoundException(exDesc.getMessage());
		} finally {
			//session.close();
		}

	}

}

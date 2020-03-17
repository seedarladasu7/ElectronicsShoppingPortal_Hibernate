package com.portal.shopping.electronics.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.shopping.electronics.entity.Product;

@Repository
@Transactional
public class ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Product> findByProductNameContainingIgnoreCaseOrderByProductName(String productName) {
		return sessionFactory.getCurrentSession().createQuery("from Product where productName LIKE :prodName order by productName desc")
				.setString("prodName", '%'+productName+'%').list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Product> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Product.class).addOrder(Order.desc("productName"))
				.list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Product> findByProductIdIn(List<Integer> iProdIds) {
		return sessionFactory.getCurrentSession().createCriteria(Product.class)
				.add(Restrictions.in("productId", iProdIds)).addOrder(Order.desc("productName")).list();
	}

	@SuppressWarnings({ "deprecation" })
	public Product findById(Integer productId) {
		return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.add(Restrictions.eq("productId", productId)).uniqueResult();
	}

}

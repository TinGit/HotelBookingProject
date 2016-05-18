package org.mum.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.mum.hotel.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDao {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);

	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		 List<Customer> resultList = entityManager.createQuery("select * from Customer", Customer.class).getResultList();
		return resultList;
	}
	
	public Customer getCustomer(int custNo){
		return entityManager.find(Customer.class, custNo);
	}
	
	public Customer findCustomer(int custNo){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
		Root<Customer> u = criteria.from(Customer.class);
		TypedQuery<Customer> query = entityManager.createQuery(
		    criteria.select(u).where(builder.equal(u.get("customerNo"), custNo)));
		Customer cust = query.getSingleResult();
		return cust;
	}
}

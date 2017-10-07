package com.niit.laptopsbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopsbackend.model.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements ICartItemDAO {

	@Autowired
	 SessionFactory sessionFactory;
	public CartItemDAOImpl(SessionFactory sessionFactory2) {
		// TODO Auto-generated constructor stub
	}

	public boolean addCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public List<CartItem> getAll() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from CartItem",CartItem.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	public boolean deleteCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public CartItem getCartItem(int id) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from CartItem where cartitemid=:id",CartItem.class).setParameter("id", id).getSingleResult();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return null;
			}
	}

	public boolean deleteAll(int cart_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public CartItem getExistingCartItemCount(int prodid, int cart_id) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from CartItem where product_prodid=:prodid and cart_cartid=:cartid",CartItem.class)
									.setParameter("prodid", prodid)
									.setParameter("cartid", cart_id)
									.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	public boolean updateCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	


}

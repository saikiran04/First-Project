package com.niit.laptopsbackend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.laptopsbackend.model.Cart;
import com.niit.laptopsbackend.model.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements ICartItemDAO {

	@Autowired
	 SessionFactory sessionFactory;
	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	public boolean addCartItem(CartItem cartItem) {
		try {
			  Session s=sessionFactory.openSession();
			  Transaction tx=s.beginTransaction();
			  s.save(cartItem);
			  tx.commit();
			  
			  
			 return true;
			  
		  }catch(HibernateException e) {
			  
			  e.printStackTrace();
			  return false;
		  }
		/*try {
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}*/
	}

	public List<CartItem> getAll() {
		try {
			String hql="from CartItem";
			Session s=sessionFactory.openSession();
			Transaction tx=s.beginTransaction();
			org.hibernate.Query query=s.createQuery(hql);
			List<CartItem> all=query.list();
			tx.commit();
			return all;
		}catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		/*try {
			return sessionFactory.getCurrentSession().createQuery("from CartItem",CartItem.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}*/
	}

	public boolean deleteCartItem(CartItem cartItem) {
		try {
			  Session s=sessionFactory.openSession();
			  Transaction tx=s.beginTransaction();
			  s.update(cartItem);
			  tx.commit();
			  
			  
			 return true;
			  
		  }catch(HibernateException e) {
			  
			  e.printStackTrace();
			  return false;
		  }
		/*try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}*/
	}

	public CartItem getCartItem(int id) {
		try {
			   String hql="from CartItem where cartitemid="+id;
				Session s=sessionFactory.openSession();
				System.out.println("I am in get");
				Transaction tx=s.beginTransaction();
				org.hibernate.Query query=s.createQuery(hql);
				List<CartItem> list=query.list();
				tx.commit();
				if(list==null)
				{
					
					return null;
				
				}
				else
				{
					
					return list.get(0);
				}

			   }catch(HibernateException e) {
				   e.printStackTrace();
				   return null;
			   }
		/*try {
			return sessionFactory.getCurrentSession().createQuery("from CartItem where cartitemid=:id",CartItem.class).setParameter("id", id).getSingleResult();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return null;
			}*/
	}

	public boolean deleteAll(int cart_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public CartItem getExistingCartItemCount(int prodid, int cart_id) {
		try {
			String hql="from CartItem where product_prodid="+prodid+" and cart_cartid="+cart_id;
			System.out.println(hql);
			Session s=sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			Query query=s.createQuery(hql);
			List<CartItem> list=query.list();
			tx.commit();
			if(list!=null) {
				return list.get(0);
			}else {
				return null;
			}
			}catch(HibernateException e) {
				System.out.println(e);
				return null;
		}
		/*try {
			return sessionFactory.getCurrentSession().createQuery("from CartItem where product_prodid=:prodid and cart_cartid=:cartid",CartItem.class)
									.setParameter("prodid", prodid)
									.setParameter("cartid", cart_id)
									.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}*/
	}

	public boolean updateCartItem(CartItem cartItem) {
		try {
			  Session s=sessionFactory.openSession();
			  Transaction tx=s.beginTransaction();
			  s.update(cartItem);
			  tx.commit();
			  
			  
			 return true;
			  
		  }catch(HibernateException e) {
			  
			  e.printStackTrace();
			  return false;
		  }
		/*try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}*/
	}

	


}

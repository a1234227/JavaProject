package Dao.porder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DbConnection;
import Model.porder;

public class porderDaoimpl implements porderDao{

	public static void main(String[] args) {
//		porder p=new porder("A桌",2,4,6);
//		new porderDaoimpl().add(p);
		
//		List<porder> porderList = new porderDaoimpl().queryAll();
//		for(porder p:porderList) {
//			System.out.println(p);
//		}
		
//		List<porder> porderList = new porderDaoimpl().querySum(100, 900);
//		for(porder p:porderList) {
//			System.out.println(p);
//		}
		
		porder p=new porderDaoimpl().queryPorder(5);
		//p.setB(4);
		//p.setC(10);
		//p.setDesk("A桌");
		p.setSum();
		new porderDaoimpl().update(p);
		
//		new porderDaoimpl().delete(3);
		
		
	}

	@Override
	public void add(porder p) {
		EntityManager em=DbConnection.getdb();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<porder> queryAll() {
		EntityManager em=DbConnection.getdb();
		String JPQL="select p from porder p";
		Query q=em.createQuery(JPQL);
		List<porder> list=q.getResultList();
		return list;
	}

	@Override
	public List<porder> querySum(int start,int end) {
		EntityManager em=DbConnection.getdb();
		String JPQL="select p from porder p where p.sum>=?1 and p.sum<=?2";
		Query q=em.createQuery(JPQL);
		q.setParameter(1, start);
		q.setParameter(2, end);
		List<porder> list=q.getResultList();
		return list;
	}

	@Override
	public void update(porder p) {
		EntityManager em=DbConnection.getdb();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(int id) {
		EntityManager em=DbConnection.getdb();
		porder p=em.find(porder.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public porder queryPorder(int id) {
		EntityManager em=DbConnection.getdb();
		String JPQL="select p from porder p where id=?1";
		Query q=em.createQuery(JPQL);
		q.setParameter(1, id);
		List<porder> list=q.getResultList();
		if(list.size() == 0) return null;
		else {
		porder[] p=list.toArray(new porder[list.size()]);
		return p[0];
		}
	}

}

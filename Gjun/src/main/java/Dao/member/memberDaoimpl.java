package Dao.member;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dao.DbConnection;
import Model.member;

public class memberDaoimpl implements memberDao{

	public static void main(String[] args) {
//		member m=new member("Tom","1234","Tom","台北市","000","111");
//		new memberDaoimpl().add(m);
		
//		List<member> list=new memberDaoimpl().queryAll();
//		for(member m:list) {
//			System.out.println(m);
//		}
		
//		member m=new memberDaoimpl().queryMember("Tom", "1234");
//		System.out.println(m);
		
//		System.out.println(new memberDaoimpl().queryUsername("Tom"));
		
//		System.out.println(new memberDaoimpl().queryMember(2));
		
//		member m=new memberDaoimpl().queryMember(2);
//		m.setName("Jason");
//		m.setAddress("高雄市");
//		m.setPhone("0912345678");
//		new memberDaoimpl().update(m);
		
		new memberDaoimpl().delete(1);

	}

	@Override
	public void add(member m) {
		EntityManager em=DbConnection.getdb();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<member> queryAll() {
		EntityManager em=DbConnection.getdb();
		String JPQL="select m from member m";
		Query q=em.createQuery(JPQL);
		List<member> list=q.getResultList();
		return list;
	}

	@Override
	public member queryMember(String username, String password) {
		EntityManager em=DbConnection.getdb();
		String JPQL="select m from member m where m.username=?1 and m.password=?2";
		Query q=em.createQuery(JPQL);
		q.setParameter(1, username);
		q.setParameter(2, password);
		List<member> list=q.getResultList();
		if(list.size()==0) {
			return null;
		}else {
			member[] m=list.toArray(new member[list.size()]);
			return m[0];
		}
	}

	@Override
	public boolean queryUsername(String username) {
		EntityManager em=DbConnection.getdb();
		String JPQL="select m from member m where m.username=?1";
		Query q=em.createQuery(JPQL);
		q.setParameter(1, username);
		List<member> list=q.getResultList();
		if(list.size() != 0) return true;
		else return false;
	}

	@Override
	public member queryMember(int id) {
		EntityManager em=DbConnection.getdb();
		String JPQL="select m from member m where m.id=?1";
		Query q=em.createQuery(JPQL);
		q.setParameter(1, id);
		List<member> list=q.getResultList();
		if(list.size()==0) {
			return null;
		}else {
			member[] m=list.toArray(new member[list.size()]);
			return m[0];
		}
	}

	@Override
	public void update(member m) {
		EntityManager em=DbConnection.getdb();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(int id) {
		EntityManager em=DbConnection.getdb();
		em.getTransaction().begin();
		member m=em.find(member.class, id);
		em.remove(m);
		em.getTransaction().commit();
		em.close();
		
	}

}

package Dao.member;

import java.util.List;

import Model.member;

public interface memberDao {
	
	//Create 新增
	void add(member m);
	
	//Read 查詢
	List<member> queryAll();
	member queryMember(String username,String password);//登入用
	boolean queryUsername(String username);//帳號是否重複
	member queryMember(int id);//用id找人
	
	//Update 更新
	void update(member m);
	
	//Delete 刪除
	void delete(int id);

}

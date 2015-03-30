package controller;

import entity.User;

public class ListController {
	public List<User> populate(){
	List<User> userList = new ArrayList<User>();
	User user1 = new User();
	user1.setName("Vasya");
	user1.setAge(13);
	userList.add(user1);
	User user2 = new User();
	user2.setName("Petya");
	user2.setAge(19);
	userList.add(user2);

	return userList;
	}
}

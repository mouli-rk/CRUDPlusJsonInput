package com.kb.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kb.rest.model.User;

//Just to avoid DB calls in this example, Assume below data is interacting with DB

@Repository
public class UserDAO {
	static HashMap<Integer, User> usersMap = new HashMap<Integer, User>();

	public UserDAO() {
			User user1 = new User();
			user1.setId(1);
			user1.setAge(20);
			user1.setName("raj");
			
			User user2 = new User();
			user2.setId(2);
			user2.setAge(21);
			user2.setName("ram");
			
			usersMap.put(1, user1);
			usersMap.put(2, user2);
	}

	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>(usersMap.values());
		return userList;
	}

	public User getUserForId(int id) {
		User user = usersMap.get(id);
		return user;
	}

	public User createUser(User user) {
		usersMap.put(user.getId(), user);
		return usersMap.get(user.getId());
	}

	public User updateUser(User user) {
		if (usersMap.get(user.getId()) != null) {
			usersMap.get(user.getId()).setName(user.getName());
		} else {
			usersMap.put(user.getId(), user);
		}
		return usersMap.get(user.getId());
	}

	public User deleteUser(int id) {
		User userResponse = usersMap.remove(id);
		return userResponse;
	}

}

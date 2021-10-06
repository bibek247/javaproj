package com.demo.webservice.demowebservice.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;



@Component
public class UserDaoService {
	
private static List<User> users= new ArrayList<>();
private static int usercount=0;

static {
	
	
	users.add(new User(++usercount,"aaaa", new Date()));
	
	users.add(new User(++usercount,"bbbb", new Date()));
	
	users.add(new User(++usercount,"cccc", new Date()));
	
}
public List<User> findall() {
	// TODO Auto-generated method stub
		
return users;
}
public User findone(int id) {
	// TODO Auto-generated method stub
	for(User user:users) {
		if(user.getId()==id)
			return user;
	}
	
	return null;

}
public User save(User user) {
	// TODO Auto-generated method stub
	
	if(user.getId()==null) {
		user.setId(++usercount);
	}
	users.add(user);
	
	return user;
}
public User deletebyid(int id) {
	// TODO Auto-generated method stub
	Iterator<User> iterator = users.iterator();
	while(iterator.hasNext()) {
		User user = iterator.next();
		if(user.getId()==id) {
			iterator.remove();
			return user;
		}
			
	}
	
	return null;

}
}

package com.rest.restfulservices.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
private static List<User> users=new ArrayList<>();

private static int usersCount = 0;

static {
	users.add(new User(++usersCount,"Adam",12));
	users.add(new User(++usersCount,"Eve",10));
	users.add(new User(++usersCount,"Jim",11));
}
public List<User> findAll(){
	return users;
}
public User findUser(Integer id) {
	Predicate<? super User> pre= user -> user.getId().equals(id);
	return users.stream().filter(pre).findFirst().get();
}
public User save(User user) {
	user.setId(++usersCount);
	users.add(user);
	return user;
}
public void deleteById(int id) {
	Predicate<? super User> predicate = user -> user.getId().equals(id);
	users.removeIf(predicate);
}
}

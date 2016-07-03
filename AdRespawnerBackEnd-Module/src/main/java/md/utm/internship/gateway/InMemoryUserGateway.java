package md.utm.internship.gateway;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import md.utm.internship.model.Contact;
import md.utm.internship.model.Photo;
import md.utm.internship.model.Sex;
import md.utm.internship.model.User;

@Repository
public class InMemoryUserGateway implements UserGateway {
	
	private ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();
	private AtomicLong idGenerator = new AtomicLong(0);
	
	public InMemoryUserGateway() {
		User first = new User("mike@gmail.com", "mike", "p@ssword");
		first.setBirthDate(new Date());
		first.getContacts().add(new Contact("+373", "69952044"));
		first.getContacts().add(new Contact("+373", "022467911"));
		first.setSex(Sex.MALE);
		first.setPhoto(new Photo("/resources/images/macbook.png"));
		first.setFirstName("Mike");
		first.setLastName("Smith");
		createUser(first);
	}

	@Override
	public List<User> getAllUsers() {
		return users.values()
					.stream()
					.collect(Collectors.toList());
	}

	@Override
	public User getUser(Long userId) {
		return users.get(userId);
	}

	@Override
	public User createUser(User user) {
		user.setId(idGenerator.incrementAndGet());
		users.put(user.getId(), user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		users.put(user.getId(), user);
		return user;
	}

	@Override
	public void deleteUser(Long userId) {
		users.remove(userId);
	}
}

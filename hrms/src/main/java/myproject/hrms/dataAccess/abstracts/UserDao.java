package myproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email); // Email kontrolü için kayıt işleminde kullanılıyor
}

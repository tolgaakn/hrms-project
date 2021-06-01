package myproject.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.hrms.core.entities.User;


public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email); // Email kontrolü için kayıt işleminde kullanılıyor
}

package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userr,Long> {

//    @Query("SELECT u FROM Userr u WHERE size(u.posts) > ?1")
//    List<Userr> findUsersWithMoreThanNPosts(int n);

    Userr findByUsername(String username);
}

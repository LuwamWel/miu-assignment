package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userr,Long> {
}

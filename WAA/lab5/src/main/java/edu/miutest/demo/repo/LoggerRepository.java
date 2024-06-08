package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoggerRepository extends JpaRepository<Logger, Long> {
    @Query("select l from Logger l where l.dateTime < ?1")
    List<Logger> findByAgeLessThan(Integer age);
//    List<Logger> findLoggerByDateTimeBefore(LocalDateTime age);
}

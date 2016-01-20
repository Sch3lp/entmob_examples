package be.pxl.spring.rest.fallout.logging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JMSLogRepository extends JpaRepository<JMSLog, Long> {
}

package be.pxl.spring.rest.fallout.quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface QuoteRepository extends JpaRepository<Quote, UUID> {

}

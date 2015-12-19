package be.pxl.spring.rest.fallout.quote;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuoteRepository extends JpaRepository<Quote, UUID> {

}

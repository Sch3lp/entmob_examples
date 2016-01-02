package be.pxl.spring.rest.fallout.quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface QuoteRepository extends JpaRepository<Quote, UUID> {

    @Query("select q from Quote q where q.author = ?1")
    List<Quote> findByAuthor(String author);
}

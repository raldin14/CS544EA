package Lab14PartB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameIgnoreCaseContaining(String name);

    @Query("SELECT p FROM Product p WHERE lower(p.name) LIKE lower(concat('%', ?1, '%')) OR lower(p.description) LIKE lower(concat('%', ?1, '%'))")
    List<Product> search(String term);
}

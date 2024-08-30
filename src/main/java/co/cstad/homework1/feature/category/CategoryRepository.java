package co.cstad.homework1.feature.category;


import co.cstad.homework1.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, Integer> {
    boolean existsByName(String name);
    Optional<Category> findById(String id);
    Optional<Category> findByName(String name);

}

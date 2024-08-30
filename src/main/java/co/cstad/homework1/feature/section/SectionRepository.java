package co.cstad.homework1.feature.section;


import co.cstad.homework1.domain.Section;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SectionRepository extends MongoRepository<Section, String> {
    Optional<Section> findByOrderNo(Integer orderNo);

}

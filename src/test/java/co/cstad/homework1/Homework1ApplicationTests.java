package co.cstad.homework1;


import co.cstad.homework1.domain.Category;
import co.cstad.homework1.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


@SpringBootTest
class Homework1ApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testFilterCategory(){

        Query query = new Query();

//        Criteria byName = Criteria
//                .where("name")
//                .regex("web" ,"i");

        Criteria byIcon = Criteria
                .where("icon")
                .regex("web" ,"i");
        Criteria criteria = new Criteria();
        criteria.andOperator(byIcon);

        query.addCriteria(criteria);

        List<Category> categories = mongoTemplate.find(query, Category.class);

       categories.forEach(s -> System.out.println(s));

    }

}

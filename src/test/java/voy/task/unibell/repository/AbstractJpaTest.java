package voy.task.unibell.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
abstract class AbstractJpaTest {

    @PostConstruct
    private void asd() {
        System.out.println("init AbstractJpaTest");
    }

}

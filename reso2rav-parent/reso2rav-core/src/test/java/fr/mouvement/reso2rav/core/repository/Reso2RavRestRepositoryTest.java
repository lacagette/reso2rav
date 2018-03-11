package fr.mouvement.reso2rav.core.repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import fr.mouvement.reso2rav.core.ApplicationCoreTest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ApplicationCoreTest.class)
@AutoConfigureMockMvc
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Reso2RavRestRepositoryTest {

}

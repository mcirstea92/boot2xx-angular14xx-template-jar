package ro.mariuscirstea.eventtracker;

import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.mariuscirstea.eventtracker.config.SpringConfig;
import ro.mariuscirstea.eventtracker.security.JwtProvider;
import ro.mariuscirstea.eventtracker.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = EventTrackerApplication.class)
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@Slf4j
@ActiveProfiles("test")
public class BasicTest {

    @MockBean
    JwtProvider jwtProvider;

    @MockBean
    UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testSuccessfullyAutowire() {
        Assert.notNull(passwordEncoder, "Bean should be auto-wired successfully!");
    }

}

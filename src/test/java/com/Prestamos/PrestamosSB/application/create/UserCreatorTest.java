package com.Prestamos.PrestamosSB.application.create;

import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



@SpringBootTest
class UserCreatorTest {


    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserCreator userCreator;

    @Test
    void create() {
        User user = User.builder().email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();
        userCreator.create(user);

        Mockito.verify(userRepository,Mockito.times(1)).save(user);

    }

}
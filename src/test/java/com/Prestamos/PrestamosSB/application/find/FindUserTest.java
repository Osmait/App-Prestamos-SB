package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.User;
import com.Prestamos.PrestamosSB.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FindUserTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private FindUser findUser;

    @Test
    void findAllUser() {
        List<User> userList = new ArrayList<>();

        User user1 = User.builder().email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();
        User user2 = User.builder().email("joseburgos6@gmail.com").name("jose").lastName("burgos").password("12345678").build();
        userList.add(user1);
        userList.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        List<User> result  = findUser.findAllUser();

        assertEquals(userList.size(),result.size());
        assertEquals(userList.get(0), result.get(0));
        assertEquals(userList.get(1), result.get(1));

    }
}
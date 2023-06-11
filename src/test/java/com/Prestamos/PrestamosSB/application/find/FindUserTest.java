package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.User.User;
import UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class FindUserTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private FindUser findUser;

    @MockBean
    private AuthService authService;

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

    @Test
    void findProfile() {


        User user1 = User.builder().id(1L).email("saulburgos8@gmail.com").name("saul").lastName("burgos").password("12345678").build();



        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user1);

        Mockito.when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));

        User result  = findUser.findProfile();

        assertEquals(user1.getId(),result.getId());
        assertEquals(user1.getEmail(), result.getEmail());



    }
}
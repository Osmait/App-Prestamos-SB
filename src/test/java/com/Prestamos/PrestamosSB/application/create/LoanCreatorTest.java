package com.Prestamos.PrestamosSB.application.create;


import com.Prestamos.PrestamosSB.application.auth.AuthService;
import com.Prestamos.PrestamosSB.domain.Client;
import com.Prestamos.PrestamosSB.domain.Loan;
import com.Prestamos.PrestamosSB.domain.LoanRepository;
import com.Prestamos.PrestamosSB.domain.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@Transactional
class LoanCreatorTest {


    @MockBean
    private LoanRepository prestamoRepository;

    @Autowired
    private LoanCreator prestamoCreator;
    @MockBean
    private AuthService authService;

    @Test
    void create()  {
        User user = User.builder().email("saulburgos6@gmail.com").name("saul").lastName("burgos").password("12345678").build();
        Client client = Client.builder()
                .name("saul")
                .lastName("burgos")
                .email("saulburgos6@gmail.com")
                .phoneNumber("12345678")
                .build();
        Loan prestamo =Loan.builder().amount(100.00).client(client).build();
        Mockito.when(authService.getIdCurrentLoggedUser()).thenReturn(user);
        prestamoCreator.create(prestamo);
        Mockito.verify(prestamoRepository,Mockito.times(1)).save(prestamo);

    }
}
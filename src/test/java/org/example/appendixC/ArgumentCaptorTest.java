package org.example.appendixC;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class ArgumentCaptorTest {
//    private UserRegister userRegister;
//    private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);
//
//    @Test
//    void whenRegisterThenSendMail() {
//        // register()에서 emailNotifier의 sendRegisterEmail() 호출한다고 가정
//        userRegister.register("id", "pw", "email@email.com");
//
//        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//        then(mockEmailNotifier)
//                .should().sendRegisterEmail(captor.capture());
//
//        String realEmail = captor.getValue();
//        assertEquals("email@email.com", realEmail);
//    }
}

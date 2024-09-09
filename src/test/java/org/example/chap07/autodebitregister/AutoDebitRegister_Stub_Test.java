package org.example.chap07.autodebitregister;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.chap07.autodebitregister.CardValidity.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;

    @BeforeEach
    void setUp() {
//        CardNumberValidator validator = new CardNumberValidator();
        stubValidator = new StubCardNumberValidator();
        AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, repository);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("1111222222333333");

        AutoDebitReq req = new AutoDebitReq("user1", "1111222222333333");
        RegisterResult result = this.register.register(req);

        assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard() {
        stubValidator.setTheftNo("1234123412341234");

        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);

        assertEquals(THEFT, result.getValidity());
    }
}

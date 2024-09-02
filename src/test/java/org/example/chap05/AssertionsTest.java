package org.example.chap05;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void sameObjectAssertEquals_Then_TestPassed() {
        LocalDate dateTime1 = LocalDate.now();
        LocalDate dateTime2 = LocalDate.now();

        assertEquals(dateTime1, dateTime2);
    }

    @Test
    void failMethodCalled_Then_TestFailed() {
        boolean throwException = false;

        try {
            this.throwIndeedException(throwException);
            fail(); // 이 지점에 다 다르면 fail() 메서드는 테스트 실패 에러를 발생
        } catch (Exception e) {
            return;
        }
    }

    @Test
    void rightExceptionByAssertThrows_Then_TestPassed() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.throwIndeedException(true);
        });
    }

    @Test
    void assertThrowsReturnExceptionObject() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            this.throwIndeedException(true);
        });

        assertEquals("Indeed Exception", e.getMessage());
    }

    @Test
    void firstAssertEqualsFailed_Then_NextAssertionsNotCalled() {
        assertEquals(1, 2); // 검증 실패로 에러 발생
        assertEquals(1, 1); // 이 코드는 실행되지 않음
    }

    @Test
    void assertAllHasFailedCase_Then_AllExecute() {
        assertAll(
                () -> assertEquals(1, 2),
                () -> assertEquals(1, 1),
                () -> assertEquals(3, 4),
                () -> assertEquals(4, 4)
        );
    }

    private void throwIndeedException(boolean throwException) {
        if(!throwException) {
            return;
        }

        throw new IllegalArgumentException("Indeed Exception");
    }
}

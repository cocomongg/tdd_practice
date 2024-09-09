package org.example.appendixC;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {
    @Test
    void mockTest() {
        GameNumGen genMock = Mockito.mock(GameNumGen.class);
        given(genMock.generate(GameLevel.EASY)).willReturn("123");

        String genNum = genMock.generate(GameLevel.EASY);
        assertEquals("123", genNum);
    }

    @Test
    void mockThrowTest() {
        GameNumGen genMock = Mockito.mock(GameNumGen.class);
        given(genMock.generate(null)).willThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> {
            genMock.generate(null);
        });
    }
}

package codingdojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordWrapTest {

    static Stream<WordWrap> wrapperProvider() {
        return Stream.of(
                new WordWrapKoflerLoop(),
                new WordWrapKoflerLoopBuffer(),
                new WordWrapKoflerRegex(),
                new WordWrapBlausten(),
                new WordWrapBlausten2(),
                new WordWrapMartin()
        );
    }

    // TODO: write some more test cases like this one
    @ParameterizedTest
    @MethodSource("wrapperProvider")
    public void testWrapEmptyString(WordWrap wrapper) {
        assertEquals("", wrapper.wrap("", 1));
    }

}

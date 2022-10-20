package org.example.Input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserTest {

    InputParser underTestClass;

    @BeforeEach
    void setUp() {
        underTestClass = new InputParser();
    }

    @Test
    void convertCorrectNumberCharToInt() {
        int actual = underTestClass.charToInt('6');
        int expected = 6;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void convertCorrectLetterInputToInt() {
        int actual = underTestClass.charToInt('c');
        int expected = 2;
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void inputToCoordinates() {
        int[] actual = underTestClass.inputToCoordinates("a3");
        int[] expected = {0, 3};
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
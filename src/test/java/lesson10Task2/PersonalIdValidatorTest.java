package lesson10Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalIdValidatorTest {

    @Test
    void validatePersonalIdValid() {
        Assertions.assertTrue(PersonalIdValidator.validatePersonalId("12345678901"));
    }
    @Test
    void validatePersonalIdNotValid() {
        Assertions.assertFalse(PersonalIdValidator.validatePersonalId("1234567890"));
    }
}
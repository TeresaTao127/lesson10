package lesson10Task5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswordValidatorTest {

  @ParameterizedTest
  @ValueSource(strings ={ "MyP@ssw1", "javaFirstpro1"})
  void shouldReturnTureForPassword(String stringToCheck) {
    Assertions.assertTrue(PasswordValidator.isPasswordValid(stringToCheck));
  }
  @ParameterizedTest
  @ValueSource(strings ={ "JAVAstudyIn2023", "Pass1", "23Password"})
  void shouldReturnFalseForPassword(String stringToCheck) {
    Assertions.assertFalse(PasswordValidator.isPasswordValid(stringToCheck));
  }
}
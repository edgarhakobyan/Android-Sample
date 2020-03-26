package com.example.userregister;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class EmailValidatorTest {
    @Test
    public void emailValidatorCorrectEmail() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"));
    }

    @Test
    public void emailValidatorCorrectEmailSubDomain() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"));
    }

    @Test
    public void emailValidatorNoDomain() {
        assertFalse(EmailValidator.isValidEmail("name@email"));
    }

    @Test
    public void emailValidatorDoubleDot() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"));
    }

    @Test
    public void emailValidatorNoUsername() {
        assertFalse(EmailValidator.isValidEmail("@email.com"));
    }

    @Test
    public void emailValidatorEmptyString() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidatorNullEmail() {
        assertFalse(EmailValidator.isValidEmail(null));
    }
}

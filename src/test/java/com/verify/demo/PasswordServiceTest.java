package com.verify.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.verify.demo.exception.PasswordException;
import com.verify.demo.response.PasswordApiResponse;
import com.verify.demo.service.PasswordService;

@SpringBootTest
public class PasswordServiceTest {

    @InjectMocks
    PasswordService pService;
    
    @Test
    public void length_test(){
        String passPhrase = "Xyz23";
        PasswordException thrown = Assertions.assertThrows(PasswordException.class, ()-> pService.isValidPassword(passPhrase));
        assertEquals("Password must be less than 20 and more than 8 characters in length.", thrown.getException().getMessage());
    }

    @Test
    public void uppercase_test(){
        String passPhrase = "xyzdfh23";
        PasswordException thrown = Assertions.assertThrows(PasswordException.class, ()-> pService.isValidPassword(passPhrase));
        assertEquals("Password must have atleast one uppercase character.", thrown.getException().getMessage());
    }

    @Test
    public void lowercase_test(){
        String passPhrase = "XYZFDG23";
        PasswordException thrown = Assertions.assertThrows(PasswordException.class, ()-> pService.isValidPassword(passPhrase));
        assertEquals("Password must have atleast one lowercase character.", thrown.getException().getMessage());
    }

    @Test
    public void nummber_test(){
        String passPhrase = "XYZFDGth";
        PasswordException thrown = Assertions.assertThrows(PasswordException.class, ()-> pService.isValidPassword(passPhrase));
        assertEquals("Password must have atleast one number.", thrown.getException().getMessage());
    }

    @Test
    public void null_test(){
        String passPhrase = null;
        PasswordException thrown = Assertions.assertThrows(PasswordException.class, ()-> pService.isValidPassword(passPhrase));
        assertEquals("Password should not be empty.", thrown.getException().getMessage());
    }

    @Test
    public void valid_test(){
        String passPhrase = "Valid1N3";
        PasswordApiResponse pResp = pService.isValidPassword(passPhrase);
        assertEquals("Password is valid.", pResp.getProcessSummary().getSummaryMessage());
    }
}

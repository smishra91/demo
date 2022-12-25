package com.verify.demo.service;

import org.springframework.stereotype.Service;

import com.verify.demo.exception.PasswordException;
import com.verify.demo.response.PasswordApiResponse;
import com.verify.demo.response.ProcessSummary;

@Service
public class PasswordService {

    public PasswordApiResponse isValidPassword(String passPhrase) {

        PasswordApiResponse pApiResponse = new PasswordApiResponse();
        int validcount = 5;

        if (null == passPhrase) {
            validcount--;
            throw new PasswordException(pApiResponse, new Exception("Password should not be empty."));
        }
        if (passPhrase.length() < 8) {
            validcount--;
            throw new PasswordException(pApiResponse,
                    new Exception("Password must be less than 20 and more than 8 characters in length."));
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!passPhrase.matches(upperCaseChars)) {
            validcount--;
            throw new PasswordException(pApiResponse,
                    new Exception("Password must have atleast one uppercase character."));
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!passPhrase.matches(lowerCaseChars)) {
            pApiResponse.setIs1dTrue(false);
            validcount--;
            throw new PasswordException(pApiResponse,
                    new Exception("Password must have atleast one lowercase character."));
        }
        String numbers = "(.*[0-9].*)";
        if (!passPhrase.matches(numbers)) {
            validcount--;
            throw new PasswordException(pApiResponse, new Exception("Password must have atleast one number."));
        }
        if (validcount >= 3 && pApiResponse.getIs1dTrue()) {
            pApiResponse.setIsValid(true);
            ProcessSummary processSummary = pApiResponse.getProcessSummary();

            processSummary.setStatus("Success");
            processSummary.setSummaryMessage("Password is valid.");

            pApiResponse.setProcessSummary(processSummary);
        }
        return pApiResponse;
    }

}

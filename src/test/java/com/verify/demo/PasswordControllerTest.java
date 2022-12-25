package com.verify.demo;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verify.demo.requests.Password;
import com.verify.demo.response.PasswordApiResponse;
import com.verify.demo.service.PasswordService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class PasswordControllerTest {

    @MockBean
    PasswordService pswdService;

    @Autowired
    MockMvc mockMvc;

    @Mock
    static HttpServletRequest request;

    public static MockHttpServletRequestBuilder buildPostMethodTest(String url) {
        return MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON); 
    }
    
    @Test
    public void test_controller() throws JsonProcessingException, Exception{
        Password pRequest = new Password();
        pRequest.setPassword("fersto34u");
        PasswordApiResponse pApiResponse = new PasswordApiResponse();
        when(pswdService.isValidPassword(anyString())).thenReturn(pApiResponse);
        mockMvc.perform(buildPostMethodTest("/api/password/verify").content(new ObjectMapper().writeValueAsString(pRequest))).andExpect(status().isOk());
    }
}

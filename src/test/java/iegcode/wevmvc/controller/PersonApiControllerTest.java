package iegcode.wevmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import iegcode.wevmvc.model.CreatePersonRequest;
import iegcode.wevmvc.model.CreateSocialMediasRequest;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
@SpringBootTest
@AutoConfigureMockMvc
class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception{
        CreatePersonRequest request = new CreatePersonRequest();
        request.setFirstName("Ibrahim");
        request.setMiddleName("El");
        request.setLastName("Gibran");
        request.setEmail("gibran@example.com");
        request.setPhone("085876076005");
        request.setHobbies(List.of("Coding", "Reading", "Makan"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediasRequest("facebook", "facebook.com/ibrhaimelgibran"));
        request.getSocialMedias().add(new CreateSocialMediasRequest("instagram", "instagram.com/elgibran17"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isOk(),
                content().json(jsonRequest)
        );
    }

    @Test
    void createPersonValidationError() throws Exception{
        CreatePersonRequest request = new CreatePersonRequest();
        request.setMiddleName("El");
        request.setLastName("Gibran");
        request.setHobbies(List.of("Coding", "Reading", "Makan"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediasRequest("facebook", "facebook.com/ibrhaimelgibran"));
        request.getSocialMedias().add(new CreateSocialMediasRequest("instagram", "instagram.com/elgibran17"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("Validation Error"))
        );
    }
}
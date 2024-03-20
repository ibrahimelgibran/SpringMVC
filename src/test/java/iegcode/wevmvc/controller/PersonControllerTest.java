package iegcode.wevmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Ibrahim")
                        .param("middleName", "El")
                        .param("lastName", "Gibran")
                        .param("email", "gibran@example.com")
                        .param("phone", "085876076005")
                        .param("address.street", "Jalan belum jadi")
                        .param("address.city", "Yogyakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "55581")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Makan")
                        .param("socialMedias[0].name", "facebook")
                        .param("socialMedias[0].location", "facebook.com/ibrhaimelgibran")
                        .param("socialMedias[1].name", "instagram")
                        .param("socialMedias[1].location", "instagram.com/@elgibran17")

        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person Ibrahim El Gibran " + "with email gibran@example.com and phone 085876076005" +
                        " with address Jalan belum jadi, Yogyakarta, Indonesia, 55581"))
        );
    }
}
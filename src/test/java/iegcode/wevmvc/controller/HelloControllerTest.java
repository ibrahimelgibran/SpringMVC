package iegcode.wevmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGuest() throws Exception {
        mockMvc.perform(
                get("/hello")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Guest"))
        );
    }

    @Test
    void testName() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name", "Gibran")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Gibran"))
        );
    }

    @Test
    void testPost() throws Exception {
        mockMvc.perform(
                post("/hello").queryParam("name", "Gibran")
        ).andExpectAll(
                status().isMethodNotAllowed()
        );
    }

    @Test
    void helloView() throws Exception {
      mockMvc.perform(
              get("/web/hello").queryParam("name", "Gibran")
      ).andExpectAll(
              status().isOk(),
              content().string(Matchers.containsString("Learn View")),
              content().string(Matchers.containsString("Hello Gibran"))
      );
    };
}
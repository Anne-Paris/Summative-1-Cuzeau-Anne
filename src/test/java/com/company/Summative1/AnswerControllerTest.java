package com.company.Summative1;

import com.company.Summative1.controllers.AnswerController;
import com.company.Summative1.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() {
        //Autowired
    }

    // Testing POST /answer
    @Test
    public void shouldReturnAnswer() throws Exception {

        Answer answer = new Answer();
        answer.setQuestion("question?");
        answer.setId(1);
        answer.setAnswer("Yes");


        String inputJson = mapper.writeValueAsString(answer);

        mockMvc.perform(
                post("/magic")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().is2xxSuccessful());
   }


}

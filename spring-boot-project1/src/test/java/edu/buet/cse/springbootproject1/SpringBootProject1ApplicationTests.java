package edu.buet.cse.springbootproject1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import edu.buet.cse.springboot.project1.SpringBootProject1Application;

@SpringBootTest(classes = {SpringBootProject1Application.class})
@AutoConfigureMockMvc
public class SpringBootProject1ApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetBooks() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/books"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Beginning Java"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].author").value("Ivor Horton"));
  }
}

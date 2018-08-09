package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testUpload() {
        try {
            String result;
            result = mockMvc.perform(
                    MockMvcRequestBuilders
                            .fileUpload("/")
                            .file(
                                    new MockMultipartFile("thefile", "test.txt", ",multipart/form-data", "this is file content.......".getBytes("UTF-8"))
                            ).param("fileid", "id0").param("description", "this is a test file")
            ).andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn().getResponse().getContentAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

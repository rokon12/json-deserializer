package com.bazlur.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

/**
 * @author Bazlur Rahman Rokon
 * @since 11/24/15.
 */
public class App {
    public static void main(String[] args) throws IOException {

        User user = new User();
        user.setId(1L);
        user.setEmail("example@example.com");
        user.setName("Bazlur Rahman");

        Program program = new Program();
        program.setId(1L);
        program.setName("Program @# 1");
        program.setCreatedBy(user);
        program.setContents("Some contents");

        ObjectMapper objectMapper = new ObjectMapper();

        final String json = objectMapper.writeValueAsString(program);
        System.out.println(json);

        String jsonString = "{\"id\":1,\"name\":\"Program @# 1\",\"createdBy\":{\"id\":1,\"name\":\"Bazlur Rahman\",\"email\":\"example@example.com\"},\"contents\":\"Some contents\"}";

        final Program program1 = objectMapper.readValue(jsonString, Program.class);
        System.out.println(program1);


        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Program.class, new ProgramDeserializer());

        mapper.registerModule(module);

        String newJsonString = "{\"id\":1,\"name\":\"Program @# 1\",\"ownerId\":1,\"contents\":\"Some contents\"}";
        final Program program2 = mapper.readValue(newJsonString, Program.class);

        System.out.println(program2);
    }
}

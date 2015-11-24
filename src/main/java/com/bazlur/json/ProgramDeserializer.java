package com.bazlur.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * @author Bazlur Rahman Rokon
 * @since 11/24/15.
 */
public class ProgramDeserializer extends JsonDeserializer<Program> {
    @Override
    public Program deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);

        final Long id = node.get("id").asLong();
        final String name = node.get("name").asText();
        final String contents = node.get("contents").asText();
        final long ownerId = node.get("ownerId").asLong();

        User user = new User();
        user.setId(ownerId);

        return new Program(id, name, contents, user);
    }
}

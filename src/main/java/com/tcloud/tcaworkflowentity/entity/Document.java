package com.tcloud.tcaworkflowentity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.HashMap;

@Builder(toBuilder = true)
@Data
@Jacksonized
public class Document {

    private String documentId;
    private byte[] entities;
    private byte[] states;

    @JsonIgnore
    private ObjectMapper objectMapper;

    public static Document init() {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();

            return Document.builder()
                    .entities(objectMapper.writeValueAsBytes(new HashMap<>()))
                    .states(objectMapper.writeValueAsBytes(new ArrayList<>()))
                    .build();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return Document.builder().build();
    }
}

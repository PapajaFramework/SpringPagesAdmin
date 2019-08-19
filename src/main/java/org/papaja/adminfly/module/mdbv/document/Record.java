package org.papaja.adminfly.module.mdbv.document;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@SuppressWarnings({"unused"})
@Document
public class Record {

    @Id
    private BigInteger id;

    private JsonNode value;

}

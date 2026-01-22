package com.example.claimloader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClaimDataStore {

    private static JsonNode claimJson;
    private static Document claimXml;
    private static String claimTxt;

    public static void load(Path directory) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        claimJson = mapper.readTree(
                Files.readString(directory.resolve("claimJSON.json"))
        );

        claimXml = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(directory.resolve("claimXML.xml").toFile());

        claimTxt = Files.readString(
                directory.resolve("claimTxt.txt")
        );
    }

    public static JsonNode getClaimJson() {
        return claimJson;
    }

    public static Document getClaimXml() {
        return claimXml;
    }

    public static String getClaimTxt() {
        return claimTxt;
    }
}

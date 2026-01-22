package com.example.claimloader;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleFileLoader {

    // In-memory storage
    static JsonNode claimJson;
    static Document claimXml;
    static String claimTxt;

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // JSON
        claimJson = mapper.readTree(
                Files.readString(Path.of("claimJSON.json"))
        );

        // XML
        claimXml = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse("claimXML.xml");

        // TXT
        claimTxt = Files.readString(Path.of("claimTxt.txt"));

        // Example access
        System.out.println(claimJson);
        System.out.println(claimXml.getDocumentElement().getNodeName());
        System.out.println(claimTxt);

    }
}

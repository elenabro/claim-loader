package com.example.claimloader;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * SimpleFileLoader
 *
 * Loads client-provided claim files (JSON, XML, TXT),
 * parses them, and keeps the results in memory so they
 * can be reused by other parts of the application.
 *
 * This class intentionally keeps everything in one place
 * to demonstrate a minimal, easy-to-follow solution.
 */


public class SimpleFileLoader {

    // Parsed file contents stored in memory
    static JsonNode claimJson;
    static Document claimXml;
    static String claimTxt;

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // Parse JSON file into a JsonNode
        claimJson = mapper.readTree(
                Files.readString(Path.of("claimJSON.json"))
        );

        // Parse XML file into a DOM Document
        claimXml = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse("claimXML.xml");

        // Load TXT file as plain text
        claimTxt = Files.readString(Path.of("claimTxt.txt"));

        // Simple verification output
        System.out.println(claimJson);
        System.out.println(claimXml.getDocumentElement().getNodeName());
        System.out.println(claimTxt);

    }
}

package com.example.claimloader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ClaimDataStore
 *
 * Loads client claim files (JSON, XML, TXT),
 * parses them, and stores the parsed results in memory.
 *
 * Other parts of the application can access the parsed
 * data through the provided getter methods.
 */


public class ClaimDataStore {


    // Parsed file contents kept in memory
    private static JsonNode claimJson;
    private static Document claimXml;
    private static String claimTxt;

    /**
     * Loads and parses all required claim files from the given directory.
     */

    public static void load(Path directory) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

    // Parse JSON into a tree structure
        claimJson = mapper.readTree(
                Files.readString(directory.resolve("claimJSON.json"))
        );

    // Parse XML into a DOM document
        claimXml = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(directory.resolve("claimXML.xml").toFile());

    // Load TXT file as plain text
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

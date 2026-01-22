package com.example.claimloader;

import java.nio.file.Path;

/**
 * Application entry point.
 *
 * Demonstrates loading client claim files and
 * making the parsed data available in memory.
 */


public class App {
    public static void main(String[] args) throws Exception {

        // Load files from the project root directory
        ClaimDataStore.load(Path.of("."));

        // Simple confirmation output
        System.out.println("Files parsed and stored in memory");
        System.out.println("JSON loaded: " + (ClaimDataStore.getClaimJson() != null));
        System.out.println("XML loaded: " +
                ClaimDataStore.getClaimXml().getDocumentElement().getNodeName());
        System.out.println("TXT length: " +
                ClaimDataStore.getClaimTxt().length());

    }
}


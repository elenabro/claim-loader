package com.example.claimloader;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {

        // Load files from project root
        ClaimDataStore.load(Path.of("."));

        // Proof it worked
        System.out.println("Files parsed and stored in memory");
        System.out.println("JSON loaded: " + (ClaimDataStore.getClaimJson() != null));
        System.out.println("XML loaded: " +
                ClaimDataStore.getClaimXml().getDocumentElement().getNodeName());
        System.out.println("TXT length: " +
                ClaimDataStore.getClaimTxt().length());

    }
}


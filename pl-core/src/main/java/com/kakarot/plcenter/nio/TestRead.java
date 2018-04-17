package com.kakarot.plcenter.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class TestRead {

    public static void main(String[] args) throws IOException, URISyntaxException {
        byte[] bytes = Files.readAllBytes(Paths.get("d:/test/SAMPLE.CAMT052.CGI_CREDIT.xml"));
        String text = new String(bytes);
        System.out.println(text);
    }
}

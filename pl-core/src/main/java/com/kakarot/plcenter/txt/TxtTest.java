package com.kakarot.plcenter.txt;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class TxtTest {

    public static void main(String[] args) throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get("d:/test.txt"));
        String text = new String(bytes);
        List<String> list = Arrays.asList(text.split("\\n"));
        list.stream().forEach(s -> System.out.println(s.replaceAll("\\(.*?\\)|\\{.*?}|\\[.*?]|（.*?）", "")));
        Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");
        list.stream().forEach(s -> {
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()){
                System.out.println(matcher.group());
            }else{
                System.out.println("");
            }
        });
    }
}

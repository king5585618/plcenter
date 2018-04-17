package com.kakarot.plcenter.controller;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URLDecoder;

/**
 * @author jinzj
 * @since v4.0.1
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {

    @RequestMapping(value = "/getFile")
    @ResponseBody
    public String getFile(HttpEntity<byte[]> content) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(content.getBody());
        BufferedReader br = new BufferedReader(new InputStreamReader(
                inputStream, "utf8"));
        System.out.println(URLDecoder.decode(IOUtils.toString(br),"utf-8"));
        return "SUCCESS";
    }
}

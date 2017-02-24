package com.kakarot.plcenter.demo;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jinzj on 2017/2/23.
 */
public class ChannelTest {

    @Test
    public void fileChannelTest() throws Exception {
        File f = new File("D:/test.txt");
        RandomAccessFile rf = new RandomAccessFile(f, "rw");
        Long length = rf.length();

        rf.seek(length);
        for (int i = 0; i < 10; i++) {
            //写入基本类型double数据
            rf.writeBytes("a bcd你好啊的撒法");
        }
        rf.seek(0);
        System.out.println(rf.readLine());
        rf.close();
    }

    @Test
    public void insert() throws Exception {
        Resource resource = new ClassPathResource("data-nio.txt");
        RandomAccessFile rf = new RandomAccessFile(resource.getFile(), "rw");
        FileChannel inChannel = rf.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead!=-1){
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        System.out.println(bytesRead);
        rf.close();
    }
}

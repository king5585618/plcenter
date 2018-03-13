package com.kakarot.plcenter.watch;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;

/**
 * 监听文件变化
 * @author jinzj
 * @since v4.0.1
 */
public class TestWatchService {

    private static final String path = "D:\\test.txt";

    public static void main(String[] args) throws IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
    }
}

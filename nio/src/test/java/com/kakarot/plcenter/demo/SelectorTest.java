package com.kakarot.plcenter.demo;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by jinzj on 2017/2/24.
 */
public class SelectorTest {

    @Test
    public void simpleSelector() throws Exception {
        Selector selector = Selector.open();
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.socket().bind(new InetSocketAddress(8080));

    }
}

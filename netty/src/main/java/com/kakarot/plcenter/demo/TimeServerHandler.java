package com.kakarot.plcenter.demo;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by jinzj on 2017/2/28.
 */
@Deprecated
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // NOOP
    }
}

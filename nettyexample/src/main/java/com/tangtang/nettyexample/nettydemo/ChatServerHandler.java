package com.tangtang.nettyexample.nettydemo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {
    public static final ChannelGroup group = new DefaultChannelGroup(
            GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        for (Channel ch : group) {
            ch.writeAndFlush(
                    "[" + channel.remoteAddress() + "] " + "is comming");
        }
        group.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        for (Channel ch : group) {
            ch.writeAndFlush(
                    "[" + channel.remoteAddress() + "] " + "is comming");
        }
        group.remove(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[" + channel.remoteAddress() + "] " + "online");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[" + channel.remoteAddress() + "] " + "offline");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        System.out.println(
                "[" + ctx.channel().remoteAddress() + "]" + "exit the room");
        ctx.close().sync();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel channel = channelHandlerContext.channel();
        for (Channel ch : group) {
            if (ch == channel) {
                ch.writeAndFlush("[you]：" + s + "\n");
            } else {
                ch.writeAndFlush(
                        "[" + channel.remoteAddress() + "]: " + s + "\n");
            }
        }
    }
}

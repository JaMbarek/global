package com.example.mvc.example.sharding.sharding.processors;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup group = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(group, work)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>(){

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel
                                .pipeline()
                                .addLast(new ChannelInboundHandlerAdapter(){
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                        ByteBuf in = (ByteBuf)msg;
                                        System.out.print(in.toString(CharsetUtil.UTF_8));
                                    }
                                } );
                    }
                })
        ;

        server.bind(8080)
                .sync()
                .channel()
                .closeFuture()
                .sync();

    }




}

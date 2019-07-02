package test.netty.test.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import test.netty.test.entity.MsgDecode;
import test.netty.test.entity.MsgEncoder;
import test.netty.test.idle.ServerHandler2;

public class ServerMain {
    private final int port;

    public ServerMain(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap sb = new ServerBootstrap();
            // 绑定线程池
            sb.group(group)
                    .channel(NioServerSocketChannel.class) // 指定使用的channel
                    .localAddress(this.port)// 绑定监听端口
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作

                                @Override
                                protected void initChannel(SocketChannel ch) throws Exception {
                                    System.out.println("connected...; Client:" + ch.remoteAddress());
                                   // ch.pipeline().addLast(new ServerHandler()); // 客户端触发操作
                                    ch.pipeline().addLast(new MsgDecode());
                                    ch.pipeline().addLast(new MsgEncoder());
                                    //设置读，写，读写 超时时间
                                    ch.pipeline().addLast(new IdleStateHandler(0, 0, 15));
                                    ch.pipeline().addLast(new ServerHandler2());
                                }
                            })
                    .option(ChannelOption.SO_BACKLOG, 128)       
                    .childOption(ChannelOption.SO_KEEPALIVE, true); 
            ChannelFuture cf = sb.bind().sync(); // 服务器异步创建绑定
            System.out.println(ServerMain.class + " started and listen on " + cf.channel().localAddress());
            cf.channel().closeFuture().sync(); // 关闭服务器通道
        } finally {
            group.shutdownGracefully().sync(); // 释放线程池资源
        }
    }

    public static void main(String[] args) throws Exception {
        new ServerMain(33333).start(); // 启动
    }
}

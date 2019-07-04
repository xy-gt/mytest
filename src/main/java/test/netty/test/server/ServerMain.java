package test.netty.test.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import test.netty.test.entity.HeadVo;
import test.netty.test.entity.MessageVo;
import test.netty.test.entity.MsgDecode;
import test.netty.test.entity.MsgEncoder;
import test.netty.test.idle.ServerHandler2;
import test.netty.test.idle.ServiceHeartbeatHandler;

import java.util.Map;
import java.util.Scanner;

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
                                    ch.pipeline().addLast(new IdleStateHandler(15, 0, 0));
                                    ch.pipeline().addLast(new ServerHandler2());
                                }
                            })
                    .option(ChannelOption.SO_BACKLOG, 128)       
                    .childOption(ChannelOption.SO_KEEPALIVE, true); 
            ChannelFuture cf = sb.bind().sync(); // 服务器异步创建绑定
            System.out.println(ServerMain.class + " started and listen on " + cf.channel().localAddress());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入通道：");
                String ip = scanner.next();
                System.out.println("请输入内容：");
                String string = scanner.next();
                if ("exit".equals(string)) {
                    break;
                }
                Map<String,ChannelHandlerContext> map =  ServiceHeartbeatHandler.connectMap;
                ChannelHandlerContext ctx = map.get(ip);

                ctx.channel().writeAndFlush(new MessageVo(new HeadVo(string.getBytes("UTF-8").length,1,3),string));
            }


            cf.channel().closeFuture().sync(); // 关闭服务器通道
        } finally {
            group.shutdownGracefully().sync(); // 释放线程池资源
        }
    }

    public static void main(String[] args) throws Exception {
        new ServerMain(33333).start(); // 启动
    }
}

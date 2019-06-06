package test.netty.test.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import test.netty.test.idle.ClientHandler2;

import java.net.InetSocketAddress;

public class ClientMain {
    private final String host;
    private final int port;
    static ChannelFuture cf ;
    public ClientMain() {
        this(0);
    }

    public ClientMain(int port) {
        this("localhost", port);
    }

    public ClientMain(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group) // 注册线程池
                    .channel(NioSocketChannel.class) // 使用NioSocketChannel来作为连接用的channel类
                    .remoteAddress(new InetSocketAddress(this.host, this.port)) // 绑定连接端口和host信息
                    .handler(new ChannelInitializer<SocketChannel>() { // 绑定连接初始化器
                                @Override
                                protected void initChannel(SocketChannel ch) throws Exception {
                                    System.out.println("connected...");
                                   // ch.pipeline().addLast(new ClientHandler());
                                    ch.pipeline().addLast(new IdleStateHandler(0, 0, 5));
                                    ch.pipeline().addLast(new ClientHandler2());
                                }
                            })
                  .option(ChannelOption.SO_KEEPALIVE, true); 
            System.out.println("created..");
            // 异步连接服务器
            cf = b.connect().sync();
            // 连接完成
            System.out.println("connected...");

            for (int i = 0; i < 10 ; i++) {
                cf.channel().write(Unpooled.copiedBuffer("333333333", CharsetUtil.UTF_8));
                Thread.sleep(3000);
                cf.channel().flush();
            }


            cf.channel().closeFuture().sync(); // 异步等待关闭连接channel
            // 关闭完成
            System.out.println("closed..");
        } finally {
            group.shutdownGracefully().sync(); // 释放线程池资源
        }
    }

    public static void main(String[] args) throws Exception {
        // 连接127.0.0.1/65535，并启动
        new ClientMain("127.0.0.1", 33333).start();
    }
  
}
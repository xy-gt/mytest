package test.netty.test.idle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import test.netty.test.entity.HeadVo;
import test.netty.test.entity.MessageVo;

import java.util.Objects;

public abstract class ClientHeartbeatHandler extends SimpleChannelInboundHandler {
    public static final int PING_MSG = 1;
    public static final int PONG_MSG = 2;
    public static final int CUSTOM_MSG = 3;
    protected String name;
    private int heartbeatCount = 0;

    public ClientHeartbeatHandler(String name) {
        this.name = name;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext context, Object msg) throws Exception {

        MessageVo mess = (MessageVo) msg;
        HeadVo headVo = mess.getHead();

        if (Objects.equals(headVo.getType(),PING_MSG)) {
            System.out.println("----------rec ping--------------");
        } else if (Objects.equals(headVo.getType(),PONG_MSG)) {
            System.out.println("----------rec pong--------------");
        } else if (Objects.equals(headVo.getType(),CUSTOM_MSG)) {
            // handleData(context, byteBuf);
            System.out.println("----------------------client rec---------------------"+msg);
        }
    }

    protected abstract void handleData(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // IdleStateHandler 所产生的 IdleStateEvent 的处理逻辑.
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:
                    handleReaderIdle(ctx);
                    break;
                case WRITER_IDLE:
                    handleWriterIdle(ctx);
                    break;
                case ALL_IDLE:
                    handleAllIdle(ctx);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.err.println("---" + ctx.channel().remoteAddress() + " is active---");
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                    System.out.println("发送心跳--------------ping------------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctx.writeAndFlush(new MessageVo(new HeadVo(4,1,PING_MSG),"ping"));

           /*     ByteBuf byteBuf = ctx.alloc().buffer(5);
                byteBuf.writeInt(5);
                byteBuf.writeByte(1);
                ctx.writeAndFlush(byteBuf);*/
            }
        }).start();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx)  {
        System.err.println("---" + ctx.channel().remoteAddress() + " is inactive---");
    }

    protected void handleReaderIdle(ChannelHandlerContext ctx) {
        System.err.println("---READER_IDLE---");
    }

    protected void handleWriterIdle(ChannelHandlerContext ctx) {
        System.err.println("---WRITER_IDLE---");
    }

    protected void handleAllIdle(ChannelHandlerContext ctx) {
        System.err.println("---ALL_IDLE---");
    }
}

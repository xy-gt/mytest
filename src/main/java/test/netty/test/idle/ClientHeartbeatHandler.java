package test.netty.test.idle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import test.netty.test.client.ClientMain;
import test.netty.test.entity.HeadVo;
import test.netty.test.entity.MessageVo;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class ClientHeartbeatHandler extends SimpleChannelInboundHandler {
    public static final int PING_MSG = 1;
    public static final int PONG_MSG = 2;
    public static final int CUSTOM_MSG = 3;
    public static final int REGISTER = 4;

    @Override
    protected void channelRead0(ChannelHandlerContext context, Object msg) throws Exception {

        MessageVo mess = (MessageVo) msg;
        HeadVo headVo = mess.getHead();

        if (Objects.equals(headVo.getType(),PING_MSG)) {
            System.out.println("----------rec ping--------------");
        } else if (Objects.equals(headVo.getType(),PONG_MSG)) {
            System.out.println("----------rec pong--------------");
        } else if (Objects.equals(headVo.getType(),CUSTOM_MSG)) {
            recMsg(context,msg);
        }
    }

    protected abstract void recMsg(ChannelHandlerContext channelHandlerContext, Object msg);

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
        //开始连接
        System.err.println("---" + ctx.channel().remoteAddress() + " is active---");
        ctx.writeAndFlush(new MessageVo(new HeadVo(8,1,REGISTER),"register"));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //服务端断开连接
        System.err.println("---" + ctx.channel().remoteAddress() + " is inactive---");
        //重连
        new ClientMain("127.0.0.1", 33333).start();
    }

    protected void handleReaderIdle(ChannelHandlerContext ctx) {
        System.err.println("---READER_IDLE---");
    }

    protected void handleWriterIdle(ChannelHandlerContext ctx) {

        System.err.println("--- cli write idle send ping---");
        ctx.writeAndFlush(new MessageVo(new HeadVo(4,1,PING_MSG),"ping"));
    }

    protected void handleAllIdle(ChannelHandlerContext ctx) {
        //读写超时
        System.err.println("---ALL_IDLE---");
    }
    /**
     * 异常
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client occur exception:" + cause.getMessage());
        // cause.printStackTrace();
        ctx.close(); // 关闭发生异常的连接
    }
}

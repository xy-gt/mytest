package test.netty.test.idle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import test.netty.test.entity.HeadVo;
import test.netty.test.entity.MessageVo;

import java.net.SocketAddress;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Sharable
public abstract class ServiceHeartbeatHandler extends SimpleChannelInboundHandler<Object> {
    public static final int PING_MSG = 1;
    public static final int PONG_MSG = 2;
    public static final int CUSTOM_MSG = 3;
    public static final int REGISTER = 4;

    protected String name;
    public static final ConcurrentMap<String,ChannelHandlerContext> connectMap = new ConcurrentHashMap();
    @Override
    protected void channelRead0(ChannelHandlerContext context, Object msg) throws Exception {

        MessageVo mess = (MessageVo) msg;
        HeadVo headVo = mess.getHead();

        if (Objects.equals(headVo.getType(),PING_MSG)) {
            sendPongMsg(context);
        } else if (Objects.equals(headVo.getType(),PONG_MSG)) {
            System.out.println("----------sned pong--------------");
        } else if (Objects.equals(headVo.getType(),CUSTOM_MSG)) {
           recMsg(context,msg);
        } else {
              String addr = context.channel().remoteAddress().toString();
              mess.setChannelId(addr.substring(addr.indexOf(":")));
              register(context,mess.getContent());
        }
    }

    protected void sendPingMsg(ChannelHandlerContext context) throws InterruptedException {
        context.writeAndFlush(new MessageVo(new HeadVo(4,1,PING_MSG),"ping"));
     /*   ByteBuf buf = context.alloc().buffer(5);
        buf.writeInt(5);
        buf.writeByte(PING_MSG);
        context.writeAndFlush(buf);
        heartbeatCount++;
        System.out.println(name + " sent ping msg to " + context.channel().remoteAddress() + ", count: " + heartbeatCount);*/
    }

    private void sendPongMsg(ChannelHandlerContext context) throws InterruptedException {

        context.writeAndFlush(new MessageVo(new HeadVo(4,1,PONG_MSG),"pong"));
       /* ByteBuf buf = context.alloc().buffer(5);
        buf.writeInt(5);
        buf.writeByte(PONG_MSG);
        context.channel().writeAndFlush(buf);
        heartbeatCount++;
        System.out.println(name + " sent pong msg to " + context.channel().remoteAddress() + ", count: " + heartbeatCount);*/
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
    public void channelActive(ChannelHandlerContext ctx)  {
        System.err.println("---" + ctx.channel().remoteAddress() + " is active---");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx)  {
        System.err.println("---" + ctx.channel().remoteAddress() + " is inactive---");
        connectMap.remove(ctx.channel().remoteAddress().toString());
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

    /**
     * 注册
     * @param ctx
     */
    public void register(ChannelHandlerContext ctx, String msg) {
        String addr = ctx.channel().remoteAddress().toString();
        connectMap.put(addr.substring(addr.indexOf(":")+1),ctx);
    }

    /**
     * 异常
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server occur exception:" + cause.getMessage());
       // cause.printStackTrace();
        ctx.close(); // 关闭发生异常的连接
    }
}

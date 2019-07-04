package test.netty.test.idle;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import test.netty.test.entity.MessageVo;

@Sharable
public class ServerHandler2 extends ServiceHeartbeatHandler {

    @Override
    protected void recMsg(ChannelHandlerContext channelHandlerContext, Object msg) {
        System.out.println("----------------------service rec---------------------");

        MessageVo mess = (MessageVo) msg;
        System.out.println(mess.getContent());
    }


    @Override
    protected void handleReaderIdle(ChannelHandlerContext ctx) {
        super.handleReaderIdle(ctx);
        System.err.println("---client " + ctx.channel().remoteAddress().toString() + " reader timeout, close it---");
        ctx.close();
    }
}
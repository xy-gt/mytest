package test.netty.test.idle;

import io.netty.channel.ChannelHandlerContext;
import test.netty.test.entity.HeadVo;
import test.netty.test.entity.MessageVo;

public class ClientHandler2 extends ClientHeartbeatHandler {

    @Override
    protected void recMsg(ChannelHandlerContext channelHandlerContext, Object msg) {
        System.out.println("----------------------client rec---------------------");
        MessageVo mess = (MessageVo) msg;
        System.out.println(mess.getContent());
    }

    @Override
    protected void handleAllIdle(ChannelHandlerContext ctx) {
        super.handleAllIdle(ctx);
    }
}
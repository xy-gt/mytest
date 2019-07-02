package test.netty.test.entity;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

/**
 * @Description:  编码
 * @Author: panda
 * @Date: 2019/7/2 13:57
 */
public class MsgEncoder extends MessageToByteEncoder<MessageVo> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageVo myMessage, ByteBuf byteBuf) throws Exception {

        int length = myMessage.getHead().getLength();
        int version = myMessage.getHead().getVersion();
        int type = myMessage.getHead().getType();
        String content = myMessage.getContent();

        byteBuf.writeInt(length);
        byteBuf.writeInt(version);
        byteBuf.writeInt(type);
        byteBuf.writeBytes(content.getBytes(Charset.forName("UTF-8")));

    }
}

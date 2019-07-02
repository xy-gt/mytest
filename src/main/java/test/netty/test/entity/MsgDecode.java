package test.netty.test.entity;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Description: 解码
 * @Author: panda
 * @Date: 2019/7/2 13:58
 */
public class MsgDecode extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        int length = byteBuf.readInt();
        int version = byteBuf.readInt();
        int type = byteBuf.readInt();

        byte[] body = new byte[length];
        byteBuf.readBytes(body);

        String content = new String(body, Charset.forName("UTF-8"));

        MessageVo myMessage = new MessageVo(new HeadVo(length,version,type),content);

        list.add(myMessage);
    }
}

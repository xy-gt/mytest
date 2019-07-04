package test.netty.test.send;

import io.netty.channel.ChannelHandlerContext;
import test.netty.test.entity.HeadVo;
import test.netty.test.entity.MessageVo;
import test.netty.test.idle.ServiceHeartbeatHandler;

import java.util.Map;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/3 10:26
 */
public class ClientToServer {

    public static void main(String[] args) {
      Map<String,ChannelHandlerContext> map =  ServiceHeartbeatHandler.connectMap;
      ChannelHandlerContext ctx = map.get("/127.0.0.1:58562");
      ctx.writeAndFlush(new MessageVo(new HeadVo(4,1,3),"sssssssss"));
    }
}

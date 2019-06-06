package test.netty.test1.entity;

import test.netty.test1.MsgType;

public class PingMsg extends BaseMsg {
    public PingMsg() {
        super();
        setType(MsgType.PING);
    }
}

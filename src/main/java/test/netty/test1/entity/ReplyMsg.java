package test.netty.test1.entity;

import test.netty.test1.MsgType;

public class ReplyMsg extends BaseMsg {
    public ReplyMsg() {
        super();
        setType(MsgType.REPLY);
    }
    private ReplyBody body;
 
    public ReplyBody getBody() {
        return body;
    }
 
    public void setBody(ReplyBody body) {
        this.body = body;
    }
}
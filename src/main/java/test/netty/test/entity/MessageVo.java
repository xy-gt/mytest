package test.netty.test.entity;

import java.io.Serializable;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/2 13:55
 */
public class MessageVo implements Serializable {
    //消息head
    private HeadVo head;
    //消息body
    private String content;

    private String channelId;

    public MessageVo(HeadVo head, String content) {
        this.head = head;
        this.content = content;
    }

    public HeadVo getHead() {
        return head;
    }

    public void setHead(HeadVo head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "head=" + head +
                ", content='" + content + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }
}

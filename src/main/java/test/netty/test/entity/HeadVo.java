package test.netty.test.entity;

import java.io.Serializable;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/2 13:54
 */
public class HeadVo implements Serializable {
    //数据长度
    private int length;

    //数据版本
    private int version;

    private int type;

    public HeadVo(int length, int version, int type) {
        this.length = length;
        this.version = version;
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HeadVo{" +
                "length=" + length +
                ", version=" + version +
                ", type=" + type +
                '}';
    }
}

package test.enums;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/7/4 9:46
 */
public enum SourceEnum {

        /**
         * 数据库使用时，存入的是 name属性，所以 一经使用，千万不要修改name
         */
        UNKNOW(0,"未知"),
        APP(1,"APP"),
        IOS(11,"IOS-APP"),
        Android(12,"Android-APP"),
        WX_SHOP(2,"微信商城"),
        WEB(3,"WEB"),
        WX_SUBSCRIBE(4,"微信订阅号"),
        WX_SERVICE(5,"微信服务号"),

        CTI(9,"CTI"),
        WXMINI(10,"小程序"),
        PARTNER_WX_MINI(13,"合伙人小程序"),
        NECO_WX_MINI(14,"NECO小程序");

        SourceEnum(Integer code,String remark){
            this.code = code;
            this.remark = remark;
        }

        private Integer code;

        private String remark;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

}

package test.enums;

public enum SourceEnum {

        APP(1,"APP"),
        IOS(11,"IOS-APP"),
        Android(12,"Android-APP"),
        WX_SHOP(2,"微信商城"),
        WEB(3,"WEB"),
        WX_SUBSCRIBE(4,"微信订阅号"),
        WX_SERVICE(5,"微信服务号");

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

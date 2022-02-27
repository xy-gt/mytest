package test.test;


public class AA {
    private Integer a = 1;
    private String name = "test";

    private String a_s;
    private String as2;

    public synchronized Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA_s() {
        return a_s;
    }

    public void setA_s(String a_s) {
        this.a_s = a_s;
    }

    public String getAs2() {
        return as2;
    }

    public void setAs2(String as2) {
        this.as2 = as2;
    }

    public class  AA2 {
        private Integer a2 = 12;
        private String name2 = "test2";

       /* public void test() {
            System.out.println(a);
        }*/

        public Integer getA2() {
            return a2;
        }

        public void setA2(Integer a2) {
            this.a2 = a2;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }
    }
}

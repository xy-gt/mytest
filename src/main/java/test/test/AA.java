package test.test;

/**
 * 内部类
 *
 * 内部内调用外部参数： 因为内部类构造器传入了外部类的this引用
 */
public class AA {
    private Integer a = 1;
    private String name = "test";

    public Integer getA() {
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

    public class  AA2 {
        private Integer a2 = 12;
        private String name2 = "test2";

        public void test() {
            System.out.println(a);
        }

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

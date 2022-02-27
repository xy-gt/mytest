package test.jfrog;

import org.jfrog.artifactory.client.Artifactory;
import org.jfrog.artifactory.client.ArtifactoryClientBuilder;

import java.io.File;
import java.util.function.Function;

public class JfrogTest {
   private static Artifactory artifactory;
    static {
         artifactory = ArtifactoryClientBuilder.create()
                .setUrl("http://192.168.2.196:8081/artifactory")
                .setUsername("xiongyong")
                .setPassword("AKCp8ihVdSGsXaVPtwBHEQNpMkrnQfmTaxhApUSVs8qQXqCioTyhHjZnvkqtPRf3PXsAtJN9c")
                .build();
    }

    public static void main(String[] args) {
    /*    artifactory.repository("s").upload("",new File("")).doUpload();
        artifactory.repository("jfrog-local-snapshot").delete("/test/aa2.txt");*/

        System.out.println("ssss--");
        new JfrogTest().test(p -> {
            System.out.println(p);
            return p;
        });


    }


    public void test(Function function) {

        function.apply("aaaaaaa");
    }

}



package test.jfrog.Model;

import lombok.Data;

import java.util.List;

/**
 * 制品库rest 接口返回
 * @Author xiongyong
 * @Date 2021/8/19
 */

@Data
public class ArtifactRestDTO {


    private List<ArtifactUri> results;




    @Data
    public static class ArtifactUri {

        private String uri;
    }

}

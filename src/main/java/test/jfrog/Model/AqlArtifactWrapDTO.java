package test.jfrog.Model;

import lombok.Data;

import java.util.List;

/**
 * @author qiaofazhan
 * @version 1.0
 * @date 2020/4/20 17:20
 */
@Data
public class AqlArtifactWrapDTO {
    private List<AqlArtifactDTO> results;
    private Range range;

    @Data
 public   class Range{
        private Integer startPos;
        private Integer endPos;
        private Integer limit;
        private Integer total;
    }
}

package test.jfrog.Model;

import lombok.Data;

import java.util.List;

/**
 * 制品目录
 * @Author xiongyong
 * @Date 2021/2/24
 */

@Data
public class ArtifactStorageDTO {

    private String repo;

    private String path;

    private List<StorageItem> children;


}

@Data
class StorageItem {
    private String uri;
    private String folder;
}

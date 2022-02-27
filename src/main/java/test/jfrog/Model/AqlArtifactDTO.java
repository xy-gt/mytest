package test.jfrog.Model;

import lombok.Data;

import java.util.Date;


@Data
public class AqlArtifactDTO {
    private String  repo;
    private String  path;
    private Integer  depth;
    private String  name;
    private String  type;
    private Long  size;
    private Date created;
    private String  created_by;
    private Date updated;
    private String  modified_by;
}

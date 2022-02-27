package test.jfrog.Model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JfrogGroup implements Serializable {

    private String name;
    private String description;

    private String realm;

    private String realmAttributes;

    private Boolean autoJoin;

    private Boolean adminPrivileges;

    private List<String> usersInGroup;

    private List<String> userNames;

}

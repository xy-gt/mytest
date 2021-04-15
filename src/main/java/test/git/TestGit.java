package test.git;

import cn.hutool.core.date.DateUtil;
import org.gitlab4j.api.Constants;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.Pager;
import org.gitlab4j.api.models.*;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

/**
 * 测试git 操作
 * @Author xiongyong
 * @Date 2021/3/8
 */


public class TestGit {
  // public static String hosturl = "https://gitnew.hundsun.com";
   public static String hosturl = "https://192.168.35.78:443";
   private static String token = "kC1Rwx42y7RTufSk2qPW";

   public static GitLabApi gitLabApi = new GitLabApi(hosturl,token);

    public static void main(String[] args) throws GitLabApiException {

        Group group = new Group();
        group.setName("test-api");
        group.setPath("test-api");
        //group.setVisibility(Visibility.PRIVATE);

        //Group group1 = gitLabApi.getGroupApi().updateGroup(group);

        //gitLabApi.getGroupApi().deleteGroup("test-api2");

        List<Group> groups = gitLabApi.getGroupApi().getGroups("test-api");
        System.out.println(groups);


   /*   GitLabApi a = new GitLabApi(hosturl, Constants.TokenType.PRIVATE,"4miEzrXcL4WgR6q2Bdg9");

       Project project = a.getProjectApi().getProject("157");*/
      /*  List<User> users = gitLabApi.getUserApi().getActiveUsers();
        System.out.println(users);
*/
      /*  List<ImpersonationToken> test_u1 = gitLabApi.getUserApi().getImpersonationTokens(105);
        System.out.println(test_u1);

        for (ImpersonationToken impersonationToken : test_u1) {
          gitLabApi.getUserApi().revokeImpersonationToken(105,impersonationToken.getId());
        }*/

       /* LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(1);
        Date date = Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());

*/

       //gitLabApi.getProjectApi().addMember(157,107,AccessLevel.MAINTAINER,new Date());

        //gitLabApi.getRepositoryApi().protectBranch(157,"test");

        // 预读取1条 调用page 方法真正获取数据
      /*  Pager<Commit> test = gitLabApi.getCommitsApi().getCommits(157, "test", null, null, 10);

        System.out.println(test.page(1));*/

        //master.page(3)


        //gitLabApi.getRepositoryApi().createBranch(218,"test2","master");

    }

}

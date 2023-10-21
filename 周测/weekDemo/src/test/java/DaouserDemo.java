import entity.daoentity.KfmUser;
import org.junit.Test;
import utils.dao.basesoperations.DbUtilsHelper;

/**
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 11:02
 */
public class DaouserDemo {
    @Test
    public void selectByUsernameAndPassword() {
        String username = "admin";
        String password = "admin";
        String sql = "select id, username, name from kfm_user where username = ? and password = ?";
        System.out.println(DbUtilsHelper.queryOne(sql, KfmUser.class, username, password).toString());
    }


}

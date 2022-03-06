package exp.libs.db.sql;

import exp.libs.conf.xml.DBConfig;
import exp.libs.db.sql.bean.DataSourceBean;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// FIXME docker
class DBUtilsTest {

    private static DBConfig conf;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        conf = DBConfig.getInstn();
        conf.loadConfFile("./conf/conf_demo.xml");
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    @Ignore
    public void testDBUtils() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testGetConn() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testGetConnByPool() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testGetConnByJDBC() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testGetConnNeverOT() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testSetAutoCommit() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testClose() {
        fail("Not yet implemented");
    }

    @Test
    public void testCreateBeanFromDB() {
        DataSourceBean ds = conf.getDataSourceBean("TEST-DS-SQL");
        Connection conn = DBUtils.getConn(ds);
        DBUtils.createBeanFromDB(conn,
                "exp.libs.bean.test",
                "./src/test/java/exp/libs/bean/test",
                new String[] {
                        "t_mt_ems",
                        "t_mt_fault",
                });
        DBUtils.close(conn);
        System.out.println("ok");
    }

    @Ignore
    public void testCreateBeanFromPDM() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testJudgeDBType() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testQueryKvs() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testQueryKvo() {
        fail("Not yet implemented");
    }

    @Test
    public void testQuery() {
        DataSourceBean ds = conf.getDataSourceBean("TEST");
        Connection conn = DBUtils.getConn(ds);
        List<TMtFault> list = DBUtils.query(TMtFault.class, conn, TMtFault.SQL_SELECT);
        for(TMtFault bean : list) {
            System.out.println(bean);
        }
        DBUtils.close(conn);
    }

    @Ignore
    public void testQueryNum() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testExecuteConnectionStringObjectArray() {
        fail("Not yet implemented");
    }

    @Ignore
    public void testExecuteConnectionString() {
        fail("Not yet implemented");
    }

}
package exp.libs.conf.xml;

import exp.libs.db.redis.bean.RedisBean;
import exp.libs.db.sql.bean.DataSourceBean;
import exp.libs.utils.num.NumUtils;
import exp.libs.utils.other.BoolUtils;
import exp.libs.utils.str.StrUtils;

/**
 * DB 专用的 xml 配置加载器，支持读取以下默认的配置结构：
 *  1. datasource
 *  2. redis
 *
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a>
 * @version   2017-08-25
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class DBConfig extends _Config {

    /** 单例 */
    private static volatile DBConfig instance;

    /**
     * 构造函数
     * @param name 配置器名称
     */
    protected DBConfig(String name) {
        super(name);
    }

    /**
     * 获取数据库配置单例
     * @return 数据库配置单例
     */
    public static DBConfig getInstn() {
        if(instance == null) {
            synchronized (DBConfig.class) {
                if(instance == null) {
                    instance = new DBConfig("DEFAULT_DB_CONFIG");
                }
            }
        }
        return instance;
    }

    /**
     * 根据标准配置模板获取数据源配置
     * @param dsId 数据源配置 ID
     * @return 数据源配置
     */
    public DataSourceBean getDataSourceBean(String dsId) {
        DataSourceBean ds = new DataSourceBean();
        if(StrUtils.isEmpty(dsId)) {
            return ds;
        }

        String xPath = toXPath("datasource", dsId);
        XNode xNode = findXNode(xPath);
        if(xNode != NULL_XNODE) {
            ds.setId(dsId);
            ds.setDriver(xNode.getChildVal("driver"));
            ds.setIp(xNode.getChildVal("ip"));
            ds.setPort(NumUtils.toInt(xNode.getChildVal("port")));
            ds.setUsername(xNode.getChildVal("username"));
            ds.setPassword(xNode.getChildVal("password"));
            ds.setName(xNode.getChildVal("name"));
            ds.setCharset(xNode.getChildVal("charset"));
            ds.setMaximumActiveTime(NumUtils.toLong(xNode.getChildVal("maximum-active-time"), -1));
            ds.setHouseKeepingTestSql(xNode.getChildVal("house-keeping-test-sql"));
            ds.setHouseKeepingSleepTime(NumUtils.toLong(xNode.getChildVal("house-keeping-sleep-time"), -1));
            ds.setSimultaneousBuildThrottle(NumUtils.toInt(xNode.getChildVal("simultaneous-build-throttle"), -1));
            ds.setMaximumConnectionCount(NumUtils.toInt(xNode.getChildVal("maximum-connection-count"), -1));
            ds.setMinimumConnectionCount(NumUtils.toInt(xNode.getChildVal("minimum-connection-count"), -1));
            ds.setMaximumNewConnections(NumUtils.toInt(xNode.getChildVal("maximum-new-connections"), -1));
            ds.setPrototypeCount(NumUtils.toInt(xNode.getChildVal("prototype-count"), -1));
            ds.setMaximumConnectionLifetime(NumUtils.toLong(xNode.getChildVal("maximum-connection-lifetime"), -1));
            ds.setTestBeforeUse(BoolUtils.toBool(xNode.getChildVal("test-before-use"), false));
            ds.setTestAfterUse(BoolUtils.toBool(xNode.getChildVal("test-after-use"), false));
            ds.setTrace(BoolUtils.toBool(xNode.getChildVal("trace"), true));
        }
        return ds;
    }

    /**
     * 根据标准配置模板获取 Redis 数据源配置
     * @param redisId Redis 数据源 ID
     * @return Redis 数据源配置
     */
    public RedisBean getRedisBean(String redisId) {
        RedisBean rb = new RedisBean();
        if(StrUtils.isEmpty(redisId)) {
            return rb;
        }

        String xPath = toXPath("redis", redisId);
        XNode xNode = findXNode(xPath);
        if(xNode != NULL_XNODE) {
            rb.setId(redisId);
            rb.setCluster(BoolUtils.toBool(xNode.getChildVal("cluster"), false));
            rb.addSockets(xNode.getChildVal("sockets"));
            rb.setPassword(xNode.getChildVal("password"));
            rb.setTimeout(NumUtils.toInt(xNode.getChildVal("timeout"), 0));
            rb.setMaxTotal(NumUtils.toInt(xNode.getChildVal("maxTotal"), 0));
            rb.setMaxIdle(NumUtils.toInt(xNode.getChildVal("maxIdle"), 0));
            rb.setMaxWaitMillis(NumUtils.toLong(xNode.getChildVal("maxWaitMillis"), -1));
            rb.setTestOnBorrow(BoolUtils.toBool(xNode.getChildVal("testOnBorrow"), true));
        }
        return rb;
    }

}

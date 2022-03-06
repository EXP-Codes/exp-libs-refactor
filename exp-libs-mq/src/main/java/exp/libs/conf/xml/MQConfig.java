package exp.libs.conf.xml;

import exp.libs.mq.jms.bean.JmsBean;
import exp.libs.utils.str.StrUtils;

/**
 * MQ 专用的 xml 配置加载器，支持读取以下默认的配置结构：
 *  1. jms
 *  2. kafka
 *
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a>
 * @version   2017-08-25
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class MQConfig extends _Config {

    /** 单例 */
    private static volatile MQConfig instance;
    
    /**
     * 构造函数
     * @param name 配置器名称
     */
    protected MQConfig(String name) {
        super(name);
    }

    /**
     * 获取数据库配置单例
     * @return 数据库配置单例
     */
    public static MQConfig getInstn() {
        if(instance == null) {
            synchronized (MQConfig.class) {
                if(instance == null) {
                    instance = new MQConfig("DEFAULT_DB_CONFIG");
                }
            }
        }
        return instance;
    }

    public JmsBean getJmsBean(String jmsId) {
        JmsBean jb = new JmsBean();
        if(StrUtils.isEmpty(jmsId)) {
            return jb;
        }

        String xPath = toXPath("jms", jmsId);
        XNode xNode = findXNode(xPath);
        if(xNode != NULL_XNODE) {
            // TODO
        }
        return jb;
    }
    
}

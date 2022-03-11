package exp.libs.conf.xml;

import exp.libs.sock.socket.bean.SocketBean;
import exp.libs.utils.num.NumUtils;
import exp.libs.utils.str.StrUtils;

/**
 * Socket 专用的 xml 配置加载器，支持读取以下默认的配置结构：
 *  1. socket
 *
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class SocketConfig extends _Config {

    /** 单例 */
    private static volatile SocketConfig instance;

    /**
     * 构造函数
     * @param name 配置器名称
     */
    protected SocketConfig(String name) {
        super(name);
    }

    /**
     * 获取数据库配置单例
     * @return 数据库配置单例
     */
    public static SocketConfig getInstn() {
        if(instance == null) {
            synchronized (SocketConfig.class) {
                if(instance == null) {
                    instance = new SocketConfig("DEFAULT_DB_CONFIG");
                }
            }
        }
        return instance;
    }

    public SocketBean getSocketBean(String sockId) {
        SocketBean sb = new SocketBean();
        if(StrUtils.isEmpty(sockId)) {
            return sb;
        }

        String xPath = toXPath("socket", sockId);
        XNode xNode = findXNode(xPath);
        if(xNode != NULL_XNODE) {
            sb.setId(sockId);
            sb.setIp(xNode.getChildVal("ip"));
            sb.setPort(NumUtils.toInt(xNode.getChildVal("port")));
            sb.setUsername(xNode.getChildVal("username"));
            sb.setPassword(xNode.getChildVal("password"));
            sb.setCharset(xNode.getChildVal("charset"));
            sb.setReadCharset(xNode.getChildVal("readCharset"));
            sb.setWriteCharset(xNode.getChildVal("writeCharset"));
            sb.setBufferSize(NumUtils.toInt(xNode.getChildVal("bufferSize"), -1));
            sb.setReadBufferSize(NumUtils.toInt(xNode.getChildVal("readBufferSize"), -1));
            sb.setWriteBufferSize(NumUtils.toInt(xNode.getChildVal("writeBufferSize"), -1));
            sb.setDelimiter(xNode.getChildVal("delimiter"));
            sb.setReadDelimiter(xNode.getChildVal("readDelimiter"));
            sb.setWriteDelimiter(xNode.getChildVal("writeDelimiter"));
            sb.setOvertime(NumUtils.toInt(xNode.getChildVal("overtime"), -1));
            sb.setMaxConnectionCount(NumUtils.toInt(xNode.getChildVal("maxConnectionCount"), -1));
            sb.setExitCmd(xNode.getChildVal("exitCmd"));
        }
        return sb;
    }

}

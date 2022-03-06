package exp.libs.envm;

/**
 * <PRE>
 * 枚举类：编码
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Charset {

    /** 系统默认编码 */
    public final static String DEFAULT = System.getProperty("sun.jnu.encoding");
    
    /** UNICODE编码 */
    public final static String UNICODE = "UNICODE";
    
    /** UTF-8编码 */
    public final static String UTF8 = "UTF-8";
    
    /** GBK编码（繁简） */
    public final static String GBK = "GBK";
    
    /** GB2312编码（简） */
    public final static String GB2312 = "GB2312";
    
    /** ASCII编码（ISO-8859-1） */
    public final static String ASCII = "ISO-8859-1";
    
    /** ISO-8859-1编码  */
    public final static String ISO = "ISO-8859-1";
    
}

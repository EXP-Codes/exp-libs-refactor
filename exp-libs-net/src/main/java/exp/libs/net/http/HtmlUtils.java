package exp.libs.net.http;

import exp.libs.envm.Charset;
import exp.libs.utils.str.StrUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * <PRE>
 * html 内容处理工具（与 jsoup 搭配使用）
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-10-02
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class HtmlUtils {

    /** 日志器 */
    private final static Logger log = LoggerFactory.getLogger(HtmlUtils.class);

    /** 默认编码 */
    private final static String DEFAULT_CHARSET = Charset.UTF8;

    /** 私有化构造函数 */
    protected HtmlUtils() {}

    public static String getFirstTextByTag(Element parent, String tagName) {
        String text = "";
        if (parent != null) {
            Elements elements = parent.getElementsByTag(tagName);
            for(Element element : elements) {
                text = element.text();
                break;
            }
        }
        return text;
    }

    public static Element getFirstElementByAtt(Element parent, String attKey) {
        Element e = null;
        if (parent != null) {
            Elements elements = parent.getElementsByAttribute(attKey);
            for(Element element : elements) {
                e = element;
                break;
            }
        }
        return e;
    }

    public static Element getFirstElementByClass(Element parent, String className) {
        Element e = null;
        if (parent != null) {
            Elements elements = parent.getElementsByClass(className);
            for(Element element : elements) {
                e = element;
                break;
            }
        }
        return e;
    }

    public static String getFirstTextByClass(Element parent, String className) {
        String text = "";
        if (parent != null) {
            Elements elements = parent.getElementsByClass(className);
            for(Element element : elements) {
                text = element.text();
                break;
            }
        }
        return text;
    }

    public static List<String> getAllTextByClass(Element parent, String className) {
        List<String> texts = new LinkedList<>();
        if (parent != null) {
            Elements elements = parent.getElementsByClass(className);
            for(Element element : elements) {
                texts.add(element.text());
            }
        }
        return texts;
    }

    public static List<String> getAllImageByClass(Element parent, String className, String urlAttName) {
        List<String> urls = new LinkedList<>();
        if (parent != null) {
            Elements elements = parent.getElementsByClass(className);
            for(Element element : elements) {
                String url = element.attr(urlAttName);
                if (url.startsWith("//")) {
                    url = StrUtils.concat("https:", url);
                }
                urls.add(url);
            }
        }
        return urls;
    }

    public static List<String> getAllVideoByTag(Element parent, String tagName, String urlAttName) {
        List<String> urls = new LinkedList<>();
        if (parent != null) {
            Elements elements = parent.getElementsByClass(tagName);
            for(Element element : elements) {
                String url = element.attr(urlAttName);
                if (url.startsWith("//")) {
                    url = StrUtils.concat("https:", url);
                }
                urls.add(url);
            }
        }
        return urls;
    }

}

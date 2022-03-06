package exp.libs.conf.xml;

/**
 * 配置文件属性
 *
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class _ConfFileAttribute {

    /** 磁盘上的配置文件 */
    protected final static int DISK_FILE = 0;

    /** jar包内的配置文件 */
    protected final static int JAR_FILE = 1;

    private int fileType;

    private String filePath;

    protected _ConfFileAttribute(int fileType, String filePath) {
        this.fileType = fileType;
        this.filePath = filePath;
    }

    public int getFileType() {
        return fileType;
    }

    public String getFilePath() {
        return filePath;
    }

}

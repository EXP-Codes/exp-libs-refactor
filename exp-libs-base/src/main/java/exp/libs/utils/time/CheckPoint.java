package exp.libs.utils.time;

import exp.libs.utils.num.IDUtils;

/**
 * <PRE>
 * 检查点对象。
 * 配合 QuickTimer 使用
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-10-13
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class CheckPoint {

    private String name;

    private long bgnTime;

    private long endTime;

    private long diffTime;

    public CheckPoint(String name) {
        this.name = (name == null ? String.valueOf(IDUtils.getTimeID()) : name);
        this.bgnTime = 0;
        this.endTime = 0;
        this.diffTime = 0;
    }

    public String getName() {
        return name;
    }

    protected CheckPoint setName(String name) {
        this.name = name;
        return this;
    }

    public long getBgnTime() {
        return bgnTime;
    }

    protected CheckPoint setBgnTime(long bgnTime) {
        this.bgnTime = bgnTime;
        return this;
    }

    public long getEndTime() {
        return endTime;
    }

    protected CheckPoint setEndTime(long endTime) {
        this.endTime = endTime;
        this.diffTime = endTime - bgnTime;
        return this;
    }

    public long getDiffTime() {
        return this.diffTime;
    }

}

package exp.libs.utils.time;

import java.util.LinkedList;
import java.util.List;

/**
 * <PRE>
 * 快捷计时器
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-09-25
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class QuickTimer {

    private List<Long> checkPoints;

    private long lastCheckpoint;

    public QuickTimer() {
        this.checkPoints = new LinkedList<>();

        this.lastCheckpoint = System.currentTimeMillis();
        checkPoints.add(lastCheckpoint);
    }

    /**
     * 记录检查点
     * @return 当前检查点 与 上一检查点 之间经过的毫秒数
     */
    public long checkpoint() {
        long checkpoint = System.currentTimeMillis();
        long diff = checkpoint - lastCheckpoint;
        lastCheckpoint = checkpoint;
        checkPoints.add(lastCheckpoint);
        return diff;
    }

    /**
     * 获取历史所有计时的时间点
     * @return 返回检查点列表
     */
    public List<Long> getHistoryCheckPoints() {
        return checkPoints;
    }

    /**
     * 清除历史所有计时的时间点
     */
    public void clearCheckPoints() {
        checkPoints.clear();
    }

}

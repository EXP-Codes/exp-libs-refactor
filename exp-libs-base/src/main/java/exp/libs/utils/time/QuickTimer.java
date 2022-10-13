package exp.libs.utils.time;

import exp.libs.utils.other.EscapeUtils;
import exp.libs.utils.other.ListUtils;

import java.util.*;

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

    private Map<String, CheckPoint> checkPointMap;

    private List<CheckPoint> checkPointList;

    private CheckPoint lastCheckpoint;

    private boolean isTiming;

    public QuickTimer() {
        this.checkPointMap = new HashMap<>();
        this.checkPointList = new LinkedList<>();

        this.lastCheckpoint = null;
        this.isTiming = false;
    }

    private void add(CheckPoint checkPoint) {
        this.checkPointMap.put(checkPoint.getName(), checkPoint);
        this.checkPointList.add(checkPoint);
    }

    /**
     * 启动计时器
     * @return 启动的时间点（毫秒）
     */
    public long start() {
        return start(null);
    }

    /**
     * 启动计时器
     * @param name 计时器名称
     * @return 启动的时间点（毫秒）
     */
    public long start(String name) {
        return start(name, System.currentTimeMillis());
    }

    private long start(String name, long time) {
        if (isTiming) {
            return lastCheckpoint.getBgnTime();
        }

        isTiming = true;
        CheckPoint cp = new CheckPoint(name);
        cp.setBgnTime(time);
        add(cp);
        lastCheckpoint = cp;
        return time;
    }

    /**
     * 停止计时器
     * @return 停止的时间点（毫秒）
     */
    public long stop() {
        return stop(System.currentTimeMillis());
    }

    private long stop(long time) {
        if (!isTiming) {
            return lastCheckpoint.getEndTime();

        } else if (lastCheckpoint == null) {
            return -1;
        }

        isTiming = false;
        lastCheckpoint.setEndTime(time);
        return time;
    }

    /**
     * 计算最后一次计时经过的毫秒数
     * @return 获取当前计时经过的毫秒数
     */
    public long lastDiffMillis() {
        return isTiming ? -1 : (
                lastCheckpoint == null ? -1 : lastCheckpoint.getDiffTime()
        );
    }

    /**
     * 计算总共计时经过的毫秒数
     * @return 第一次和最后一次检查点之间经过的毫秒数
     */
    public long allDiffMillis() {
        if (checkPointList.size() <= 0) {
            return 0;
        }
        CheckPoint head = checkPointList.get(0);
        CheckPoint tail = lastCheckpoint;
        return (isTiming ? lastCheckpoint.getBgnTime() : lastCheckpoint.getEndTime()) - head.getBgnTime();
    }

    /**
     * 连续执行检查点
     * @return
     */
    public long checkpoint() {
        long time = System.currentTimeMillis();
        if (isTiming) {
            stop(time);
        }
        start(null, time);
        return time;
    }

    /**
     * 获取历史所有检查点
     * @return 返回检查点列表
     */
    public List<CheckPoint> getHistoryCheckPoints() {
        return checkPointList;
    }

    /**
     * 打印历史所有检查点
     * @return 返回检查点列表（用于打印的表格）
     */
    public String printHistoryCheckPoints() {
        List<List<String>> tables = new LinkedList<>();

        String[] head = new String[] { "id", "name", "start_time", "end_time", "diff_time" };
        tables.add(ListUtils.asList(head));

        int id = 1;
        for(CheckPoint cp : checkPointList) {
            List<String> row = new LinkedList<>();
            row.add(String.valueOf(id++));
            row.add(cp.getName());
            row.add(String.valueOf(cp.getBgnTime()));
            row.add(String.valueOf(cp.getEndTime()));
            row.add(String.valueOf(cp.getDiffTime()));
            tables.add(row);
        }
        return EscapeUtils.toTXT(tables, true);
    }

    /**
     * 清除历史所有检查点
     */
    public void clearCheckPoints() {
        this.checkPointMap.clear();
        this.checkPointList.clear();
    }

}

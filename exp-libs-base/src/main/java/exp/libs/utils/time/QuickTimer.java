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

    /** 所有 CheckPoint 的 map */
    private Map<String, CheckPoint> checkPointMap;

    /** 所有 CheckPoint 的 list */
    private List<CheckPoint> checkPointList;

    /** 最后一个 CheckPoint */
    private CheckPoint lastCheckPoint;

    /** 标记当前是否计时中 */
    private boolean isTiming;

    public QuickTimer() {
        this.checkPointMap = new HashMap<>();
        this.checkPointList = new LinkedList<>();

        this.lastCheckPoint = null;
        this.isTiming = false;
    }

    /**
     * 启动一个新的 CheckPoint
     * @return 启动的时间点（毫秒）
     */
    public long start() {
        return start(null);
    }

    /**
     * 启动一个新的 CheckPoint
     * @param name CheckPoint 名称
     * @return 启动的时间点（毫秒）
     */
    public long start(String name) {
        return start(name, System.currentTimeMillis());
    }

    /**
     * 启动一个新的 CheckPoint
     * @param name CheckPoint 名称
     * @param time 启动的时间点（毫秒）
     * @return 启动的时间点（毫秒）
     */
    private long start(String name, long time) {
        if (isTiming) {
            return lastCheckPoint.getBgnTime();
        }

        isTiming = true;
        CheckPoint cp = new CheckPoint(name);
        cp.setBgnTime(time);
        add(cp);
        lastCheckPoint = cp;
        return time;
    }

    /**
     * 停止当前的 CheckPoint
     * @return 停止的时间点（毫秒）
     */
    public long stop() {
        return stop(System.currentTimeMillis());
    }

    /**
     * 停止当前的 CheckPoint
     * @param time 停止的时间点（毫秒）
     * @return 停止的时间点（毫秒）
     */
    private long stop(long time) {
        if (lastCheckPoint == null) {
            return -1;

        } else if (!isTiming) {
            return lastCheckPoint.getEndTime();
        }

        isTiming = false;
        lastCheckPoint.setEndTime(time);
        return time;
    }

    /**
     * <pre>
     * 连续启动 CheckPoint
     * （先 stop 当前 CheckPoint, 再 start 一个新的 CheckPoint）
     * <pre>
     * @return 停止/启动的时间点（毫秒）
     */
    public long checkpoint() {
        return checkpoint(null);
    }

    /**
     <pre>
     * 连续启动 CheckPoint
     * （先 stop 当前 CheckPoint, 再 start 一个新的 CheckPoint）
     * <pre>
     * @param name 新 CheckPoint 的名称
     * @return 停止/启动的时间点（毫秒）
     */
    public long checkpoint(String name) {
        long time = System.currentTimeMillis();
        if (isTiming) {
            stop(time);
        }
        start(name, time);
        return time;
    }

    /**
     * 计算最后一次 CheckPoint 经过的时间（毫秒）
     * @return 获取当前计时经过的毫秒数
     */
    public long lastElapsedTime() {
        return isTiming ? -1 : (
                lastCheckPoint == null ? -1 : lastCheckPoint.getDiffTime()
        );
    }

    /**
     * 计算所有 CheckPoint 经过的时间（毫秒）
     * @return 第一次和最后一次 CheckPoint 之间经过的毫秒数
     */
    public long totalElapsedTime() {
        if (checkPointList.size() <= 0) {
            return 0;
        }
        CheckPoint head = checkPointList.get(0);
        CheckPoint tail = lastCheckPoint;
        return (isTiming ? tail.getBgnTime() : tail.getEndTime()) - head.getBgnTime();
    }

    /**
     * 存储 CheckPoint
     * @param checkPoint 新的 CheckPoint
     */
    private void add(CheckPoint checkPoint) {
        this.checkPointMap.put(checkPoint.getName(), checkPoint);
        this.checkPointList.add(checkPoint);
    }

    /**
     * 获取某个 CheckPoint
     * @param name CheckPoint 名称
     * @return CheckPoint，若不存在返回 null
     */
    public CheckPoint getCheckPoint(String name) {
        return checkPointMap.get(name);
    }

    /**
     * 获取所有 CheckPoint
     * @return 返回 CheckPoint 列表
     */
    public List<CheckPoint> getAllCheckPoints() {
        return checkPointList;
    }

    /**
     * 以文本表格形式返回历史所有 CheckPoint
     * @return 返回表格格式 CheckPoint 列表
     */
    public String printAllCheckPoints() {
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
     * 清除所有 CheckPoint
     */
    public void clearAllCheckPoints() {
        this.checkPointMap.clear();
        this.checkPointList.clear();
    }

}

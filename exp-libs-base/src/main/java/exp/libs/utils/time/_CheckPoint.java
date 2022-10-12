package exp.libs.utils.time;

import exp.libs.utils.num.IDUtils;

/**
 * description
 *
 * @author exp 2022/10/12 21:57
 */
class _CheckPoint {

    private String name;

    private long bgnTime;

    private long endTime;

    protected _CheckPoint(String name) {
        this.name = (name == null ? String.valueOf(IDUtils.getTimeID()) : name);
        this.bgnTime = 0;
        this.endTime = 0;
    }

    public String getName() {
        return name;
    }

    public _CheckPoint setName(String name) {
        this.name = name;
        return this;
    }

    public long getBgnTime() {
        return bgnTime;
    }

    public _CheckPoint setBgnTime(long bgnTime) {
        this.bgnTime = bgnTime;
        return this;
    }

    public long getEndTime() {
        return endTime;
    }

    public _CheckPoint setEndTime(long endTime) {
        this.endTime = endTime;
        return this;
    }
}

package exp.libs.algorithm.substr;

import exp.libs.utils.other.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author exp
 * @date 2022-09-23 2:53
 */
class SundayPattern extends _Pattern {

    private Map<Character, Integer> next;

    protected SundayPattern(String pattern) {
        super(pattern);
    }

    @Override
    protected void genNext() {
        this.next = new HashMap<>(MapUtils.genSize(length));
    }

    protected int nextAt(char ch) {
        int index = -1;
        Integer val = next.get(ch);

        if (val != null) {
            index = val.intValue();

        // 从后往前检索
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (charAt(i) == ch) {
                    index = i;
                    next.put(ch, index);
                    break;
                }
            }
        }
        return index;
    }


}

package exp.libs.algorithm.substr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author exp
 * @date 2022-09-24 0:01
 */
public class BMPattern extends _Pattern {

    private Map<Character, Integer> badCharacter;

    private int[] goodSuffix;

    protected BMPattern(String pattern) {
        super(pattern);
    }

    @Override
    protected void init() {
        initBadCharacter();
        initGoodSuffix();
    }

    /**
     * 坏字符表
     */
    private void initBadCharacter() {
        this.badCharacter = new HashMap<>();
        for (int i = 0; i < length - 1; i++) {
            char ch = charAt(i);
            badCharacter.put(ch, length - 1 - i);
        }
    }

    /**
     * 好后缀表
     * @return
     */
    private void initGoodSuffix() {
        this.goodSuffix = new int[length];
        int lastPrefixPosition = length;

        for (int i = length - 1; i >= 0; --i) {
            if (isPrefix(i + 1)) {
                lastPrefixPosition = i + 1;
            }
            goodSuffix[length - 1 - i] = lastPrefixPosition - i + length - 1;
        }

        for (int i = 0; i < length - 1; ++i) {
            int slen = suffixLength(i);
            goodSuffix[slen] = length - 1 - i + slen;
        }
    }

    /**
     * 前缀匹配
     */
    private boolean isPrefix(int p) {
        for (int i = p, j = 0; i < length; ++i, ++j) {
            if (charAt(i) != charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 后缀匹配
     */
    private int suffixLength(int p) {
        int len = 0;
        for (int i = p, j = length - 1; i >= 0 && charAt(i) == charAt(j); i--, j--) {
            len += 1;
        }
        return len;
    }

    protected int badAt(char ch) {
        Integer val = badCharacter.get(ch);
        return val == null ? length : val.intValue();       // 默认返回模式串的长度
    }

    protected int goodAt(int idx) {
        return goodSuffix[idx];
    }

}

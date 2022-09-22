package exp.libs.algorithm.substr;

/**
 * @author exp
 * @date 2022-09-21 23:18
 */
class Pattern {

    private SubStrAlgorithm algorithm;

    private String pattern;

    private int length;

    /* for KMP */
    private int[] next;

    /* for Sunday */
    private int[] move;

    protected Pattern(String pattern) {
        this(pattern, null);
    }

    protected Pattern(String pattern, SubStrAlgorithm algorithm) {
        this.algorithm = (algorithm == null ? SubStrAlgorithm.DEFAULT : algorithm);
        this.pattern = (pattern == null ? "" : pattern);
        this.length = this.pattern.length();

        if (algorithm == SubStrAlgorithm.KMP) {
            genNextArray();
        }
    }


    private void genNextArray() {
        this.next = new int[this.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < length - 1) {
            if (k == -1 || charAt(j) == charAt(k)) {
                if (charAt(++j) == charAt(++k)) {       // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
    }


    protected int nextAt(int index) {
        return this.next[index];
    }


    protected char charAt(int index) {
        return this.pattern.charAt(index);
    }

    protected int length() {
        return this.length;
    }

}

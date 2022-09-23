package exp.libs.algorithm.substr;

/**
 * @author exp
 * @date 2022-09-23 2:37
 */
class KMPPattern extends _Pattern {

    private int[] next;

    protected KMPPattern(String pattern) {
        super(pattern);
    }

    @Override
    protected void genNext() {
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

}

package exp.libs.algorithm.substr;

/**
 * @author exp
 * @date 2022-09-21 23:18
 */
class Pattern {

    private String pattern;

    private SubStrAlgorithm algorithm;

    private int length;

    private int[] next;

    protected Pattern(String pattern) {
        this(pattern, null);
    }

    protected Pattern(String pattern, SubStrAlgorithm algorithm) {
        this.pattern = (pattern == null ? "" : pattern);
        this.algorithm = (algorithm == null ? SubStrAlgorithm.DEFAULT : algorithm);
        this.length = this.pattern.length();

        if (algorithm == SubStrAlgorithm.KMP) {
            genNextArray();
        }
    }

    private void genNextArray() {
        this.next = new int[this.length];
        this.next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < this.length - 1) {
            if (k == -1 || charAt(j) == charAt(k)) {
                this.next[++j] = ++k;
            } else {
                k = this.next[k];
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

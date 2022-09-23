package exp.libs.algorithm.substr;

/**
 * @author exp
 * @date 2022-09-21 23:18
 */
abstract class _Pattern {

    protected String pattern;

    protected int length;

    protected _Pattern(String pattern) {
        this.pattern = (pattern == null ? "" : pattern);
        this.length = this.pattern.length();
        init();
    }

    abstract protected void init();

    protected char charAt(int index) {
        return this.pattern.charAt(index);
    }

    protected int length() {
        return this.length;
    }

}

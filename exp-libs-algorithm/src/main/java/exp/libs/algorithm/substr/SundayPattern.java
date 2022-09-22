package exp.libs.algorithm.substr;

/**
 * @author exp
 * @date 2022-09-23 2:53
 */
class SundayPattern extends _Pattern {

    protected SundayPattern(String pattern) {
        super(pattern);
    }

    @Override
    protected void genNextArray() {

    }

    protected int lastIndex(String str, char ch) {
        // 从后往前检索
        for (int j = str.length() - 1; j >= 0; j--) {
            if (str.charAt(j) == ch) {
                return j;
            }
        }
        return -1;
    }


}

package exp.libs.algorithm.substr;

/**
 * @author exp
 * @date 2022-09-21 0:27
 */
public enum SubStrAlgorithm {

    /* 暴力搜索 */
    DEFAULT("Brute-Force"),

    /* KMP 算法 */
    KMP("KMP"),

    /* BM 算法 */
    BM("Boyer-Moore"),

    /* Sunday 算法 */
    SUNDAY("Sunday"),

    ;

    private String type;

    private SubStrAlgorithm(String type) {
        this.type = type;
    }

    public String TYPE() {
        return type;
    }

}

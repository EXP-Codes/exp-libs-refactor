package exp.libs.algorithm.substr;

/**
 * @author exp
 * @date 2022-09-21 0:27
 */
public enum SubStrAlgorithm {

    DEFAULT("Brute-Force"),

    BF("Brute-Force"),

    KMP("KMP"),

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

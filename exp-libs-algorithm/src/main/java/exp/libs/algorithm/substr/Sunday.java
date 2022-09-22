package exp.libs.algorithm.substr;

/**
 * description
 *
 * @author exp 2022/09/22 22:56
 */
public class Sunday extends _SubStr {

    private static volatile Sunday instance;

    private Sunday() {
        super(SubStrAlgorithm.SUNDAY);
    }

    public static Sunday getInstn() {
        if(instance == null) {
            synchronized (Sunday.class) {
                if(instance == null) {
                    instance = new Sunday();
                }
            }
        }
        return instance;
    }

    @Override
    protected int _indexOf(String str, String pattern) {
        return 0;
    }
}

package exp.libs.algorithm.substr;

/**
 * description
 *
 * @author exp 2022/09/22 22:57
 */
public class BoyerMoore extends _SubStr {

    private static volatile BoyerMoore instance;

    public BoyerMoore() {
        super(SubStrAlgorithm.BM);
    }

    public static BoyerMoore getInstn() {
        if(instance == null) {
            synchronized (BoyerMoore.class) {
                if(instance == null) {
                    instance = new BoyerMoore();
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

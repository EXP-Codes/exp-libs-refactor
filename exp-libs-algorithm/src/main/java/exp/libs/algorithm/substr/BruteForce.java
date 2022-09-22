package exp.libs.algorithm.substr;

/**
 * description
 *
 * @author exp 2022/09/22 22:59
 */
public class BruteForce extends _SubStr {

    private static volatile BruteForce instance;

    public BruteForce() {
        super(SubStrAlgorithm.DEFAULT);
    }

    public static BruteForce getInstn() {
        if(instance == null) {
            synchronized (BruteForce.class) {
                if(instance == null) {
                    instance = new BruteForce();
                }
            }
        }
        return instance;
    }

    @Override
    protected int _indexOf(String str, String pattern) {
        return str.indexOf(pattern);
    }

}

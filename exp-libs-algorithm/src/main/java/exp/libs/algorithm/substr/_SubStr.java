package exp.libs.algorithm.substr;

import exp.libs.utils.str.StrUtils;

/**
 * description
 *
 * @author exp 2022/09/22 22:14
 */
abstract class _SubStr {

    protected SubStrAlgorithm algorithm;

    protected _SubStr(SubStrAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public int indexOf(String str, String pattern) {
        int index = -1;
        if (StrUtils.isNotEmpty(str, pattern)) {
            index = _indexOf(str, pattern);
        }
        return index;
    }

    abstract protected int _indexOf(String str, String pattern);

}

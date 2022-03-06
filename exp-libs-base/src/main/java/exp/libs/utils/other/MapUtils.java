package exp.libs.utils.other;


/**
 * <PRE>
 * 标准化工具
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public final class MapUtils {

	/** Map 最小的标准容量 */
	public final static int MIN_MAP_SIZE = 2;

	/** 私有化构造函数 */
	private MapUtils() {}

	/**
	 * <PRE>
	 * 根据实际需要的容量，返回构造 Map 的标准容量(使得 Map 的搜索性能最优)。
	 * 	返回值为大于 actualSize 的 2^n (不超过 2^30 -1, 即 int 最大值)
	 * </PRE>
	 * 
	 * @param actualSize 实际容量
	 * @return 标准容量
	 */
	public static int genSize(int actualSize) {
		boolean isDone = false;
		int size = MIN_MAP_SIZE;
		for(int i = 1; i < 30; i++) {
			size = (size << 1);
			if(size >= actualSize) {
				isDone = true;
				break;
			}
		}
		
		if(isDone == false) {
//			size = Integer.MAX_VALUE;
			size = actualSize;
		}
		return size;
	}
	

	
}

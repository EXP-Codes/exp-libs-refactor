package exp.libs.cep.fun.impl.num;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.CEPParseException;
import exp.libs.cep.fun.BaseFunction1;

/**
 * <pre>
 * 自定函数：
 * 	进制转换： 10 -> 16
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Hex extends BaseFunction1 {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = -6884126558907265608L;
	
	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "hex";
	
	/**
	 * 进制转换： 10 -> 16
	 * @param param Integer/String:10进制数值(字符串)
	 * @return String: 16进制数值字符串
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(Object param) throws EvaluationException {
		int iNum = 0;
		
		if(param instanceof String) {
			String sNum = asString(1, param);
			try {
				iNum = Integer.parseInt(sNum);
			} catch (NumberFormatException e) {
				throw new CEPParseException(this, 1, sNum, Integer.class, e);
			}
			
		} else {
			iNum = asInt(1, param);
		}
		return Integer.toHexString(iNum);
	}

	/**
	 * 获取函数名称
	 * @return 函数名称
	 */
	@Override
	public String getName() {
		return NAME;
	}
	
}

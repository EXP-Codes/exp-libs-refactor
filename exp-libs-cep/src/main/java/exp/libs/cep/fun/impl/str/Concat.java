package exp.libs.cep.fun.impl.str;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.fun.BaseFunctionN;

import java.util.List;

/**
 * <pre>
 * 自定函数：
 * 	字符串操作： 无限拼接
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Concat extends BaseFunctionN {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = -8008474521815772996L;

	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "concat";
	
	/**
	 * 字符串拼接.若出现null串则跳过.
	 * @param params 若干个字符串
	 * @return String: 所有字符串顺序拼接
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(List<Object> params) throws EvaluationException {
		StringBuilder sb = new StringBuilder();
		int pidx = 0;
		for(Object oParam : params) {
			if(oParam == null) {
				continue;
			}
			String sParam = asString(++pidx, oParam);
			sb.append(sParam);
		}
		return sb.toString();
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

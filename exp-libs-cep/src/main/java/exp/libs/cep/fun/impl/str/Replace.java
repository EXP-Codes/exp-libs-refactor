package exp.libs.cep.fun.impl.str;

import com.singularsys.jep.EvaluationException;
import exp.libs.cep.fun.BaseFunctionN;

import java.util.List;

/**
 * <pre>
 * 自定函数：
 * 	字符串操作：正则替换
 * </pre>	
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class Replace extends BaseFunctionN {

	/**
	 * 序列化唯一ID
	 */
	private static final long serialVersionUID = -7197942130083226335L;

	/**
	 * 建议函数名,方便调用.
	 * 可不使用.
	 */
	public final static String NAME = "replace";
	
	/**
	 * 限定参数个数为3.
	 */
	@Override
	public boolean checkNumberOfParameters(int inParamsNum){
        return inParamsNum == 3;
    }
	
	/**
	 * 字符串正则替换.
	 * @param params 共3个参数：
	 * 		param[1] String:原字符串
	 * 		param[2] String:正则表达式
	 * 		param[2] String:替代字符串
	 * @return String:正则替换后的字符串
	 * @throws EvaluationException 若执行失败则抛出异常
	 */
	@Override
	protected Object eval(List<Object> params) throws EvaluationException {
		String orgStr = asString(1, params.remove(0));
		String regex = asString(2, params.remove(0));
		String rplStr = asString(3, params.remove(0));
		return orgStr.replaceAll(regex, rplStr);
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

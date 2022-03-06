package exp.libs.soap.server;

import javax.jws.WebService;

/**
 * <PRE>
 * Websevices服务提供的API接口定义.
 * </PRE>
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
@WebService  	// JAX-WS注解, 必须有
public interface _IWsdlService {  
    
	/**
	 * 自定义接口服务
	 * @param param 样例入参
	 * @return 样例出参
	 */
	public String foo(String param);  
	
	/**
	 * 自定义接口服务
	 * @param param 样例入参
	 */
    public void bar(int param);  
    
}  

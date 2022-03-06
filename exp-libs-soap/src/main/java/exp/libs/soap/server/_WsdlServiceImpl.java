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

// 注解中必须指定接口类位置, 否则会报错 "Could not load Webservice SEI" 
@WebService(endpointInterface="exp.libs.warp.net.wsdl.server._IWsdlService")  
public class _WsdlServiceImpl implements _IWsdlService {

	@Override
	public String foo(String param) {
		return "webservice-demo : foo-".concat(param);
	}

	@Override
	public void bar(int param) {
		System.out.println("webservice-demo : bar-" + param);
	}

}  
package exp.libs.db.sql;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <PRE>
 * Sqlite 数据库工具.
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public final class SqliteUtils extends DBUtils {

	/** 私有化构造函数 */
	protected SqliteUtils() {}
	
	/**
	 * 强制释放磁盘库文件占用的多余空间.
	 * @param conn 数据库连接
	 * @return 是否释放成功
	 */
	public static boolean releaseDisk(Connection conn) {
		boolean isOk = false;
		if(conn != null) {
			isOk = execute(conn, "vacuum");
		}
		return isOk;
	}
	
	/**
	 * <B>暂不支持<B>
	 * @return 固定返回""
	 */
	@Deprecated
	public static String execSP(Connection conn, String proSql, Object[] params) {
		return "";
	}
	
	/**
	 * <B>暂不支持<B>
	 * @return 空列表
	 */
	@Deprecated
	public static List<Map<String, Object>> callSP(Connection conn, 
			String proSql, Object[] params) {
		return new LinkedList<Map<String,Object>>();
	}
	
}

package exp.libs.db.sql.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * <PRE>
 * PDM物理模型 - 表.
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class PdmTable {

	private String tableName;

	private List<PdmColumn> columns;

	public PdmTable() {
		this.columns = new LinkedList<PdmColumn>();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<PdmColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<PdmColumn> columns) {
		this.columns = columns;
	}
	
}

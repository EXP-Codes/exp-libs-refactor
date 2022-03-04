package exp.libs.conf.xml;

import exp.libs.envm.Charset;
import exp.libs.utils.file.FileUtils;
import exp.libs.utils.file.JarUtils;
import exp.libs.utils.num.NumUtils;
import exp.libs.utils.os.OSUtils;
import exp.libs.utils.other.BoolUtils;
import exp.libs.utils.other.PathUtils;
import exp.libs.utils.str.StrUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _Config implements _IConfig {

	/** 日志器 */
	protected final static Logger log = LoggerFactory.getLogger(_Config.class);
	
	protected final static XNode NULL_XNODE = new XNode(null, null);
	
	/** 配置对象名称 */
	protected String name;
	
	/**
	 * 依序记录所加载过的配置文件.
	 *  其中 单个元素为  String[2] { filxPath, 文件类型:DISK|JAR }
	 */
	protected List<String[]> confFiles; 
	
	private _XTree xTree;
	
	/**
	 * 构造函数
	 * @param name 配置器名称
	 */
	protected _Config(String name) {
		this.name = name;
		this.confFiles = new LinkedList<String[]>();
		this.xTree = new _XTree();
	}

	@Override
	public String NAME() {
		return name;
	}
	
	protected void clear() {
		confFiles.clear();
		xTree.clear();
	}
	
	@Override
	public boolean loadConfFiles(String... confFilePaths) {
		if(confFilePaths == null) {
			return false;
		}
		
		boolean isOk = true;
		for(String confFilePath : confFilePaths) {
			if(StrUtils.isNotEmpty(confFilePath)) {
				isOk &= (loadConfFile(confFilePath) != null);
			}
		}
		return isOk;
	}

	@Override
	public Element loadConfFile(String confFilePath) {
		if(confFilePath == null) {
			return null;
			
		} else if(OSUtils.isRunByTomcat()) {
			return loadConfFileByTomcat(confFilePath);
		}
		
		Element root = null;
		try {
			File confFile = new File(confFilePath);
			String charset = XmlUtils.getCharset(confFile);
			String xml = FileUtils.read(confFile, charset);
			Document doc = DocumentHelper.parseText(xml);
			root = doc.getRootElement();
			xTree.update(root);
			confFiles.add(new String[] { confFilePath, DISK_FILE });
			
		} catch (Exception e) {
			log.error("加载文件失败: [{}].", confFilePath, e);
		}
		return root;
	}
	
	@Override
	public boolean loadConfFilesInJar(String... confFilePaths) {
		if(confFilePaths == null) {
			return false;
		}
		
		boolean isOk = true;
		for(String confFilePath : confFilePaths) {
			if(StrUtils.isNotEmpty(confFilePath)) {
				isOk &= (loadConfFileInJar(confFilePath) != null);
			}
		}
		return isOk;
	}
	
	@Override
	public Element loadConfFileInJar(String confFilePath) {
		if(confFilePath == null) {
			return null;
		}
		
		Element root = null;
		try {
			String content = JarUtils.read(confFilePath, Charset.ISO);
			String charset = XmlUtils.getCharset(content);
			String xml = JarUtils.read(confFilePath, charset);
			Document doc = DocumentHelper.parseText(xml);
			root = doc.getRootElement();
			xTree.update(root);
			confFiles.add(new String[] { confFilePath, JAR_FILE });
			
		} catch (Exception e) {
			log.error("加载文件失败: [{}].", confFilePath, e);
		}
		return root;
	}
	
	@Override
	public boolean loadConfFilesByTomcat(String... confFilePaths) {
		if(confFilePaths == null) {
			return false;
		}
		
		boolean isOk = true;
		for(String confFilePath : confFilePaths) {
			if(StrUtils.isNotEmpty(confFilePath)) {
				isOk &= (loadConfFileByTomcat(confFilePath) != null);
			}
		}
		return isOk;
	}
	
	@Override
	public Element loadConfFileByTomcat(String confFilePath) {
		if(confFilePath == null) {
			return null;
			
		} else if(!OSUtils.isRunByTomcat()) {
			return loadConfFile(confFilePath);
		}
		
		// 修正配置文件位置
		File dir = new File(PathUtils.getProjectCompilePath());
		String path = PathUtils.combine(dir.getAbsolutePath(), confFilePath);	// classes目录优先
		if(!FileUtils.exists(path)) {	// 若classes目录下不存在该文件, 则找上一层目录
			path = PathUtils.combine(dir.getParentFile().getAbsolutePath(), confFilePath);
		}
		confFilePath = path;
		
		// 加载配置文件
		Element root = null;
		try {
			File confFile = new File(confFilePath);
			String charset = XmlUtils.getCharset(confFile);
			String xml = FileUtils.read(confFile, charset);
			Document doc = DocumentHelper.parseText(xml);
			root = doc.getRootElement();
			xTree.update(root);
			confFiles.add(new String[] { confFilePath, DISK_FILE });
			
		} catch (Exception e) {
			log.error("加载文件失败: [{}].", confFilePath, e);
		}
		return root;
	}
	
	protected List<String[]> getConfFiles() {
		return confFiles;
	}
	
	public String toXPath(String xName, String xId) {
		return xTree.toXPath(xName, xId);
	}
	
	public XNode findXNode(String xPath) {
		XNode node = xTree.findXNode(xPath);
		return (node == null ? NULL_XNODE : node);
	}
	
	@Override
	public XNode getNode(String xPath) {
		return findXNode(xPath);
	}

	@Override
	public XNode getNode(String xName, String xId) {
		return getNode(toXPath(xName, xId));
	}
	
	@Override
	public String getVal(String xPath) {
		XNode xNode = findXNode(xPath);
		return xNode.VAL();
	}
	
	@Override
	public String getVal(String xName, String xId) {
		return getVal(toXPath(xName, xId));
	}
	
	@Override
	public int getInt(String xPath) {
		return NumUtils.toInt(getVal(xPath), 0);
	}
	
	@Override
	public int getInt(String xName, String xId) {
		return getInt(toXPath(xName, xId));
	}
	
	@Override
	public long getLong(String xPath) {
		return NumUtils.toLong(getVal(xPath), 0L);
	}
	
	@Override
	public long getLong(String xName, String xId) {
		return getLong(toXPath(xName, xId));
	}
	
	@Override
	public boolean getBool(String xPath) {
		return BoolUtils.toBool(getVal(xPath), false);
	}
	
	@Override
	public boolean getBool(String xName, String xId) {
		return getBool(toXPath(xName, xId));
	}
	
	@Override
	public List<String> getEnums(String xPath) {
		List<String> enums = new LinkedList<String>();
		XNode xNode = findXNode(xPath);
		Iterator<XNode> childs = xNode.getChilds();
		while(childs.hasNext()) {
			XNode child = childs.next();
			enums.add(child.VAL());
		}
		return enums;
	}
	
	@Override
	public List<String> getEnums(String xName, String xId) {
		return getEnums(toXPath(xName, xId));
	}
	
	@Override
	public String getAttribute(String xPath, String attributeName) {
		XNode xNode = findXNode(xPath);
		return xNode.getAttribute(attributeName);
	}
	
	@Override
	public String getAttribute(String xName, String xId, String attributeName) {
		return getAttribute(toXPath(xName, xId), attributeName);
	}
	
	@Override
	public Map<String, String> getAttributes(String xPath) {
		XNode xNode = findXNode(xPath);
		return xNode.getAttributes();
	}
	
	@Override
	public Map<String, String> getAttributes(String xName, String xId) {
		return getAttributes(toXPath(xName, xId));
	}
	
}

package exp.libs.utils.os;

import exp.libs.utils.file.FileFlowReader;
import exp.libs.utils.file.FileUtils;
import exp.libs.utils.str.CharsetUtils;
import exp.libs.utils.str.StrUtils;
import exp.libs.utils.verify.RegexUtils;

import java.io.File;
import java.util.*;

/**
 * <PRE>
 * Java工具类.
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class JavaUtils {

	/** 获取当前运行的JDK版本号 */
	protected final static String JDK_VER =
			System.getProperty("java.version").toUpperCase();

	/** Java关键字数组 */
	private final static String[] JAVA_KEY_WORDS = {
			"abstract", "assert", "boolean", "break", "byte",
			"case", "catch", "char", "class", "const",
			"continue", "default", "do", "double", "else",
			"enum", "extends", "final", "finally", "float",
			"for", "goto", "if", "implements", "import",
			"instanceof", "int", "interface", "long", "native",
			"new", "package", "private", "protected", "public",
			"return", "short", "static", "strictfp", "super",
			"switch", "synchronized", "this", "throw", "throws",
			"transient", "try", "void", "volatile", "while",	
	};
	
	/** java关键字列表 */
	private final static List<String> JAVA_KEY_WORD_LIST = 
			Arrays.asList(JAVA_KEY_WORDS);
	
	/** 私有化构造函数 */
	protected JavaUtils() {}

	/**
	 * 获取当前运行的JDK版本号
	 * @return 当前运行的JDK版本号
	 */
	public static String getJdkVersion() {
		return JDK_VER;
	}

	/**
	 * 检测当前运行的版本是否为JDK1.6
	 * @return true:是; false:否
	 */
	public static boolean isJDK16() {
		return JDK_VER.startsWith("1.6");
	}

	/**
	 * 检测当前运行的版本是否为JDK1.7
	 * @return true:是; false:否
	 */
	public static boolean isJDK17() {
		return JDK_VER.startsWith("1.7");
	}

	/**
	 * 检测当前运行的版本是否为JDK1.8
	 * @return true:是; false:否
	 */
	public static boolean isJDK18() {
		return JDK_VER.startsWith("1.8");
	}

	/**
	 * 检查单词是否为java关键字
	 * 
	 * @param word 待检查字符串
	 * @return true:是 ; false:不是
	 */
	public static boolean isJavaKeyWord(String word) {
		boolean isKeyWord = false;
		if(word != null && !"".equals(word.trim())) {
			isKeyWord = JAVA_KEY_WORD_LIST.contains(word.trim());
		}
		return isKeyWord;
	}
	
	/**
	 * <PRE>
	 * 修正Java源文件的package路径.
	 * 
	 * 	用于解决Eclipse迁移包代码时，不能自动修改package路径的问题。
	 * 	当要迁移整个包代码时，先在系统文件夹直接移动，再使用此方法调整所有源码文件的package路径。
	 * 	<B>使用要求：在迁移包代码之前，代码无任何语法错误。</B>
	 * </PRE>
	 * @param srcDirPath 源码根目录的绝对路径，如 D:foo/bar/project/src/main/java
	 * @param encoding 源码文件的内容编码
	 */
	public static void modifyPackagePath(String srcDirPath, String encoding) {
		if(StrUtils.isEmpty(srcDirPath) || CharsetUtils.isInvalid(encoding)) {
			return;
		}
		
		File srcDir = new File(srcDirPath);
		if(!srcDir.exists()) {
			return;
		}
		
		Map<String, String> packagePaths = new HashMap<String, String>();
		searchPackagePath(null, srcDir, encoding, packagePaths);
		modifyPackagePath(srcDir, encoding, packagePaths);
	}
	
	private static void searchPackagePath(String dir, File file, 
			String encoding, Map<String, String> packagePaths) {
		if(file.isDirectory()) {
			dir = (dir == null ? "" : StrUtils.concat(dir, file.getName(), "."));
			File[] files = file.listFiles();
			for(File f : files) {
				searchPackagePath(dir, f, encoding, packagePaths);
			}
			
		} else {
			if(file.getName().endsWith(".java") && StrUtils.isNotEmpty(dir)) {
				String newPackagePath = dir.replaceFirst("\\.$", "");
				String oldPackagePath = "";
				
				FileFlowReader ffr = new FileFlowReader(file, encoding);
				while(ffr.hasNextLine()) {
					String line = ffr.readLine(';');
					line = line.trim();
					if(line.startsWith("package")) {
						oldPackagePath = RegexUtils.findFirst(line, "package\\s([^;]+);");
						break;
					}
				}
				ffr.close();
				
				if(StrUtils.isNotEmpty(oldPackagePath) && 
						!oldPackagePath.equals(newPackagePath)) {
					packagePaths.put(oldPackagePath, newPackagePath);
				}
			}
		}
	}
	
	private static void modifyPackagePath(File file, 
			String encoding, Map<String, String> packagePaths) {
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File f : files) {
				modifyPackagePath(f, encoding, packagePaths);
			}
			
		} else {
			if(file.getName().endsWith(".java")) {
				String content = FileUtils.read(file, encoding);
				Iterator<String> keyIts = packagePaths.keySet().iterator();
				while(keyIts.hasNext()) {
					String oldPackagePath = keyIts.next();
					String newPackagePath = packagePaths.get(oldPackagePath);
					content = content.replace(oldPackagePath, newPackagePath);
					if("".equals(newPackagePath)) {
						content = content.replaceAll("import\\s+\\w+;", "");	// 根目录下的类不能import
					}
				}
				FileUtils.write(file, content, encoding, false);
			}
		}
	}
	
}

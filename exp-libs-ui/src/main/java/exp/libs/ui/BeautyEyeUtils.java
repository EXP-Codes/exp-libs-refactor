package exp.libs.ui;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI.NormalColor;

import javax.swing.*;
import java.awt.*;

/**
 * <PRE>
 * swing美瞳组件工具.
 * 	(设置swing组件风格样式)
 * 
 * 使用示例:
 * 	在初始化界面之前, 调用BeautyEyeUtils.init()方法即可（程序运行期间只需调用一次）.
 * 
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public final class BeautyEyeUtils {

	/** UIManager中UI字体名称相关的key */
	private final static String[] DEFAULT_FONT = new String[] {
			"Table.font", 
			"TableHeader.font", 
			"CheckBox.font", 
			"Tree.font", 
			"Viewport.font", 
			"ProgressBar.font", 
			"RadioButtonMenuItem.font", 
			"ToolBar.font", 
			"ColorChooser.font", 
			"ToggleButton.font", 
			"Panel.font", 
			"TextArea.font", 
			"Menu.font", 
			"TableHeader.font", 
//			"TextField.font", 
			"OptionPane.font", 
			"MenuBar.font", 
			"Button.font", 
			"Label.font", 
			"PasswordField.font", 
			"ScrollPane.font", 
			"MenuItem.font", 
			"ToolTip.font", 
			"List.font", 
			"EditorPane.font", 
			"Table.font", 
			"TabbedPane.font", 
			"RadioButton.font", 
			"CheckBoxMenuItem.font", 
			"TextPane.font", 
			"PopupMenu.font", 
			"TitledBorder.font", 
			"ComboBox.font"
	};
			
	/** 私有化构造函数 */
	protected BeautyEyeUtils() {}
	
	/**
	 * 初始化 BeautyEye 
	 * 	(默认的苹果系统风格边框类型)
	 */
	public static void init() {
		// 选择苹果风格边框类型 （弱立体感半透明）
		init(FrameBorderStyle.translucencyAppleLike);
	}
	
	/**
	 * 初始化 BeautyEye 
	 * @param frameBorderStyle 组件风格样式
	 * 		translucencyAppleLike: 苹果系统风格边框类型 - 强立体感半透明（默认）
	 * 		translucencySmallShadow: 苹果系统风格边框类型 - 弱立体感半透明
	 * 		generalNoTranslucencyShadow: 苹果系统风格边框类型 - 普通不透明
	 * 		osLookAndFeelDecorated: 本地系统默认风格边框
	 */
	public static void init(FrameBorderStyle frameBorderStyle) {

		// 禁用 DirectDraw, 防止激活/切换输入法时白屏
		// 切换输入法导致白屏问题是由于官方的透明 API 的 bug 引起，与 BeautyEye 本身无关
		// 这里的 true 表示使用 ToolBar.background 颜色实现纯色填充背景，BeautyEye 中此属性默认是 false
		System.setProperty("sun.java2d.noddraw", "true");

		// 选择边框风格类型 
		BeautyEyeLNFHelper.frameBorderStyle = (frameBorderStyle == null ? 
				FrameBorderStyle.translucencyAppleLike : frameBorderStyle);
		
		// 隐藏右上角无效按钮【设置】
	    UIManager.put("RootPane.setupButtonVisible", false);
		
	    // 初始化 BeautyEye 外观组件
		try {	
			BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			SwingUtils.warn("初始化 BeautyEye 外观组件失败.");
		}
	}
	
	/**
	 * 界面字体效果增强(除了文本框的字体，基本所有界面字体都会受到影响)
	 * 	[使用微软雅黑14号字体]
	 */
	public static void boostUIFont() {
		final Font FONT = new Font("微软雅黑", Font.PLAIN, 14);
		for (int i = 0; i < DEFAULT_FONT.length; i++) {
			UIManager.put(DEFAULT_FONT[i], FONT);
		}
	}
	
	/**
	 * 界面字体效果设置(除了文本框的字体，基本所有界面字体都会受到影响)
	 * @param font 字体效果
	 */
	public static void setUIFont(Font font) {
		if(font == null) {
			return;
		}
		
		for (int i = 0; i < DEFAULT_FONT.length; i++) {
			UIManager.put(DEFAULT_FONT[i], font);
		}
	}
	
	/**
	 * 设置按钮风格样式
	 * @param style 风格样式
	 * 		normal: 普通样式（默认）
	 * 		green: 绿色风格
	 * 		lightBlue: 浅蓝风格
	 * 		blue: 蓝色风格
	 * 		red: 红色风格
	 * @param buttons 按钮对象集
	 */
	public static void setButtonStyle(NormalColor style, JButton... buttons) {
		if(buttons == null) {
			return;
		}
		
		style = (style == null ? NormalColor.normal : style);
		BEButtonUI BTN_UI =  new BEButtonUI();
		BTN_UI.setNormalColor(style);
		
		for(JButton button : buttons) {
			button.setUI(BTN_UI);
		}
	}
	
}

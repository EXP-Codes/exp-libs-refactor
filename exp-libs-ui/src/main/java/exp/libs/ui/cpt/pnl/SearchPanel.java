package exp.libs.ui.cpt.pnl;


import exp.libs.ui.SwingUtils;
import exp.libs.utils.str.StrUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * <PRE>
 * swing动态检索的承载面板
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class SearchPanel {

	/** 承载面板 */
	private JPanel panel;
	
	/** 搜索输入框 */
	private JTextField searchTF;
	
	/** 搜索列表组件 */
	private JList searchList;
	
	/** 搜索列表组件中的候选内容集 */
	private List<String> candidateList;
	
	/**
	 * 构造函数
	 * @param candidateList 被检索的候选内容集合
	 */
	public SearchPanel(List<String> candidateList) {
		this.candidateList = (candidateList == null ? 
				new LinkedList<String>() : candidateList);
		
		this.searchTF = new JTextField();
		this.searchList = new JList();
		reflashList(null);
		
		JPanel searchPanel = SwingUtils.addCenterPanel(searchTF);
		SwingUtils.addBorder(searchPanel, "search");
		JScrollPane listPanel = SwingUtils.addAutoScroll(searchList);
		SwingUtils.addBorder(listPanel, "list");
		this.panel = SwingUtils.getNBorderPanel(listPanel, searchPanel);
		setListener();
	}
	
	/**
	 * 刷新搜索列表组件的内容
	 * @param keyword 当前输入的关键字
	 */
	private void reflashList(String keyword) {
		searchList.removeAll();
		DefaultListModel listModel = new DefaultListModel();
		for(String str : candidateList) {
			if(str == null) {
				continue;
				
			} else if(StrUtils.isEmpty(keyword)) {
				listModel.addElement(str);
				
			} else if(str.toLowerCase().contains(keyword.toLowerCase())) {
				listModel.addElement(str);
			}
		}
		searchList.setModel(listModel);
	}
	
	/**
	 * 设置组件监听器
	 */
	private void setListener() {
		final SearchListener searchListener = new SearchListener();
		searchTF.getDocument().addDocumentListener(searchListener);
		
		searchList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getSource() != null) {
					JList list = (JList) e.getSource();
					Object select = list.getSelectedValue();
					if(select != null) {
						
						// 先移除输入框的监听器, 待JList设置输入框的值后再恢复监听器，避免陷入无限事件触发循环
						searchTF.getDocument().removeDocumentListener(searchListener);
						searchTF.setText(list.getSelectedValue().toString());
						searchTF.getDocument().addDocumentListener(searchListener);
					}
				}
			}
		});
	}
	
	/**
	 * 获取搜索面板的承载面板
	 * @return 承载面板
	 */
	public JPanel getJPanel() {
		return panel;
	}
	
	/**
	 * 获取当前搜索框的检索值
	 * @return 检索值
	 */
	public String getText() {
		return searchTF.getText();
	}
	
	//////////////////////////////////////////////////////
	
	/** 索输入框监听器 */
	private class SearchListener implements DocumentListener {

		@Override
		public void removeUpdate(DocumentEvent e) {
			reflashList(searchTF.getText());
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			reflashList(searchTF.getText());
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			reflashList(searchTF.getText());
		}
		
	}
	
}

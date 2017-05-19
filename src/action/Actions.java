package action;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 对各功能方法的声明
 * @author hyz
 *
 */
public interface Actions {
	public void action_import(DefaultTableModel tm);
	public void action_export(DefaultTableModel tm);
	public void action_sort(DefaultTableModel tm);
	public void action_search(DefaultTableModel tm);
	public void action_modify(JTable table,JButton jb,ImageIcon origin,ImageIcon willing);
}

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
	public void action_import(JTable table,DefaultTableModel tm);
	public void action_export();
	public void action_sort();
	public void action_search();
	public void action_modify(JTable table,JButton jb,ImageIcon origin,ImageIcon willing);
}

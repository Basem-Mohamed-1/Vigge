package gui.OrdersWindow;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


public class TableOrders  extends JPanel {


    private DefaultTableModel model ;
    private JTable ordersTable;
    private Footer footer;
    public TableOrders(){
        footer = new Footer();
        footer.setBounds(0,600,800,100);
        JLabel currentOrderLable = new JLabel("Current Order");
        currentOrderLable.setFont(new Font("MV Boli", Font.ITALIC | Font.BOLD, 24));
        currentOrderLable.setBounds(10,5,200,40);
        currentOrderLable.setForeground(new Color(0x00FF00));

    


        String column  []= {"id","type","Qunitity","Price"};

        model = new DefaultTableModel(column, 0);

        ordersTable = new JTable(model);
        JScrollPane jscrollpane = new JScrollPane(ordersTable);
        ordersTable.getTableHeader().setFont(new Font("MV Boli", Font.BOLD, 18));
        ordersTable.setFont(new Font("MV Boli", Font.ITALIC, 14));
        ordersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply to all columns
        for (int i = 0; i < ordersTable.getColumnCount(); i++) {
            ordersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        ((DefaultTableCellRenderer)ordersTable.getTableHeader()
        .getDefaultRenderer())
        .setHorizontalAlignment(SwingConstants.CENTER);
        
        jscrollpane.setBounds(0,50,820,550);
        ordersTable.setSelectionForeground(Color.WHITE);
        ordersTable.setSelectionBackground(new Color(0x00FF00));
        ordersTable.setRowHeight(40);
        ordersTable.setRowMargin(5);
        ordersTable.setGridColor(Color.white);
        ordersTable.setShowHorizontalLines(true);
        ordersTable.setShowVerticalLines(true);
        centerRenderer.setBorder(BorderFactory.createLineBorder(new Color(0x00FF00)));
        

        setBackground(Color.white);
        setPreferredSize(new Dimension(1000, 600));
        add(jscrollpane);
        setLayout(null);
        add(currentOrderLable);
        add(footer);
    }



    public DefaultTableModel getModelOfTable(){
        return model;
    }

    public JTable getOrdersTable(){
        return ordersTable;
    }

    public Footer getFooter(){
        return footer;
    }

}

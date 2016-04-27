import javax.swing.*; 
import java.awt.*;

public class SearchDisplayInterface extends JFrame
{
	private SearchDisplayButton searchDisplayButton = new SearchDisplayButton();
	private SearchDisplayPanel searchDisplayPanel = new SearchDisplayPanel();

	public SearchDisplayInterface()
	{
		setTitle( "查找设备" );
		setSize( 370, 365 );
		setLocationRelativeTo( null );

		add( searchDisplayButton, BorderLayout.SOUTH );
		add( searchDisplayPanel, BorderLayout.CENTER );
	}

	public SearchDisplayPanel getSearchDisplayPanel()
	{
		return searchDisplayPanel;
	}

	public SearchDisplayButton getSearchDisplayButton()
	{
		return searchDisplayButton;
	}
}

class SearchDisplayButton extends JPanel
{
	private JButton jbtOK = new JButton( "确定" );

	public SearchDisplayButton()
	{
		setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		add( jbtOK );
	}
}

class SearchDisplayPanel extends JPanel
{
	String[][] data = new String[8][2];
	String[] names = { "", "" };

	public SearchDisplayPanel()
	{
		data[0][0] = "设备编号";
		data[1][0] = "设备名称";
		data[2][0] = "设备类型";
		data[3][0] = "设备价格";
		data[4][0] = "购入时间";
		data[5][0] = "生产厂商";
		data[6][0] = "是否报废";
		data[7][0] = "报废时间";
		JTable jtb = new JTable( data, names );
		
		jtb.getColumnModel().getColumn( 0 ).setPreferredWidth( 5 );
		jtb.setFont( new Font( "SansSerif", Font.BOLD, 13 ) );
		jtb.setPreferredScrollableViewportSize( new Dimension( 320, 283 ) );
		jtb.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS); 
		jtb.setEnabled( true );
		jtb.setRowHeight( 35 );
		JScrollPane scrollPane = new JScrollPane( jtb );
		add( scrollPane );
	}
}


import javax.swing.*;
import java.awt.*;

public class MainInterface extends JFrame
{
	private MainFunction mainFunction = new MainFunction();
	private MainList mainList = new MainList();

	public MainInterface()
	{
		setLayout( new FlowLayout( FlowLayout.CENTER ) );
		setTitle( "Device Management System" );
		setSize( 670, 460 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		add( mainFunction );
		add( mainList );
	}
	
	public MainList getMainList()
	{
		return mainList;
	}

	public MainFunction getMainFunction()
	{
		return mainFunction;
	}
}

class MainList extends JPanel
{
	public MainList()
	{
		String[] names = { "编号", "设备名称" };
		Object[][] previewData = new Object[ 10 ][ 2 ];
		
		JTable jtb = new JTable( previewData, names );
		jtb.setEnabled( false );
		JScrollPane scrollPane = new JScrollPane( jtb );
		add( scrollPane );
	}
}

class MainFunction extends JPanel
{
	private MainFunctionLabel mainFunctionLabel = new MainFunctionLabel();
	private MainNorthButton mainNorthButton = new MainNorthButton();
	private MainSouthButton mainSouthButton = new MainSouthButton();
	
	public MainFunction()
	{
		setLayout( new BorderLayout( 15, 35 ) );
		
		add( mainFunctionLabel, BorderLayout.NORTH );
		add( mainNorthButton, BorderLayout.CENTER );
		add( mainSouthButton, BorderLayout.SOUTH );
	}
	
	public MainFunctionLabel getMainFunctionLabel()
	{
		return mainFunctionLabel;
	}
	
	public MainNorthButton getMainNorthButton()
	{
		return mainNorthButton;
	}

	public MainSouthButton getMainSouthButton()
	{
		return mainSouthButton;
	}
}

class MainFunctionLabel extends JPanel
{
	JLabel jlbl = new JLabel( "功能" );

	public MainFunctionLabel()
	{
		add( jlbl );
		Font font = new Font( "SansSerif", Font.BOLD, 20 );
		jlbl.setFont( font );
	}
}

class MainNorthButton extends JPanel
{
	private JButton jbtShow = new JButton( "显示设备" );
	private JButton jbtIncrease = new JButton( "增加设备" );
	private JButton jbtSearch = new JButton( "查找设备" );
	private JButton jbtDelete = new JButton( "删除设备" );
	private JButton jbtModifity = new JButton( "修改设备" );
	
	MainNorthButton()
	{
		setLayout( new GridLayout( 5, 1, 15, 12 ) );
		
		add( jbtShow );
		add( jbtIncrease );
		add( jbtSearch );
		add( jbtDelete );
		add( jbtModifity );
	}

	public JButton getJbtShow()
	{
		return jbtShow;
	}

	public JButton getJbtIncrease()
	{
		return jbtIncrease;
	}

	public JButton getJbtSearch()
	{
		return jbtSearch;
	}

	public JButton getJbtDelete()
	{
		return jbtDelete;
	}

	public JButton getJbtModifity()
	{
		return jbtModifity;
	}
}

class MainSouthButton extends JPanel
{
	private JButton jbtSave = new JButton( "保存" );
	private JButton jbtQuit = new JButton( "退出" );

	public MainSouthButton()
	{
		setLayout( new GridLayout( 1, 2 ) );
		add( jbtSave );
		add( jbtQuit );
	}
	
	public JButton getJbtSave()
	{
		return jbtSave;
	}

	public JButton getJbtQuit()
	{
		return jbtQuit;
	}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchInterface extends JFrame
{
	private String[] choiceLabel = { "根据设备编号查找", "根据设备名称查找" };
	private String[] InputLabel = { "请输入设备编号", "请输入设备名称" };
	private SearchInputPanel searchInputPanel = new SearchInputPanel();
	private SearchButton searchButton = new SearchButton();
	private JComboBox jcbo = new JComboBox( choiceLabel );

	public SearchInterface()
	{
		setLayout( new BorderLayout( 5, 15 ) );
		setTitle( "查找设备" );
		setSize( 320, 150 );
		setLocationRelativeTo( null );

		add( jcbo, BorderLayout.NORTH );
		add( searchInputPanel, BorderLayout.CENTER );
		add( searchButton, BorderLayout.SOUTH );
		
		setDisplay( 0 );
		jcbo.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged( ItemEvent e )
					{
						setDisplay( jcbo.getSelectedIndex() );
					}
				}
				);
	}
	
	public JComboBox getJcbo()
	{
		return jcbo;
	}

	public SearchInputPanel getSearchInputPanel()
	{
		return searchInputPanel;
	}
	
	public SearchButton getSearchButton()
	{
		return searchButton;
	}

	public void setDisplay( int index )
	{
		searchInputPanel.getJlbl().setText( InputLabel[index] );
	}
}

class SearchInputPanel extends JPanel
{
	private JLabel jlbl = new JLabel();
	private JTextField jtf = new JTextField( 15 );

	public SearchInputPanel()
	{
		add( jlbl );
		add( jtf );
	}

	public JTextField getJtf()
	{
		return jtf;
	}

	public JLabel getJlbl()
	{
		return jlbl;
	}
}

class SearchButton extends JPanel
{
	private JButton jbtOK = new JButton( "确定" );
	private JButton jbtCancel = new JButton( "取消" );

	public SearchButton()
	{
		setLayout( new FlowLayout( FlowLayout.RIGHT ) );
		add( jbtOK );
		add( jbtCancel );
	}

	public JButton getJbtOK()
	{
		return jbtOK;
	}

	public JButton getJbtCancel()
	{
		return jbtCancel;
	}
}


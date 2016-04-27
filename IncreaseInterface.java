import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IncreaseInterface extends JFrame
{
	private IncreasePanel increasePanel = new IncreasePanel();
	private IncreaseButtonPanel increaseButtonPanel = new IncreaseButtonPanel();

	public IncreaseInterface()
	{
		setTitle( "新增设备" );
		setSize( 320, 370 );
		setLocationRelativeTo( null );
		setLayout( new BorderLayout() );
		
		add( increasePanel, BorderLayout.CENTER );
		add( increaseButtonPanel, BorderLayout.SOUTH );
	}

	public IncreasePanel getIncreasePanel()
	{
		return increasePanel;
	}

	public IncreaseButtonPanel getIncreaseButtonPanel()
	{
		return increaseButtonPanel;
	}
}

class IncreasePanel extends JPanel
{
	private IncreaseLabelPanel increaseLabelPanel = new IncreaseLabelPanel();
	private IncreaseTextFieldPanel increaseTextFieldPanel = new IncreaseTextFieldPanel();
	private IncreaseMustSign increaseMustSign = new IncreaseMustSign();

	public IncreasePanel()
	{
		add( increaseLabelPanel );
		add( increaseTextFieldPanel );
		add( increaseMustSign );
	}

	public IncreaseTextFieldPanel getIncreaseTextFieldPanel()
	{
		return increaseTextFieldPanel;
	}
}

class IncreaseLabelPanel extends JPanel
{
	private JLabel jlblID = new JLabel( "设备编号" );
	private JLabel jlblName = new JLabel( "设备名称" );
	private JLabel jlblType = new JLabel( "设备类型" );
	private JLabel jlblPrice = new JLabel( "设备单价" );
	private JLabel jlblPurchaseTime = new JLabel( "购入时间" );
	private JLabel jlblManfacture = new JLabel( "设备厂商" );
	private JLabel jlblIsCrapped = new JLabel( "是否报废" );
	private JLabel jlblCrappedTime = new JLabel( "报废时间" );

	public IncreaseLabelPanel()
	{
		setLayout( new GridLayout( 8, 1, 0, 17 ) );
		add( jlblID );
		add( jlblName );
		add( jlblType );
		add( jlblPrice );
		add( jlblPurchaseTime );
		add( jlblManfacture );
		add( jlblIsCrapped );
		add( jlblCrappedTime );
	}
}

class IncreaseTextFieldPanel extends JPanel
{
	private JTextField[] jtf = new JTextField[7];
	private IsCrappedButton isCrappedButton = new IsCrappedButton();

	public IncreaseTextFieldPanel()
	{
		setLayout( new GridLayout( 8, 1 ) );
		
		for( int i = 0; i < 6; i++ )
		{
			jtf[i] = new JTextField( 15 );
			add( jtf[i] );
		}
		add( isCrappedButton );
		jtf[6] = new JTextField( 15 );
		add( jtf[6] );
	}

	public JTextField[] getJtf()
	{
		return jtf;
	}

	public IsCrappedButton getIsCrappedButton()
	{
		return isCrappedButton;
	}
}

class IncreaseMustSign extends JPanel
{
	private JLabel[] jlbl = new JLabel[8];
	
	public IncreaseMustSign()
	{
		setLayout( new GridLayout( 8, 1, 0, 17 ) );

		for( int i = 0; i < 8; i++ )
		{
			if( i < 2 )
				jlbl[i] = new JLabel( "*" );
			else
				jlbl[i] = new JLabel( "");
			add( jlbl[i] );
		}
	}
}

class IncreaseButtonPanel extends JPanel
{
	private JButton jbtOK = new JButton( "确定" );
	private JButton jbtCancel = new JButton( "取消" );

	public IncreaseButtonPanel()
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

class IsCrappedButton extends JPanel
{
	private boolean isCrapped;
	private JRadioButton jrbY = new JRadioButton( "是" );
	private JRadioButton jrbN = new JRadioButton( "否" );
	private JRadioButton jrb = new JRadioButton();

	public IsCrappedButton()
	{
		setLayout( new FlowLayout( FlowLayout.LEFT ) );
		
		ButtonGroup group = new ButtonGroup();
		
		add( jrbY );
		add( jrbN );
		add( jrb );

		group.add( jrbY );
		group.add( jrbN );
		group.add( jrb );
		
		jrb.setVisible( false );

		jrbY.addActionListener( new ActionListener()
				{
					public void actionPerformed( ActionEvent e )
					{
						setIsCrapped( true );
					}
				});

		jrbN.addActionListener( new ActionListener()
				{
					public void actionPerformed( ActionEvent e )
					{
						setIsCrapped( false );
					}
				});
	}
	
	public JRadioButton getJrbY()
	{
		return jrbY;
	}

	public JRadioButton getJrbN()
	{
		return jrbN;
	}
	
	public JRadioButton getJrb()
	{
		return jrb;
	}

	public void setIsCrapped( boolean isCrapped )
	{
		this.isCrapped = isCrapped;
	}	
	
	public boolean getIsCrapped()
	{
		return isCrapped;
	}
}

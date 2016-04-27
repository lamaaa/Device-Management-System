import javax.swing.*;
import java.awt.*;

public class ResetInterface extends JFrame
{
	private ResetPanel resetPanel = new ResetPanel();
	private ResetLabel resetLabel = new ResetLabel();
	private ResetButton resetButton = new ResetButton();

	public ResetInterface()
	{
		setTitle( "重置帐户" );
		setSize( 350, 250 );
		setLocationRelativeTo( null );
		setResizable( false );
		
		setLayout( new BorderLayout( 0, 38 ) );
		add( resetLabel, BorderLayout.NORTH );
		add( resetPanel, BorderLayout.CENTER );
		add( resetButton, BorderLayout.SOUTH );
	}

	public ResetPanel getResetPanel()
	{
		return resetPanel;
	}

	public ResetLabel getResetLabel()
	{
		return resetLabel;
	}

	public ResetButton getResetButton()
	{
		return resetButton;
	}
}

class ResetPanel extends JPanel
{
	private ResetAccountPanel resetAccountPanel = new ResetAccountPanel();
	private ResetPasswdPanel resetPasswdPanel1 = new ResetPasswdPanel();
	private ResetPasswdPanel resetPasswdPanel2 = new ResetPasswdPanel();

	public ResetPanel()
	{
		setLayout( new GridLayout( 3, 1 ) );
		add( resetAccountPanel );
		add( resetPasswdPanel1 );
		add( resetPasswdPanel2 );
	}

	public ResetAccountPanel getResetAccountPanel()
	{
		return resetAccountPanel;
	}

	public ResetPasswdPanel getResetPasswdPanel1()
	{
		return resetPasswdPanel1;
	}

	public ResetPasswdPanel getResetPasswdPanel2()
	{
		return resetPasswdPanel2;
	}
}

class ResetAccountPanel extends JPanel
{
	private JLabel jlbl = new JLabel( "帐户" );
	private JTextField jtf = new JTextField( 15 );

	public ResetAccountPanel()
	{
		add( jlbl );
		add( jtf );
	}

	public JLabel getLabel()
	{
		return jlbl;
	}

	public JTextField getTextField()
	{
		return jtf;
	}
}

class ResetPasswdPanel extends JPanel
{
	private JLabel jlbl = new JLabel( "密码" );
	private JPasswordField jpf = new JPasswordField( 15 );
	
	public ResetPasswdPanel()
	{
		add( jlbl );
		add( jpf );
	}

	public JLabel getLabel()
	{
		return jlbl;
	}

	public JPasswordField getPasswordField()
	{
		return jpf;
	}
}

class ResetLabel extends JPanel
{
	private JLabel jlbl = new JLabel( "请您填写以下的信息:" );

	public ResetLabel()
	{
		setLayout( new FlowLayout( FlowLayout.LEFT ) );
		add( jlbl );
	}
}

class ResetButton extends JPanel
{
	private JButton jbtOK = new JButton( "确认" );
	private JButton jbtCancel = new JButton( "取消" );

	public ResetButton()
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

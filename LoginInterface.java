import javax.swing.*;
import java.awt.*;

public class LoginInterface extends JFrame
{
	private LoginPanel loginPanel = new LoginPanel();
	private LoginLeftButton loginLeftButton = new LoginLeftButton();
	private LoginRightButton loginRightButton = new LoginRightButton();

	public LoginInterface()
	{
		add( loginPanel, BorderLayout.NORTH );
		add( loginLeftButton, BorderLayout.WEST );
		add( loginRightButton, BorderLayout.EAST );
		setTitle( "Device Management System" );
		pack();
		//setSize( 400, 200 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//setResizable( false );
		setVisible( true );
	}

	public LoginPanel getLoginPanel()
	{
		return loginPanel;
	}

	public LoginRightButton getLoginRightButton()
	{
		return loginRightButton;
	}

	public LoginLeftButton getLoginLeftButton()
	{
		return loginLeftButton;
	}
}

class LoginLeftButton extends JPanel
{
	private JButton jbtNew = new JButton( "新建" );
	private JButton jbtReset = new JButton( "重置" );

	public LoginLeftButton()
	{
		setLayout( new FlowLayout( FlowLayout.LEFT ) );
		add( jbtNew );
		add( jbtReset );
	}

	public JButton getJbtNew()
	{
		return jbtNew;
	}

	public JButton getJbtReset()
	{
		return jbtReset;
	}
}

class LoginRightButton extends JPanel
{
	private JButton jbtOK = new JButton( "登陆" );
	private JButton jbtCancel = new JButton( "退出" );

	public LoginRightButton()
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

class LoginPanel extends JPanel
{
	private LoginInputPanel loginInputPanel = new LoginInputPanel();
	private LoginLabel loginLabel = new LoginLabel();

	public LoginPanel()
	{
		setLayout( new BorderLayout() );

		add( loginInputPanel, BorderLayout.SOUTH );
		add( loginLabel, BorderLayout.CENTER );
	}

	public LoginInputPanel getLoginInputPanel()
	{
		return loginInputPanel;
	}
}

class LoginInputPanel extends JPanel
{
	private LoginAccountPanel accountPanel = new LoginAccountPanel();
	private LoginPasswdPanel passwdPanel = new LoginPasswdPanel();

	public LoginInputPanel()
	{
		setLayout( new GridLayout( 3, 1, 0, 0 ) );
		
		accountPanel.setSize( 10, 10 );
		passwdPanel.setSize( 10, 10 );
		
		add( accountPanel );
		add( passwdPanel );
	}

	public LoginAccountPanel getLoginAccountPanel()
	{
		return accountPanel;
	}

	public LoginPasswdPanel getLoginPasswdPanel()
	{
		return passwdPanel;
	}
}

class LoginPasswdPanel extends JPanel
{
	private JPasswordField jpfPasswd = new JPasswordField( 15 );
	private JLabel jlblPasswd = new JLabel( "密码" );

	public LoginPasswdPanel( )
	{
		add( jlblPasswd );
		add( jpfPasswd );
	}

	public JPasswordField getJpfPasswd()
	{
		return jpfPasswd;
	}
}

class LoginAccountPanel extends JPanel
{
	private JTextField jtfAccount = new JTextField( 15 );
	private JLabel jlblAccount = new JLabel( "帐户" );

	public LoginAccountPanel()
	{
		add( jlblAccount );
		add( jtfAccount );
	}

	public JTextField getJtfAccount()
	{
		return jtfAccount;
	}
}

class LoginLabel extends JPanel
{
	private JLabel jlbl = new JLabel( "设备管理系统" );

	public LoginLabel()
	{
		Font font = new Font( "SansSerif", Font.BOLD, 20 );

		jlbl.setFont( font );
		setLayout( new FlowLayout( FlowLayout.CENTER ) );
		add( jlbl );
	}
}

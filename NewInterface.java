import javax.swing.*;
import java.awt.*;

public class NewInterface extends JFrame
{
	private  NewPanel newPanel = new NewPanel();
	private  NewLabel newLabel = new NewLabel();
	private  NewButton newButton = new NewButton();

	public NewInterface()
	{
		setTitle( "新建帐户" );
		setSize( 350, 250 );
		setLocationRelativeTo( null );
		setResizable( false );
		
		setLayout( new BorderLayout( 0, 36 ) );
		add( newLabel, BorderLayout.NORTH );
		add( newPanel, BorderLayout.CENTER );
		add( newButton, BorderLayout.SOUTH );
	}

	public NewPanel getNewPanel()
	{
		return newPanel; 
	}

	public NewLabel getNewLabel()
	{
		return newLabel;
	}

	public NewButton getNewButton()
	{
		return newButton;
	}
}

class NewPanel extends JPanel
{
	private NewAccountPanel newAccountPanel = new NewAccountPanel();
	private NewPasswdPanel newPasswdPanel1 = new NewPasswdPanel();
	private NewPasswdPanel newPasswdPanel2 = new NewPasswdPanel();

	public NewPanel()
	{
		setLayout( new GridLayout( 3, 1 ) );
		add( newAccountPanel );
		add( newPasswdPanel1 );
		add( newPasswdPanel2 );
	}

	public NewAccountPanel getNewAccountPanel()
	{
		return newAccountPanel;
	}

	public NewPasswdPanel getNewPasswdPanel1()
	{
		return newPasswdPanel1;
	}

	public NewPasswdPanel getNewPasswdPanel2()
	{
		return newPasswdPanel2;
	}

}

class NewAccountPanel extends JPanel
{
	private JLabel jlbl = new JLabel( "帐户" );
	private JTextField jtf = new JTextField( 15 );

	public NewAccountPanel()
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

class NewPasswdPanel extends JPanel
{
	private JLabel jlbl = new JLabel( "密码" );
	private JPasswordField jpf = new JPasswordField( 15 );

	public NewPasswdPanel()
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

class NewLabel extends JPanel
{
	private JLabel jlbl = new JLabel( "请您填写以下的信息:" );

	public NewLabel()
	{
		setLayout( new BorderLayout() );
		add( jlbl , BorderLayout.CENTER );
	}
}

class NewButton extends JPanel
{
	private JButton jbtOK = new JButton( "确认" );
	private JButton jbtCancel = new JButton( "取消" );

	public NewButton()
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

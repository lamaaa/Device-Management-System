import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Application
{
	private  LoginInterface loginInterface = new LoginInterface();
	private MainInterface mainInterface = new MainInterface();
	private NewInterface newInterface = new NewInterface();
	private ResetInterface resetInterface = new ResetInterface();
	
	private Equipment data = new Equipment();
	private String account;
	private String passwd;

	public void run()
	{
		loginInterface.getLoginRightButton().getJbtOK().addActionListener( new LoginButtonListener() );
		loginInterface.getLoginRightButton().getJbtCancel().addActionListener( new QuitButtonListener() );
		loginInterface.getLoginLeftButton().getJbtNew().addActionListener( new NewButtonListener() );
		loginInterface.getLoginLeftButton().getJbtReset().addActionListener( new ResetButtonListener() );

		newInterface.getNewButton().getJbtOK().addActionListener( new NewOKButtonListener() );
		newInterface.getNewButton().getJbtCancel().addActionListener( new NewCancelButtonListener() );
		
		resetInterface.getResetButton().getJbtOK().addActionListener( new ResetOKButtonListener() );
		resetInterface.getResetButton().getJbtCancel().addActionListener( new ResetCancelButtonListener() );

		mainInterface.getMainFunction().getMainNorthButton().getJbtShow().addActionListener( new MainShowButtonListener() );
		mainInterface.getMainFunction().getMainNorthButton().getJbtIncrease().addActionListener( new MainIncreaseButtonListener() );
		mainInterface.getMainFunction().getMainNorthButton().getJbtSearch().addActionListener( new MainSearchButtonListener() );
		mainInterface.getMainFunction().getMainNorthButton().getJbtDelete().addActionListener( new MainDeleteButtonListener() );
		mainInterface.getMainFunction().getMainNorthButton().getJbtModifity().addActionListener( new MainModifityButtonListener() );
		mainInterface.getMainFunction().getMainSouthButton().getJbtSave().addActionListener( new MainSaveButtonListener() );
		mainInterface.getMainFunction().getMainSouthButton().getJbtQuit().addActionListener( new MainQuitButtonListener() );
	}
	
	public void setData( Equipment data )
	{
		this.data = data;
	}
	
	public Equipment getData()
	{
		return data;
	}
	
	public void setAccount( String account )
	{
		this.account = account;
	}

	public void setPasswd( String passwd )
	{
		this.passwd = passwd;
	}
	
	private class LoginButtonListener implements ActionListener
	{
		private String inputAccount;
		private String inputPasswd;
	
		public void actionPerformed( ActionEvent e )
		{
			inputAccount = loginInterface.getLoginPanel().getLoginInputPanel().getLoginAccountPanel().getJtfAccount().getText();
			inputPasswd = loginInterface.getLoginPanel().getLoginInputPanel().getLoginPasswdPanel().getJpfPasswd().getText();
	
			if( inputAccount.equals( "" ) )
				JOptionPane.showMessageDialog( null, "请输入帐户" );
			else if( inputPasswd.equals( "" ) )
				JOptionPane.showMessageDialog( null, "请输入密码" );
			else
			{
				File accountFile = new File( "Account/" + inputAccount );
	
				if( !accountFile.exists() )
				{
					JOptionPane.showMessageDialog( null, "帐户错误,请重新输入" );
				}
				else
				{
					try
					{
						if( readAccount( accountFile, inputPasswd ) )
						{
							JOptionPane.showMessageDialog( null, "登陆成功！" );
							setAccount( inputAccount );
							setPasswd( inputPasswd );
							
							File dataFile = new File( "Data/" + inputAccount );		
							if( dataFile.exists() )
							{
								Equipment head = readFile( dataFile, inputPasswd ); 
								setData( head );
							}
							else
							{
								JOptionPane.showMessageDialog( null, "数据文件损坏" );
							}
							loginInterface.setVisible( false );
							mainInterface.setVisible( true );
						}
						else
						{
							return;
						}
					}
					catch( FileNotFoundException ex )
					{
						JOptionPane.showMessageDialog( null, "密码文件已损坏" );
						return;
					}
				}
			}
		}
			
		private boolean readAccount( File accountFile, String inputPasswd ) throws FileNotFoundException
		{
			Scanner input = new Scanner( accountFile );
	
			String passwd = input.next();
	
			if( passwd.equals( inputPasswd ) )
			{
					input.close();
					return true;
			}
			else
			{
				JOptionPane.showMessageDialog( null, "密码错误，请重新输入" );
				input.close();
				return false;
			}
		}
	
		private Equipment readFile( File dataFile, String passwd ) throws FileNotFoundException
		{
			Scanner input = new Scanner( dataFile );
			Equipment head = new Equipment();
			Equipment p = head;
			Equipment pBefore = head;
			
			/*头节点有内容*/
			while( input.hasNext() )
			{
				p.setID( input.next() );
				p.setName( input.next() );
				p.setType( input.next() );
				p.setPrice( input.nextDouble() );
				p.setPurchaseTime( input.next() );
				p.setManfacture( input.next() );
				p.setIsCrapped( input.nextBoolean() );
				p.setCrappedTime( input.next() );
				
				p = new Equipment();
				p.setBefore( pBefore );
				pBefore.setNext( p );
				pBefore = pBefore.getNext();
			}
			
			p.getBefore().setNext( null );
			input.close();
			
			return head;
		}
	}


	private class QuitButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			int option = JOptionPane.showConfirmDialog( null, "请您确认是否退出" );
			if( option == JOptionPane.YES_OPTION )
				System.exit( 0 );
		}
	}
	
	private class NewButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			newInterface.setVisible( true );
		}
	}

	private class ResetButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			resetInterface.setVisible( true );
		}
	}

	private class NewOKButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			String account = newInterface.getNewPanel().getNewAccountPanel().getTextField().getText();
			String passwd1 = newInterface.getNewPanel().getNewPasswdPanel1().getPasswordField().getText();
			String passwd2 = newInterface.getNewPanel().getNewPasswdPanel2().getPasswordField().getText();
			
			if( account.equals( "" ) )
				JOptionPane.showMessageDialog( null, "请输入帐户" );
			else if( passwd1.equals( "" ) )
				JOptionPane.showMessageDialog( null, "请输入密码" );
			else if( passwd2.equals( "" ) )
				JOptionPane.showMessageDialog( null, "请再次输入密码" );
			else if( !passwd1.equals( passwd2 ) )
				JOptionPane.showMessageDialog( null, "两次输入的密码不一致" );
			else
			{
					try
					{
						saveAccount( account, passwd1 );
					}
					catch( FileNotFoundException ex )
					{
						JOptionPane.showMessageDialog( null, "未找到文件,请先创建Account文件夹和Data文件夹" );
						return;
					}

					JOptionPane.showMessageDialog( null, "恭喜，帐户创建成功" );
					newInterface.setVisible( false );
			}
		}

		private void saveAccount( String account, String passwd ) throws FileNotFoundException
		{
			String accountFileName = "Account/" + account;
			String dataFileName = "Data/" + account;

			File accountFile = new File( accountFileName );
			File dataFile = new File( dataFileName );

			PrintWriter output1 = new PrintWriter( accountFile );
			PrintWriter output2 = new PrintWriter( dataFile );

			output1.print( passwd );
			output1.close();

			output2.close();
		}
	}

	private class NewCancelButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			newInterface.setVisible( false );
		}
	}
	
	private class ResetOKButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			String inputAccount = resetInterface.getResetPanel().getResetAccountPanel().getTextField().getText();
			String inputPasswd1 = resetInterface.getResetPanel().getResetPasswdPanel1().getPasswordField().getText();
			String inputPasswd2 = resetInterface.getResetPanel().getResetPasswdPanel2().getPasswordField().getText();

			if( inputAccount.equals( "" ) )
				JOptionPane.showMessageDialog( null, "请输入帐户" );
			else if( inputPasswd1.equals( "" ) )
				JOptionPane.showMessageDialog( null, "请输入密码" );
			else if( inputPasswd2.equals( "" ) )
				JOptionPane.showMessageDialog( null, "请再次输入密码" );
			else if( !inputPasswd1.equals( inputPasswd2 ) )
				JOptionPane.showMessageDialog( null, "两次输入的密码不一致" );
			else
			{
				File accountFile = new File( "Account/" + inputAccount );

				if( !accountFile.exists() )
				{
					JOptionPane.showMessageDialog( null, "系统内无该帐户" );
					return;	
				}
				else
				{
					try
					{
						changeAccount( accountFile, inputPasswd1 ); 
						JOptionPane.showMessageDialog( null, "重置成功！" );
					}
					catch( FileNotFoundException ex )
					{
						JOptionPane.showMessageDialog( null, "密码文件损坏！" );
					}
					finally
					{
						resetInterface.setVisible( false );
					}
				}
			}
		}
		
		private void changeAccount( File accountFile, String inputPasswd ) throws FileNotFoundException
		{
			PrintWriter output = new PrintWriter( accountFile );

			output.println( inputPasswd );

			output.close();
		}
	}

	private class ResetCancelButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			resetInterface.setVisible( false );
		}
	}
	
	private class MainShowButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
		}
	}

	private class MainIncreaseButtonListener implements ActionListener
	{
		IncreaseInterface increaseInterface = new IncreaseInterface();

		public void actionPerformed( ActionEvent e )
		{
			increaseInterface.setVisible( true );
			
			increaseInterface.getIncreaseButtonPanel().getJbtOK().addActionListener( new IncreaseButtonJbtOKListener() );
			increaseInterface.getIncreaseButtonPanel().getJbtCancel().addActionListener( new IncreaseButtonJbtCancelListener() );
		}

		private class IncreaseButtonJbtOKListener implements ActionListener
		{
			String[] text = new String[8];

			public void actionPerformed( ActionEvent e )
			{
				for( int i = 0; i < 7; i++ )
				{
					text[i] = increaseInterface.getIncreasePanel().getIncreaseTextFieldPanel().getJtf()[i].getText();
				}

				if( text[0].equals( "" ) )
					JOptionPane.showMessageDialog( null, "请填写设备编号" );
				else if( text[1].equals( "" ) )
					JOptionPane.showMessageDialog( null, "请填写设备名称" );
				else
				{
					Equipment p = getData();
					
					Equipment increaseEquipment = new Equipment();
					boolean isCrapped = increaseInterface.getIncreasePanel().getIncreaseTextFieldPanel().getIsCrappedButton().getIsCrapped();
					
					for( int i = 2; i < 7; i++ )
						if( text[i] == null )
							text[i] = "";

					increaseEquipment.setID( text[0] );
					increaseEquipment.setName( text[1] );
					increaseEquipment.setType( text[2] );
					if( !text[3].equals( "" ) )
						increaseEquipment.setPrice( Double.parseDouble( text[3] ) );
					increaseEquipment.setPurchaseTime( text[4] );
					increaseEquipment.setManfacture( text[5] );
					increaseEquipment.setIsCrapped( isCrapped );
					increaseEquipment.setCrappedTime( text[6] );	
					
					while( p.getNext() != null )
					{
						p = p.getNext();
					}

					p.setNext( increaseEquipment );
					increaseEquipment.setBefore( p );
					
					for( int i = 0; i < 7; i++ )
					increaseInterface.getIncreasePanel().getIncreaseTextFieldPanel().getJtf()[i].setText( "" );
				increaseInterface.getIncreasePanel().getIncreaseTextFieldPanel().getIsCrappedButton().getJrb().setSelected( true );
	
				increaseInterface.setVisible( false );
				}

			}
		}

		private class IncreaseButtonJbtCancelListener implements ActionListener
		{
			public void actionPerformed( ActionEvent e )
			{
				for( int i = 0; i < 7; i++ )
					increaseInterface.getIncreasePanel().getIncreaseTextFieldPanel().getJtf()[i].setText( "" );
				increaseInterface.getIncreasePanel().getIncreaseTextFieldPanel().getIsCrappedButton().getJrb().setSelected( true );
	
				increaseInterface.setVisible( false );
			}
		}
	}

	private class MainSearchButtonListener implements ActionListener
	{
		SearchInterface searchInterface = new SearchInterface();

		public void actionPerformed( ActionEvent e )
		{
			searchInterface.setVisible( true );
			searchInterface.getSearchButton().getJbtOK().addActionListener( new SearchButtonJbtOKListener() );
			searchInterface.getSearchButton().getJbtCancel().addActionListener( new SearchButtonJbtCancelListener() );
		}

		private class SearchButtonJbtOKListener implements ActionListener
		{
			public void actionPerformed( ActionEvent e )
			{
				int choice = searchInterface.getJcbo().getSelectedIndex();
				SearchDisplayInterface searchDisplayInterface = new SearchDisplayInterface();

				
				if( choice == 0 )
				{
					String ID = searchInterface.getSearchInputPanel().getJtf().getText();

					Equipment ptr = getData();

					while( ptr != null )
					{
						if( ptr.getID().equals( ID ) )
						{
							break;
						}
						else
						{
							ptr = ptr.getNext();
						}
					}

					if( ptr != null )
					{
						String[][] data = searchDisplayInterface.getSearchDisplayPanel().data;
						
						data[0][1] = ptr.getID();
						data[1][1] = ptr.getName();
						data[2][1] = ptr.getType();
						data[3][1] = Double.toString( ptr.getPrice() );
						data[4][1] = ptr.getPurchaseTime();
						data[5][1] = ptr.getManfacture();
						data[6][1] = Boolean.toString( ptr.getIsCrapped() );
						data[7][1] = ptr.getCrappedTime();

						searchDisplayInterface.setVisible( true );
					}
					else
						JOptionPane.showMessageDialog( null, "没有找到该设备" );

				}
				else
				{
					String name = searchInterface.getSearchInputPanel().getJtf().getText();
					Equipment ptr = getData();

					while( ptr != null )
					{
						if( ptr.getName().equals( name ) )
						{
							break;
						}
						else
						{
							ptr = ptr.getNext();
						}
					}

					if( ptr != null )
					{
						String[][] data = searchDisplayInterface.getSearchDisplayPanel().data;

						data[0][1] = ptr.getID();
						data[1][1] = ptr.getName();
						data[2][1] = ptr.getType();
						data[3][1] = Double.toString( ptr.getPrice() );
						data[4][1] = ptr.getPurchaseTime();
						data[5][1] = ptr.getManfacture();
						data[6][1] = Boolean.toString( ptr.getIsCrapped() );
						data[7][1] = ptr.getCrappedTime();
						searchDisplayInterface.setVisible( true );

					}
					else
						JOptionPane.showMessageDialog( null, "没有找到该设备" );
				}
			}
		}

		private class SearchButtonJbtCancelListener implements ActionListener
		{
			public void actionPerformed( ActionEvent e )
			{
				searchInterface.getSearchInputPanel().getJtf().setText( "" );
				searchInterface.setVisible( false );
			}
		}
	}

	private class MainDeleteButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			SearchInterface searchInterface = new SearchInterface();

			searchInterface.setVisible( true );
		}
	}

	private class MainModifityButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			SearchInterface searchInterface = new SearchInterface();

			searchInterface.setVisible( true );
		}
	}

	private class MainSaveButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			try
			{
				saveFile( getData() );
			}
			catch( FileNotFoundException ex )
			{
			
			}
		}
	}
	
	private void saveFile( Equipment head ) throws FileNotFoundException
	{
		File file = new File( "Data/" + account );
		Equipment p = getData();
		
		if( file.exists() )
		{
			PrintWriter output = new PrintWriter( file );
			
			while( p != null )
			{
				output.println( p.getID() );
				output.println( p.getName() );
				output.println( p.getType() );
				output.println( p.getPrice() );
				output.println( p.getPurchaseTime() );
				output.println( p.getManfacture() );
				output.println( p.getIsCrapped() );
				output.println( p.getCrappedTime() );

				p = p.getNext();
			}	
			output.close();
		}
	}

	private class MainQuitButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			int option = JOptionPane.showConfirmDialog( null, "请您确认是否退出" );
			if( option == JOptionPane.YES_OPTION )
				System.exit( 0 );
		}
	}
}

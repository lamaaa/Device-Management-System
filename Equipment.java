public class Equipment
{
	private String ID;
	private String name; 
	private String type;
	private double price;
	private String purchaseTime;
	private String manfacture;
	private boolean isCrapped;
	private String crappedTime;
	private Equipment before;
	private Equipment next;

	public String getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type;
	}

	public double getPrice()
	{
		return price;
	}

	public String getPurchaseTime()
	{
		return purchaseTime;
	}

	public String getManfacture()
	{
		return manfacture;
	}

	public boolean getIsCrapped()
	{
		return isCrapped;
	}

	public String getCrappedTime()
	{
		if( isCrapped == true )
			return crappedTime;
		else
			return null;
	}

	public Equipment getBefore()
	{
		return before;
	}

	public Equipment getNext()
	{
		return next;
	}
	
	public void setID( String ID )
	{
		this.ID = ID;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public void setType( String type )
	{
		this.type = type;
	}

	public void setPrice( double price )
	{
		this.price = price;
	}

	public void setPurchaseTime( String purchaseTime )
	{
		this.purchaseTime = purchaseTime;
	}

	public void setManfacture( String manfacture )
	{
		this.manfacture = manfacture;
	}

	public void setIsCrapped( boolean isCrapped )
	{
		this.isCrapped = isCrapped;
	}

	public void setCrappedTime( String crappedTime )
	{
		if( isCrapped == true )
			this.crappedTime = crappedTime;
	}

	public void setBefore( Equipment before )
	{
		this.before = before;
	}

	public void setNext( Equipment next )
	{
		this.next = next;
	}
}

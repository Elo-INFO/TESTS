package TD1.TD1;

public enum Country {
	
	France(1.196), 
	DE(1.19),
	DK(1.25),
	HR(1.25),
	IS(1.255),
	CH(1.08);
	
	private final Double TaxeToApply;
	
	private Country(Double TaxeToApply)
	{
		this.TaxeToApply = TaxeToApply;
	}
	
	Double getTaxeToApply()
	{
		return TaxeToApply;
	}
	
	
	
	

}

package TD1.TD1;

public class Item {
	
	private double prix;
	private String label;
	private int quantite;

	public Item(String string, double d) 
	{
		label = string;
		prix = d;
	}

	@Override
	public String toString() {
		return label+" coûte"+prix+"€";
	}

	public Double getPrice() {
		return this.prix;
	}
	
	

	

}

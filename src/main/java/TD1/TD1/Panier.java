package TD1.TD1;


import java.util.HashMap;
import java.util.stream.Collectors;

public class Panier {

		public HashMap<Item, Integer> contenu = new HashMap<Item, Integer>();
		public int quantite;
		
		public Panier() {}
		
		


		public  void add(Item item, int q) 
		{
			contenu.put(item, q);			
		}		
		


		public Object getContenu() {
			
			return contenu;
		}


		public double getPriceWithoutTaxes() {
			return contenu.entrySet().stream().map(x -> x.getKey().getPrice()*x.getValue())
					.collect(Collectors.summingDouble(Double::doubleValue));
		}

		public double getPriceWithTaxes(Country c) {
			return prixAvecReduction()*c.getTaxeToApply();
		}
		
		public double prixAvecReduction()
		{
			double total = this.getPriceWithoutTaxes();
			double reduc;
			if(total < 1000)
			{
				return total;
			}
			else if (total >= 1000 && total < 5000)
			{
				reduc = total*0.03;
				total -= reduc;
			}
			else if (total >= 5000 && total < 7000)
			{
				reduc = total*0.05;
				total -= reduc;
			}
			else if (total >= 7000 && total < 10000) 
			{
				reduc = total*0.07;
				total -= reduc;
			}
			else if (total >= 10000 && total < 50000) 
			{
				reduc = total*0.10;
				total -= reduc;
			}
			else if (total >= 50000)
			{
				reduc = total*0.15;
				total -= reduc;
			}
			return total;
			
			
			
		}
	
		
}

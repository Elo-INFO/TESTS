package TD1.TD1;




import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
/**
 * Unit test for simple App.
 */
public class PanierTest 
{
	
	@Test
	public void addItem()
	{
		final Panier p = new Panier();
		final Item carrot = new Item("Carrot", 2.5);
		p.add(carrot, 1);
		
		Assert.assertEquals(p.getContenu(), new HashMap<Item, Integer>(){{
			put(carrot, 1);
		}});
	}
	
	@Test
	public void computePriceWithoutTaxes()
	{
		final Panier p = new Panier();
		final Item carrot = new Item("Carrot", 2.5);
		p.add(carrot, 1);
		p.add(new Item("Apple", 1), 25);
		p.add(new Item("Banana 1kg, ", 5), 3);
		Assert.assertEquals(p.getPriceWithoutTaxes(), 42.5, 0.0001);
	}
	
	@Test
	public void computePriceWithTaxesFR()
	{
		final Panier p = new Panier();
		final Item carrot = new Item("Carrot", 2.5);
		p.add(carrot, 1);
		p.add(new Item("Apple", 1), 25);
		p.add(new Item("Banana 1kg, ", 5), 3);
		Assert.assertEquals(p.getPriceWithTaxes(Country.France), 50.83, 0.0001);
	}
	
	@Test
	public void computePriceWithTaxesDE()
	{
		final Panier p = new Panier();
		final Item carrot = new Item("Carrot", 2.5);
		p.add(carrot, 1);
		p.add(new Item("Apple", 1), 25);
		p.add(new Item("Banana 1kg, ", 5), 3);
		Assert.assertEquals(p.getPriceWithTaxes(Country.DE), 50.5749 , 0.0001);
	}
	
	@Test
	public void prixAveccReductionTest()
	{
		final Panier p = new Panier();
		final Item carrot = new Item("Carrot", 2.5);
		p.add(carrot, 189);
		p.add(new Item("Apple", 56), 25);
		p.add(new Item("Banana 1kg, ", 9), 332);
		Assert.assertEquals(p.prixAvecReduction(), 4714.685, 0.0001);
		Assert.assertEquals(p.getPriceWithTaxes(Country.DK), 5893.35625, 0.0001);
	}
	
		
}
	


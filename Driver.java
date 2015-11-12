public class Driver 
{
	public static void main(String[] args)
	{
		String input = "3 + 4 * 22";
		Converter c = new Converter(input);
		c.convert();
		c.process();
	}
}

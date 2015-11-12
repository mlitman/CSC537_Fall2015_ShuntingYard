
public class LinkedList 
{
	private Node head;
	private String theOps = "+-*/^()";
	private String thePrec = "2233411";
	private String theAss = "LLLLRLL";
	
	
	public LinkedList()
	{
		this.head = null;
	}
	
	public void addFront(String value)
	{
		Node n = new Node(value);
		if(this.head == null)
		{
			this.head = n;
		}
		else
		{
			n.setNextNode(this.head);
			this.head = n;
		}
	}
	
	public String pop()
	{
		return this.removeFront();
	}
	
	//this is specific to the Shunting Yard Algorithm
	public boolean push(String op)
	{
		if(this.head == null || op.equals("("))
		{
			Node n = new Node(op);
			n.setNextNode(this.head);
			this.head = n;
			return true;
		}
		
		int topPos = this.theOps.indexOf(this.head.getPayload());
		int topPrec = Integer.parseInt("" + this.thePrec.charAt(topPos));
		char topAss = this.theAss.charAt(topPos);
		
		int newPos = this.theOps.indexOf(op);
		int newPrec = Integer.parseInt("" + this.thePrec.charAt(newPos));
		char newAss = this.theAss.charAt(newPos);
		
		if(newPrec > topPrec || (newPrec == topPrec && topAss == 'R'))
		{
			Node n = new Node(op);
			n.setNextNode(this.head);
			this.head = n;
			return true;
		}
		return false;
	}
	
	public boolean hasMoreElements()
	{
		return this.head != null;
	}
	
	public void addEnd(String value)
	{
		Node n = new Node(value);
		if(this.head == null)
		{
			this.head = n;
		}
		else
		{
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			currNode.setNextNode(n);
		}
	}
	
	public String removeFront()
	{
		if(this.head == null)
		{
			return null;
		}
		else
		{
			String valueToReturn = this.head.getPayload();
			this.head = this.head.getNextNode();
			return valueToReturn;
		}
	}
	
	public void display()
	{
		if(this.head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			this.head.display();
		}
	}
}

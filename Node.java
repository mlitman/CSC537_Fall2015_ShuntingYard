
public class Node 
{
	private String payload;
	private Node nextNode;
	
	public Node(String payload)
	{
		this.payload = payload;
		this.nextNode = null;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public String getPayload() {
		return payload;
	}
	
	public void display()
	{
		System.out.print(this.payload);
		if(this.nextNode != null)
		{
			System.out.print(" -> ");
			this.nextNode.display();
		}
	}
}

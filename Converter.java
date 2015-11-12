import java.util.StringTokenizer;


public class Converter 
{
	private String infix;
	private String ops = "+-*/^()";
	private LinkedList theTokens;
	private LinkedList theOutput;
	private LinkedList theOpStack;
	
	public Converter(String infix)
	{
		this.infix = infix;
		this.theTokens = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(this.infix, this.ops, true);
		String temp;
		while(st.hasMoreTokens())
		{
			temp = st.nextToken().trim();
			if(temp.length() > 0)
			{
				this.theTokens.addEnd(temp);
			}
		}
	}
	
	public void convert()
	{
		this.theOutput = new LinkedList();
		this.theOpStack = new LinkedList();
		String currToken;
		while(this.theTokens.hasMoreElements())
		{
			currToken = this.theTokens.removeFront();
			if(this.ops.indexOf(currToken) == -1)
			{
				//currToken is a number
				this.theOutput.addEnd(currToken);
			}	
			else
			{
				//currToken is an op and we have to TRY to push it onto the op Stack
				if(currToken.equals(")"))
				{
					//pop from opStack until we hit open paren
					String currOp = this.theOpStack.pop();
					while(!currOp.equals("("))
					{
						this.theOutput.addEnd(currOp);
						currOp = this.theOpStack.pop();
					}
				}
				else
				{
					while(!this.theOpStack.push(currToken))
					{
						this.theOutput.addEnd(this.theOpStack.pop());
					}
				}
			}
		}
		
		//we have process all of the tokens, now empty the opStack onto the output
		while(this.theOpStack.hasMoreElements())
		{
			this.theOutput.addEnd(this.theOpStack.pop());
		}
	}
	
	public void process()
	{
		LinkedList theProcessStack = new LinkedList();
		String currElement;
		while(this.theOutput.hasMoreElements())
		{
			currElement = this.theOutput.pop();
			if(this.ops.indexOf(currElement) == -1)
			{
				theProcessStack.addFront(currElement);
			}
			else
			{
				double op1 = Double.parseDouble(theProcessStack.pop());
				double op2 = Double.parseDouble(theProcessStack.pop());
				if(currElement.equals("+"))
				{
					theProcessStack.addFront("" + (op2 + op1));
				}
				else if(currElement.equals("-"))
				{
					theProcessStack.addFront("" + (op2 - op1));
				}
				else if(currElement.equals("*"))
				{
					theProcessStack.addFront("" + (op2 * op1));
				}
				else if(currElement.equals("/"))
				{
					theProcessStack.addFront("" + (op2 / op1));
				}
				else if(currElement.equals("^"))
				{
					theProcessStack.addFront("" + (Math.pow(op2, op1)));
				}
			}
		}
		theProcessStack.display();
	}
}

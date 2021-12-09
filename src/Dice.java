import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Dice {

	Random gene = new Random();
	int side = 0;
	public void home(){
		String [] buttons = {"Dice","Help", "Quit"};
		int x = JOptionPane.showOptionDialog(null, "Click dice to roll a die \n" +"Please note, the number of tosses is limited to your hardware; until you run out of memory", "Dice toss", 0, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons);
		if(x == 0){
			try{
			double [] values1 = getCubeTosses();
			msg1(getLongestRun(values1));
			}catch(Exception e){
				msg("Please enter a valid number");
				home();
			}
			home();
		}if(x == 1){
			msg("Enter the number of sides of the dice , \n" +
					"Then enter the number of times you want to toss the dice \n" +
					"The lonest run will be reported, if there is no run it will return -1 \n" +
					"Make sure you have a good PC with memory for large amounts of tosses unlike my PC...");
			home();
		}if(x == 2){
			System.exit(0);
		}
	}
	public String in(String s){
		return JOptionPane.showInputDialog(s);
	}
	public void msg(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	public void msg1(double s){
		JOptionPane.showMessageDialog(null,"Longest run of a repeating number " + s + "\n The side that caused a longest run " + side);
	}
	public double numbersides() {
		String s = JOptionPane.showInputDialog("Enter number of sides");
		double d = Double.parseDouble(s);
		return d;
	}
	public double numbertosses() {
		String s = JOptionPane.showInputDialog("Enter number of tosses");
		double d = Double.parseDouble(s);
		return d;
	}
	public double toss(int sides){
		int x = gene.nextInt(sides) + 1;
		return x;
	}
	
	public double[] getCubeTosses()
	{	
		try{
		double sides = numbersides();
		double numTosses = numbertosses();
		
		
		
	 double[] cubeTosses = new double[(int)numTosses];
		
	 for (int i = 0; i < numTosses; i++)
	 {
	 cubeTosses[i] = toss((int)sides);
	 }
	 return cubeTosses;
		}catch(Exception e){
			msg("The number of tosses is too large to handle \n" +
					"Or Either a negative number, no response was written \n" +
					"Or response not valid");
			home();
			return null;
		}
	} 

	
	public double getLongestRun(double[] values)
	{
	 int currentLen = 0;
	 int maxLen = 0;
	 int maxStart = -1;
	 for (int i = 0; i < values.length-1; i++)
	 {
	 if (values[i] == values[i+1])
	 {
	 currentLen++;
	 if (currentLen > maxLen)
	 {
	 side = (int) values[i];
	 maxLen = currentLen;
	 maxStart = i - currentLen + 1;
	 }
	 }
	 else
	 {
	 currentLen = 0;
	 }
	 }
	 return maxStart;
	} 
	
}

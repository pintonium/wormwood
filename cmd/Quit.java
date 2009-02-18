package cmd;
import core.Input;
import obj.Player;
import iface.Command;

public class Quit implements Command {
   public void exec (Player p) {
      System.out.println("Are you sure you wish to quit? (y/n)");
      String answer;
      answer = Input.nextLine(); 

      if (answer.matches("y") || answer.matches("Y")) 
         System.exit(0);
      // Do nothing
      else if (answer.matches("n") || answer.matches("N"));
      // User entered invalid input
      else 
         System.out.println("You must answer with y or n.");
   }
   
   public void construct(String params[]){
	   
   }

   public void setDir (char d) {}
   public void setName (String n) {}
      
}
public class Use implements Command {
   private String itemName;

   public void exec (Player p) {
      Item item = p.getItem(itemName);

      if (item != null && item.getNumUses() > 0)
         item.use(p);
      else 
         System.out.println("You can't use this item anymore.");
   }

   public void setDir (char dir) {}

   public void setName (String itemToBeUsed) {
      itemName = itemToBeUsed;
   }
}


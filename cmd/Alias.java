/**
 * Alias
 * Creates a new alias
 * params:
 * 		- name: stores name of alias
 * 		- command: stores command name
 * 		- [params[]]: stores parameter[s] to be passed
 */
package cmd;

import obj.Player;
import core.Output;
import java.util.ArrayList;

public class Alias {
	private String name, command;
	private ArrayList<String> params;
	private static ArrayList<Alias> aliases = new ArrayList<Alias>();
	
	public void exec (Player p){}
	
	public void construct(String params[]){
		//Remove an alias of the same name if it already exists
		if(exists(params[0])){
			Alias temp = get(params[0]);
			temp.remove();
		}
		//Initialize params list
		this.params = new ArrayList<String>();
		
		//Set the name of the alias and the command to be aliased
		this.name = params[0];
		this.command = params[1];
		
		//Grab the rest of the params array and set the params to be passed, if any, to the aliased command
		for(int i = 2; i < params.length; i++)
			this.params.add(params[i]);
		aliases.add(this);
		Output.println("Alias added");
	}
	
	//Returns an alias with a selected name
	public static Alias get(String name){
		if(exists(name)){
			for(int i = 0; i < aliases.size(); i++){
				if(aliases.get(i).name.equalsIgnoreCase(name))
					return aliases.get(i);
			}
		}
		//Return a null alias if it doesn't exist
		return null;			
	}
	
	//Casts the list of params into an array and returns it
	public String[] getParams(){
		String[] params = new String[this.params.size()];
		for(int i = 0; i < this.params.size(); i++)
			params[i] = this.params.get(i);
		return  params;
	}
	
	//Returns the command that is run by this alias
	public String getCommand(){
		return this.command;
	}
	
	//Removes this alias
	public void remove(){
		for(int i = 0; i < aliases.size(); i++){
			if(aliases.get(i).name.equalsIgnoreCase(this.name)){
				aliases.remove(i);
			}
		}
	}
	
	//Add an array of parameters to the current param list
	public void addParams(String[] newParams){
		for(int i = 0; i < newParams.length; i++)
			this.params.add(newParams[i]);
	}
	
	//Checks to see if an alias exists with selected name
	public static boolean exists(String name){
		for(int i = 0; i < aliases.size(); i++){
			if(aliases.get(i).name.equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
}

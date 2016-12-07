
public class Bathroom extends Room {



	public Bathroom(String name, String n, String e, String w, String s, itemInventory itemList) {
		super(name, n, e, w, s, itemList);
		this.human = 100;
	}

	@Override
	public void lookaround() {
		
		System.out.println("This room looks like a bathroom.");
		System.out.println("There is a rusted mirror on the wall.");
		System.out.println("You look into the mirror, "
				+ "and see a person you cannot recognize anymore.");
	}
	
	public void search()  {
		this.searched = true;
		System.out.println("You searched the toilet and the tub, and found:");
		this.itemList.print();
		
		if  (this.human >= 0)  {
			System.out.println("A girl is hiding in the tub, silent.");
			System.out.println("There is blood on her hands.");
		}
	}

}

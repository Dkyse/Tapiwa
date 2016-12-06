import java.util.Map;

public class Player {

	private int health;
	private int food;
	private int water;
	private int mental;
	private itemInventory bag;
	private Room currentRoom;
	
	public Player(String roomName, Map<String, Room> m)  {
		this.health = 100;
		this.food = 100;
		this.water = 100;
		this.mental = 100;
		this.bag = new itemInventory();
		this.currentRoom = m.get(roomName);
	}
	
	
	public void status()  {
		System.out.println("Current status:");
		System.out.println("Health: " + this.health);
		System.out.println("Food: " + this.food);
		System.out.println("Water: " + this.water);
		System.out.println("Mental status: " + this.mental);
		System.out.println("Your bag contains: ");
		this.bag.print();
		System.out.println("You are currently in a " + this.currentRoom.getName());
		System.out.println("If your health, food, water, or mental status drops to 0, you are dead.");
	}
	
	
	public void oneturn()  {
		this.water -= 7;
		this.food -= 4;
		this.health -= 1;
		this.mental -= 9;
	}
	
	
	public void go(String direction, Map<String, Room> m)  {
		String newRoom = this.currentRoom.go(direction);
		if (newRoom == null)  {
			/* do nothing, because the spelling is incorrect */
		}  else  {
		if  (newRoom.equalsIgnoreCase("wall"))  {
			System.out.println("You cannot go this way, there is no door in this direction.");
		}  else  {
			this.currentRoom = m.get(newRoom);
			System.out.println("You have entered another room.");
		}
		}
	}
	
	
	public void consume(String item)  {
		
		/* check if the player has the item */
		if  (!this.bag.contains(item))  {
			System.out.println("Cannot consume this item, because it is not in your bag.");
		}  else  {
			
			/* if the bag does contain the item, consume and return it */
			Item ret = this.bag.consume(item);
			
			/* if ret is null, it means there is no effect on the player, otherwise, do the effect */
			if  (ret != null)  {	
				
				this.mental += 10;
			
				if  (ret.getCategory() == 0)  {
					
					if (this.water < 100)  {
					this.water += ret.getEffect();
					}
					
				}  else  if  (ret.getCategory() == 1)  {
					
					if (this.food < 100)  {
						this.food += ret.getEffect();
						}
					
				}  else if  (ret.getCategory() == 2)  {
					
					if (this.health < 100)  {
						this.health += ret.getEffect();
						}
				}
			}
			}
		
	}  /* end of consume function */
	
	
	public void pickup(String item)  {
		
		/* take the item out of the room inventory */
		Item pick = this.currentRoom.pickup(item);
		
		if  (!pick.equals(null))  {
			this.bag.pickup(pick);
		}
	}
	
	public void lookat(String item)  {
		
		if  (this.currentRoom.searched == false)  {
			System.out.println("You haven't searched the room yet.");
		}  else  {
			
			
			/* if the player has searched the room */
		Item look = this.currentRoom.itemList.returnItemDontDelete(item);
		
		if  (look.equals(null))  {
			System.out.println("This room does not contain this item.");
		}  else  {
			Item.lookat(look);
		}
		}
	}
	
	
	public void lookaround()  {
		this.currentRoom.lookaround();
	}
	
	public void discard(String item)  {
		this.bag.discard(item);
	}
	
	public void search()  {
		this.currentRoom.search();
	}
}

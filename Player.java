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
	}


	public void oneturn()  {
		this.water -= 7;
		this.food -= 4;
		this.health -= 1;
		this.mental -= 9;
	}


	public void rest()  {
		this.health += 6;
		this.mental += 31;
	}
	
	
	public void bag()  {
		System.out.println("Your bag contains:");
		this.bag.print();
	}
	
	
	public void location()  {
		System.out.println("You are in a:");
		System.out.println(this.currentRoom.name);
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
						this.water += ret.getEffect();

				}  else  if  (ret.getCategory() == 1)  {
						this.food += ret.getEffect();

				}  else if  (ret.getCategory() == 2)  {
						this.health += ret.getEffect();
						this.mental += 15;
				}
			}
		}

	}  /* end of consume function */


	public void pickup(String item)  {

		/* take the item out of the room inventory */
		Item pick = this.currentRoom.pickup(item);

		if  (pick != null)  {
			this.bag.pickup(pick);
		}
	}

	public void itemInfo(String item)  {

		if  (this.currentRoom.searched == false)  {
			System.out.println("You haven't searched the room yet.");
		}  else  {


			/* if the player has searched the room */
			Item look = this.currentRoom.itemList.returnItemDontDelete(item);

			/* if the room or the bag has this item, then look at it */
			if  (look == null && !this.bag.contains(item))  {
				System.out.println("You cannot look at this item, "
						+ "because its not in your bag or the room.");
			}  else  {
				
				/* at this point, either your bag or the room contains the item */
				
				/* if the item is in the room */
				if  (look != null)  {
				Item.itemInfo(look);
				}  else  {
					
					/* if the item is in the bag */
					Item.itemInfo(this.bag.returnItemDontDelete(item));
				}
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


	public boolean checkAlive()  {
		if  (this.health > 0 
				&& this.food > 0
				&& this.water > 0
				&& this.mental > 0)  {
			return true;
		}  else  {
			return false;
		}
	}
	
	
	public void checkWarning()  {
		
		System.out.println("");
		
		if  (this.health <= 25)  {
			System.out.println("WARNING: extremely tired. Seek medicines or take rests immediately");
		}
		if  (this.water <= 25)  {
			System.out.println("WARNING: extremely thirsty. Seek liquid immediately");
		}
		if  (this.food <= 25)  {
			System.out.println("WARNING: extremely hungry. Seek food immediately");
		}
		if  (this.mental <= 35)  {
			System.out.println("WARNING: mental state low. You may lose your mind soon");
		}
	}
	
	/* this function checks if your status goes over 100 every turn. */
	public void checkCap()  {
		if  (this.health > 100)  {
			this.health = 100;
		}
		if  (this.food > 100)  {
			this.food = 100;
		}
		if  (this.water > 100)  {
			this.water = 100;
		}
		if  (this.mental > 100)  {
			this.mental = 100;
		}
	}
	

	public void checkDeathReason()  {
		if  (this.health <= 0)  {
			System.out.println("You died of injure and tiredness.");
			System.out.println("Take rests or pills next time.");
		}
		if  (this.food <= 0)  {
			System.out.println("You died of hunger.");
			System.out.println("Eat more food.");
		}
		if  (this.water <= 0)  {
			System.out.println("You died of thirst.");
			System.out.println("Keep hydrated next time.");
		}
		if  (this.mental <= 0)  {
			System.out.println("You were too depressed and lost your mind.");
			System.out.println("Watch your mental state next time.");
		}
	}
	
	
	
	public void commands()  {
		System.out.println("Command Menu:");
		System.out.println("\"go <direction>\": goes to a certain direction.");
		System.out.println("\"status\": prints out player life status.");
		System.out.println("\"rest\": take a rest. Mental and Health status will increase.");
		System.out.println("\"consume <item name>\": consumes one item in your bag.");
		System.out.println("\"pick up <item name>\": picks up one item found in the room.");
		System.out.println("\"item info <item name>\": gives you info about an item in the bag or the room");
		System.out.println("\"look around\": describe the room.");
		System.out.println("\"discard <item name>\": discard one item from bag.");
		System.out.println("\"search room\": search the room for items.");
		System.out.println("\"bag\": see what's in your bag.");
		System.out.println("\"where am I\": tells you locations.");
		System.out.println("\"command menu\": prints out this menu.");
		System.out.println("\"suicide\": suicide.");
	}

}

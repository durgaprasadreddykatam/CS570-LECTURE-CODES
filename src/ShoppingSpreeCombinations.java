import java.util.ArrayList;

class GroceryItem {
	public String itemName; // Name of item
	public int priceDollars; // Price of item
}

public class ShoppingSpreeCombinations {
	public static final int MAX_SHOPPING_BAG_SIZE = 3; // Max number of items in shopping bag

	/*
	 * Output every combination of items that fit in a shopping bag. Each recursive
	 * call moves one item into the shopping bag.
	 */
	public static void shoppingBagCombinations(ArrayList<GroceryItem> currBag, // Bag contents
			ArrayList<GroceryItem> remainingItems, // Available items
			ArrayList<String> allBags) { // To avoid repetitions we keep a list of the possible bag contents

		// TODO: don't forget about base case(s)!

		if (currBag.size() == MAX_SHOPPING_BAG_SIZE) {
			double bagValue = 0;
			ArrayList<String> itemNames = new ArrayList<String>();

			for (int s = 0; s < currBag.size(); s++) {
				bagValue += currBag.get(s).priceDollars;
				itemNames.add(currBag.get(s).itemName);
			}

			itemNames.sort(null);
			String bagContent = itemNames.toString();

			if (allBags.contains(bagContent)) {
				// Do nothing
			} else {
				allBags.add(bagContent);
				System.out.println(bagContent + "  " + bagValue);
			}
		}

		for (int s = 0; s < remainingItems.size(); s++) {
			GroceryItem gC = remainingItems.remove(s);
			currBag.add(gC);

			shoppingBagCombinations(currBag, remainingItems, allBags);

			remainingItems.add(s, gC);
			currBag.remove(currBag.size() - 1);
		}

	}

	public static void main(String[] args) {
		ArrayList<GroceryItem> possibleItems = new ArrayList<GroceryItem>(); // Possible shopping items
		ArrayList<GroceryItem> shoppingBag = new ArrayList<GroceryItem>(); // Current shopping bag
		GroceryItem tmpGroceryItem; // Temp item

		// Populate grocery with different items
		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Milk";
		tmpGroceryItem.priceDollars = 2;
		possibleItems.add(tmpGroceryItem);

		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Belt";
		tmpGroceryItem.priceDollars = 24;
		possibleItems.add(tmpGroceryItem);

		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Toys";
		tmpGroceryItem.priceDollars = 19;
		possibleItems.add(tmpGroceryItem);

		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Cups";
		tmpGroceryItem.priceDollars = 12;
		possibleItems.add(tmpGroceryItem);

		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Eggs";
		tmpGroceryItem.priceDollars = 18;
		possibleItems.add(tmpGroceryItem);

		// Try different combinations of three items
		ArrayList<String> allBags = new ArrayList<String>();
		shoppingBagCombinations(shoppingBag, possibleItems, allBags);
	}
}
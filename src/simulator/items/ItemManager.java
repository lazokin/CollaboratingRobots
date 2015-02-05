// Author: Nikolce Ambukovski
// Student Number: s2008618

package simulator.items;

import java.util.HashMap;

import simulator.SimCoordinator;
import simulator.events.SimEventDispatcher;

public class ItemManager {

    private HashMap<String, Item> items = new HashMap<String, Item>();
    private ItemFactory itemFactory = new ItemFactory();

    public ItemManager() {
        super();
    }

    public void addItem(String itemID, ItemType itemType, int positionX,
        int positionY, int positionZ) {
        if (!itemExists(itemID)) {
            boolean validPosition = SimCoordinator.getInstance().pathExists(
                positionX, positionY, positionZ);
            if (validPosition) {
                Item item = itemFactory.createItem(itemID, itemType, positionX,
                    positionY, positionZ);
                items.put(itemID, item);
                SimCoordinator.getInstance().getPath(positionX, positionY,
                    positionZ).setItem(item);
                SimEventDispatcher.getInstance().notifyItemAdded(item);
            }
        }
    }

    public void removeItem(String itemID) {
        if (itemExists(itemID)) {
            Item item = items.remove(itemID);
            SimCoordinator.getInstance().getPath(item.getPositionX(),
                item.getPositionY(), item.getPositionZ()).setItem(null);
            SimEventDispatcher.getInstance().notifyItemRemoved(item);
        }
    }

    public Item getItem(String itemID) {
        if (items.containsKey(itemID)) {
            return items.get(itemID);
        } else {
            throw new IllegalArgumentException("Invalid ItemID");
        }
    }

    public boolean itemExists(String itemID) {
        return items.containsKey(itemID) ? true : false;
    }

    public void clear() {
        String copyOfItemIDs[] = new String[items.size()];
        items.keySet().toArray(copyOfItemIDs);
        for (String itemID : copyOfItemIDs) {
            this.removeItem(itemID);
        }
    }

    public void resetItems() {
        for (Item item : items.values()) {
            item.reset();
            SimCoordinator.getInstance().getPath(item.getPositionX(),
                item.getPositionY(), item.getPositionZ()).setItem(item);
        }
    }

    public Apple[] getAllApples() {
        int numberOfApples = 0;
        for (Item item : items.values()) {
            if (item.itemType == ItemType.APPLE) {
                numberOfApples++;
            }
        }
        Apple[] apples = new Apple[numberOfApples];
        int idx = 0;
        for (Item item : items.values()) {
            if (item.itemType == ItemType.APPLE) {
                apples[idx++] = (Apple) item;
            }
        }
        return apples;
    }

    public Bin[] getAllBins() {
        int numberOfBins = 0;
        for (Item item : items.values()) {
            if (item.itemType == ItemType.BIN) {
                numberOfBins++;
            }
        }
        Bin[] bins = new Bin[numberOfBins];
        int idx = 0;
        for (Item item : items.values()) {
            if (item.itemType == ItemType.BIN) {
                bins[idx++] = (Bin) item;
            }
        }
        return bins;
    }

}

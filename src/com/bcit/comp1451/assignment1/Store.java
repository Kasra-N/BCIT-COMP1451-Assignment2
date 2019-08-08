package com.bcit.comp1451.assignment1;

import java.util.Collection;
import java.util.HashMap;

/**
 * This class models a store
 * @author Kasra
 * @version 1.0
 */

public class Store {
    private Address streetAddress;
    private String name;
    private HashMap<String, Item> itemsForSale;

    /**
     * @param streetAddress street address
     * @param name store name
     */
    public Store(Address streetAddress, String name) {
        this.setStreetAddress(streetAddress);
        this.setName(name);
        this.itemsForSale = new HashMap<>();
    }

    /**
     * setter for street address
     * @param streetAddress the street address
     */
    private void setStreetAddress(Address streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * setter for the store name
     * @param name name of the store
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the store name
     * @return the name of the store
     */
    public String getName() {
        return this.name;
    }

    /**
     * method to add items entered
     * @param item items entered
     */
    public void addItem(Item item) {
        itemsForSale.put(item.getUniqueId(), item);
    }

    /**
     *
     * @param key the given key
     * @return the item with the entered key
     */
    public Item getItemByKey(String key){
        return itemsForSale.get(key);
    }

    /**
     * method to get the collection of items
     * @return the items
     */
    public Collection getCollectionOfItems() {
        return itemsForSale.values();
    }
}

package com.bcit.comp1451.assignment1;


import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class models a shoe store
 * @author Kasra
 * @version 1.0
 */
public class ShoeStore extends Store {
    private Collection<Shoe> shoes;
    private ShoeType department;

    /**
     * Constructor for ShoeStore
     * @param streetAddress the street address of the shoe store
     * @param name the name of the shoe store
     * @param department the department of the shoe store
     */
    public ShoeStore(Address streetAddress, String name, ShoeType department) {
        super(streetAddress, name);
        this.department = department;
        addShoes();
    }

    /**
     * OverLoaded Constructor for ShoeStore
     * @param streetAddress the street address of the shoe store
     * @param name the name of the shoe store
     * @param department the String department of the shoe store
     */
    public ShoeStore(Address streetAddress, String name, String department) {
        super(streetAddress, name);
        this.department = ShoeType.get(department);
        addShoes();
    }

    private void addShoes() {
        Name name = new Name("Skechers");
        ShoeType department = ShoeType.get("men");
        Color color = Color.darkGray;
        Material material = Material.get("leather");
        Shoe s = new Shoe(1.0D, 58.5D, 90.0D, "Diameter",
                material, 10, name, color, department);
        addItem(s);

        department = ShoeType.get("children");
        color = Color.pink;
        material = Material.get("plastic");
        s = new Shoe(0.85D, 32.5D, 50.0D,
                "Lite Kicks Rainbow Sprite", material, 10, name, color, department);
        addItem(s);

        name = new Name("Robert", "Cobbler");
        department = ShoeType.get("dress");
        color = Color.black;
        material = Material.get("leather");
        s = new Shoe(1.15D, 104.0D, 160.0D, "Wave",
                material, 12, name, color, department);
        addItem(s);

        department = ShoeType.get("children");
        color = Color.blue;
        material = Material.get("cloth");
        s = new Shoe(0.5D, 39.0D, 60.0D, "Toachi",
                material, 5, name, color, department);
        addItem(s);

        name = new Name("Geox");
        department = ShoeType.get("men");
        color = Color.blue;
        material = Material.get("cloth");
        s = new Shoe(1.0D, 110.5D, 170.0D, "Monet",
                material, 7, name, color, department);
        addItem(s);

        department = ShoeType.get("women");
        color = Color.gray;
        material = Material.get("plastic");
        s = new Shoe(0.9D, 97.5D, 150.0D, "Marieclaire",
                material, 10, name, color, department);
        addItem(s);

        name = new Name("Nine", "West");
        color = Color.black;
        material = Material.get("plastic");
        s = new Shoe(0.85D, 84.5D, 130.0D,
                "Camya Multi Glitter", material, 8, name, color, department);
        addItem(s);

        name = new Name("Stride", "Rite");
        department = ShoeType.get("children");
        color = Color.gray;
        material = Material.get("rubber");
        s = new Shoe(0.6D, 45.5D, 70.0D,
                "Balance Of The Force", material, 9, name, color, department);
        addItem(s);

        name = new Name("Sperry");
        department = ShoeType.get("children");
        color = Color.orange;
        material = Material.get("cloth");
        s = new Shoe(0.7D, 39.0D, 39.0D,
                "Top-Sider Unisex Bluefish H&L", material, 9, name, color, department);
        addItem(s);

        name = new Name("Nike");
        department = ShoeType.get("sports");
        color = Color.white;
        material = Material.get("rubber");
        s = new Shoe(1.2D, 117.0D, 180.0D,
                "Jordan Ace 23 II", material, 13, name, color, department);
        addItem(s);
    }

    /**
     * display all the shoes and designers
     */
    public void displayAllShoesAndDesigners() {
        for(Shoe s: shoes){
            System.out.println(String.format("%s offers %s size-%s %s's %s",
                    s.getDesigner().getFullName(), s.getMeterial().toString().toLowerCase(), s.getSize(),
                    s.getShoeType().toString().toLowerCase(), s.getUniqueId()));
        }
    }

    /**
     * display all shoes by designer name entered
     * @param designerName name entered
     */
    public void displayAllShoesByDesigner(String designerName) {
        if (designerName == null) {
            System.out.println("Wrong Designer name");
        } else {

            for(Shoe s: shoes){
                if (s.getDesigner().getFirstName().equalsIgnoreCase(designerName)) {
                    System.out.println(String.format("%s offers a size-%d %s's %s",
                            s.getDesigner().getFirstName(), s.getSize(), s.getShoeType().toString().toLowerCase(),
                            s.getUniqueId()));
                }
            }
        }
    }

    /**
     * display all the shoes made of material entered
     * @param material material entered
     */
    public void displayAllShoesMadeOf(Material material) {
        if (material == null) {
            System.out.println("Wrong material");
        } else {

            for(Shoe s: shoes){
                if (s.getMeterial().equals(material)) {
                    System.out.println(String.format("The size-%s %s is made of %s",
                            s.getSize(), s.getUniqueId(), s.getMeterial().toString().toLowerCase()));
                }
            }
        }
    }

    /**
     * display all shoes made of material entered
     * @param material material entered
     */
    public void displayAllShoesMadeOf(String material) {
        if (material != null) {
            this.displayAllShoesMadeOf(Material.get(material));
        } else {
            System.out.println("Wrong material");
        }
    }

    /**
     * display the number of shoes designed by designer entered
     * @param designer designer entered
     */
    public void displayNumberOfShoesDesignedBy(Name designer) {
        if (designer == null) {
            System.out.println("Wrong designer entered");
        } else {
            int count = 0;

            for(Shoe s: shoes){
                if (s.getDesigner().getFullName().equalsIgnoreCase(designer.getFullName())) {
                    ++count;
                }
            }

            System.out.println(String.format("This store has %d shoes designed by %s", count, designer.getFirstName()));
        }

    }

    /**
     * display number of shoes designed by the designer last name entered
     * @param designerLastName last name entered
     */
    public void displayNumberOfShoesDesignedBy(String designerLastName) {
        if (designerLastName == null) {
            System.out.println("Wrong last name");
        } else {
            int count = 0;

            for(Shoe s: shoes){
                if (s.getDesigner().getLastName() != null && s.getDesigner().getLastName().equalsIgnoreCase(designerLastName)) {
                    ++count;
                }
            }

            System.out.println(String.format("This store has %d shoes designed by %s", count, designerLastName));
        }
    }

    /**
     * display the smallest shoe size
     */
    public void displaySmallestShoeSize() {
        int shoeSize = 13;

        for(Shoe s: shoes){
            if (s.getSize() < shoeSize) {
                shoeSize = s.getSize();
            }
        }

        System.out.println("smallest shoe size: " + shoeSize);
    }

    /**
     * display the total weight of all shoes in kilograms
     */
    public void displayTotalWeightKgOfAllShoes() {
        double totalShoeWeight = 0.0;

        for(Shoe s: shoes){
            totalShoeWeight += s.getWeightKg();
        }
        System.out.println("total kg of shoes: " + totalShoeWeight);
    }

    /**
     * display all the shoes made
     * @param material material entered
     * @param designer designer entered
     */
    public void displayAllShoesOfThisMaterialMadeByThisDesigner(Material material, Name designer) {
        shoes = getCollectionOfItems();
        boolean match = false;

        if (material != null && designer != null) {

            for(Shoe s: shoes){
                if (s.getMeterial().equals(material) && s.getDesigner().getFullName().equalsIgnoreCase(designer.getFullName())) {
                    match = true;

                    System.out.println(String.format("The %s is a %s shoe offered by %s",
                            s.getUniqueId(), s.getMeterial().toString().toLowerCase(), s.getDesigner().getFullName()));
                }
            }
            if (!match) {
                System.out.println(String.format("This store has no %s shoes designed by %s",
                        material.getTheMaterial(), designer.getFullName()));
            }
        } else {
            System.out.println("Wrong material and designer");
        }
    }

    /**
     * display all shoes not in matching store
     */
    public void displayAllShoesNotInMatchingStore() {
        for(Shoe s: shoes){
            if (!s.getShoeType().equals(this.department)) {
                System.out.println(String.format("The %s is a %s's shoe offered by %s",
                        s.getUniqueId(), s.getShoeType().getTheShoeType(), s.getDesigner().getFullName()));
            }
        }
    }
}

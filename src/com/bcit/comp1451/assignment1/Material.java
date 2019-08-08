package com.bcit.comp1451.assignment1;

import java.util.HashMap;
import java.util.Map;

/**
 * This Enum models the material used
 * @author Kasra
 * @version 1.0
 */
public enum Material {
    PLASTIC("plastic"), LEATHER("leather"), RUBBER("rubber"), CLOTH("cloth");

    private String theMaterial;
    private static Map<String, Material> lookup = new HashMap<>();

    static{
        for (Material m : Material.values()){
            lookup.put(m.getTheMaterial(), m);
        }
    }

    /**
     *
     * @param material the material used
     */
    Material(String material) {
        this.theMaterial = material;
    }

    /**
     *
     * @return the material used
     */
    public String getTheMaterial() {
        return this.theMaterial;
    }

    /**
     *
     * @param theMaterial the material used
     * @return the material used
     */
    public static Material get(String theMaterial) {
        return lookup.get(theMaterial);
    }

}

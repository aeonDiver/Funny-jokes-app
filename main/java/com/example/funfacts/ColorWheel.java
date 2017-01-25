package com.example.funfacts;

import android.graphics.Color;

import java.util.Random;

public class ColorWheel {
    // Fields (member Variables) = properties about the object
    private String[] nColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    // Methods - actions the object can take
    public int getColor() {
        String color;
        //Randomly select a fact
        Random randomGenerator = new Random();
        int randomNUmber = randomGenerator.nextInt(nColors.length);
        color = nColors[randomNUmber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.lab08;

/**
 *
 * @author 2539556
 */
public enum PenSize {
    SMALL(2),
    MEDIUM(4),
    LARGE(6);
    
    private final int radius;
    
    PenSize(int radius){this.radius = radius;}
    
    public int getRadius(){return radius;}
}

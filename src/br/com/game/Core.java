package br.com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Core {
	
	

	public Core() {
        
	}
	
	
    public static void main(String[] args) {
    	JFrame jf = new JFrame();
    	jf.setContentPane(new Panel());
    	jf.setSize(600, 800);
        jf.setTitle("RiverRaid");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.pack();
    }
    

}

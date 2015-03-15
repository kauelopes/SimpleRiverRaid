package br.com.game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.text.Position;

public class Jogador {
	private int x;
	private int y;
	private Image image;
	
	Jogador(){
		x = 4;
		y = 11;		
		try {
			image = ImageIO.read(new File("assets/playerShip.png"));
		} catch (IOException e) {System.out.println("Nao achou a imagem da nave jogador");}

	}
	public int getx(){
		return x;
	}
	public void setx(int x){
		this.x = x;
	}
	
	public void andaParaADireita(){
		if(x<9) x++;
	}
	public void andaParaAEsquerda(){
		if(x>0) x--;
	}
	public int gety(){
		return y;
	}
	public Image getImage(){
		return image;
	}
	
	
	

}

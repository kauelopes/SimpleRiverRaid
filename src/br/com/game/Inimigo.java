package br.com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Inimigo {
	Point posicao;
	Image imagem;
	int tipo;
	
	public Inimigo(int tipo, int x, int y){
		this.tipo = tipo;
		if(tipo == 0){
			try {
				imagem = ImageIO.read(new File("assets/enemyShip.png"));
			} catch (IOException e) {e.printStackTrace();}
		
		}
		if(tipo == 1){
			imagem = null;
		}
		posicao = new Point(x, y);
	}
	
	
	public void draw(Graphics g){
		g.drawImage(imagem, posicao.x , posicao.y + 80,60, 60, null);
		
	}

}

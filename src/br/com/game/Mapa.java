package br.com.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.font.NumericShaper;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Mapa {
	Inimigo[][] mapa = new Inimigo[10][12];
	Image backGround;
	public Jogador jogador;
	Boolean fimDeJogo;
	
	Mapa(){
		try {
			backGround = ImageIO.read(new File("assets/background.jpg"));
		} catch (IOException e) {
			System.out.println("Nao achou imagem de fundo");
		}
		for(int i = 0; i<10; i++){
			for (int j = 0; j < 12; j++) {
				mapa[i][j] = new Inimigo(1, 60*i, 60*j);
			}
		}
		jogador = new Jogador();
		fimDeJogo = false;
		
	}
	
	public void setTile(int x, int y, Inimigo tile){
		mapa[x][y] = tile;
	}
	
	public Inimigo getTile(int x, int y){
		return mapa[x][y];
	}
	
	public void draw(Graphics g){
		g.drawImage(backGround, 0, 0, 1000, 800, null);
		g.drawImage(jogador.getImage(), jogador.getx()*60, jogador.gety()*60,60,60, null);
		for(int i = 0; i<10; i++){
			for (int j = 0; j < 12; j++) {
				g.drawImage(mapa[i][j].imagem, 60*i, 60*j,60,60, null);
			}
		}
		if(mapa[jogador.getx()][11].tipo == 0){
			fimDeJogo=true;
		}
		
	}
	public void downALine(int numberOfTheLine){
		for (int i = 0; i < 10; i++) {		
			mapa[i][numberOfTheLine + 1] =mapa[i][numberOfTheLine];		
		}
	}
	
	public void newLineOfEnemies(){
		for(int i = 0; i< 11; i++){
			downALine(10-i);
		}
		
		for (int i = 0; i < 10; i++) {
			
			mapa[i][0] = new Inimigo(0, 60*i, 80);
		}
		creatRandomLineOfEnemies();
	}
	
	public void creatRandomLineOfEnemies(){
		int enemy1 = (int) (Math.random()*10);
		int enemy2 = (int) (Math.random()*10);
		System.out.println(enemy1);
		
		for (int i = 0; i < 10; i++) {			
			mapa[i][0] = new Inimigo(1, 60*i, 80);		
		}
		mapa[enemy1][0] = new Inimigo(0, 60*enemy1, 80);
		mapa[enemy2][0] = new Inimigo(0, 60*enemy1, 80);
	}
	

}

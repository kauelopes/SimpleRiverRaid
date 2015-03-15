package br.com.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable,KeyListener {
	Graphics2D g;
	BufferedImage stage;
	Thread thr;
	
	Mapa mapa;
	Jogador jogador;
	
	Panel(){
		super();
		setPreferredSize(new Dimension(600, 800));
		setFocusable(true);
		requestFocus();
		stage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) stage.getGraphics();
		create();
	}
	
	private void create(){
		mapa = new Mapa();
		jogador = new Jogador();
	}
	
	public void addNotify() {
		
		super.addNotify();
		if (thr== null) {
			

			thr = new Thread(this);
			addKeyListener(this);
			System.out.println("Apertou");
			thr.start();
		}
	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("Apertou");
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			mapa.jogador.andaParaADireita();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			mapa.jogador.andaParaAEsquerda();
			
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		while (true) {
			if(!mapa.fimDeJogo){
				mapa.draw(g);
				mapa.newLineOfEnemies();
				draw();			

			}else{
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 600, 800);
				g.setColor(Color.BLUE);
				g.drawString("Você perdeu!", 100, 200);
				draw();			

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {e.printStackTrace();}
				System.exit(HEIGHT);
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {e.printStackTrace();}
		
		}

		
	}
	
	private void draw(){
		Graphics g2 = getGraphics();
		g2.drawImage(stage, 0, 0, 600, 800, null);
		g2.dispose();
	}
	

}

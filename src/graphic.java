import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class graphic{
	BufferedImage img = null;
	int x = 0, y= 0;
	Graphics g;
	
	public graphic(String name) {
		try {img = ImageIO.read(new File(name));}
		catch (IOException e) {
			System.out.println(name);
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {g.drawImage(img,x,y,null);}
	
	public int getX() {return x;}
	public int getY() {return y;}
}
package application.test;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquareTest extends JPanel implements MouseListener
{
	private int i;
	
	public SquareTest()
	{
		this.i = 1;
		this.addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Factory factory = Factory.getInstance();
		Render visualComponent = factory.getVisualComponent(this.i);
		visualComponent.renderGraphics(this, g);
	}
	
//	public Graphics2D getSquareGraphics()
//	{
//		Graphics g = this.getGraphics();
//		Graphics2D g2 = (Graphics2D) g;
//		
//		return g2;
//	}
	
	public static void main(String[] args)
	{
		Frame frame = new Frame();
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// switch state based on click
		if(this.i == 1)
			this.i = 2;
		else
			this.i = 1;
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


class Frame extends JFrame
{	
	public Frame()
	{
		this.setLayout(new GridLayout(5, 5, 1, 1));
		for(int i = 0; i < 25; i++)
		{
			SquareTest square = new SquareTest();
			this.add(square);
		}
		
	}
	
//	public Square getSquare()
//	{
//		return this.square;
//	}
}


// start of the decorator pattern
abstract class Render 
{
	public abstract void renderGraphics(SquareTest square, Graphics g);
}


class EmptySquare extends Render
{

	@Override
	public void renderGraphics(SquareTest square, Graphics g) 
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, square.getWidth(), square.getHeight());
	}
	
}


abstract class SquareDecorator extends Render
{
	private Render visualComponent;
	
	public SquareDecorator(Render visualComponent)
	{
		this.visualComponent = visualComponent;
	}
	
	public void callVisualComponent(SquareTest square, Graphics g)
	{
		if(this.visualComponent != null)
			visualComponent.renderGraphics(square, g);
	}
}


class Robot extends SquareDecorator
{

	public Robot(Render visualComponent) 
	{
		super(visualComponent);		
	}
	
	@Override
	public void renderGraphics(SquareTest square, Graphics g)
	{
		super.callVisualComponent(square, g);
//		Graphics2D g2 = square.getSquareGraphics();
		
		g.setColor(Color.RED);
		g.fillOval(10, 10, 50, 50);
	}	
}

class TinyRobot extends SquareDecorator
{
	public TinyRobot(Render visualComponent)
	{
		super(visualComponent);
	}
	
	@Override
	public void renderGraphics(SquareTest square, Graphics g)
	{
		super.callVisualComponent(square, g);
//		Graphics2D g2 = square.getSquareGraphics();
		
		g.setColor(Color.YELLOW);
		g.fillOval(10, 10, 25, 25);
	}
}


class Factory
{
	private static Factory uniqueInstance;
	
	private Factory()
	{
		
	}
	
	public static Factory getInstance()
	{
		if(uniqueInstance == null)
			uniqueInstance = new Factory();
		
		return uniqueInstance;
	}
	
	public Render getVisualComponent(int i)
	{
		switch(i)
		{
		case 1:
			return new TinyRobot(new Robot(new EmptySquare()));
		case 2:
			return new TinyRobot(new EmptySquare());
		default:
			return null;
		}
		
	}
}



//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class Square extends JPanel
//{
//	public Square()
//	{
//		
//	}
//	
//	@Override
//	public void paintComponent(Graphics g)
//	{
//		
//	}
//	
//	public Graphics2D getSquareGraphics()
//	{
//		Graphics g = this.getGraphics();
//		Graphics2D g2 = (Graphics2D) g;
//		
//		return g2;
//	}
//	
//	public static void main(String[] args)
//	{
//		Frame frame = new Frame();
//		frame.setSize(400, 400);
//		frame.setVisible(true);
//		
//		Factory factory = Factory.getInstance();
//		VisualComponent visualComponent = factory.getVisualComponent();
//		visualComponent.drawComponents(frame.getSquare());
//	}
//}
//
//
//class Frame extends JFrame
//{
//	private Square square;
//	
//	public Frame()
//	{
//		this.square = new Square();
//		this.add(square);
//	}
//	
//	public Square getSquare()
//	{
//		return this.square;
//	}
//}
//
//
//// start of the decorator pattern
//abstract class VisualComponent 
//{
//	public abstract void drawComponents(Square square);
//}
//
//
//class EmptySquare extends VisualComponent
//{
//
//	@Override
//	public void drawComponents(Square square) 
//	{
//		// TODO Auto-generated method stub
//		Graphics2D g2 = square.getSquareGraphics();
//		g2.setColor(Color.BLACK);
//		g2.fillRect(0, 0, square.getWidth(), square.getHeight());
//	}
//	
//}
//
//
//abstract class SquareDecorator extends VisualComponent
//{
//	private VisualComponent visualComponent;
//	
//	public SquareDecorator(VisualComponent visualComponent)
//	{
//		this.visualComponent = visualComponent;
//	}
//	
//	public void callVisualComponent(Square square)
//	{
//		if(this.visualComponent != null)
//			visualComponent.drawComponents(square);
//	}
//}
//
//
//class Robot extends SquareDecorator
//{
//
//	public Robot(VisualComponent visualComponent) 
//	{
//		super(visualComponent);		
//	}
//	
//	@Override
//	public void drawComponents(Square square)
//	{
//		super.callVisualComponent(square);
//		Graphics2D g2 = square.getSquareGraphics();
//		
//		g2.setColor(Color.RED);
//		g2.fillOval(10, 10, 50, 50);
//	}	
//}
//
//class TinyRobot extends SquareDecorator
//{
//	public TinyRobot(VisualComponent visualComponent)
//	{
//		super(visualComponent);
//	}
//	
//	@Override
//	public void drawComponents(Square square)
//	{
//		super.callVisualComponent(square);
//		Graphics2D g2 = square.getSquareGraphics();
//		
//		g2.setColor(Color.YELLOW);
//		g2.fillOval(10, 10, 25, 25);
//	}
//}
//
//
//class Factory
//{
//	private static Factory uniqueInstance;
//	
//	private Factory()
//	{
//		
//	}
//	
//	public static Factory getInstance()
//	{
//		if(uniqueInstance == null)
//			uniqueInstance = new Factory();
//		
//		return uniqueInstance;
//	}
//	
//	public VisualComponent getVisualComponent()
//	{
//		return new TinyRobot(new Robot(new EmptySquare()));
//	}
//}
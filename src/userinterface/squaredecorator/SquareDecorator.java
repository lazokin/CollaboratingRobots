// Author: Adrian Wong
// Student Number: s3452563

package userinterface.squaredecorator;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import userinterface.square.Square;

public abstract class SquareDecorator extends Render
{
    private Render render;
    
    public SquareDecorator(Render render)
    {
        this.render = render;
    }
    
    protected BufferedImage resizeImage(Square square, BufferedImage originalImage)
    {
        int x = square.getHeight() < square.getWidth() ? (square.getHeight() - 8) : (square.getWidth() - 8);
        
        BufferedImage resizedImage = new BufferedImage(x, x, BufferedImage.TYPE_INT_ARGB);
        Graphics g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, x, x, null);
        g.dispose();
        
        return resizedImage;
    }
    
    public void callRender(Square square, Graphics graphics)
    {
        if(this.render != null)
            this.render.renderGraphics(square, graphics);
    }
}

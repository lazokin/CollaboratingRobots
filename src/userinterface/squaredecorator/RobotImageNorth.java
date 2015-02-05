// Author: Adrian Wong
// Student Number: s3452563

package userinterface.squaredecorator;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import userinterface.square.Square;

public class RobotImageNorth extends SquareDecorator
{
    private BufferedImage image;
    
    public RobotImageNorth(Render render)
    {
        super(render);
        
        try
        {
            this.image = ImageIO.read(new File("images//android_big_n.png"));
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void renderGraphics(Square square, Graphics graphics)
    {
        super.callRender(square, graphics);
        
        BufferedImage resizedImage = super.resizeImage(square, this.image);
        
        int x = (square.getWidth() - resizedImage.getWidth()) / 2;
        int y = (square.getHeight() - resizedImage.getHeight()) / 2;
        
        graphics.drawImage(resizedImage, x, y, null);
    }
}

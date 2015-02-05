// Author: Adrian Wong
// Student Number: s3452563

package userinterface.squaredecorator;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import userinterface.square.Square;

public class ItemNumber extends SquareDecorator
{
    public ItemNumber(Render render)
    {
        super(render);
    }

    @Override
    public void renderGraphics(Square square, Graphics graphics)
    {
        super.callRender(square, graphics);
        
        String itemID = square.getItemIDRef();
        graphics.setColor(Color.MAGENTA);
        graphics.setFont(new Font("STENCIL", Font.BOLD, 20));
        FontMetrics fontMetrics = graphics.getFontMetrics();
        
        int x = (square.getWidth() - fontMetrics.stringWidth(itemID)) / 2;
        int y = (square.getHeight() + fontMetrics.getAscent()) / 2;
        
        graphics.drawString(itemID, x, y);
    }
}
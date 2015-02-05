// Author: Adrian Wong
// Student Number: s3452563

package userinterface.squaredecorator;

import java.awt.Color;
import java.awt.Graphics;

import userinterface.square.Square;

public class PathSquare extends SquareDecorator
{
    public PathSquare(Render render)
    {
        super(render);
    }

    @Override
    public void renderGraphics(Square square, Graphics graphics)
    {
        super.callRender(square, graphics);
        
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, square.getWidth(), square.getHeight());
    }
}

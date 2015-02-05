// Author: Adrian Wong
// Student Number: s3452563

package userinterface.squaredecorator;

import java.awt.Color;
import java.awt.Graphics;

import userinterface.square.Square;

public class EmptySquare extends Render
{
    @Override
    public void renderGraphics(Square square, Graphics graphics)
    {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, square.getWidth(), square.getHeight());
    }
}

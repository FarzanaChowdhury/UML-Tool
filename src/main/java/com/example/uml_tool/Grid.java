package com.example.uml_tool.canvas;


/*
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public final class Grid
{
    private static final Color GRID_COLOR = Color.rgb(220, 220, 220);
    private static final double GRID_SIZE = 10;

    private Grid() {}


    public static void draw(GraphicsContext pGraphics, Rectangle pBounds)
    {
        Paint oldStroke = pGraphics.getStroke();
        pGraphics.setStroke(GRID_COLOR);
        int x1 = pBounds.getX();
        int y1 = pBounds.getY();
        int x2 = pBounds.getMaxX();
        int y2 = pBounds.getMaxY();
        for(int x = x1; x < x2; x += GRID_SIZE)
        {
            ToolGraphics.strokeSharpLine(pGraphics, x, y1, x, y2);
        }
        for(int y = y1; y < y2; y += GRID_SIZE)
        {
            ToolGraphics.strokeSharpLine(pGraphics, x1, y, x2, y);
        }
        pGraphics.setStroke(oldStroke);
    }



    public static Rectangle snapped(Rectangle pRectangle)
    {
        assert pRectangle != null;
        int x = (int)(Math.round(pRectangle.getX() / GRID_SIZE) * GRID_SIZE);
        int width = (int)(Math.ceil(pRectangle.getWidth() / GRID_SIZE) * GRID_SIZE);
        int y = (int)(Math.round(pRectangle.getY() / GRID_SIZE) * GRID_SIZE);
        int height = (int)(Math.ceil(pRectangle.getHeight() / GRID_SIZE) * GRID_SIZE);
        return new Rectangle(x, y, width, height);
    }


    public static Point snapped(Point pPoint)
    {
        assert pPoint != null;
        int x = (int)(Math.round(pPoint.getX() / GRID_SIZE) * GRID_SIZE);
        int y = (int)(Math.round(pPoint.getY() / GRID_SIZE) * GRID_SIZE);
        return new Point(x, y);
    }


    public static int toMultiple(int pCoordinate)
    {
        assert pCoordinate >= 0;
        return (int)(Math.ceil(pCoordinate / GRID_SIZE) * GRID_SIZE);
    }


    public static Point toSnap(Dimension pDimension)
    {
        assert pDimension != null;
        final int size = (int) GRID_SIZE;
        int xRemainder = pDimension.width() % size;
        if( xRemainder < size/2 )
        {
            xRemainder = -xRemainder;
        }
        else
        {
            xRemainder = size - xRemainder;
        }

        int yRemainder = pDimension.height() % size;
        if( yRemainder < size/2 )
        {
            yRemainder = -yRemainder;
        }
        else
        {
            yRemainder = size - yRemainder;
        }
        return new Point(xRemainder, yRemainder);
    }
}
*/


package client.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GUIComponent {

    public static final int TOP = -1, LEFT = -1, CENTER = 0, BOTTOM = 1, RIGHT = 1;

    private int x, y, width, height;
    protected int renderX, renderY, renderedWidth, renderedHeight;
    private Color background, borderColor;
    private BufferedImage backgroundImage;
    private int imgX, imgY,  imgWidth, imgHeight;
    private boolean border;
    private double scale = 1;
    private int verticalAlign = TOP, horizontalAlign = LEFT;

    public GUIComponent(int width, int height) {
        this(0, 0, width, height);
    }

    public GUIComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackground(BufferedImage background){
        this.backgroundImage = background;
    }

    public int getImgX() {
        return imgX;
    }

    public void setImgX(int imgX) {
        this.imgX = imgX;
    }

    public int getImgY() {
        return imgY;
    }

    public void setImgY(int imgY) {
        this.imgY = imgY;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }

    public int getVerticalAlign() {
        return verticalAlign;
    }

    public void setVerticalAlign(int verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public int getHorizontalAlign() {
        return horizontalAlign;
    }

    public void setHorizontalAlign(int horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public int getRenderX() {
        return renderX;
    }

    public int getRenderY() {
        return renderY;
    }

    public int getRenderedWidth() {
        return renderedWidth;
    }

    public int getRenderedHeight() {
        return renderedHeight;
    }

    public void revalidate(int screenWidth, int screenHeight) {
        renderX = x;
        renderY = y;
        renderedWidth = width;
        renderedHeight = height;

        if(verticalAlign == CENTER) {
            renderY = (screenHeight - height) / 2 + y;
        } else if (verticalAlign == BOTTOM) {
            renderY = screenHeight - height + y;
        }

        if (horizontalAlign == CENTER) {
            renderX = (screenWidth - width) / 2 + x;
        } else if (horizontalAlign == RIGHT) {
            renderX = screenWidth - width + x;
        }

        int motionX = (int) ((scale - 1) * renderedWidth);
        int motionY = (int) ((scale - 1) * renderedHeight);
        renderedWidth += motionX;
        renderedHeight += motionY;
        renderX -= motionX / 2;
        renderY -= motionY / 2;
    }

    public void render(Graphics2D g) {
        g.setClip(new Rectangle(renderX, renderY, renderedWidth, renderedHeight));
        if (!border) {
            g.setColor(background);
            g.fillRect(renderX, renderY, renderedWidth, renderedHeight);
            if(backgroundImage != null)
                g.drawImage(backgroundImage, renderX + imgX,renderY + imgY, imgWidth, imgHeight, null);
        } else {
            g.setColor(background);
            g.fillRect(renderX+1, renderY+1, renderedWidth-1, renderedHeight-1);
            g.setColor(borderColor);
            g.drawRect(renderX, renderY, renderedWidth-1, renderedHeight-1);
            if(backgroundImage != null)
                g.drawImage(backgroundImage, renderX + imgX,renderY + imgY, imgWidth, imgHeight, null);
        }
        g.setClip(null);
    }
}

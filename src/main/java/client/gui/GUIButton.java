package client.gui;

import client.BombermanPanel;

import java.awt.*;

public class GUIButton extends GUIComponent {

    private String label;
    private Font font = BombermanPanel.DEFAULT_FONT, renderedFont = BombermanPanel.DEFAULT_FONT;
    private Color textColor = Color.WHITE;
    private int textX, textY;
    private int verticalTextAling = CENTER, horizontalTextAling = CENTER;
    private Runnable onClickListener;

    public GUIButton(int width, int height, String label) {
        super(width, height);
        this.label = label;
    }

    public GUIButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getVerticalTextAling() {
        return verticalTextAling;
    }

    public void setVerticalTextAling(int verticalTextAling) {
        this.verticalTextAling = verticalTextAling;
    }

    public int getHorizontalTextAling() {
        return horizontalTextAling;
    }

    public void setHorizontalTextAling(int horizontalTextAling) {
        this.horizontalTextAling = horizontalTextAling;
    }

    public Runnable getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(Runnable onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void revalidate(int screenWidth, int screenHeight) {
        super.revalidate(screenWidth, screenHeight);
        if(label != null && label.length() > 0) {
            renderedFont = font.deriveFont((float) (getScale() * font.getSize()));
            FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
            int textWidth = Toolkit.getDefaultToolkit().getFontMetrics(font).stringWidth(label);
            textX= renderX + getRenderedWidth() / 2 - textWidth /2;
            textY = renderY + getRenderedHeight() / 2 + metrics.getAscent() / 2 - metrics.getDescent();
        }
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        if(label != null && label.length() > 0) {
            g.setColor(textColor);
            g.setFont(renderedFont);
            g.drawString(label, textX, textY);
        }
    }
}

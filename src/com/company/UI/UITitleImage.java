

package com.company.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UITitleImage extends UIObject {

    private BufferedImage[] images;
    private ClickListiner clicker;

    public UITitleImage(float x, float y, int width, int height, BufferedImage[] images, ClickListiner clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {}

    @Override
    public void render(Graphics g) {

            g.drawImage(images[0], (int) x, (int) y, width, height, null);

    }

    @Override
    public void onClick() {
        clicker.onClick();
    }

}
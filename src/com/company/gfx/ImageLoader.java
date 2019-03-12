package com.company.gfx;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

class imageLoader
{

    public static BufferedImage loadImage(String path)
    {
        try
        {
            return ImageIO.read(imageLoader.class.getResource(path));
        } catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
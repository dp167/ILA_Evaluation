package com.company.gfx;


import java.awt.image.BufferedImage;
import com.company.gfx.imageLoader;


public class Assets
{

    private static final int width = 32, height = 32;
    public static BufferedImage dirt,grass,stone,tree;
    public static BufferedImage[] player_down, player_up,player_left,player_right;
    public static BufferedImage[] btn_start;
    public static BufferedImage[] Title;
    public static BufferedImage[] Auditory;
    public static BufferedImage[] Visual;
    public static BufferedImage[] Physical;
    public static BufferedImage[] Reading;


    public static void init()
    {
        SpriteSheet Auditory_image = new SpriteSheet(imageLoader.loadImage("/textures/Auditory_learn.png"));
        SpriteSheet Auditory_image2 = new SpriteSheet(imageLoader.loadImage("/textures/Auditory_learn2.png"));

        SpriteSheet title_image = new SpriteSheet(imageLoader.loadImage("/textures/Title-logo2.png"));
        SpriteSheet Visual_image = new SpriteSheet(imageLoader.loadImage("/textures/Visual_learn.png"));
        SpriteSheet Visual_image2 = new SpriteSheet(imageLoader.loadImage("/textures/Visual_learn2.png"));

        SpriteSheet Physical_image = new SpriteSheet(imageLoader.loadImage("/textures/Physical_learning.png"));
        SpriteSheet Physical_image2 = new SpriteSheet(imageLoader.loadImage("/textures/Physical_learning2.png"));

        SpriteSheet Reading_image  = new SpriteSheet(imageLoader.loadImage("/textures/Reading_learning.png"));
        SpriteSheet Reading_image2 = new SpriteSheet(imageLoader.loadImage("/textures/Reading_learning2.png"));


        Title = new BufferedImage[1];
        Title[0] = title_image.crop(0,0,1418,647);

        Auditory = new BufferedImage[2];
        Auditory[0] = Auditory_image.crop(0,0,463,66);
        Auditory[1] = Auditory_image2.crop(0,0,459,67);

       Visual = new BufferedImage[2];
       Visual[0] = Visual_image.crop(0,0,410,63);
       Visual[1] = Visual_image2.crop(0,0,409,62);

       Physical = new BufferedImage[2];
       Physical[0] = Physical_image.crop(0,0,662,89);
       Physical[1] = Physical_image2.crop(0,0,557,80);

        Reading = new BufferedImage[2];
        Reading[0] = Reading_image.crop(0,0,569,69);
        Reading[1] = Reading_image2.crop(0,0,561,73);




    }
}
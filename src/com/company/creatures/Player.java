package com.company.creatures;

import com.company.gfx.Animation;
import com.company.creatures.Creature;
import com.company.frames.Game;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import com.company.gfx.Assets;
import com.company.frames.Handler;

public class Player extends Creature
{
    private Animation animDown, animUp, animLeft, animRight;

    public Player(Handler handler, float x, float y)
    {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 22;
        bounds.y = 44;
        bounds.width = 19;
        bounds.height = 19;

        //Animatons
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
    }

    @Override
    public void tick()
    {
        //Animations
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();

        getInput();
        yMove = speed * 2;
        move();

        //handler.getGameCamera().centerOnEntity(this);


    }

    private void getInput()
    {
        yMove = 0;
        xMove = 0;

        if (handler.getKeyManager().up)
        {
            yMove = -speed * 3;
            xMove = speed;
        }

        if (handler.getKeyManager().down)
            yMove = speed;

        if (handler.getKeyManager().left)
            xMove = -speed;

        if (handler.getKeyManager().right)
            xMove = speed;

    }

    @Override
    public void render(Graphics g)
    {
       // g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        //  g.setColor(Color.red);
        //  g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
        //     (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
        //  bounds.width, bounds.height);
    }


    private BufferedImage getCurrentAnimationFrame()
    {
        if (xMove < 0)
        {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0)
        {
            return animRight.getCurrentFrame();
        } else if (yMove < 0)
        {
            return animUp.getCurrentFrame();
        } else
        {
            return animDown.getCurrentFrame();
        }
    }
}
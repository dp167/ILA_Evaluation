package com.company.frames;


import com.company.input.KeyManager;
import com.company.input.MouseManager;

public class Handler
{
    private Game game;
    private World world;


    public Handler(Game game)
    {
        this.game= game;

    }

   /*public GameCamera getGameCamera()
    {
        return game.getGetGameCamera();
    }
    */

    public KeyManager getKeyManager()
    {
        return game.GetKeyManager();
    }


    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }


    public int getWidth()
    {
        return game.getWidth();
    }
    public int getHeight()
    {
        return game.getHeight();
    }
    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    public World getWorld()
    {
        return world;
    }

    public void setWorld(World world)
    {
        this.world = world;
    }
}
package com.company.States;


import java.awt.Graphics;
import com.company.gfx.Assets;
import com.company.frames.Game;
import com.company.frames.Handler;

public abstract class State
{
    private static State currentState = null;



    public static void setState(State state)
    {
        currentState = state;
    }
    public static State getState()
    {
        return currentState;
    }

    protected Handler handler;

    public State(Handler handler)
    {
        this.handler= handler;
    }







    //CLASS
    public abstract void tick();


    public abstract void render(Graphics g);

}
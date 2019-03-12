package com.company.frames;


import com.company.frames.Game;

public class Launcher
{
    public static void main(String[] args)
    {
        Game game = new Game("Title!",800, 600);
        game.start();
    }

}
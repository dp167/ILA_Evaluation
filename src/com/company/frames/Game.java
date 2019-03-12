package com.company.frames;

import com.company.Display.Display;
//import com.company.gfx.GameCamera;

import com.company.gfx.Assets;

import com.company.States.State;
//import com.company.States.GameState;
import com.company.States.MenuState;


import com.company.input.KeyManager;
import com.company.input.MouseManager;


import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable
{
    public String title;
    private Display display;

    private int width, height;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //STATES

    public State gameState;
    public State menuState;
    public State verbalState;
    public State readingState;
    public State visualState;
    public State physicalState;

    //INPUTS
    private KeyManager keyManager;
    private MouseManager mouseManager;


    //camera
   // private GameCamera gameCamera;

    //handler

    private Handler handler;

    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();


    }
    // private BufferedImage testImage;
    //private SpriteSheet sheet;

    // private Graphics g;

    private void init()
    {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();

        handler = new Handler(this);
       // gameCamera = new GameCamera(handler,0,0);


       // gameState = new GameState(handler);

        menuState = new MenuState(handler);
        State.setState(menuState);
        // testImage = imageLoader.loadImage("/textures/sheet.png");
        // sheet = new SpriteSheet(testImage);


        // testImage = imageLoader.loadImage("/textures/test1.png");// this loads image via path .. image resource file must be set to resuource in the module settings page
    }
    //int x =0;

    private void tick()
    {
        //   x +=1;

        keyManager.tick();

        if(State.getState() != null)
            State.getState().tick();

    }
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();//buffer strategy is a way for computer to draw to screen
        //buffer is a hidden computer screen in your computer ... holds memory of what will be shown
        //we will draw everything to the buffer after we end drawing that buffer will move to the next buffer
        //we do this so we can prevent flickering on the screen it allows a movie reel of drawn images to screen
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0,width,height);

        if(State.getState()!= null)//important because if gamestate ever equals null it will throw an error
            State.getState().render(g);

//       g.drawImage(Assets.grass,x,10,null);

        // g.setColor(Color.red);

        //  g.drawRect(10,50,50,70);
        // g.fillRect(10,50,50,70);

        bs.show();
        g.dispose();
    }



    public void run()
    {

        init();

        int fps = 60;
        double timePerTick = 1000000000/fps;//there are one billion nano seconds in a second //1 sec devided by 60 fps
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;// tells computer when and when not to call tick and render
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1)
            {

                tick();
                render();
                ++ticks;
                --delta;
            }
            if(timer >= 1000000000)
            {
                System.out.println("frame rate: " + ticks);
                ticks =0;
                timer =0;
            }
        }

        stop();

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager(){
        return mouseManager;
    }


/*
    public GameCamera getGameCamera()
    {
        return gameCamera;
    }
*/


    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public synchronized void start()
    {
        if(running)
            return;

        running = true;

        thread = new Thread(this);
        thread.start();

    }
    public synchronized void stop ()
    {
        if(!running)
            return;

        running = false;

        try
        {
            thread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
/*
    public GameCamera getGetGameCamera()
    {
        return gameCamera;
    }
    */

    public KeyManager GetKeyManager()
    {
        return keyManager;
    }
}
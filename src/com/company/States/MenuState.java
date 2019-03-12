package com.company.States;


import com.company.frames.Handler;
import com.company.gfx.Assets;
import com.company.UI.ClickListiner;
import com.company.UI.UIImageButton;
import com.company.UI.UIManager;
import com.company.UI.UITitleImage;

import java.awt.Graphics;

public class MenuState extends State
{
    private UIManager uiManager;

    public  MenuState(Handler handler)
    {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButton(401, 200, 399, 150, Assets.Visual, new ClickListiner()
        {
            @Override
            public void onClick()
            {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().visualState);


            }
        }));


         uiManager.addObject(new UIImageButton(0, 200, 400, 150, Assets.Auditory, new ClickListiner()
        {
                 @Override
                 public void onClick()
                 {
                  handler.getMouseManager().setUIManager(null);
                  State.setState(handler.getGame().verbalState);


                 }
            }));

//need to create a class for the title button so that hovering oesnt crash the game
        uiManager.addObject(new UITitleImage(0, 0, 800, 200, Assets.Title, new ClickListiner()
        {
            @Override
            public void onClick()
            {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);


            }
        }));


        uiManager.addObject(new UIImageButton(0, 350, 400, 150, Assets.Physical, new ClickListiner()
        {
            @Override
            public void onClick()
            {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().physicalState);


            }
        }));



        uiManager.addObject(new UIImageButton(401, 350, 399, 150, Assets.Reading, new ClickListiner()
        {
            @Override
            public void onClick()
            {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().readingState);


            }
        }));

    }


    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }

}
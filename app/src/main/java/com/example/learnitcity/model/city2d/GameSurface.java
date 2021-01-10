package com.example.learnitcity.model.city2d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.LinearLayout;

import com.example.learnitcity.R;
import com.example.learnitcity.database.LearnItCityDB;
import com.example.learnitcity.datasource.PersonnageDao;
import com.example.learnitcity.model.LearnIt;
import com.example.learnitcity.model.Personnage;

import java.util.ArrayList;
import java.util.List;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
    private GameThread gameThread;
    private List<Personnage> personnages = new ArrayList<>();
    private List<CityCharacter> characters = new ArrayList<>();
    private CityCharacter chibi1;
    private CityCharacter chibi2;
    private CityCharacter chibi3;
    private CityCharacter chibi4;
    private Activity current_Activity;
    private  LearnIt learnIt;
    public GameSurface(Context context, LearnIt learnIt)  {
        super(context);
        current_Activity = (Activity)context;
        this.learnIt = learnIt;
        this.getHolder().setFixedSize(1070,2100);

        //this.scrollBy(1070,2000);
        this.setZOrderOnTop(true);    // necessary
        SurfaceHolder sfhTrackHolder = this.getHolder();
        sfhTrackHolder.setFormat(PixelFormat.TRANSPARENT);

        // Make Game Surface focusable so it can handle events. .
        // this.setFocusable(true);

        this.getHolder().addCallback(this);
    }

    public void update()  {
        for (CityCharacter character: characters) {
            character.update();
        }
        //this.chibi1.update();
        //this.chibi2.update();
        //this.chibi3.update();
        //this.chibi4.update();
    }


    @Override
    public void draw(Canvas canvas)  {
        super.draw(canvas);
        //canvas.drawText("Econmiste",0,0,null);
        for (CityCharacter character: characters) {
            character.draw(canvas);
        }
        //this.chibi1.draw(canvas);
        //this.chibi2.draw(canvas);
        //this.chibi3.draw(canvas);
        //this.chibi4.draw(canvas);
    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Bitmap bit = BitmapFactory.decodeResource(getResources(),R.drawable.background_city);
        Drawable image = getResources().getDrawable(R.drawable.background_city);
        this.setBackground(image);

        //Charger perso en BD
        /*LearnItCityDB db = LearnItCityDB.getDatabase(getContext());
        PersonnageDao persoDao = db.personnageDao();
        persoDao.deleteAll();¨*/


        personnages = learnIt.getmPersonnages();
        //TODO

        //TestChargement
        for (Personnage perso:personnages) {
            switch(perso.getName()) {
                case ("Economistes"):
                    for(int i = 0; i < (int)perso.getNombre(); i++){
                        Bitmap chibiBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.charact1);
                        //rezize de l'image
                        chibiBitmap1 = Bitmap.createScaledBitmap(chibiBitmap1,250,550,true);
                        characters.add(new CityCharacter(this,chibiBitmap1,100*i,345));
                    }
                    break;
                case("Informaticiens"):
                    for(int i = 0; i < (int)perso.getNombre(); i++){
                        Bitmap chibiBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.charact2);
                        //rezize de l'image
                        chibiBitmap1 = Bitmap.createScaledBitmap(chibiBitmap1,250,550,true);
                        characters.add(new CityCharacter(this,chibiBitmap1,100*i,870));
                    }
                    break;
                case("Fermiers"):
                    for(int i = 0; i < (int)perso.getNombre(); i++){
                        Bitmap chibiBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.charact3);
                        //rezize de l'image
                        chibiBitmap1 = Bitmap.createScaledBitmap(chibiBitmap1,250,550,true);
                        characters.add(new CityCharacter(this,chibiBitmap1,100*i,1380));
                    }
                    break;
                case("Medecins"):
                    for(int i = 0; i < (int)perso.getNombre(); i++){
                        Bitmap chibiBitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.charact4);
                        //rezize de l'image
                        chibiBitmap1 = Bitmap.createScaledBitmap(chibiBitmap1,250,550,true);
                        characters.add(new CityCharacter(this,chibiBitmap1,100*i,1930));
                    }
                    break;

            }

        }

       /*

        */
        //gameThread.destroy();

        gameThread = new GameThread(this,holder,current_Activity);
        gameThread.setRunning(true);
        Thread current = new Thread(gameThread);
        current.setName("Personnages");
        current.start();
    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    // Implements method of SurfaceHolder.Callback
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry= true;
        while(retry) {
            try {
                //this.gameThread.setRunning(false);
                // Parent thread must wait until the end of GameThread.
                this.gameThread.join();
            }catch(InterruptedException e)  {
                e.printStackTrace();
            }
            retry= false;
        }
    }
}

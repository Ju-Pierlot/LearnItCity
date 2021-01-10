package com.example.learnitcity.model.city2d;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.renderscript.RenderScript;
import android.view.SurfaceHolder;

public class GameThread extends Thread /*AsyncTask<String, Void, String>*/ {
    private boolean running;
    private GameSurface gameSurface;
    private SurfaceHolder surfaceHolder;
    private Activity activity;

    public GameThread(GameSurface gameSurface, SurfaceHolder surfaceHolder, Activity main_activity)  {
        this.gameSurface= gameSurface;
        this.activity = main_activity;
        this.surfaceHolder= surfaceHolder;
    }


   @Override
   public void run() {
       long startTime = System.nanoTime();

       while (running) {
           Thread current = Thread.currentThread();
           current.setPriority(Thread.MIN_PRIORITY);
           //running =false;
           Canvas canvas = null;
           try {
               // Get Canvas from Holder and lock it.
               canvas = surfaceHolder.lockCanvas();
               // Synchronized
               synchronized (canvas) {
                   gameSurface.update();
                   gameSurface.draw(canvas);
               }
           } catch (Exception e) {
               // Do nothing.
           } finally {
               if (canvas != null) {
                   // Unlock Canvas.
                   surfaceHolder.unlockCanvasAndPost(canvas);
               }
           }
           long now = System.nanoTime();
           // Interval to redraw game
           // (Change nanoseconds to milliseconds)
           long waitTime = (now - startTime) / 1000000;
           waitTime = 100;
           if (waitTime < 10) {
               waitTime = 10; // Millisecond.
           }
           System.out.print(" Wait Time=" + waitTime);

           try {
               // Sleep.
               this.sleep(waitTime);
           } catch (InterruptedException e) {

           }
           startTime = System.nanoTime();
           System.out.print(".");
       }
   }


    public void setRunning(boolean running)  {
        this.running= running;
    }
}

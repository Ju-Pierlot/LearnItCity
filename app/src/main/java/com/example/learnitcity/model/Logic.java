package com.example.learnitcity.model;

import java.util.List;

public class Logic implements ILogic {
    private final double mLogicMedoc = 0.05;
    private final double mLogicFarmer = 0.066;
    private final double mLogicInfo = 0.02;
    private final double mLogicEco = 0.025;

    @Override
    public int getGlobalPoints(LearnIt learnIt) {
        int pointsMedo = 0, pointsFarmer = 0, pointsEco = 0, pointsInfo = 0, points, totalPerso = learnIt.getTotalPersonnage();
        int nbMedoc = learnIt.nbMedoc();
        if(nbMedoc > 0){
            double inter = totalPerso*mLogicMedoc;
            double next = (double)nbMedoc - inter;
            next = Math.abs(next);
            next = next * 6;
            pointsMedo = 25 - (int)next;
            if(pointsMedo < 0) pointsMedo = 0;
            else if(pointsMedo > 25) pointsMedo = 25;
        }
        int nbEco = learnIt.nbEco();
        if(learnIt.nbEco() > 0){
            double inter = totalPerso*mLogicEco;
            double next = (double)nbEco - inter;
            next = Math.abs(next);
            next = next * 3;
            pointsEco = 25 - (int)next;
            if(pointsEco < 0) pointsEco = 0;
            else if(pointsEco > 25) pointsEco = 25;
        }
        int nbFarmer = learnIt.nbFarmer();
        if(learnIt.nbFarmer() > 0){
            double inter = totalPerso*mLogicFarmer;
            double next = (double)nbFarmer - inter;
            next = Math.abs(next);
            next = next * 7;
            pointsFarmer = 25 - (int)next;
            if(pointsFarmer < 0) pointsFarmer = 0;
            else if(pointsFarmer > 25) pointsFarmer = 25;
        }
        int nbInfo = learnIt.nbInfo();
        if(learnIt.nbInfo() > 0){
            double inter = totalPerso*mLogicInfo;
            double next = (double)nbInfo - inter;
            next = Math.abs(next);
            next = next * 2;
            pointsInfo = 25 - (int)next;
            if(pointsInfo < 0) pointsInfo = 0;
            else if(pointsInfo > 25) pointsInfo = 25;
        }
        points = pointsEco + pointsFarmer+ pointsInfo + pointsMedo;
        return points;
    }
}

package com.example.learnitcity.model;

import java.util.ArrayList;
import java.util.List;
import com.example.learnitcity.R;
import com.example.learnitcity.datasource.PersonnageDao;

public class LearnIt {
    private List<Personnage> mPersonnages;
    private ILogic mLogic;
    private PersonnageDao mPersoDao;

    public LearnIt(List<Personnage> personnages, ILogic logic, PersonnageDao perso){
        this.mPersonnages = new ArrayList<>();
        this.mPersoDao = perso;
        addPersos(personnages);
        this.mLogic = logic;
    }
    public void addPerso(Personnage personnage){
        boolean notIn = true;
        for(int i = 0; i < this.mPersonnages.size(); i++){
            if(this.mPersonnages.get(i).equals(personnage)){
                this.mPersonnages.get(i).addPlus(personnage.getNombre());
                this.mPersoDao.updateNombre(this.mPersonnages.get(i).getNombre(), this.mPersonnages.get(i).getName());
                notIn = false;
            }
        }
        if(notIn) this.mPersonnages.add(personnage);
    }
    public void addPersos(List<Personnage> personnages){
        boolean notIn = true;
        for(int i = 0; i < personnages.size(); i++){
            notIn = true;
            for(int j = 0; j < this.mPersonnages.size(); j++){
                if(this.mPersonnages.get(j).equals(personnages.get(i))){
                    this.mPersonnages.get(j).addPlus(personnages.get(i).getNombre());
                    this.mPersoDao.updateNombre(this.mPersonnages.get(j).getNombre(), this.mPersonnages.get(j).getName());
                    notIn = false;
                }
            }
            if(notIn) this.mPersonnages.add(personnages.get(i));
        }
    }
    public int getGlobalHumor(){
        return this.mLogic.getGlobalPoints(this);
    }
    public int getTotalPersonnage(){
        int total = 0;
        for(int i = 0; i < this.mPersonnages.size(); i++){
            total += this.mPersonnages.get(i).getNombre();
        }
        return total;
    }
    public String getGlobalHumorToString(){
        return Integer.toString(getGlobalHumor()) + "%";
    }
    public List<Personnage> getmPersonnages(){
        return this.mPersonnages;
    }
    public int nbMedoc(){
        for(int i = 0; i < this.mPersonnages.size(); i++){
            if(this.mPersonnages.get(i).getName().equals("Medecins")){
                return this.mPersonnages.get(i).getNombre();
            }
        }
        return 0;
    }
    public int nbInfo(){
        for(int i = 0; i < this.mPersonnages.size(); i++){
            if(this.mPersonnages.get(i).getName().equals("Informaticiens")){
                return this.mPersonnages.get(i).getNombre();
            }
        }
        return 0;
    }
    public int nbFarmer(){
        for(int i = 0; i < this.mPersonnages.size(); i++){
            if(this.mPersonnages.get(i).getName().equals("Fermiers")){
                return this.mPersonnages.get(i).getNombre();
            }
        }
        return 0;
    }
    public int nbEco(){
        for(int i = 0; i < this.mPersonnages.size(); i++){
            if(this.mPersonnages.get(i).getName().equals("Economistes")){
                return this.mPersonnages.get(i).getNombre();
            }
        }
        return 0;
    }
}


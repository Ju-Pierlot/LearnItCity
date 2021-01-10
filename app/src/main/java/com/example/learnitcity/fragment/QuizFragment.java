package com.example.learnitcity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnitcity.R;
import com.example.learnitcity.adapter.AdapterTheme;
import com.example.learnitcity.database.LearnItCityDB;
import com.example.learnitcity.model.Article;
import com.example.learnitcity.model.LearnIt;
import com.example.learnitcity.model.Question;
import com.example.learnitcity.model.Quizz;
import com.example.learnitcity.model.Reponse;
import com.example.learnitcity.model.Reward;
import com.example.learnitcity.model.Theme;

import java.util.ArrayList;
import java.util.List;

public class QuizFragment extends Fragment {

    private Activity main;

    private RecyclerView listeTheme;
    private List<Theme> themeList;
    private RecyclerView.Adapter adapterTheme;
    private RecyclerView.LayoutManager adapterManager;
    private LearnIt learnIt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        themeList = new ArrayList<>();

        themeList.add(new Theme("Sante", getResources().getDrawable(R.drawable.sante)));
        themeList.add(new Theme("Economie", getResources().getDrawable(R.drawable.economie)));
        themeList.add(new Theme("Agriculture", getResources().getDrawable(R.drawable.ble)));
        themeList.add(new Theme("Numérique", getResources().getDrawable(R.drawable.informatique)));

        LearnItCityDB db = LearnItCityDB.getDatabase(getContext());
        if(db.articleDao().selectAll().size() == 0 ||
        db.quizzDao().selectAll().size() == 0 ||
        db.questionDao().getAll().size() == 0 ||
        db.reponseDao().selectAll().size() == 0) {
            /*db.articleDao().deleteAll();
            db.quizzDao().deleteAll();
            db.questionDao().deleteAll();
            db.reponseDao().deleteAll();*/

            //Santé
            db.articleDao().insert(new Article("Les gestes de base", "Les 4 étapes pour porter secours\n\n\r1. Sécurisez le lieu de l’accident et les personnes impliqués\nEvaluez les conditions de sécurité et vérifiez qu'il n'existe aucun danger \tsupplémentaire (circulation, incendie, électricité...). N'approchez le lieu de l'accident que si \tcela ne présente aucun risque pour vous. Dans la mesure du possible, assurez la sécurité des \tvictimes et des autres personnes présentes. Si la situation est dangereuse et si vous ne \tpouvez agir sans prendre de risque, alertez les services d'urgence. Etablissez un périmètre de \tsécurité autour du lieu de l'accident en attendant l'arrivée des secours.\n\n\r2. Appréciez l’état de la victime\n\rPrésentez-vous et expliquez à la victime ce que vous allez faire afin de la rassurer. Vérifiez qu'elle est consciente et respire normalement. Le pronostic vital est souvent en jeu en cas d'altération de la conscience ou de la respiration. Ces éléments seront à transmettre aux secours.\n\n\r3. Demandez de l’aide\n\rSi vous avez besoin d'aide, alertez les services d'urgence. Europe : 112\n\n\r4. Effectuez les gestes de premiers secours\n\rDispensez les gestes de premiers secours de façon calme et non précipitée.\n\r\n\n\rLes 4 étapes pour porter secours\n\n\r1. La victime ne peut pas répondre (elle secoue éventuellement la tête), mais est consciente.\n\r2. La victime ne peut ni parler, ni respirer, ni tousser. Elle peut émettre des sifflements ou tenter de tousser sans émettre de bruit. \n\r3. Donnez un maximum de 5 claques dans le dos de la victime. Après chaque claque, vérifiez si tout rentre dans l'ordre.\n\r4. Si les claques dans le dos n'ont pas d'effet, effectuez un maximum de 5 compressions abdominales.\n\r5. Si le problème n'est toujours pas résolu, alternez 5 claques dans le dos et 5 compressions abdominales.\n\r 6. Si la victime perd connaissance, posez-la délicatement au sol et alertez immédiatement les secours, puis entreprenez une réanimation cardio-pulmonaire en commençant par effectuer 30 compressions thoraciques.\n\r7. Poursuivez la réanimation jusqu'à ce que les secours arrivent ou que la victime reprenne une respiration normale.", "https://www.cdiscount.com/pdt2/0/8/0/1/700x700/auc6194143985080/rw/tempsa-kit-de-secours-trousse-urgence-premier-soin.jpg", "Sante"));
            db.articleDao().insert(new Article("Le Covid-19 c'est quoi ?", "Ce nouveau coronavirus a été appelé SARS-CoV-2 (SARS pour \"Syndrome Aigu Respiratoire Sévère\" et CoV pour \"COronaVirus\").\n\rSa maladie a été nommée Covid-19 le 11 février 2020 par l'OMS pour signifier :\n\r\"Co\" signifie \"corona\"\n\r\"vi\" pour \"virus\"\n\r\"D\" pour \" disease\" (\"maladie\" en anglais). \n\n\rLe chiffre 19 indique l'année de son apparition : 2019. \"Nous avons dû trouver un nom qui ne faisait pas référence à un lieu géographique, à un animal, à un individu ou à un groupe de personnes\" a précisé le directeur général de l'OMS, le Dr Tedros Adhanom Ghebreyesus, pour éviter toute stigmatisation de la maladie. \n\n\n\rC'est quoi coronavirus ? \n\n\rSras, Mers, Covid-19... Très contagieux, les coronavirus se répandent rapidement avec des risques de mortalité élevés pour certaines personnes. Mutation, symptômes pulmonaires, incubation, transmission... Que sait-on de ces virus responsables d'épidémies contagieuses et mortelles ?\n\r\n" +
                    "\nSon origine : une contamination animale\n\n\rLe pangolin possible hôte intermédiaire du coronavirus\n\rLe SARS-CoV-2 appartient à la famille des coronavirus (comptant un grand nombre de virus) qui peuvent provoquer des maladies bénignes chez l'homme comme un rhume et des pathologies plus graves comme le Sras. La contamination est d'origine animale. L'épidémie est partie d'un marché local de Wuhan en Chine où étaient vendus des animaux sauvages. Actuellement, on ne sait toujours pas avec certitude quel animal en est responsable. Il pourrait s'agir de la chauve-souris où a été détecté un virus très proche du Sars-CoV-2. Le 7 février 2020, des scientifiques de l'Université d'agriculture du sud de la Chine ont identifié le pangolin comme un \"possible hôte intermédiaire\" soupçonné d'avoir transmis le coronavirus à l'homme. Ce petit mammifère consommé dans le sud de la Chine pourrait être impliqué comme hôte intermédiaire entre la chauve-souris et l'homme. Le pangolin est un mammifère couvert d'écailles menacé d'extinction, dont la chair délicate est très prisée dans la gastronomie chinoise et vietnamienne. Dans un communiqué, les scientifiques expliquent qu'un animal peut être porteur d'un virus sans pour autant être malade et le transmettre à d'autres espèces comme l'homme. Après l'analyse de 1 000 échantillons, les scientifiques ont pu montrer que les génomes de séquences de virus prélevés sur les pangolins étaient à 99 % identiques aux virus retrouvés sur des personnes atteintes du nCoV, indique Chine Nouvelle. Rappelons que lors de l'épidémie de Sras de 2002-2003, l'hôte intermédiaire du virus était la civette, un petit animal au pelage gris dont la viande est consommée en Chine. La chauve-souris a, elle aussi, été à l'origine de transmission de virus à l'homme dont le Sras, le MERS en Arabie Saoudite mais aussi Ebola.\n\r\t ", "https://www.visiondumonde.fr/sites/visiondumonde.fr/files/styles/square_xs/public/editorial/image/2020-03/virus-covid-19-nouveau-coronavirus.png?itok=SNWPpNRN", "Sante"));
            db.articleDao().insert(new Article("Les brûlures", "Contenu de l'article", "https://images.bluethumb.com.au/uploads/listing/229226/donald-paull-my-hand-bluethumb-4a4f.jpg?w=766&h=766&fit=crop&auto=compress&cs=tinysrgb&q=70&s=e0931faba36918631e0b68ef3a3100fc", "Sante"));
            db.articleDao().insert(new Article("Le VIH", "Contenu de l'article", "https://files.hiv.gov/s3fs-public/20191125-aids-blog.jpg", "Sante"));

            //Économie
            db.articleDao().insert(new Article("Karl Marx", "Contenu de l'article", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Karl_Marx_monochromatic.svg/1024px-Karl_Marx_monochromatic.svg.png", "Economie"));
            db.articleDao().insert(new Article("La Bourse", "Contenu de l'article", "https://cdn.self-made.io/wp-content/uploads/2019/09/preferred-stock-and-baby-bond-owners-have-a-rough-year_2018-12-13-1024x1024.jpg", "Economie"));

            //Agriculture
            db.articleDao().insert(new Article("Les différentes herbes", "Contenu de l'article", "https://cdn.futura-sciences.com/buildsv6/images/largesquare/1/d/7/1d739afbc4_104938_tag-agriculture.jpg", "Agriculture"));
            db.articleDao().insert(new Article("Comment faire un potager", "Contenu de l'article", "https://i.pinimg.com/originals/45/d9/21/45d92177ee385cdc9f2f04ac6d79bc42.jpg", "Agriculture"));

            //Numérique
            db.articleDao().insert(new Article("Comment faire un top 1", "Pour rappel, le Battle Royale Warzone est un mode crossplay, ce qui veut dire que les joueurs disposant du jeu sur PS4, Xbox One et PC peuvent jouer ensemble et les uns contre les autres. De plus, le mode Warzone est bel et bien Free-to-play et permettra donc à tous les joueurs de pouvoir se lancer sur le champ de bataille avec ses amis et profiter de ce tout nouveau Battle Royale proposé par Activision.\n\n\n\rBien choisir son point de spawn\n\n\r\n" +
                    "Une fois la partie lancée les joueurs auront accès à la carte de Verdansk ainsi qu'à l'emplacement de la première zone. La première étape sera donc de choisir un point de chute intéressant. Il est donc préférable de choisir des emplacements déjà dans la zone pour éviter de perdre du temps en déplacement. Il est également important de choisir des lieux avec plusieurs bâtiments pour avoir plus de possibilités de loot. Attention toutefois, qui dit plus de loot et de bâtiments dit aussi plus de joueurs, il faudra donc veiller à ne pas se faire surprendre !\n\n\r\n" +
                    "Bien choisir ses armes\n\n\r\n" +
                    "Les armes dépendent bien entendu des lieux ou de ce que les adversaire ont sur eux lorsqu'ils se font tués, il est donc difficile de donner des noms précis. En revanche il est recommandé d'utiliser généralement des armes de type mitraillette, fusil d'assaut ou des armes relativement polyvalentes en arme principale. Bien que les armes comme les fusils de précision ou les fusils à pompe soient très efficaces dans certaines situations ils se révèlent généralement inutiles dans d'autres.\n\n\r\n" +
                    "\n" +
                    "Savoir gérer son argent et ses améliorations\n\n\r\n" +
                    " \n" +
                    "L'argent est l'un des particularités du Battle Royale de Call of Duty: Modern Warfare. Il permet d'acheter diverses améliorations et équipements dans les nombreuses stations de ravitaillement situées à Verdansk. Dans certaines situations il sera donc préférable d'opter pour une amélioration offensive comme un killstreak ou une caisse de ravitaillement. Dans d'autres il vaudra mieux opter pour un masque un gaz permettant de rester plus longtemps dans la zone de gaz ou bien un kit d'autoréanimation.\n\n\r\n" +
                    "Savoir se positionner et se déplacer\n\n\r\n" +
                    " \n" +
                    "Le positionnement est également un autre facteur important. Il est donc recommandé de surveiller régulièrement l'avancée de la zone pour prendre de l'avance et aller se positionner dans la zone suivante. Tandis que certains préféreront des positions en bord de zone, d'autres chercheront une position plus centrale dans la zone suivante, tout ceci dépendant des joueurs, de leur équipement et des informations qu'ils ont sur la position des autres joueurs. Prendre le contrôle d'un bâtiment est une bonne idée car il permet d'avoir une couverture pour récupérer des points de vie et généralement un avantage de hauteur sur les adversaires.\n\n\r\n" +
                    "Lors des déplacements il est préférables d'éviter les grands espaces ouverts et de privilégier les courses rapides sur de courtes distances en prenant soin de garder des en vue des endroits où se cacher en cas de problèmes.\n\n\r\n", "https://pic.clubic.com/v1/images/1782366/raw?fit=smartCrop&height=900&width=900&hash=405b7ea8d91080cceafc059efad2701e540f07bf", "Numérique"));
            db.articleDao().insert(new Article("Faire une recherche Google", "Contenu de l'article", "https://images.frandroid.com/wp-content/uploads/2017/01/google-search.png", "Numérique"));

            // WARNING UN ARTICLE A UN QUIZ ET EST RELIE A L ARTICLE PAR L'ARTICLE ID (FK).
            // AVEC L ARTICLE ID ON RETROUVE LE QUIZ ID. AVEC LE QUIZ ID ON OBITENT TOUTES LES QUESTIONS DU QUIZ

            db.quizzDao().insert(new Quizz("Sante", db.articleDao().selectAllArticleByTheme("Sante").get(0).getID()));

            long id = db.quizzDao().selectAllQuizzByTheme("Sante").get(0).getID();

            Question question1 = new Question("Le numéro à appeler en cas d'urgence est :", id);
            Question question2 = new Question("Quel est le nombre de claque dans le dos de la victime à mettre en cas d'étouffement ?", id);
            Question question3 = new Question("Laquelle des ces affirmations suivantes est fausse ?", id);
            Question question4 = new Question("Si je vois une personne en difficulté je ne dois surtout pas :", id);
            Question question5 = new Question("Si je sécurise le lieu d'accident je ne dois surtout pas :", id);

            db.questionDao().insert(question1);
            long questionID = db.questionDao().getQuestionsFromQuizz(id).get(0).getID();
            db.reponseDao().insert(new Reponse("911", false, questionID));
            db.reponseDao().insert(new Reponse("101", false, questionID));
            db.reponseDao().insert(new Reponse("112", true, questionID));
            db.reponseDao().insert(new Reponse("421", false, questionID));

            db.questionDao().insert(question2);
            long questionID2 = db.questionDao().getQuestionsFromQuizz(id).get(1).getID();
            db.reponseDao().insert(new Reponse("2", false, questionID2));
            db.reponseDao().insert(new Reponse("10", false, questionID2));
            db.reponseDao().insert(new Reponse("5", true, questionID2));
            db.reponseDao().insert(new Reponse("Aucune", false, questionID2));

            db.questionDao().insert(question3);
            long questionID3 = db.questionDao().getQuestionsFromQuizz(id).get(2).getID();
            db.reponseDao().insert(new Reponse("Effectuer les gestes de premiers secours", false, questionID3));
            db.reponseDao().insert(new Reponse("Demander de l'aide", false, questionID3));
            db.reponseDao().insert(new Reponse("Apprécier l'état de la victime", false, questionID3));
            db.reponseDao().insert(new Reponse("Donner un médicament à la victime", true, questionID3));

            db.questionDao().insert(question4);
            long questionID4 = db.questionDao().getQuestionsFromQuizz(id).get(3).getID();
            db.reponseDao().insert(new Reponse("Essayer de la transporter", true, questionID4));
            db.reponseDao().insert(new Reponse("Lui porter secours", false, questionID4));
            db.reponseDao().insert(new Reponse("Appeler les services d'urgence", false, questionID4));
            db.reponseDao().insert(new Reponse("Demander de l'aide", false, questionID4));

            db.questionDao().insert(question5);
            long questionID5 = db.questionDao().getQuestionsFromQuizz(id).get(4).getID();
            db.reponseDao().insert(new Reponse("Encercler la victime", true, questionID5));
            db.reponseDao().insert(new Reponse("Évaluer les conditions de sécurité", false, questionID5));
            db.reponseDao().insert(new Reponse("Assurer la sécurité des victimes", false, questionID5));
            db.reponseDao().insert(new Reponse("Établir un périmètre de sécurite", false, questionID5));

            //---------------------------------------------------------------------------------------------------
            db.quizzDao().insert(new Quizz("Sante", db.articleDao().selectAllArticleByTheme("Sante").get(1).getID()));

            long idbis = db.quizzDao().selectAllQuizzByTheme("Sante").get(1).getID();

            Question question1bis = new Question("De quel animal provient le Covid-19 ?", idbis);
            Question question2bis = new Question("Lequel de ces symptômes n'est pas lié au Covid-19 ?", idbis);
            Question question3bis = new Question("De quelle ville de Chine provient ce coronavirus ?", idbis);
            Question question4bis = new Question("Laquelle des ces affirmations est fausse ?", idbis);
            Question question5bis = new Question("Quel est le premier nom donné à ce coronavirus ?", idbis);

            db.questionDao().insert(question1bis);
            long questionIDbis = db.questionDao().getQuestionsFromQuizz(idbis).get(0).getID();
            db.reponseDao().insert(new Reponse("Le pangolin", false, questionIDbis));
            db.reponseDao().insert(new Reponse("Le lémurien", false, questionIDbis));
            db.reponseDao().insert(new Reponse("Le chien", false, questionIDbis));
            db.reponseDao().insert(new Reponse("La chauve-souris", true, questionIDbis));

            List<Question> insertedQuestion = db.questionDao().getQuestionsFromQuizz(2);
            List<Reponse> insertedreponse = db.reponseDao().selectAll();

            db.questionDao().insert(question2bis);
            long questionID2bis = db.questionDao().getQuestionsFromQuizz(idbis).get(1).getID();
            db.reponseDao().insert(new Reponse("La toux", false, questionID2bis));
            db.reponseDao().insert(new Reponse("La fièvre", false, questionID2bis));
            db.reponseDao().insert(new Reponse("La perte d'équilibre", true, questionID2bis));
            db.reponseDao().insert(new Reponse("Difficultés respiratoires", false, questionID2bis));

            db.questionDao().insert(question3bis);
            long questionID3bis = db.questionDao().getQuestionsFromQuizz(idbis).get(2).getID();
            db.reponseDao().insert(new Reponse("Pékin", false, questionID3bis));
            db.reponseDao().insert(new Reponse("Shenzhen", false, questionID3bis));
            db.reponseDao().insert(new Reponse("Nankin", false, questionID3bis));
            db.reponseDao().insert(new Reponse("Wuhan", true, questionID3bis));

            db.questionDao().insert(question4bis);
            long questionID4bis = db.questionDao().getQuestionsFromQuizz(idbis).get(3).getID();
            db.reponseDao().insert(new Reponse("Le Covid-19 est très contagieux", false, questionID4bis));
            db.reponseDao().insert(new Reponse("La période d'incubation est de 5 à 7 jours", false, questionID4bis));
            db.reponseDao().insert(new Reponse("Le Covid-19 peut être mortel", false, questionID4bis));
            db.reponseDao().insert(new Reponse("Le Covid-19 est inoffensif  pour les adolescents", true, questionID4bis));

            db.questionDao().insert(question5bis);
            long questionID5bis = db.questionDao().getQuestionsFromQuizz(idbis).get(4).getID();
            db.reponseDao().insert(new Reponse("CAFS-CoV-19", false, questionID5bis));
            db.reponseDao().insert(new Reponse("SARS-CoV-2", true, questionID5bis));
            db.reponseDao().insert(new Reponse("SARS-CoV-19", false, questionID5bis));
            db.reponseDao().insert(new Reponse("CAFS-CoV-2", false, questionID5bis));

            List<Question> insertedQuestionbis = db.questionDao().getQuestionsFromQuizz(2);

            //---------------------------------------------------------------------------------------------------
            db.quizzDao().insert(new Quizz("Numérique", db.articleDao().selectAllArticleByTheme("Numérique").get(0).getID()));

            long idbiss = db.quizzDao().selectAllQuizzByTheme("Numérique").get(0).getID();

            Question question1biss = new Question("Quel est le nom de carte de Warzone ?", idbiss);
            Question question2biss = new Question("Laquelle de ces armes n'est pas polyvalente ?", idbiss);
            Question question3biss = new Question("Lequel de ces facteurs est le plus important ?", idbiss);
            Question question4biss = new Question("Lequel de ces éléments ne fait pas partie du jeu ?", idbiss);
            Question question5biss = new Question("Lequel de ces titres ne fait pas partie de l'article ?", idbiss);

            db.questionDao().insert(question1biss);
            long questionIDbiss = db.questionDao().getQuestionsFromQuizz(idbiss).get(0).getID();
            db.reponseDao().insert(new Reponse("Baltimate", false, questionIDbiss));
            db.reponseDao().insert(new Reponse("Firing Range", false, questionIDbiss));
            db.reponseDao().insert(new Reponse("Verdask", false, questionIDbiss));
            db.reponseDao().insert(new Reponse("Aucune réponse", true, questionIDbiss));

            db.questionDao().insert(question2biss);
            long questionID2biss = db.questionDao().getQuestionsFromQuizz(idbiss).get(1).getID();
            db.reponseDao().insert(new Reponse("Le fusil d'assaut", false, questionID2biss));
            db.reponseDao().insert(new Reponse("La mitrailette", false, questionID2biss));
            db.reponseDao().insert(new Reponse("Le fusil de précision", false, questionID2biss));
            db.reponseDao().insert(new Reponse("Le lance-roquettes", true, questionID2biss));

            db.questionDao().insert(question3biss);
            long questionID3biss = db.questionDao().getQuestionsFromQuizz(idbiss).get(2).getID();
            db.reponseDao().insert(new Reponse("Surveiller l'avancement de la zone", true, questionID3biss));
            db.reponseDao().insert(new Reponse("Avoir des grenades", false, questionID3biss));
            db.reponseDao().insert(new Reponse("Se déplacer en véhicule", false, questionID3biss));
            db.reponseDao().insert(new Reponse("Jouer sneacky", false, questionID3biss));

            db.questionDao().insert(question4biss);
            long questionID4biss = db.questionDao().getQuestionsFromQuizz(idbiss).get(3).getID();
            db.reponseDao().insert(new Reponse("Le kit d'autoréanimation", false, questionID4biss));
            db.reponseDao().insert(new Reponse("Les drones", false, questionID4biss));
            db.reponseDao().insert(new Reponse("Le RC-XD", true, questionID4biss));
            db.reponseDao().insert(new Reponse("Le masque à gaz", false, questionID4biss));

            db.questionDao().insert(question5biss);
            long questionID5biss = db.questionDao().getQuestionsFromQuizz(idbiss).get(4).getID();
            db.reponseDao().insert(new Reponse("Savoir se positionner et se déplacer", false, questionID5biss));
            db.reponseDao().insert(new Reponse("Savoir gérer son argent", false, questionID5biss));
            db.reponseDao().insert(new Reponse("Se dropper correctement", true, questionID5biss));
            db.reponseDao().insert(new Reponse("Bien choisir son spawn", false, questionID5biss));



        }
        db.rewardDao().deleteAll();
        List<Article> articles = db.articleDao().selectAll();
        db.rewardDao().insert(new Reward("Economistes",2,articles.get(0).getID()));
        db.rewardDao().insert(new Reward("Informaticiens",1,articles.get(0).getID()));
        listeTheme = view.findViewById(R.id.listeThemes);
        adapterManager = new GridLayoutManager(main,1);
        listeTheme.setLayoutManager(adapterManager);
        adapterTheme = new AdapterTheme(main, themeList);
        listeTheme.setAdapter(adapterTheme);
        adapterTheme.notifyDataSetChanged();

        return view;
    }

    public QuizFragment(Activity activity){
        this.main = activity;
        this.learnIt = learnIt;
    }
}

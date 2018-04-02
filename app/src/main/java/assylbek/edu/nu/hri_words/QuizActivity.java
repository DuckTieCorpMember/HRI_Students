package assylbek.edu.nu.hri_words;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Console;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

class Dictionary{
    String category;
    List<String> words;

    public Dictionary(String cats, List<String> list){
        this.category = cats;
        this.words = list;
    }
}

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QUIZ_ACTIVITY";

    ListView categoriesList;
    ListView wordsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        String[] chosenCats = intent.getStringArrayListExtra("categories").toArray(new String[0]);

        Log.d(TAG, chosenCats[0]);
        Log.d(TAG, chosenCats[1]);
        Log.d(TAG, chosenCats[2]);

        List<Dictionary> cats = new ArrayList<>();

        for(int i=0; i<chosenCats.length; i++)
        {
            if(chosenCats[i].equals("Cloth"))
            {
                cats.add(new Dictionary("Cloth", Arrays.asList(getResources().getStringArray(R.array.Cloth))));
            }
            if(chosenCats[i].equals("Food"))
            {
                cats.add(new Dictionary("Food", Arrays.asList(getResources().getStringArray(R.array.Food))));
            }
            if(chosenCats[i].equals("Animal"))
            {
                cats.add(new Dictionary("Animal", Arrays.asList(getResources().getStringArray(R.array.Animal))));
            }
            if(chosenCats[i].equals("Plant"))
            {
                cats.add(new Dictionary("Plant", Arrays.asList(getResources().getStringArray(R.array.Plant))));
            }
        }

        List<Dictionary> picks = new LinkedList<>();
        for(int i=0; i<3; i++)
        {
            List<String> list = new ArrayList<>();
            while(list.size() < 4)
            {
                Random random = new Random();
                int id = random.nextInt(cats.get(i).words.size());
                if(!list.contains(cats.get(i).words.get(i)))
                {
                    list.add(cats.get(i).words.get(i));
                }
            }
            picks.add(new Dictionary(cats.get(i).category, list));
        }

        QuizCategoryAdapter adapterCat = new QuizCategoryAdapter(this, picks);
        categoriesList.setAdapter(adapterCat);

        List<String> ss = new ArrayList<>();
        for(int i=0; i<picks.size(); i++)
        {
            for(int j=0; j<picks.get(i).words.size(); j++)
            {
                ss.add(picks.get(i).words.get(j));
            }
        }
        Collections.shuffle(ss);
        QuizWordAdapter adapterWord = new QuizWordAdapter(this, ss);
        wordsList.setAdapter(adapterWord);
    }
}

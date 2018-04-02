package assylbek.edu.nu.hri_words;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CategoryChoice extends AppCompatActivity {

    ListView listView;
    Button startButton;
    int clickedCategories = 0;

    ArrayList<String> clickedInts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_choice);

        listView = findViewById(R.id.list_view);
        startButton = findViewById(R.id.startButton);
        String[] categories = getResources().getStringArray(R.array.categories);
        CategoriesAdapter adapter = new CategoriesAdapter(this, categories);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView text = view.findViewById(R.id.categoryTextView);
                if(clickedCategories < 3 && text.getTextColors().getDefaultColor() == getResources().getColor(R.color.categoryTextColor))
                {
                    text.setTextColor(getResources().getColor(R.color.categoryTextClicked));
                    text.setBackgroundColor(getResources().getColor(R.color.categoryClicked));
                    clickedCategories ++;
                    clickedInts.add((String) text.getText());
                }
                else if(text.getTextColors().getDefaultColor() == getResources().getColor(R.color.categoryTextClicked))
                {
                    text.setTextColor(getResources().getColor(R.color.categoryTextColor));
                    text.setBackgroundColor(getResources().getColor(R.color.categoryColor));
                    clickedCategories --;
                    clickedInts.add((String) text.getText());
                }

                if(clickedCategories < 3)
                {
                    startButton.setVisibility(View.INVISIBLE);
                }
                else if( clickedCategories == 3)
                {
                    startButton.setVisibility(View.VISIBLE);
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartQuiz(clickedInts);
            }
        });
    }

    void StartQuiz(ArrayList<String> s)
    {
        ArrayList<String> strings = s;

        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("categories", strings);
        startActivity(intent);
    }
}

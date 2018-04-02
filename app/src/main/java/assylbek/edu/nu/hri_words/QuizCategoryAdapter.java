package assylbek.edu.nu.hri_words;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 31.03.2018.
 */

public class QuizCategoryAdapter extends BaseAdapter {

    Context context;
    List<Dictionary> list;

    public QuizCategoryAdapter(Context context, List<Dictionary> dictionaries)
    {
        this.context = context;
        this.list = dictionaries;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.category_quiz_item, viewGroup, false);
        TextView categoryTextView = view.findViewById(R.id.categoryTextView);

        categoryTextView.setText(list.get(i).category);

        return view;
    }
}

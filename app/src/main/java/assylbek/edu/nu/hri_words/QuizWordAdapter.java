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

public class QuizWordAdapter extends BaseAdapter {
    Context context;
    List<String> list;

    public QuizWordAdapter(Context context, List<String> strings)
    {
        this.context = context;
        this.list =strings;
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
        view = inflater.inflate(R.layout.words_quiz_item, viewGroup, false);
        TextView wordTextView = view.findViewById(R.id.wordTextView);

        wordTextView.setText(list.get(i));

        return view;
    }
}

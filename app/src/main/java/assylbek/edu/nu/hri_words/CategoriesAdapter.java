package assylbek.edu.nu.hri_words;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Admin on 27.03.2018.
 */

public class CategoriesAdapter extends BaseAdapter {
    Context context;
    String[] values;

    public CategoriesAdapter(Context context, String[] values)
    {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return values[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.category_list_item, viewGroup, false);
        TextView categoryTextView = view.findViewById(R.id.categoryTextView);

        categoryTextView.setText(values[i]);

        return view;
    }
}

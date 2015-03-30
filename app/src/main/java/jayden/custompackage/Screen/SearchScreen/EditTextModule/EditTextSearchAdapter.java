package jayden.custompackage.Screen.SearchScreen.EditTextModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jayden.custompackage.R;

/**
 * Created by jayden on 15. 3. 20..
 */
public class EditTextSearchAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mArrayList;

    public EditTextSearchAdapter(Context context, ArrayList<String> arrayList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mArrayList = arrayList;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        String title = mArrayList.get(position);

        if(convertView == null) {
            viewHolder = new ViewHolder();

            convertView = mLayoutInflater.inflate(R.layout.item_search_result, null);

            viewHolder.titleTextView = (TextView) convertView.findViewById(R.id.item_search_result_textview);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTextView.setText(title);

        return convertView;
    }

    class ViewHolder {
        public TextView titleTextView;
    }
}

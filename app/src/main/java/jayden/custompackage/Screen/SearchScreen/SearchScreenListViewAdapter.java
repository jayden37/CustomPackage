package jayden.custompackage.Screen.SearchScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jayden.custompackage.Common.ApplicationClass;
import jayden.custompackage.R;

/**
 * @author Jayden
 * @since 03. 20. 2015.
 * <p/>
 * SearchScreen listview Adapter
 */
public class SearchScreenListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mArrayList;

    public SearchScreenListViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mArrayList = ApplicationClass.searchListViewItemArrayList;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String item = mArrayList.get(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = mLayoutInflater.inflate(R.layout.item_search_screen_listview, null);

            viewHolder.textView = (TextView) convertView.findViewById(R.id.item_search_screen_listview_textview);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(item);

        return convertView;
    }

    private static class ViewHolder {
        public TextView textView;
    }
}

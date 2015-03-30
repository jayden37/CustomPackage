package jayden.custompackage.Screen.MainScreen;

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
 * @author Jayden.
 * @since 03. 20. 2015.
 *
 *
 * Main listview Adapter
 */
public class MainListViewAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mArrayList;

    public MainListViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mArrayList = ApplicationClass.mainListViewItemArrayList;
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

        if(convertView == null) {
            viewHolder = new ViewHolder();

            convertView = mLayoutInflater.inflate(R.layout.item_main_listview, null);

            viewHolder.textview = (TextView) convertView.findViewById(R.id.item_main_listview_textview);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textview.setText(item);

        return convertView;
    }

    private static class ViewHolder {
        public TextView textview;
    }
}

package jayden.custompackage.Screen.SearchScreen.AutoCompleteModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import jayden.custompackage.R;

/**
 * Created by jayden on 15. 3. 20..
 */
public class AutoCompleteSearchAdapter extends BaseAdapter implements Filterable {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mArrayList;
    private ArrayList<String> mAllArrayList;
    private ArrayList<String> mSuggestions;

    public AutoCompleteSearchAdapter(Context context, ArrayList<String> arrayList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);

        mArrayList = arrayList;
        mAllArrayList = (ArrayList<String>) mArrayList.clone();
        mSuggestions = new ArrayList<>();
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

        if (convertView == null) {
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

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private Filter mFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            if (charSequence != null) {
                mSuggestions.clear();
                for (String item : mAllArrayList) {
                    if (item.contains(charSequence)) {
                        mSuggestions.add(item);
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mSuggestions;
                filterResults.count = mSuggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            ArrayList<String> resultArrayList = (ArrayList<String>) filterResults.values;
            if (filterResults != null && filterResults.count > 0) {
                mArrayList.clear();
                for (String item : resultArrayList) {
                    mArrayList.add(item);
                }
                notifyDataSetChanged();
            }
        }
    };
}


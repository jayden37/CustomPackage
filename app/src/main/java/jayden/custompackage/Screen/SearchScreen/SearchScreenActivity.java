package jayden.custompackage.Screen.SearchScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import jayden.custompackage.R;
import jayden.custompackage.Screen.SearchScreen.AutoCompleteModule.AutoCompleteSearchActivity;
import jayden.custompackage.Screen.SearchScreen.EditTextModule.EditTextSearchActivity;

public class SearchScreenActivity extends ActionBarActivity {

    private Context mContext;
    private ListView mListView;
    private SearchScreenListViewAdapter mSearchScreenListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);

        initResource();
        initSearchScreenListView();
    }

    private void initResource() {
        mContext = this;

        mListView = (ListView) findViewById(R.id.activity_search_screen_listview);
    }

    private void initSearchScreenListView() {
        mSearchScreenListViewAdapter = new SearchScreenListViewAdapter(mContext);
        mListView.setAdapter(mSearchScreenListViewAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = null;

                switch (position) {
                    case 0:
                        intent = new Intent(SearchScreenActivity.this, AutoCompleteSearchActivity.class);
                        break;
                    case 1:
                        intent = new Intent(SearchScreenActivity.this, EditTextSearchActivity.class);
                        break;
                    default:
                        break;
                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}

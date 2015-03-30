package jayden.custompackage.Screen.MainScreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import jayden.custompackage.Common.ApplicationClass;
import jayden.custompackage.R;
import jayden.custompackage.Screen.SearchScreen.SearchScreenActivity;

/**
 * @author Jayden
 * @since 03. 20. 2015.
 *
 * Main Activity
 */
public class MainActivity extends ActionBarActivity {

    private Context mContext;
    private ListView mListView;
    private MainListViewAdapter mMainListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* view resource init method */
        initResource();

        /* main listview init method */
        initMainListView();
    }

    /**
     * view resource init method
     */
    private void initResource() {
        /* init class member values */
        mContext = this;

        /* init view resource */
        mListView = (ListView) findViewById(R.id.activity_main_listview);
    }

    /**
     * main listview init method
     */
    private void initMainListView() {
        mMainListViewAdapter = new MainListViewAdapter(mContext);
        mListView.setAdapter(mMainListViewAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = null;

                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, SearchScreenActivity.class);
                        break;
                    default:
                        break;
                }

                if(intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}

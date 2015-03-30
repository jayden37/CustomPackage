package jayden.custompackage.Screen.SearchScreen.AutoCompleteModule;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

import jayden.custompackage.Common.ApplicationClass;
import jayden.custompackage.R;

public class AutoCompleteSearchActivity extends ActionBarActivity {

    private Context mContext;

    private AutoCompleteTextView mAutoCompleteTextView;
    private AutoCompleteSearchAdapter mAutoCompleteSearchAdapter;
    private ArrayList<String> mFilterArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_search);

        initResource();
        initAutoCompleteTextView();
    }

    private void initResource() {
        mContext = this;

        mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.activity_auto_complete_search_autocompletetextview);
    }

    private void initAutoCompleteTextView() {
        mFilterArrayList = (ArrayList<String>) ApplicationClass.defaultSearchItemArrayList.clone();

        mAutoCompleteSearchAdapter = new AutoCompleteSearchAdapter(mContext, mFilterArrayList);
        mAutoCompleteTextView.setAdapter(mAutoCompleteSearchAdapter);
    }
}

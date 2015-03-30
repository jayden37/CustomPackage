package jayden.custompackage.Screen.SearchScreen.EditTextModule;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import jayden.custompackage.Common.ApplicationClass;
import jayden.custompackage.R;

public class EditTextSearchActivity extends ActionBarActivity {

    private Context mContext;

    private EditText mEditText;
    private ListView mListView;
    private EditTextSearchAdapter mEditTextSearchAdapter;
    private ArrayList<String> mResultArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_search);

        initResource();
        initSearchAdatper();
        initEditText();
    }

    private void initResource() {
        mContext = this;

        mEditText = (EditText) findViewById(R.id.activity_edit_text_search_edittext);
        mListView = (ListView) findViewById(R.id.activity_edit_text_search_listview);
    }

    private void initSearchAdatper() {
        mEditTextSearchAdapter = new EditTextSearchAdapter(mContext, mResultArrayList);
        mListView.setAdapter(mEditTextSearchAdapter);
    }

    private void initEditText() {
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setResultListView(s.toString());
                mEditTextSearchAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setResultListView(String s) {
        mResultArrayList.clear();

        for (String item : ApplicationClass.defaultSearchItemArrayList) {
            if(item.contains(s)) {
                mResultArrayList.add(item);
            }
        }
    }
}

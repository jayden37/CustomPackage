package jayden.custompackage.Common;

import android.app.Application;

import java.util.ArrayList;

/**
 * @author Jayden
 * @since 03. 20. 2015.
 *
 * global application class.
 */
public class ApplicationClass extends Application {

    public static ArrayList<String> mainListViewItemArrayList;

    public static ArrayList<String> searchListViewItemArrayList;

    public static ArrayList<String> defaultSearchItemArrayList;

    @Override
    public void onCreate() {
        super.onCreate();

        initGlobalValues();
    }

    /* global values init method */
    private void initGlobalValues() {
        mainListViewItemArrayList = new ArrayList<>();
        mainListViewItemArrayList.add("Search");

        searchListViewItemArrayList = new ArrayList<>();
        searchListViewItemArrayList.add("AutoCompleteTextView");
        searchListViewItemArrayList.add("EditText + ListView");

        initDefaultSearchItem();
    }

    private void initDefaultSearchItem() {
        defaultSearchItemArrayList = new ArrayList<>();
        defaultSearchItemArrayList.add("대한민국");
        defaultSearchItemArrayList.add("영국");
        defaultSearchItemArrayList.add("독일");
        defaultSearchItemArrayList.add("프랑스");
        defaultSearchItemArrayList.add("일본");
        defaultSearchItemArrayList.add("중국");
        defaultSearchItemArrayList.add("몽골");
        defaultSearchItemArrayList.add("러시아");
        defaultSearchItemArrayList.add("캐나다");
        defaultSearchItemArrayList.add("멕시코");
        defaultSearchItemArrayList.add("온두라스");
        defaultSearchItemArrayList.add("브라질");
        defaultSearchItemArrayList.add("아르헨티나");
        defaultSearchItemArrayList.add("필리핀");
        defaultSearchItemArrayList.add("스위스");
        defaultSearchItemArrayList.add("스웨덴");
        defaultSearchItemArrayList.add("덴마크");
    }
}


package eu.basicenglish;

import eu.basicenglish.MainView.SizeCallback;
import eu.basicenglish.R;

import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FreakActivity extends Activity implements OnClickListener, FreakListener, SizeCallback, OnItemClickListener {
    MainView scrollView;
    View menu;
    View app;
    ImageView btnSlide;
    boolean menuOut = false;
    Handler handler = new Handler();
    int btnWidth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Database database = Database.sharedInstance();
        database.categories();
        
        LayoutInflater inflater = LayoutInflater.from(this);
        
        scrollView = (MainView) inflater.inflate(R.layout.horz_scroll_with_list_menu, null);
        setContentView(scrollView);

        menu = inflater.inflate(R.layout.horz_scroll_menu, null);
        
        app = inflater.inflate(R.layout.main_app_view, null);
        
        ViewGroup tabBar = (ViewGroup) app.findViewById(R.id.tabBar);

        //ListView listView = (ListView) app.findViewById(R.id.list);
        //initListView(listView, "Item ", 30, android.R.layout.simple_list_item_1);

        
        ListView listView = (ListView) menu.findViewById(R.id.list);
        initListView(listView, "Menu ", 30, android.R.layout.simple_list_item_1);

        btnSlide = (ImageView) tabBar.findViewById(R.id.BtnSlide);
        btnSlide.setOnClickListener(this);

        final View[] children = new View[] { menu, app };

        // Scroll to app (view[1]) when layout finished.
        int scrollToViewIdx = 1;
        scrollView.initViews(children, scrollToViewIdx);
        //scrollView.setMainView(app);
        //scrollView.setMenuView(menu);
        
        scrollView.addMainListener(children, scrollToViewIdx, this);
    }
    
    public void initListView( ListView listView, String prefix, int numItems, int layout) {
        // By using setAdpater method in listview we an add string array in list.
        String[] arr = new String[numItems];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = prefix + (i + 1);
        }
        listView.setAdapter(new ArrayAdapter<String>(this, layout, arr));
        listView.setOnItemClickListener(this);
    }
    
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Context context = view.getContext();
        
        // did select at menu
        switchView();
    }
    
    public void switchView () {
    	Context context = menu.getContext();
        String msg = "Slide " + new Date();
        Toast.makeText(context, msg, 1000).show();
        System.out.println(msg);

        int menuWidth = menu.getMeasuredWidth();

        // Ensure menu is visible
        menu.setVisibility(View.VISIBLE);

        if (!menuOut) {
            int left = 0;
            scrollView.smoothScrollTo(left, 0);
        } else {
            // Scroll to menuWidth so menu isn't on screen.
            int left = menuWidth;
            scrollView.smoothScrollTo(left, 0);
        }
        menuOut = !menuOut;
    }
    
    public void onClick(View v) {
        switchView();
    }
    
    public void onGlobalLayout() {
        btnWidth = btnSlide.getMeasuredWidth();
        System.out.println("btnWidth=" + btnWidth);
    }

    public void getViewSize(int idx, int w, int h, int[] dims) {
        dims[0] = w;
        dims[1] = h;
        final int menuIdx = 0;
        if (idx == menuIdx) {
            dims[0] = w - btnWidth;
        }
    }


	public void didSelectItem(int index, Object object, Object sender) {
		// TODO Auto-generated method stub
		
	}
}
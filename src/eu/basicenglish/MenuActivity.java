
package eu.basicenglish;

import eu.basicenglish.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String packageName = this.getClass().getPackage().getName();
        final Context context = this;

        ViewGroup contentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.activity_menu, null);

        ViewGroup g = (ViewGroup) contentView.getChildAt(0);
        int count = g.getChildCount();

        for (int i = 0; i < count; i++) {
            Button btn = (Button) g.getChildAt(i);
            final String text = btn.getText().toString();
            btn.setOnClickListener(new OnClickListener() {
                
                public void onClick(View v) {
                    try {
                        Class c = Class.forName(packageName + "." + text);
                        startActivity(new Intent(context, c));
                    } catch (ClassNotFoundException e) {
                        Toast.makeText(context, String.valueOf(e), 5000).show();
                    }
                }
            });
        }

        setContentView(contentView);
    }
}

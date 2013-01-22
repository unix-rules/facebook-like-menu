
package eu.basicenglish;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;

public class MainView extends HorizontalScrollView  implements OnGlobalLayoutListener {
	
	ViewGroup parent;
    View[] children;
    int scrollToViewIdx;
    int scrollToViewPos = 0;
    SizeCallback sizeCallback;

	
    public MainView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MainView(Context context) {
        super(context);
        init(context);
    }

    void init(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
    }

    public void initViews(View[] children, int scrollToViewIdx) {
        
    	ViewGroup parent = (ViewGroup) getChildAt(0);

        for (int i = 0; i < children.length; i++) {
            children[i].setVisibility(View.INVISIBLE);
            parent.addView(children[i]);
        }
    }
    
    public void addMainListener(View[] children, int scrollToViewIdx, SizeCallback sizeCallback) {
    	ViewGroup parent = (ViewGroup) getChildAt(0);
    	
    	this.parent = parent;
        this.children = children;
        this.scrollToViewIdx = scrollToViewIdx;
        
        this.sizeCallback = sizeCallback;
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    public void onGlobalLayout() {

        final HorizontalScrollView me = MainView.this;

        me.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        sizeCallback.onGlobalLayout();

        parent.removeViewsInLayout(0, children.length);

        final int w = me.getMeasuredWidth();
        final int h = me.getMeasuredHeight();

        int[] dims = new int[2];
        scrollToViewPos = 0;
        for (int i = 0; i < children.length; i++) {
            sizeCallback.getViewSize(i, w, h, dims);
            children[i].setVisibility(View.VISIBLE);
            parent.addView(children[i], dims[0], dims[1]);
            if (i < scrollToViewIdx) {
                scrollToViewPos += dims[0];
            }
        }
        
        new Handler().post(new Runnable() {
            
            public void run() {
                me.scrollBy(scrollToViewPos, 0);
            }
        });
    }
    
    public interface SizeCallback {
        
        public void onGlobalLayout();
        public void getViewSize(int idx, int w, int h, int[] dims);
    }
}

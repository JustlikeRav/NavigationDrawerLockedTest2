package avenview.navigationdrawerlockedtest2;

import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionManager;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

    ListView list1, list2;
    View lastView;
    String[] options1 = {
            "Start Player",
            "Current Location",
            "View Landmark",
            "Add Landmarks",
            "Default Content"
    } ;
    Integer[] imageId1 = {
            R.drawable.ic_android,
            R.drawable.ic_android,
            R.drawable.ic_android,
            R.drawable.ic_android,
            R.drawable.ic_android

    };
    Integer[] selectedGradient1 = {
            R.drawable.selected_gradient,
            R.drawable.selected_gradient,
            R.drawable.selected_gradient,
            R.drawable.selected_gradient,
            R.drawable.selected_gradient
    };

    String[] options2 = {
            "Application Settings",
            "Help & Feedback"
    } ;
    Integer[] imageId2 = {
            R.drawable.ic_android,
            R.drawable.ic_android
    };
    Integer[] selectedGradient2 = {
            R.drawable.selected_gradient,
            R.drawable.selected_gradient
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final panelAdapter adapter1 = new panelAdapter(MainActivity.this, options1, imageId1, selectedGradient1, getResources());
        list1 =  findViewById(R.id.list1);
        list1.setAdapter(adapter1);

        panelAdapter adapter2 = new panelAdapter(MainActivity.this, options2, imageId2, selectedGradient2, getResources());
        list2 =  findViewById(R.id.list2);
        list2.setAdapter(adapter2);
        lastView = getViewByPosition( 0, list1);
    }

    @Override
    protected void onStart() {
        super.onStart();

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final ViewGroup v = findViewById(R.id.lol);
                TransitionManager.beginDelayedTransition(v);
                if(lastView != view){
                    //Make the last one short
                    ImageView ivSelect = view.findViewById(R.id.selectedGrad);
                    ImageView ivLast = lastView.findViewById(R.id.selectedGrad);

                    //Change the postion now
                    ViewGroup.LayoutParams sizeRulesExpand = ivSelect.getLayoutParams();
                    ViewGroup.LayoutParams sizeRulesShort = ivLast.getLayoutParams();

                    //Calculate dimensions in DPs
                    final float scale = getResources().getDisplayMetrics().density;

                    sizeRulesExpand.height = (int) (50 * scale);
                    sizeRulesExpand.width = (int) (75 * scale);
                    ivSelect.setLayoutParams(sizeRulesExpand);

                    sizeRulesShort.height = (int) (50 * scale);
                    sizeRulesShort.width = (int) (7.5 * scale);
                    ivLast.setLayoutParams(sizeRulesShort);

                    //Make current view equal to the last view
                    lastView = view;
                }
            }
        });

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final ViewGroup v = findViewById(R.id.lol);
                TransitionManager.beginDelayedTransition(v);
                if(lastView != view){
                    //Make the last one short
                    ImageView ivSelect = view.findViewById(R.id.selectedGrad);
                    ImageView ivLast = lastView.findViewById(R.id.selectedGrad);

                    //Change the postion now
                    ViewGroup.LayoutParams sizeRulesExpand = ivSelect.getLayoutParams();
                    ViewGroup.LayoutParams sizeRulesShort = ivLast.getLayoutParams();

                    //Calculate dimensions in DPs
                    final float scale = getResources().getDisplayMetrics().density;

                    sizeRulesExpand.height = (int) (50 * scale);
                    sizeRulesExpand.width = (int) (75 * scale);
                    ivSelect.setLayoutParams(sizeRulesExpand);

                    sizeRulesShort.height = (int) (50 * scale);
                    sizeRulesShort.width = (int) (7.5 * scale);
                    ivLast.setLayoutParams(sizeRulesShort);

                    //Make current view equal to the last view
                    lastView = view;
                }
            }
        });


    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }
}

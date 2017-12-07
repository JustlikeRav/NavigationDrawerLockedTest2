package avenview.navigationdrawerlockedtest2;

import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class panelAdapter extends ArrayAdapter<String>
{
    private Activity mActivity;
    private String[] option;
    private Integer[] imageID, selectedGradient;
    Resources mResources;

    panelAdapter(Activity activity,
                 String[] name, Integer[] imageId, Integer[] selectedGradient, Resources resources) {
        super(activity, R.layout.list_row, name);

        this.mActivity = activity;
        this.option = name;
        this.imageID = imageId;
        this.selectedGradient = selectedGradient;
        this.mResources = resources;
    }

    @NonNull
    @Override
    public View getView(int i, View view,@NonNull ViewGroup viewGroup) {
        View rowView = view;

        if(rowView==null){
            LayoutInflater inflater = mActivity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_row, null, true);
//            if(i == 0){
//                ImageView ivSelect = rowView.findViewById(R.id.selectedGrad);
//                ViewGroup.LayoutParams sizeRulesExpand = ivSelect.getLayoutParams();
//
//                //Calculate dimensions in DPs
//                final float scale = mResources.getDisplayMetrics().density;
//
//                sizeRulesExpand.height = (int) (50 * scale);
//                sizeRulesExpand.width = (int) (75 * scale);
//                ivSelect.setLayoutParams(sizeRulesExpand);
//            }
        }

        TextView textView = rowView.findViewById(R.id.textEachOption);
        ImageView imageView = rowView.findViewById(R.id.imageView);
        ImageView selectGradient = rowView.findViewById(R.id.selectedGrad);

        textView.setText(option[i]);
        imageView.setImageResource(imageID[i]);
        selectGradient.setImageResource(selectedGradient[i]);
        return rowView;
    }
}

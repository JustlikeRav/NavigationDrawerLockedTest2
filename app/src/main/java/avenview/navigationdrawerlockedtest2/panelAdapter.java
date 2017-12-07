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

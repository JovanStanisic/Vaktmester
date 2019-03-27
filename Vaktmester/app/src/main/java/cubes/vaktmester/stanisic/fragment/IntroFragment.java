package cubes.vaktmester.stanisic.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cubes.vaktmester.stanisic.R;

public class IntroFragment extends Fragment {

    public TextView textTitle, textDescription;
    public ImageView imageView;

    // fildovi koje ce pager adapter da koristi pri uzimanju fragmenata

    private String textViewTitle, textViewDesc;
    private int image,position;

    public static IntroFragment getInstance(String title, String desc, int image, int position){

        IntroFragment introFragment = new IntroFragment();

        introFragment.textViewTitle = title;
        introFragment.textViewDesc = desc;
        introFragment.image = image;
        introFragment.position = position;

        return introFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflejtujem view
        return inflater.inflate(R.layout.fragment_intro,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //setujem viewove i dajem im vrednosti koje su unete kao parametri konstruktora

        textTitle = view.findViewById(R.id.textViewPager1);
        textDescription = view.findViewById(R.id.textViewPagerDesc);
        imageView = view.findViewById(R.id.imageViewPager);

        textTitle.setText(textViewTitle);
        imageView.setImageResource(image);
        textDescription.setText(textViewDesc);


        //switch statement kojim na osnovu pozicije fragmenta u pager adapteru odredjujem dimenzije slicice

        switch (position){
            case 0:
                int heightInDp0 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, getResources().getDisplayMetrics());
                int widthInDp0 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,184,getResources().getDisplayMetrics());
                imageView.getLayoutParams().height = heightInDp0;
                imageView.getLayoutParams().width = widthInDp0;
                imageView.requestLayout();
                break;
            case 1:
                int heightInDp1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 63, getResources().getDisplayMetrics());
                int widthInDp1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,52,getResources().getDisplayMetrics());
                imageView.getLayoutParams().height = heightInDp1;
                imageView.getLayoutParams().width = widthInDp1;
                imageView.requestLayout();
                break;
            case 2:
                int heightInDp2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 58, getResources().getDisplayMetrics());
                int widthInDp2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,61,getResources().getDisplayMetrics());
                imageView.getLayoutParams().height = heightInDp2;
                imageView.getLayoutParams().width = widthInDp2;
                imageView.requestLayout();
                break;
        }

    }
}

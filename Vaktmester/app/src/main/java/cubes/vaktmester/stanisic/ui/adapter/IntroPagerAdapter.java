package cubes.vaktmester.stanisic.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.FrameLayout;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.fragment.IntroFragment;

public class IntroPagerAdapter extends FragmentPagerAdapter {

    public IntroPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        // u zavisnosti od pozicije prosledjujemo odredjeni intro fragment
        // sa odredjenim parametrima u konstruktoru
        switch (i) {
            case 1:
               return IntroFragment.getInstance("Title One","Lorem ipsum dolor sit amet, consectetur adipiscing elit.", R.drawable.page_two, i);
            case 2:
                return  IntroFragment.getInstance("Title Two","Lorem ipsum dolor sit amet, consectetur adipiscing elit.", R.drawable.page_three, i);
            default:
               return IntroFragment.getInstance("Welcome to","", R.drawable.welcome_page, i);
        }
    }


    @Override
    public int getCount() {
        return 3;
    }
}

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
                return new IntroFragment("Title One", R.drawable.page_two, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",i);
            case 2:
                return new IntroFragment("Title Two", R.drawable.page_three, "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",i);
            default:
                return new IntroFragment("Welcome to", R.drawable.welcome_page, "",i);
        }
    }


    @Override
    public int getCount() {
        return 3;
    }
}

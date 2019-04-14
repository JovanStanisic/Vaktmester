package cubes.vaktmester.stanisic.utils.animations;

import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthTransformation implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View view, float v) {
        if (v < -1){    // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        }
        else if (v <= 0){    // [-1,0]
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);

        }
        else if (v <= 1){    // (0,1]
            view.setTranslationX(-v*view.getWidth());
            view.setAlpha(1-Math.abs(v));
            view.setScaleX(1-Math.abs(v));
            view.setScaleY(1-Math.abs(v));

        }
        else {    // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);

        }


    }
}



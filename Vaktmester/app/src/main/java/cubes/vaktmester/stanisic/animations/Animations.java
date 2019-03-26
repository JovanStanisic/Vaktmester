package cubes.vaktmester.stanisic.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

public class Animations {

    public static void setScaleAnimation(View v,int offset){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f,1f,0f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setStartOffset(offset);
        scaleAnimation.setDuration(200);

        v.startAnimation(scaleAnimation);
    }
}
//    public ScaleAnimation(float fromX, float toX, float fromY, float toY,
//                          int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
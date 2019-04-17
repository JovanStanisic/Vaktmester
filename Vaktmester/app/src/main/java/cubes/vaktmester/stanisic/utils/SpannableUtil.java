package cubes.vaktmester.stanisic.utils;

import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

public class SpannableUtil {

    public static Spannable spannableBold(String pom, String text) {

        String textView = pom + text;

        Spannable spannable = new SpannableString(textView);
        spannable.setSpan(new StyleSpan(Typeface.BOLD), 0, pom.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannable;
    }
}

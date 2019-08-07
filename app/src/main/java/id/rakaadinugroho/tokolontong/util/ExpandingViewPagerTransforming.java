package id.rakaadinugroho.tokolontong.util;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class ExpandingViewPagerTransforming implements ViewPager.PageTransformer {
    private static final float MAX_SCALE = 1.0f;
    private static final float MIN_SCALE = 0.9f;
    @Override
    public void transformPage(@NonNull View page, float position) {
        position = position < -1 ? -1 : position;
        position = position > 1 ? 1 : position;

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        float scaleValue = MIN_SCALE + tempScale * slope;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            page.getParent().requestLayout();
        }
    }
}

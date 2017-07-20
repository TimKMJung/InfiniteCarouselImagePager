package android.ssoim.com.infinitecarouselimagepager.utils;

import android.ssoim.com.infinitecarouselimagepager.R;
import android.ssoim.com.infinitecarouselimagepager.views.ImagePagerMainActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ImagePagerAdapter extends FragmentPagerAdapter implements ViewPager.PageTransformer {
    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.7f;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

    private CustomLayout cur = null;
    private CustomLayout next = null;
    private ImagePagerMainActivity context;
    private FragmentManager fm;
    private float scale;

    public ImagePagerAdapter(ImagePagerMainActivity context, FragmentManager fm) {
        super(fm);
        this.fm = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first pager bigger than others
        if (position == ImagePagerMainActivity.FIRST_PAGE)
            scale = BIG_SCALE;
        else
            scale = SMALL_SCALE;

        position = position % ImagePagerMainActivity.PAGES;
        return CustomFragment.newInstance(context, position, scale);
    }

    @Override
    public int getCount() {
        return ImagePagerMainActivity.PAGES * ImagePagerMainActivity.LOOPS;
    }

    @Override
    public void transformPage(View page, float position) {
        CustomLayout mCustomLayout = (CustomLayout) page.findViewById(R.id.cr_root);
        float scale = BIG_SCALE;
        if (position > 0) {
            scale = scale - position * DIFF_SCALE;
        } else {
            scale = scale + position * DIFF_SCALE;
        }

        if (scale < 0) scale = 0;

        mCustomLayout.setScaleBoth(scale);
    }
}

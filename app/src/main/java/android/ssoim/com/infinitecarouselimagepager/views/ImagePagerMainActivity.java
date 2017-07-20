package android.ssoim.com.infinitecarouselimagepager.views;

import android.os.Bundle;
import android.ssoim.com.infinitecarouselimagepager.R;
import android.ssoim.com.infinitecarouselimagepager.datas.Constants;
import android.ssoim.com.infinitecarouselimagepager.utils.ImagePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class ImagePagerMainActivity extends AppCompatActivity {


    public final static int PAGES = Constants.TOTAL_PAGES;
    public final static int LOOPS = Constants.TOTAL_LOOPS;
    public final static int FIRST_PAGE = PAGES * LOOPS / 2;


    public ImagePagerAdapter adapter;
    public ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pager_main);

        init();



    }

    private void init() {
        pager = (ViewPager) findViewById(R.id.cr_pager);

        adapter = new ImagePagerAdapter(this, this.getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setPageTransformer(false, adapter);

        // Set current item to the middle page so we can fling to both
        // directions left and right
        pager.setCurrentItem(FIRST_PAGE);

        // Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        pager.setOffscreenPageLimit(3);

        // Set margin for pages as a negative number, so a part of next and
        // previous pages will be showed
        pager.setPageMargin(-500);
    }
}

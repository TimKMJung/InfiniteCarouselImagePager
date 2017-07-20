package android.ssoim.com.infinitecarouselimagepager.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.ssoim.com.infinitecarouselimagepager.R;
import android.ssoim.com.infinitecarouselimagepager.views.ImagePagerMainActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CustomFragment extends Fragment {

    private int[] mImageResources = {
            R.drawable.img_barcelona_org,
            R.drawable.img_cordova_org,
            R.drawable.img_dubruvnik_org,
            R.drawable.img_road_org,
            R.drawable.img_sunset_org
    };




    public static Fragment newInstance(ImagePagerMainActivity context, int pos, float scale) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putFloat("scale", scale);
        return Fragment.instantiate(context, CustomFragment.class.getName(), b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        RelativeLayout l = (RelativeLayout)
                inflater.inflate(R.layout.pager_frame, container, false);


        ImageView imgView = (ImageView) l.findViewById(R.id.cr_org_img);


        int pos = this.getArguments().getInt("pos");

        Bitmap bmp = null;

//        final Options options=new BitmapFactory.Options();
//        options.inSampleSize=2;

        final BitmapFactory.Options bmpOptions = new BitmapFactory.Options();

        bmpOptions.inDensity = 2;
        bmpOptions.inTargetDensity=1;


        switch(pos) {
            case 0:
                // ROUNDED BMP
//                bmp = null;
                bmp = BitmapFactory.decodeResource(this.getResources(), mImageResources[0], bmpOptions);
                bmp.setDensity(Bitmap.DENSITY_NONE);
                Bitmap roundedBmp = getRoundedBitmap(bmp, 20);

                Drawable roundedBmPD = new BitmapDrawable(roundedBmp);
                imgView.setBackground(roundedBmPD);


                break;


            case 1 :
                // ROUNDED BMP
//                bmp = null;
                bmp = BitmapFactory.decodeResource(this.getResources(), mImageResources[1], bmpOptions);
                bmp.setDensity(Bitmap.DENSITY_NONE);
                Bitmap roundedBmp1 = getRoundedBitmap(bmp, 20);

                Drawable roundedBmPD1 = new BitmapDrawable(roundedBmp1);
                imgView.setBackground(roundedBmPD1);


                break;

            case 2 :
                // ROUNDED BMP
//                bmp = null;
                bmp = BitmapFactory.decodeResource(this.getResources(), mImageResources[2], bmpOptions);
                bmp.setDensity(Bitmap.DENSITY_NONE);
                Bitmap roundedBmp2 = getRoundedBitmap(bmp, 20);

                Drawable roundedBmPD2 = new BitmapDrawable(roundedBmp2);
                imgView.setBackground(roundedBmPD2);



                break;

            case 3 :
                // ROUNDED BMP
//                bmp = null;
                bmp = BitmapFactory.decodeResource(this.getResources(), mImageResources[3], bmpOptions);
                bmp.setDensity(Bitmap.DENSITY_NONE);
                Bitmap roundedBmp3 = getRoundedBitmap(bmp, 20);

                Drawable roundedBmPD3 = new BitmapDrawable(roundedBmp3);
                imgView.setBackground(roundedBmPD3);



                break;

            case 4 :
                // ROUNDED BMP
//                bmp = null;
                bmp = BitmapFactory.decodeResource(this.getResources(), mImageResources[4], bmpOptions);
                bmp.setDensity(Bitmap.DENSITY_NONE);
                Bitmap roundedBmp4 = getRoundedBitmap(bmp, 20);

                Drawable roundedBmPD4 = new BitmapDrawable(roundedBmp4);
                imgView.setBackground(roundedBmPD4);


                break;

        }


        CustomLayout root = (CustomLayout) l.findViewById(R.id.cr_root);
        float scale = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);

        return l;
    }

    private Bitmap getRoundedBitmap(Bitmap srcBitmap, int cornerRadius) {
        Bitmap dstBitmap = Bitmap.createBitmap(
                srcBitmap.getWidth(), // Width
                srcBitmap.getHeight(), // Height

                Bitmap.Config.ARGB_8888 // Config
        );

        Canvas canvas = new Canvas(dstBitmap);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

        Rect rect = new Rect(0, 0, srcBitmap.getWidth(), srcBitmap.getHeight());
        RectF rectF = new RectF(rect);

        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        srcBitmap.recycle();

        return dstBitmap;
    }
}

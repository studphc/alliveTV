package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bumptech.glide.load.ImageHeaderParser;

/* loaded from: classes.dex */
public interface c21 {
    Bitmap decodeBitmap(BitmapFactory.Options options);

    int getImageOrientation();

    ImageHeaderParser.ImageType getImageType();

    void stopGrowingBuffers();
}

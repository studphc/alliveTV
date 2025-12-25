package p000;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface ne1 {
    Bitmap get(int i, int i2, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i, int i2, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    Bitmap removeLast();
}

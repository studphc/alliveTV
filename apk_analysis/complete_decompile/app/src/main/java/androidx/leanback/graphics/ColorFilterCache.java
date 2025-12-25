package androidx.leanback.graphics;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class ColorFilterCache {

    /* renamed from: b */
    public static final SparseArray f5356b = new SparseArray();

    /* renamed from: a */
    public final PorterDuffColorFilter[] f5357a = new PorterDuffColorFilter[256];

    public ColorFilterCache(int i, int i2, int i3) {
        for (int i4 = 0; i4 <= 255; i4++) {
            this.f5357a[i4] = new PorterDuffColorFilter(Color.argb(i4, i, i2, i3), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static ColorFilterCache getColorFilterCache(int i) {
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int rgb = Color.rgb(red, green, blue);
        SparseArray sparseArray = f5356b;
        ColorFilterCache colorFilterCache = (ColorFilterCache) sparseArray.get(rgb);
        if (colorFilterCache == null) {
            ColorFilterCache colorFilterCache2 = new ColorFilterCache(red, green, blue);
            sparseArray.put(rgb, colorFilterCache2);
            return colorFilterCache2;
        }
        return colorFilterCache;
    }

    public ColorFilter getFilterForLevel(float f) {
        if (f >= RecyclerView.f7068F0 && f <= 1.0d) {
            return this.f5357a[(int) (f * 255.0f)];
        }
        return null;
    }
}

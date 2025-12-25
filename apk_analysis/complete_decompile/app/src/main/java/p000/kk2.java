package p000;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public abstract /* synthetic */ class kk2 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f20887a;

    static {
        int[] iArr = new int[Bitmap.Config.values().length];
        f20887a = iArr;
        try {
            iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20887a[Bitmap.Config.RGB_565.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20887a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20887a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

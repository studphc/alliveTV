package p000;

import androidx.loader.content.ModernAsyncTask$Status;

/* loaded from: classes.dex */
public abstract /* synthetic */ class oo1 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f24848a;

    static {
        int[] iArr = new int[ModernAsyncTask$Status.values().length];
        f24848a = iArr;
        try {
            iArr[ModernAsyncTask$Status.RUNNING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f24848a[ModernAsyncTask$Status.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

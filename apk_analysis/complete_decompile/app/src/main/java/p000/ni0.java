package p000;

import io.reactivex.rxjava3.core.BackpressureStrategy;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class ni0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f23370a;

    static {
        int[] iArr = new int[BackpressureStrategy.values().length];
        f23370a = iArr;
        try {
            iArr[BackpressureStrategy.DROP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f23370a[BackpressureStrategy.LATEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f23370a[BackpressureStrategy.MISSING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f23370a[BackpressureStrategy.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

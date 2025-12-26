package p000;

import io.reactivex.rxjava3.core.BackpressureStrategy;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class mk0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f22970a;

    static {
        int[] iArr = new int[BackpressureStrategy.values().length];
        f22970a = iArr;
        try {
            iArr[BackpressureStrategy.MISSING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22970a[BackpressureStrategy.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f22970a[BackpressureStrategy.DROP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f22970a[BackpressureStrategy.LATEST.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

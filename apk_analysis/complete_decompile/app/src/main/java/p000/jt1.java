package p000;

import io.reactivex.rxjava3.core.BackpressureStrategy;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class jt1 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f20624a;

    static {
        int[] iArr = new int[BackpressureStrategy.values().length];
        f20624a = iArr;
        try {
            iArr[BackpressureStrategy.DROP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20624a[BackpressureStrategy.LATEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20624a[BackpressureStrategy.MISSING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20624a[BackpressureStrategy.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

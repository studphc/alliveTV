package p000;

import io.reactivex.rxjava3.parallel.ParallelFailureHandling;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class e22 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f16660a;

    static {
        int[] iArr = new int[ParallelFailureHandling.values().length];
        f16660a = iArr;
        try {
            iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16660a[ParallelFailureHandling.SKIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16660a[ParallelFailureHandling.STOP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

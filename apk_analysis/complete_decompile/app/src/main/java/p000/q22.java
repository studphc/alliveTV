package p000;

import io.reactivex.rxjava3.parallel.ParallelFailureHandling;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class q22 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f25416a;

    static {
        int[] iArr = new int[ParallelFailureHandling.values().length];
        f25416a = iArr;
        try {
            iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f25416a[ParallelFailureHandling.SKIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f25416a[ParallelFailureHandling.STOP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

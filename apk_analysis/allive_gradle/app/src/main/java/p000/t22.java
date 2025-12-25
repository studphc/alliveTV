package p000;

import io.reactivex.rxjava3.parallel.ParallelFailureHandling;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class t22 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f26675a;

    static {
        int[] iArr = new int[ParallelFailureHandling.values().length];
        f26675a = iArr;
        try {
            iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f26675a[ParallelFailureHandling.SKIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f26675a[ParallelFailureHandling.STOP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

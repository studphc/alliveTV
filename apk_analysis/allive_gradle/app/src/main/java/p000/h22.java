package p000;

import io.reactivex.rxjava3.parallel.ParallelFailureHandling;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class h22 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f17934a;

    static {
        int[] iArr = new int[ParallelFailureHandling.values().length];
        f17934a = iArr;
        try {
            iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17934a[ParallelFailureHandling.SKIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f17934a[ParallelFailureHandling.STOP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

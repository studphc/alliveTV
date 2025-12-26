package p000;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class co0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f8431a;

    static {
        int[] iArr = new int[BackpressureOverflowStrategy.values().length];
        f8431a = iArr;
        try {
            iArr[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8431a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

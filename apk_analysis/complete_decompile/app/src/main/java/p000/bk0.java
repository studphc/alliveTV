package p000;

import io.reactivex.rxjava3.internal.util.ErrorMode;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class bk0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f8052a;

    static {
        int[] iArr = new int[ErrorMode.values().length];
        f8052a = iArr;
        try {
            iArr[ErrorMode.BOUNDARY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8052a[ErrorMode.END.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

package p000;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public abstract /* synthetic */ class eu0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f16981a;

    static {
        int[] iArr = new int[Lifecycle.State.values().length];
        f16981a = iArr;
        try {
            iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16981a[Lifecycle.State.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16981a[Lifecycle.State.CREATED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16981a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

package p000;

import com.google.common.collect.BoundType;

/* loaded from: classes.dex */
public abstract /* synthetic */ class m82 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f22848a;

    static {
        int[] iArr = new int[BoundType.values().length];
        f22848a = iArr;
        try {
            iArr[BoundType.OPEN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f22848a[BoundType.CLOSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

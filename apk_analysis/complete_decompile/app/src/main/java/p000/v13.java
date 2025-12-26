package p000;

import androidx.constraintlayout.core.state.State;

/* loaded from: classes.dex */
public abstract /* synthetic */ class v13 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f27626a;

    static {
        int[] iArr = new int[State.Chain.values().length];
        f27626a = iArr;
        try {
            iArr[State.Chain.SPREAD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f27626a[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f27626a[State.Chain.PACKED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

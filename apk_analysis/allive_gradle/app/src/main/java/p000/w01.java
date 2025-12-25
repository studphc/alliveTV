package p000;

import androidx.constraintlayout.core.state.State;

/* loaded from: classes.dex */
public abstract /* synthetic */ class w01 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f28028a;

    static {
        int[] iArr = new int[State.Chain.values().length];
        f28028a = iArr;
        try {
            iArr[State.Chain.SPREAD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f28028a[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f28028a[State.Chain.PACKED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

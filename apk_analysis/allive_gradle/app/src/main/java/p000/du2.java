package p000;

import java.math.RoundingMode;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class du2 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f16555a;

    static {
        int[] iArr = new int[RoundingMode.values().length];
        f16555a = iArr;
        try {
            iArr[RoundingMode.DOWN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16555a[RoundingMode.HALF_EVEN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16555a[RoundingMode.HALF_DOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16555a[RoundingMode.HALF_UP.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f16555a[RoundingMode.FLOOR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f16555a[RoundingMode.CEILING.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f16555a[RoundingMode.UP.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f16555a[RoundingMode.UNNECESSARY.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
    }
}

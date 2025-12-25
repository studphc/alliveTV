package p000;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* renamed from: cv */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1099cv {

    /* renamed from: a */
    public static final /* synthetic */ int[] f16119a;

    static {
        int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
        f16119a = iArr;
        try {
            iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16119a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16119a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16119a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}

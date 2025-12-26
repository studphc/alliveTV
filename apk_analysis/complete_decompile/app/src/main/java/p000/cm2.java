package p000;

import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public final class cm2 extends SplineSet {

    /* renamed from: c */
    public String f8418c;

    @Override // androidx.constraintlayout.core.motion.utils.SplineSet
    public final void setProperty(TypedValues typedValues, float f) {
        typedValues.setValue(typedValues.getId(this.f8418c), get(f));
    }
}

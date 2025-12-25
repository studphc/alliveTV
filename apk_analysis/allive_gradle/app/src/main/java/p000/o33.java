package p000;

import android.view.View;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;

/* loaded from: classes.dex */
public final class o33 extends ViewOscillator {

    /* renamed from: g */
    public final float[] f23593g = new float[1];

    /* renamed from: h */
    public ConstraintAttribute f23594h;

    @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
    public final void setCustom(Object obj) {
        this.f23594h = (ConstraintAttribute) obj;
    }

    @Override // androidx.constraintlayout.motion.utils.ViewOscillator
    public final void setProperty(View view, float f) {
        float f2 = get(f);
        float[] fArr = this.f23593g;
        fArr[0] = f2;
        CustomSupport.setInterpolatedValue(this.f23594h, view, fArr);
    }
}

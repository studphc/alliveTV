package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;

/* renamed from: androidx.constraintlayout.core.motion.utils.a */
/* loaded from: classes.dex */
public final class C0120a extends KeyCycleOscillator {

    /* renamed from: g */
    public int f2276g;

    @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
    public final void setProperty(MotionWidget motionWidget, float f) {
        motionWidget.setValue(this.f2276g, get(f));
    }
}

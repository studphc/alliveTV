package p000;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;

/* loaded from: classes.dex */
public final class z33 extends ViewTimeCycle {

    /* renamed from: a */
    public final /* synthetic */ int f29240a;

    @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
    public final boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        switch (this.f29240a) {
            case 0:
                view.setAlpha(get(f, j, view, keyCache));
                return this.mContinue;
            case 1:
                view.setElevation(get(f, j, view, keyCache));
                return this.mContinue;
            case 2:
                view.setRotation(get(f, j, view, keyCache));
                return this.mContinue;
            case 3:
                view.setRotationX(get(f, j, view, keyCache));
                return this.mContinue;
            case 4:
                view.setRotationY(get(f, j, view, keyCache));
                return this.mContinue;
            case 5:
                view.setScaleX(get(f, j, view, keyCache));
                return this.mContinue;
            case 6:
                view.setScaleY(get(f, j, view, keyCache));
                return this.mContinue;
            case 7:
                view.setTranslationX(get(f, j, view, keyCache));
                return this.mContinue;
            case 8:
                view.setTranslationY(get(f, j, view, keyCache));
                return this.mContinue;
            default:
                view.setTranslationZ(get(f, j, view, keyCache));
                return this.mContinue;
        }
    }
}

package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import p000.ai2;

/* loaded from: classes.dex */
public final class WindowInsetsAnimationControllerCompat {

    /* renamed from: a */
    public final ai2 f3940a;

    public WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.f3940a = new ai2(14, windowInsetsAnimationController);
    }

    public void finish(boolean z) {
        ((WindowInsetsAnimationController) this.f3940a.f216b).finish(z);
    }

    public float getCurrentAlpha() {
        float currentAlpha;
        currentAlpha = ((WindowInsetsAnimationController) this.f3940a.f216b).getCurrentAlpha();
        return currentAlpha;
    }

    @FloatRange(from = 0.0d, m152to = 1.0d)
    public float getCurrentFraction() {
        float currentFraction;
        currentFraction = ((WindowInsetsAnimationController) this.f3940a.f216b).getCurrentFraction();
        return currentFraction;
    }

    @NonNull
    public Insets getCurrentInsets() {
        android.graphics.Insets currentInsets;
        currentInsets = ((WindowInsetsAnimationController) this.f3940a.f216b).getCurrentInsets();
        return Insets.toCompatInsets(currentInsets);
    }

    @NonNull
    public Insets getHiddenStateInsets() {
        android.graphics.Insets hiddenStateInsets;
        hiddenStateInsets = ((WindowInsetsAnimationController) this.f3940a.f216b).getHiddenStateInsets();
        return Insets.toCompatInsets(hiddenStateInsets);
    }

    @NonNull
    public Insets getShownStateInsets() {
        android.graphics.Insets shownStateInsets;
        shownStateInsets = ((WindowInsetsAnimationController) this.f3940a.f216b).getShownStateInsets();
        return Insets.toCompatInsets(shownStateInsets);
    }

    public int getTypes() {
        int types;
        types = ((WindowInsetsAnimationController) this.f3940a.f216b).getTypes();
        return types;
    }

    public boolean isCancelled() {
        boolean isCancelled;
        isCancelled = ((WindowInsetsAnimationController) this.f3940a.f216b).isCancelled();
        return isCancelled;
    }

    public boolean isFinished() {
        boolean isFinished;
        isFinished = ((WindowInsetsAnimationController) this.f3940a.f216b).isFinished();
        return isFinished;
    }

    public boolean isReady() {
        if (!isFinished() && !isCancelled()) {
            return true;
        }
        return false;
    }

    public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, m152to = 1.0d) float f, @FloatRange(from = 0.0d, m152to = 1.0d) float f2) {
        android.graphics.Insets platformInsets;
        WindowInsetsAnimationController windowInsetsAnimationController = (WindowInsetsAnimationController) this.f3940a.f216b;
        if (insets == null) {
            platformInsets = null;
        } else {
            platformInsets = insets.toPlatformInsets();
        }
        windowInsetsAnimationController.setInsetsAndAlpha(platformInsets, f, f2);
    }
}

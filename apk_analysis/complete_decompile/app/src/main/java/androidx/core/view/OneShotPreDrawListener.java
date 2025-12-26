package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final View f3899a;

    /* renamed from: b */
    public ViewTreeObserver f3900b;

    /* renamed from: c */
    public final Runnable f3901c;

    public OneShotPreDrawListener(View view, Runnable runnable) {
        this.f3899a = view;
        this.f3900b = view.getViewTreeObserver();
        this.f3901c = runnable;
    }

    @NonNull
    public static OneShotPreDrawListener add(@NonNull View view, @NonNull Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
                view.addOnAttachStateChangeListener(oneShotPreDrawListener);
                return oneShotPreDrawListener;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.f3901c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View view) {
        this.f3900b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NonNull View view) {
        removeListener();
    }

    public void removeListener() {
        boolean isAlive = this.f3900b.isAlive();
        View view = this.f3899a;
        if (isAlive) {
            this.f3900b.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}

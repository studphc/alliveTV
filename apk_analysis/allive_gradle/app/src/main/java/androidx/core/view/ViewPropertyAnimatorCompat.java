package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import java.lang.ref.WeakReference;
import p000.b12;
import p000.u33;

/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {

    /* renamed from: a */
    public final WeakReference f3933a;

    public ViewPropertyAnimatorCompat(View view) {
        this.f3933a = new WeakReference(view);
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().alphaBy(f);
        }
        return this;
    }

    public void cancel() {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = (View) this.f3933a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    @Nullable
    public Interpolator getInterpolator() {
        View view = (View) this.f3933a.get();
        if (view != null) {
            return (Interpolator) view.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        View view = (View) this.f3933a.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().rotation(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().rotationBy(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().rotationX(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().rotationXBy(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().rotationY(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().rotationYBy(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().scaleXBy(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().scaleYBy(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long j) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator interpolator) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            if (viewPropertyAnimatorListener != null) {
                view.animate().setListener(new b12(viewPropertyAnimatorListener, view, 2));
            } else {
                view.animate().setListener(null);
            }
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        final View view = (View) this.f3933a.get();
        if (view != null) {
            if (viewPropertyAnimatorUpdateListener != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: t33
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ViewPropertyAnimatorUpdateListener.this.onAnimationUpdate(view);
                    }
                };
            } else {
                animatorUpdateListener = null;
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public void start() {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().translationX(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().translationXBy(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().translationYBy(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            u33.m7528a(view.animate(), f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            u33.m7529b(view.animate(), f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable runnable) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable runnable) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }

    @NonNull
    /* renamed from: x */
    public ViewPropertyAnimatorCompat m915x(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().x(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().xBy(f);
        }
        return this;
    }

    @NonNull
    /* renamed from: y */
    public ViewPropertyAnimatorCompat m916y(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().y(f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            view.animate().yBy(f);
        }
        return this;
    }

    @NonNull
    /* renamed from: z */
    public ViewPropertyAnimatorCompat m917z(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            u33.m7530c(view.animate(), f);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float f) {
        View view = (View) this.f3933a.get();
        if (view != null) {
            u33.m7531d(view.animate(), f);
        }
        return this;
    }
}

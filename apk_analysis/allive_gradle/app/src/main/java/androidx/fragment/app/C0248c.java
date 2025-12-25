package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.C1540m9;
import p000.RunnableC0547b7;
import p000.nt0;

/* renamed from: androidx.fragment.app.c */
/* loaded from: classes.dex */
public final class C0248c extends SpecialEffectsController.Effect {

    /* renamed from: c */
    public final C0249d f4650c;

    public C0248c(C0249d animationInfo) {
        Intrinsics.checkNotNullParameter(animationInfo, "animationInfo");
        this.f4650c = animationInfo;
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onCancel(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        C0249d c0249d = this.f4650c;
        SpecialEffectsController.Operation operation = c0249d.getOperation();
        View view = operation.getFragment().f4428K;
        view.clearAnimation();
        container.endViewTransition(view);
        c0249d.getOperation().completeEffect(this);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has been cancelled.");
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onCommit(final ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        C0249d c0249d = this.f4650c;
        if (c0249d.isVisibilityUnchanged()) {
            c0249d.getOperation().completeEffect(this);
            return;
        }
        Context context = container.getContext();
        final SpecialEffectsController.Operation operation = c0249d.getOperation();
        final View view = operation.getFragment().f4428K;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        C1540m9 m1223a = c0249d.m1223a(context);
        if (m1223a != null) {
            Animation animation = (Animation) m1223a.f22854b;
            if (animation != null) {
                if (operation.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view.startAnimation(animation);
                    c0249d.getOperation().completeEffect(this);
                    return;
                }
                container.startViewTransition(view);
                nt0 nt0Var = new nt0(animation, container, view);
                nt0Var.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$AnimationEffect$onCommit$1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(@NotNull Animation animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                        View view2 = view;
                        C0248c c0248c = this;
                        ViewGroup viewGroup = container;
                        viewGroup.post(new RunnableC0547b7(viewGroup, view2, c0248c, 2));
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Animation from operation " + SpecialEffectsController.Operation.this + " has ended.");
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(@NotNull Animation animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(@NotNull Animation animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Animation from operation " + SpecialEffectsController.Operation.this + " has reached onAnimationStart.");
                        }
                    }
                });
                view.startAnimation(nt0Var);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has started.");
                    return;
                }
                return;
            }
            throw new IllegalStateException("Required value was null.");
        }
        throw new IllegalStateException("Required value was null.");
    }
}

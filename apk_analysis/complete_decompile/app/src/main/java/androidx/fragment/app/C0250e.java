package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.C1540m9;

/* renamed from: androidx.fragment.app.e */
/* loaded from: classes.dex */
public final class C0250e extends SpecialEffectsController.Effect {

    /* renamed from: c */
    public final C0249d f4654c;

    /* renamed from: d */
    public AnimatorSet f4655d;

    public C0250e(C0249d animatorInfo) {
        Intrinsics.checkNotNullParameter(animatorInfo, "animatorInfo");
        this.f4654c = animatorInfo;
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onCancel(ViewGroup container) {
        String str;
        Intrinsics.checkNotNullParameter(container, "container");
        AnimatorSet animatorSet = this.f4655d;
        C0249d c0249d = this.f4654c;
        if (animatorSet == null) {
            c0249d.getOperation().completeEffect(this);
            return;
        }
        SpecialEffectsController.Operation operation = c0249d.getOperation();
        if (operation.getIsSeeking()) {
            if (Build.VERSION.SDK_INT >= 26) {
                DefaultSpecialEffectsController.Api26Impl.INSTANCE.reverse(animatorSet);
            }
        } else {
            animatorSet.end();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder("Animator from operation ");
            sb.append(operation);
            sb.append(" has been canceled");
            if (operation.getIsSeeking()) {
                str = " with seeking.";
            } else {
                str = ".";
            }
            sb.append(str);
            sb.append(' ');
            Log.v(FragmentManager.TAG, sb.toString());
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onCommit(ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        C0249d c0249d = this.f4654c;
        SpecialEffectsController.Operation operation = c0249d.getOperation();
        AnimatorSet animatorSet = this.f4655d;
        if (animatorSet == null) {
            c0249d.getOperation().completeEffect(this);
            return;
        }
        animatorSet.start();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has started.");
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onProgress(BackEventCompat backEvent, ViewGroup container) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        Intrinsics.checkNotNullParameter(container, "container");
        C0249d c0249d = this.f4654c;
        SpecialEffectsController.Operation operation = c0249d.getOperation();
        AnimatorSet animatorSet = this.f4655d;
        if (animatorSet == null) {
            c0249d.getOperation().completeEffect(this);
            return;
        }
        if (Build.VERSION.SDK_INT >= 34 && operation.getFragment().f4460n) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Adding BackProgressCallbacks for Animators to operation " + operation);
            }
            long j = DefaultSpecialEffectsController.Api24Impl.INSTANCE.totalDuration(animatorSet);
            long progress = backEvent.getProgress() * ((float) j);
            if (progress == 0) {
                progress = 1;
            }
            if (progress == j) {
                progress = j - 1;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Setting currentPlayTime to " + progress + " for Animator " + animatorSet + " on operation " + operation);
            }
            DefaultSpecialEffectsController.Api26Impl.INSTANCE.setCurrentPlayTime(animatorSet, progress);
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController.Effect
    public final void onStart(final ViewGroup container) {
        AnimatorSet animatorSet;
        boolean z;
        Intrinsics.checkNotNullParameter(container, "container");
        C0249d c0249d = this.f4654c;
        if (c0249d.isVisibilityUnchanged()) {
            return;
        }
        Context context = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        C1540m9 m1223a = c0249d.m1223a(context);
        if (m1223a != null) {
            animatorSet = (AnimatorSet) m1223a.f22855c;
        } else {
            animatorSet = null;
        }
        this.f4655d = animatorSet;
        final SpecialEffectsController.Operation operation = c0249d.getOperation();
        Fragment fragment = operation.getFragment();
        if (operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
            z = true;
        } else {
            z = false;
        }
        final boolean z2 = z;
        final View view = fragment.f4428K;
        container.startViewTransition(view);
        AnimatorSet animatorSet2 = this.f4655d;
        if (animatorSet2 != null) {
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$AnimatorEffect$onStart$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator anim) {
                    Intrinsics.checkNotNullParameter(anim, "anim");
                    ViewGroup viewGroup = container;
                    View viewToAnimate = view;
                    viewGroup.endViewTransition(viewToAnimate);
                    boolean z3 = z2;
                    SpecialEffectsController.Operation operation2 = operation;
                    if (z3) {
                        SpecialEffectsController.Operation.State finalState = operation2.getFinalState();
                        Intrinsics.checkNotNullExpressionValue(viewToAnimate, "viewToAnimate");
                        finalState.applyState(viewToAnimate, viewGroup);
                    }
                    C0250e c0250e = this;
                    c0250e.f4654c.getOperation().completeEffect(c0250e);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has ended.");
                    }
                }
            });
        }
        AnimatorSet animatorSet3 = this.f4655d;
        if (animatorSet3 != null) {
            animatorSet3.setTarget(view);
        }
    }
}

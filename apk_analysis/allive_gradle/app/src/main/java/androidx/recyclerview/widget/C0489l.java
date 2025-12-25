package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.l */
/* loaded from: classes.dex */
public final class C0489l extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.ViewHolder f7430a;

    /* renamed from: b */
    public final /* synthetic */ View f7431b;

    /* renamed from: c */
    public final /* synthetic */ ViewPropertyAnimator f7432c;

    /* renamed from: d */
    public final /* synthetic */ DefaultItemAnimator f7433d;

    public C0489l(View view, ViewPropertyAnimator viewPropertyAnimator, DefaultItemAnimator defaultItemAnimator, RecyclerView.ViewHolder viewHolder) {
        this.f7433d = defaultItemAnimator;
        this.f7430a = viewHolder;
        this.f7431b = view;
        this.f7432c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f7431b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f7432c.setListener(null);
        DefaultItemAnimator defaultItemAnimator = this.f7433d;
        RecyclerView.ViewHolder viewHolder = this.f7430a;
        defaultItemAnimator.dispatchAddFinished(viewHolder);
        defaultItemAnimator.f6971o.remove(viewHolder);
        defaultItemAnimator.m1608c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f7433d.dispatchAddStarting(this.f7430a);
    }
}

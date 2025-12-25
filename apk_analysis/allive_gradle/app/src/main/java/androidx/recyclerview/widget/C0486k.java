package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.k */
/* loaded from: classes.dex */
public final class C0486k extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.ViewHolder f7418a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f7419b;

    /* renamed from: c */
    public final /* synthetic */ View f7420c;

    /* renamed from: d */
    public final /* synthetic */ DefaultItemAnimator f7421d;

    public C0486k(View view, ViewPropertyAnimator viewPropertyAnimator, DefaultItemAnimator defaultItemAnimator, RecyclerView.ViewHolder viewHolder) {
        this.f7421d = defaultItemAnimator;
        this.f7418a = viewHolder;
        this.f7419b = viewPropertyAnimator;
        this.f7420c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f7419b.setListener(null);
        this.f7420c.setAlpha(1.0f);
        DefaultItemAnimator defaultItemAnimator = this.f7421d;
        RecyclerView.ViewHolder viewHolder = this.f7418a;
        defaultItemAnimator.dispatchRemoveFinished(viewHolder);
        defaultItemAnimator.f6973q.remove(viewHolder);
        defaultItemAnimator.m1608c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f7421d.dispatchRemoveStarting(this.f7418a);
    }
}

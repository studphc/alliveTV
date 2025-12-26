package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.m */
/* loaded from: classes.dex */
public final class C0492m extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.ViewHolder f7438a;

    /* renamed from: b */
    public final /* synthetic */ int f7439b;

    /* renamed from: c */
    public final /* synthetic */ View f7440c;

    /* renamed from: d */
    public final /* synthetic */ int f7441d;

    /* renamed from: e */
    public final /* synthetic */ ViewPropertyAnimator f7442e;

    /* renamed from: f */
    public final /* synthetic */ DefaultItemAnimator f7443f;

    public C0492m(DefaultItemAnimator defaultItemAnimator, RecyclerView.ViewHolder viewHolder, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f7443f = defaultItemAnimator;
        this.f7438a = viewHolder;
        this.f7439b = i;
        this.f7440c = view;
        this.f7441d = i2;
        this.f7442e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.f7439b;
        View view = this.f7440c;
        if (i != 0) {
            view.setTranslationX(RecyclerView.f7068F0);
        }
        if (this.f7441d != 0) {
            view.setTranslationY(RecyclerView.f7068F0);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f7442e.setListener(null);
        DefaultItemAnimator defaultItemAnimator = this.f7443f;
        RecyclerView.ViewHolder viewHolder = this.f7438a;
        defaultItemAnimator.dispatchMoveFinished(viewHolder);
        defaultItemAnimator.f6972p.remove(viewHolder);
        defaultItemAnimator.m1608c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f7443f.dispatchMoveStarting(this.f7438a);
    }
}

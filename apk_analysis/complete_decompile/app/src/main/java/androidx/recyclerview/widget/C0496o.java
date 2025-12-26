package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.o */
/* loaded from: classes.dex */
public final class C0496o extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ C0498p f7449a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f7450b;

    /* renamed from: c */
    public final /* synthetic */ View f7451c;

    /* renamed from: d */
    public final /* synthetic */ DefaultItemAnimator f7452d;

    public C0496o(DefaultItemAnimator defaultItemAnimator, C0498p c0498p, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f7452d = defaultItemAnimator;
        this.f7449a = c0498p;
        this.f7450b = viewPropertyAnimator;
        this.f7451c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f7450b.setListener(null);
        View view = this.f7451c;
        view.setAlpha(1.0f);
        view.setTranslationX(RecyclerView.f7068F0);
        view.setTranslationY(RecyclerView.f7068F0);
        C0498p c0498p = this.f7449a;
        RecyclerView.ViewHolder viewHolder = c0498p.f7455b;
        DefaultItemAnimator defaultItemAnimator = this.f7452d;
        defaultItemAnimator.dispatchChangeFinished(viewHolder, false);
        defaultItemAnimator.f6974r.remove(c0498p.f7455b);
        defaultItemAnimator.m1608c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f7452d.dispatchChangeStarting(this.f7449a.f7455b, false);
    }
}

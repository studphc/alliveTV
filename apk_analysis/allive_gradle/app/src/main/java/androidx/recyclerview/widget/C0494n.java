package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.n */
/* loaded from: classes.dex */
public final class C0494n extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ C0498p f7444a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f7445b;

    /* renamed from: c */
    public final /* synthetic */ View f7446c;

    /* renamed from: d */
    public final /* synthetic */ DefaultItemAnimator f7447d;

    public C0494n(DefaultItemAnimator defaultItemAnimator, C0498p c0498p, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f7447d = defaultItemAnimator;
        this.f7444a = c0498p;
        this.f7445b = viewPropertyAnimator;
        this.f7446c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f7445b.setListener(null);
        View view = this.f7446c;
        view.setAlpha(1.0f);
        view.setTranslationX(RecyclerView.f7068F0);
        view.setTranslationY(RecyclerView.f7068F0);
        C0498p c0498p = this.f7444a;
        RecyclerView.ViewHolder viewHolder = c0498p.f7454a;
        DefaultItemAnimator defaultItemAnimator = this.f7447d;
        defaultItemAnimator.dispatchChangeFinished(viewHolder, true);
        defaultItemAnimator.f6974r.remove(c0498p.f7454a);
        defaultItemAnimator.m1608c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f7447d.dispatchChangeStarting(this.f7444a.f7454a, true);
    }
}

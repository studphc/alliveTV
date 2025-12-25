package p000;

import android.animation.Animator;
import androidx.leanback.R;
import androidx.leanback.app.BackgroundManager;

/* renamed from: he */
/* loaded from: classes.dex */
public final class C1266he implements Animator.AnimatorListener {

    /* renamed from: a */
    public final RunnableC1104d f18036a = new RunnableC1104d(6, this);

    /* renamed from: b */
    public final /* synthetic */ BackgroundManager f18037b;

    public C1266he(BackgroundManager backgroundManager) {
        this.f18037b = backgroundManager;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        BackgroundManager backgroundManager = this.f18037b;
        C1684pe c1684pe = backgroundManager.f4737o;
        if (c1684pe != null) {
            c1684pe.m6911a(R.id.background_imageout, backgroundManager.f4723a);
        }
        backgroundManager.f4724b.post(this.f18036a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}

package androidx.leanback.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.leanback.widget.GuidedActionsStylist;

/* renamed from: androidx.leanback.widget.e1 */
/* loaded from: classes.dex */
public final class C0330e1 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionsStylist.ViewHolder f6283a;

    public C0330e1(GuidedActionsStylist.ViewHolder viewHolder) {
        this.f6283a = viewHolder;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f6283a.f5818D = null;
    }
}

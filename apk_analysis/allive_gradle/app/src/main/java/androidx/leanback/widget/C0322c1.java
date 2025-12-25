package androidx.leanback.widget;

import androidx.leanback.transition.TransitionListener;

/* renamed from: androidx.leanback.widget.c1 */
/* loaded from: classes.dex */
public final class C0322c1 extends TransitionListener {

    /* renamed from: a */
    public final /* synthetic */ GuidedActionsStylist f6275a;

    public C0322c1(GuidedActionsStylist guidedActionsStylist) {
        this.f6275a = guidedActionsStylist;
    }

    @Override // androidx.leanback.transition.TransitionListener
    public final void onTransitionEnd(Object obj) {
        this.f6275a.f5811t = null;
    }
}

package androidx.appcompat.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* loaded from: classes.dex */
public class AbsActionBarView$VisibilityAnimListener implements ViewPropertyAnimatorListener {

    /* renamed from: a */
    public boolean f1015a = false;

    /* renamed from: b */
    public int f1016b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC0092a f1017c;

    public AbsActionBarView$VisibilityAnimListener(AbstractC0092a abstractC0092a) {
        this.f1017c = abstractC0092a;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        this.f1015a = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        if (this.f1015a) {
            return;
        }
        AbstractC0092a abstractC0092a = this.f1017c;
        abstractC0092a.mVisibilityAnim = null;
        super/*android.view.ViewGroup*/.setVisibility(this.f1016b);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.f1015a = false;
    }

    public AbsActionBarView$VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
        this.f1017c.mVisibilityAnim = viewPropertyAnimatorCompat;
        this.f1016b = i;
        return this;
    }
}

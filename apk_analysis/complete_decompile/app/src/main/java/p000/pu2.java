package p000;

import android.view.View;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class pu2 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f25307a;

    /* renamed from: b */
    public boolean f25308b;

    /* renamed from: c */
    public int f25309c;

    /* renamed from: d */
    public final /* synthetic */ Object f25310d;

    public pu2(ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet) {
        this.f25307a = 1;
        this.f25310d = viewPropertyAnimatorCompatSet;
        this.f25308b = false;
        this.f25309c = 0;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        switch (this.f25307a) {
            case 0:
                this.f25308b = true;
                return;
            default:
                super.onAnimationCancel(view);
                return;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        switch (this.f25307a) {
            case 0:
                if (!this.f25308b) {
                    ((ToolbarWidgetWrapper) this.f25310d).f1566a.setVisibility(this.f25309c);
                    return;
                }
                return;
            default:
                int i = this.f25309c + 1;
                this.f25309c = i;
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = (ViewPropertyAnimatorCompatSet) this.f25310d;
                if (i == viewPropertyAnimatorCompatSet.f809a.size()) {
                    ViewPropertyAnimatorListener viewPropertyAnimatorListener = viewPropertyAnimatorCompatSet.f812d;
                    if (viewPropertyAnimatorListener != null) {
                        viewPropertyAnimatorListener.onAnimationEnd(null);
                    }
                    this.f25309c = 0;
                    this.f25308b = false;
                    viewPropertyAnimatorCompatSet.f813e = false;
                    return;
                }
                return;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationStart(View view) {
        switch (this.f25307a) {
            case 0:
                ((ToolbarWidgetWrapper) this.f25310d).f1566a.setVisibility(0);
                return;
            default:
                if (!this.f25308b) {
                    this.f25308b = true;
                    ViewPropertyAnimatorListener viewPropertyAnimatorListener = ((ViewPropertyAnimatorCompatSet) this.f25310d).f812d;
                    if (viewPropertyAnimatorListener != null) {
                        viewPropertyAnimatorListener.onAnimationStart(null);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public pu2(ToolbarWidgetWrapper toolbarWidgetWrapper, int i) {
        this.f25307a = 0;
        this.f25310d = toolbarWidgetWrapper;
        this.f25309c = i;
        this.f25308b = false;
    }
}

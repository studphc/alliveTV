package p000;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* renamed from: t8 */
/* loaded from: classes.dex */
public final class C1826t8 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ int f26715a;

    /* renamed from: b */
    public final /* synthetic */ Object f26716b;

    public /* synthetic */ C1826t8(int i, Object obj) {
        this.f26715a = i;
        this.f26716b = obj;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        switch (this.f26715a) {
            case 0:
                RunnableC1863u8 runnableC1863u8 = (RunnableC1863u8) this.f26716b;
                runnableC1863u8.f27145a.f732v.setAlpha(1.0f);
                runnableC1863u8.f27145a.f735y.setListener(null);
                runnableC1863u8.f27145a.f735y = null;
                return;
            default:
                C1974x8 c1974x8 = (C1974x8) this.f26716b;
                c1974x8.f28463b.f732v.setVisibility(8);
                LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = c1974x8.f28463b;
                PopupWindow popupWindow = layoutInflaterFactory2C0084e.f733w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (layoutInflaterFactory2C0084e.f732v.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) c1974x8.f28463b.f732v.getParent());
                }
                c1974x8.f28463b.f732v.killMode();
                c1974x8.f28463b.f735y.setListener(null);
                LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e2 = c1974x8.f28463b;
                layoutInflaterFactory2C0084e2.f735y = null;
                ViewCompat.requestApplyInsets(layoutInflaterFactory2C0084e2.f687B);
                return;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        switch (this.f26715a) {
            case 0:
                ((RunnableC1863u8) this.f26716b).f27145a.f732v.setVisibility(0);
                return;
            default:
                super.onAnimationStart(view);
                return;
        }
    }
}

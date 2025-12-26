package p000;

import android.view.View;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* renamed from: v8 */
/* loaded from: classes.dex */
public final class C1900v8 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f27667a;

    public C1900v8(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        this.f27667a = layoutInflaterFactory2C0084e;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f27667a;
        layoutInflaterFactory2C0084e.f732v.setAlpha(1.0f);
        layoutInflaterFactory2C0084e.f735y.setListener(null);
        layoutInflaterFactory2C0084e.f735y = null;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationStart(View view) {
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f27667a;
        layoutInflaterFactory2C0084e.f732v.setVisibility(0);
        if (layoutInflaterFactory2C0084e.f732v.getParent() instanceof View) {
            ViewCompat.requestApplyInsets((View) layoutInflaterFactory2C0084e.f732v.getParent());
        }
    }
}

package p000;

import androidx.appcompat.app.LayoutInflaterFactory2C0084e;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* renamed from: s8 */
/* loaded from: classes.dex */
public final class C1789s8 implements ContentFrameLayout.OnAttachListener {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f26312a;

    public C1789s8(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        this.f26312a = layoutInflaterFactory2C0084e;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public final void onDetachedFromWindow() {
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f26312a;
        DecorContentParent decorContentParent = layoutInflaterFactory2C0084e.f728r;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (layoutInflaterFactory2C0084e.f733w != null) {
            layoutInflaterFactory2C0084e.f722l.getDecorView().removeCallbacks(layoutInflaterFactory2C0084e.f734x);
            if (layoutInflaterFactory2C0084e.f733w.isShowing()) {
                try {
                    layoutInflaterFactory2C0084e.f733w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            layoutInflaterFactory2C0084e.f733w = null;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = layoutInflaterFactory2C0084e.f735y;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        MenuBuilder menuBuilder = layoutInflaterFactory2C0084e.m190t(0).f610h;
        if (menuBuilder != null) {
            menuBuilder.close();
        }
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
    public final void onAttachedFromWindow() {
    }
}

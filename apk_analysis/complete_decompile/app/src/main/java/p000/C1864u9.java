package p000;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* renamed from: u9 */
/* loaded from: classes.dex */
public final class C1864u9 implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    public final /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC1933w4 f27152a;

    /* renamed from: b */
    public final /* synthetic */ C1901v9 f27153b;

    public C1864u9(C1901v9 c1901v9, ViewTreeObserverOnGlobalLayoutListenerC1933w4 viewTreeObserverOnGlobalLayoutListenerC1933w4) {
        this.f27153b = c1901v9;
        this.f27152a = viewTreeObserverOnGlobalLayoutListenerC1933w4;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f27153b.f27675N.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f27152a);
        }
    }
}

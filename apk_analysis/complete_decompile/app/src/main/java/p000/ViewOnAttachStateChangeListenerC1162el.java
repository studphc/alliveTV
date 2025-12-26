package p000;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.ViewOnKeyListenerC0088b;
import androidx.appcompat.view.menu.ViewOnKeyListenerC0091e;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.ViewTarget;

/* renamed from: el */
/* loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC1162el implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final /* synthetic */ int f16862a;

    /* renamed from: b */
    public final /* synthetic */ Object f16863b;

    public /* synthetic */ ViewOnAttachStateChangeListenerC1162el(int i, Object obj) {
        this.f16862a = i;
        this.f16863b = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.f16862a) {
            case 0:
                return;
            case 1:
                Request request = ((CustomViewTarget) this.f16863b).getRequest();
                if (request != null && request.isCleared()) {
                    request.begin();
                    return;
                }
                return;
            case 2:
                View view2 = (View) this.f16863b;
                view2.removeOnAttachStateChangeListener(this);
                ViewCompat.requestApplyInsets(view2);
                return;
            case 3:
                return;
            default:
                Request request2 = ((ViewTarget) this.f16863b).getRequest();
                if (request2 != null && request2.isCleared()) {
                    request2.begin();
                    return;
                }
                return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f16862a) {
            case 0:
                ViewOnKeyListenerC0088b viewOnKeyListenerC0088b = (ViewOnKeyListenerC0088b) this.f16863b;
                ViewTreeObserver viewTreeObserver = viewOnKeyListenerC0088b.f987y;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        viewOnKeyListenerC0088b.f987y = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC0088b.f987y.removeGlobalOnLayoutListener(viewOnKeyListenerC0088b.f972j);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            case 1:
                CustomViewTarget customViewTarget = (CustomViewTarget) this.f16863b;
                Request request = customViewTarget.getRequest();
                if (request != null) {
                    customViewTarget.f9107c = true;
                    request.clear();
                    customViewTarget.f9107c = false;
                    return;
                }
                return;
            case 2:
                return;
            case 3:
                ViewOnKeyListenerC0091e viewOnKeyListenerC0091e = (ViewOnKeyListenerC0091e) this.f16863b;
                ViewTreeObserver viewTreeObserver2 = viewOnKeyListenerC0091e.f1009p;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        viewOnKeyListenerC0091e.f1009p = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC0091e.f1009p.removeGlobalOnLayoutListener(viewOnKeyListenerC0091e.f1003j);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            default:
                ViewTarget viewTarget = (ViewTarget) this.f16863b;
                Request request2 = viewTarget.getRequest();
                if (request2 != null) {
                    viewTarget.f9130d = true;
                    request2.clear();
                    viewTarget.f9130d = false;
                    return;
                }
                return;
        }
    }

    /* renamed from: a */
    private final void m4720a(View view) {
    }

    /* renamed from: b */
    private final void m4721b(View view) {
    }

    /* renamed from: c */
    private final void m4722c(View view) {
    }
}

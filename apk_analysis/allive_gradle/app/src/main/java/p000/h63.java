package p000;

import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsAnimationControllerCompat;

/* loaded from: classes.dex */
public final class h63 implements WindowInsetsAnimationControlListener {

    /* renamed from: a */
    public WindowInsetsAnimationControllerCompat f17956a = null;

    /* renamed from: b */
    public final /* synthetic */ WindowInsetsAnimationControlListenerCompat f17957b;

    public h63(WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.f17957b = windowInsetsAnimationControlListenerCompat;
    }

    public final void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat;
        WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat = this.f17957b;
        if (windowInsetsAnimationController == null) {
            windowInsetsAnimationControllerCompat = null;
        } else {
            windowInsetsAnimationControllerCompat = this.f17956a;
        }
        windowInsetsAnimationControlListenerCompat.onCancelled(windowInsetsAnimationControllerCompat);
    }

    public final void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.f17957b.onFinished(this.f17956a);
    }

    public final void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
        this.f17956a = windowInsetsAnimationControllerCompat;
        this.f17957b.onReady(windowInsetsAnimationControllerCompat, i);
    }
}

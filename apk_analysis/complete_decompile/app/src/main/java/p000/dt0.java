package p000;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.ForwardingListener;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class dt0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16534a;

    /* renamed from: b */
    public final /* synthetic */ ForwardingListener f16535b;

    public /* synthetic */ dt0(ForwardingListener forwardingListener, int i) {
        this.f16534a = i;
        this.f16535b = forwardingListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16534a) {
            case 0:
                ViewParent parent = this.f16535b.f1257d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                return;
            default:
                ForwardingListener forwardingListener = this.f16535b;
                forwardingListener.m248a();
                View view = forwardingListener.f1257d;
                if (view.isEnabled() && !view.isLongClickable() && forwardingListener.onForwardingStarted()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, RecyclerView.f7068F0, RecyclerView.f7068F0, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    forwardingListener.f1260g = true;
                    return;
                }
                return;
        }
    }
}

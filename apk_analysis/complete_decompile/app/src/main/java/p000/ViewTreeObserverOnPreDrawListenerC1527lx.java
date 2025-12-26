package p000;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bumptech.glide.request.target.SizeReadyCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: lx */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC1527lx implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    public final /* synthetic */ int f22700a = 0;

    /* renamed from: b */
    public final WeakReference f22701b;

    public ViewTreeObserverOnPreDrawListenerC1527lx(C1564mx c1564mx) {
        this.f22701b = new WeakReference(c1564mx);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        int i;
        int i2;
        switch (this.f22700a) {
            case 0:
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                C1564mx c1564mx = (C1564mx) this.f22701b.get();
                if (c1564mx != null) {
                    ArrayList arrayList = c1564mx.f23149b;
                    if (!arrayList.isEmpty()) {
                        View view = c1564mx.f23148a;
                        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        int i3 = 0;
                        if (layoutParams != null) {
                            i = layoutParams.width;
                        } else {
                            i = 0;
                        }
                        int m6261a = c1564mx.m6261a(view.getWidth(), i, paddingRight);
                        int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                        if (layoutParams2 != null) {
                            i3 = layoutParams2.height;
                        }
                        int m6261a2 = c1564mx.m6261a(view.getHeight(), i3, paddingBottom);
                        if (m6261a > 0 || m6261a == Integer.MIN_VALUE) {
                            if (m6261a2 > 0 || m6261a2 == Integer.MIN_VALUE) {
                                Iterator it = new ArrayList(arrayList).iterator();
                                while (it.hasNext()) {
                                    ((SizeReadyCallback) it.next()).onSizeReady(m6261a, m6261a2);
                                }
                                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(c1564mx.f23151d);
                                }
                                c1564mx.f23151d = null;
                                arrayList.clear();
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            default:
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                y33 y33Var = (y33) this.f22701b.get();
                if (y33Var != null) {
                    ArrayList arrayList2 = y33Var.f28826b;
                    if (!arrayList2.isEmpty()) {
                        View view2 = y33Var.f28825a;
                        int paddingRight2 = view2.getPaddingRight() + view2.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
                        int i4 = 0;
                        if (layoutParams3 != null) {
                            i2 = layoutParams3.width;
                        } else {
                            i2 = 0;
                        }
                        int m8216a = y33Var.m8216a(view2.getWidth(), i2, paddingRight2);
                        int paddingBottom2 = view2.getPaddingBottom() + view2.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams4 = view2.getLayoutParams();
                        if (layoutParams4 != null) {
                            i4 = layoutParams4.height;
                        }
                        int m8216a2 = y33Var.m8216a(view2.getHeight(), i4, paddingBottom2);
                        if (m8216a > 0 || m8216a == Integer.MIN_VALUE) {
                            if (m8216a2 > 0 || m8216a2 == Integer.MIN_VALUE) {
                                Iterator it2 = new ArrayList(arrayList2).iterator();
                                while (it2.hasNext()) {
                                    ((SizeReadyCallback) it2.next()).onSizeReady(m8216a, m8216a2);
                                }
                                ViewTreeObserver viewTreeObserver2 = view2.getViewTreeObserver();
                                if (viewTreeObserver2.isAlive()) {
                                    viewTreeObserver2.removeOnPreDrawListener(y33Var.f28828d);
                                }
                                y33Var.f28828d = null;
                                arrayList2.clear();
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
        }
    }

    public ViewTreeObserverOnPreDrawListenerC1527lx(y33 y33Var) {
        this.f22701b = new WeakReference(y33Var);
    }
}

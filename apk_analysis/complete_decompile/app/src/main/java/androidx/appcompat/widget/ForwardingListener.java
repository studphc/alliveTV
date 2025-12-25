package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.recyclerview.widget.RecyclerView;
import p000.dt0;
import p000.e70;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final float f1254a;

    /* renamed from: b */
    public final int f1255b;

    /* renamed from: c */
    public final int f1256c;

    /* renamed from: d */
    public final View f1257d;

    /* renamed from: e */
    public dt0 f1258e;

    /* renamed from: f */
    public dt0 f1259f;

    /* renamed from: g */
    public boolean f1260g;

    /* renamed from: h */
    public int f1261h;

    /* renamed from: i */
    public final int[] f1262i = new int[2];

    public ForwardingListener(View view) {
        this.f1257d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1254a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1255b = tapTimeout;
        this.f1256c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    /* renamed from: a */
    public final void m248a() {
        dt0 dt0Var = this.f1259f;
        View view = this.f1257d;
        if (dt0Var != null) {
            view.removeCallbacks(dt0Var);
        }
        dt0 dt0Var2 = this.f1258e;
        if (dt0Var2 != null) {
            view.removeCallbacks(dt0Var2);
        }
    }

    public abstract ShowableListMenu getPopup();

    public boolean onForwardingStarted() {
        ShowableListMenu popup = getPopup();
        if (popup != null && !popup.isShowing()) {
            popup.show();
            return true;
        }
        return true;
    }

    public boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup != null && popup.isShowing()) {
            popup.dismiss();
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        if (r14 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
    
        if (r4 != 3) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0102  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        e70 e70Var;
        boolean z2;
        boolean z3 = this.f1260g;
        View view2 = this.f1257d;
        if (z3) {
            ShowableListMenu popup = getPopup();
            if (popup != null && popup.isShowing() && (e70Var = (e70) popup.getListView()) != null && e70Var.isShown()) {
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.f1262i;
                view2.getLocationOnScreen(iArr);
                obtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                e70Var.getLocationOnScreen(iArr);
                obtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean onForwardedEvent = e70Var.onForwardedEvent(obtainNoHistory, this.f1261h);
                obtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 1 && actionMasked != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (onForwardedEvent) {
                }
            }
            if (onForwardingStopped()) {
                z = false;
            }
            z = true;
        } else {
            if (view2.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 != 0) {
                    if (actionMasked2 != 1) {
                        if (actionMasked2 == 2) {
                            int findPointerIndex = motionEvent.findPointerIndex(this.f1261h);
                            if (findPointerIndex >= 0) {
                                float x = motionEvent.getX(findPointerIndex);
                                float y = motionEvent.getY(findPointerIndex);
                                float f = this.f1254a;
                                float f2 = -f;
                                if (x < f2 || y < f2 || x >= (view2.getRight() - view2.getLeft()) + f || y >= (view2.getBottom() - view2.getTop()) + f) {
                                    m248a();
                                    view2.getParent().requestDisallowInterceptTouchEvent(true);
                                    if (onForwardingStarted()) {
                                        z = true;
                                        if (z) {
                                            long uptimeMillis = SystemClock.uptimeMillis();
                                            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, RecyclerView.f7068F0, RecyclerView.f7068F0, 0);
                                            view2.onTouchEvent(obtain);
                                            obtain.recycle();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    m248a();
                } else {
                    this.f1261h = motionEvent.getPointerId(0);
                    if (this.f1258e == null) {
                        this.f1258e = new dt0(this, 0);
                    }
                    view2.postDelayed(this.f1258e, this.f1255b);
                    if (this.f1259f == null) {
                        this.f1259f = new dt0(this, 1);
                    }
                    view2.postDelayed(this.f1259f, this.f1256c);
                }
            }
            z = false;
            if (z) {
            }
        }
        this.f1260g = z;
        if (z || z3) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1260g = false;
        this.f1261h = -1;
        dt0 dt0Var = this.f1258e;
        if (dt0Var != null) {
            this.f1257d.removeCallbacks(dt0Var);
        }
    }
}

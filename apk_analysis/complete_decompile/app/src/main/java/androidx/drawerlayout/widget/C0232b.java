package androidx.drawerlayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import p000.RunnableC1104d;

/* renamed from: androidx.drawerlayout.widget.b */
/* loaded from: classes.dex */
public final class C0232b extends ViewDragHelper.Callback {

    /* renamed from: a */
    public final int f4175a;

    /* renamed from: b */
    public ViewDragHelper f4176b;

    /* renamed from: c */
    public final RunnableC1104d f4177c = new RunnableC1104d(14, this);

    /* renamed from: d */
    public final /* synthetic */ DrawerLayout f4178d;

    public C0232b(DrawerLayout drawerLayout, int i) {
        this.f4178d = drawerLayout;
        this.f4175a = i;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionHorizontal(View view, int i, int i2) {
        DrawerLayout drawerLayout = this.f4178d;
        if (drawerLayout.m1049a(3, view)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = drawerLayout.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int clampViewPositionVertical(View view, int i, int i2) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final int getViewHorizontalDragRange(View view) {
        this.f4178d.getClass();
        if (DrawerLayout.m1048i(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onEdgeDragStarted(int i, int i2) {
        View m1051c;
        int i3 = i & 1;
        DrawerLayout drawerLayout = this.f4178d;
        if (i3 == 1) {
            m1051c = drawerLayout.m1051c(3);
        } else {
            m1051c = drawerLayout.m1051c(5);
        }
        if (m1051c != null && drawerLayout.getDrawerLockMode(m1051c) == 0) {
            this.f4176b.captureChildView(m1051c, i2);
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean onEdgeLock(int i) {
        return false;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onEdgeTouched(int i, int i2) {
        this.f4178d.postDelayed(this.f4177c, 160L);
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewCaptured(View view, int i) {
        ((DrawerLayout.LayoutParams) view.getLayoutParams()).f4168b = false;
        int i2 = 3;
        if (this.f4175a == 3) {
            i2 = 5;
        }
        DrawerLayout drawerLayout = this.f4178d;
        View m1051c = drawerLayout.m1051c(i2);
        if (m1051c != null) {
            drawerLayout.closeDrawer(m1051c);
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewDragStateChanged(int i) {
        this.f4178d.m1058m(i, this.f4176b.getCapturedView());
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        float width;
        int i5;
        int width2 = view.getWidth();
        DrawerLayout drawerLayout = this.f4178d;
        if (drawerLayout.m1049a(3, view)) {
            width = i + width2;
        } else {
            width = drawerLayout.getWidth() - i;
        }
        float f = width / width2;
        drawerLayout.m1056k(view, f);
        if (f == RecyclerView.f7068F0) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        view.setVisibility(i5);
        drawerLayout.invalidate();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final void onViewReleased(View view, float f, float f2) {
        int i;
        DrawerLayout drawerLayout = this.f4178d;
        drawerLayout.getClass();
        float f3 = ((DrawerLayout.LayoutParams) view.getLayoutParams()).f4167a;
        int width = view.getWidth();
        if (drawerLayout.m1049a(3, view)) {
            if (f <= RecyclerView.f7068F0 && (f != RecyclerView.f7068F0 || f3 <= 0.5f)) {
                i = -width;
            } else {
                i = 0;
            }
        } else {
            int width2 = drawerLayout.getWidth();
            if (f < RecyclerView.f7068F0 || (f == RecyclerView.f7068F0 && f3 > 0.5f)) {
                width2 -= width;
            }
            i = width2;
        }
        this.f4176b.settleCapturedViewAt(i, view.getTop());
        drawerLayout.invalidate();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public final boolean tryCaptureView(View view, int i) {
        DrawerLayout drawerLayout = this.f4178d;
        drawerLayout.getClass();
        if (DrawerLayout.m1048i(view) && drawerLayout.m1049a(this.f4175a, view) && drawerLayout.getDrawerLockMode(view) == 0) {
            return true;
        }
        return false;
    }
}

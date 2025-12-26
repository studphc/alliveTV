package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.ControlBar;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.m */
/* loaded from: classes.dex */
public final class C0360m implements ControlBar.OnChildFocusedListener {

    /* renamed from: a */
    public final /* synthetic */ C0372p f6322a;

    public C0360m(C0372p c0372p) {
        this.f6322a = c0372p;
    }

    @Override // androidx.leanback.widget.ControlBar.OnChildFocusedListener
    public final void onChildFocusedListener(View view, View view2) {
        C0372p c0372p = this.f6322a;
        if (c0372p.f6342i.f6395c == null) {
            return;
        }
        for (int i = 0; i < c0372p.f6340g.size(); i++) {
            if (((Presenter.ViewHolder) c0372p.f6340g.get(i)).view == view) {
                c0372p.f6342i.f6395c.mo1495a((Presenter.ViewHolder) c0372p.f6340g.get(i), c0372p.mo1502c().get(i), c0372p.f6336c);
                return;
            }
        }
    }
}

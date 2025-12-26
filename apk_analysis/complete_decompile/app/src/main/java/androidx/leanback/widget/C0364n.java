package androidx.leanback.widget;

import androidx.leanback.widget.ObjectAdapter;

/* renamed from: androidx.leanback.widget.n */
/* loaded from: classes.dex */
public final class C0364n extends ObjectAdapter.DataObserver {

    /* renamed from: a */
    public final /* synthetic */ C0372p f6326a;

    public C0364n(C0372p c0372p) {
        this.f6326a = c0372p;
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onChanged() {
        C0372p c0372p = this.f6326a;
        if (c0372p.f6335b == c0372p.mo1502c()) {
            c0372p.m1503d(c0372p.f6337d);
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeChanged(int i, int i2) {
        C0372p c0372p = this.f6326a;
        if (c0372p.f6335b == c0372p.mo1502c()) {
            for (int i3 = 0; i3 < i2; i3++) {
                c0372p.m1500a(i + i3, c0372p.mo1502c(), c0372p.f6337d);
            }
        }
    }
}

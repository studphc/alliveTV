package androidx.leanback.widget;

import androidx.leanback.widget.ObjectAdapter;

/* renamed from: androidx.leanback.widget.y1 */
/* loaded from: classes.dex */
public final class C0409y1 extends ObjectAdapter.DataObserver {

    /* renamed from: a */
    public final /* synthetic */ C0413z1 f6441a;

    public C0409y1(C0413z1 c0413z1) {
        this.f6441a = c0413z1;
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onChanged() {
        C0413z1 c0413z1 = this.f6441a;
        if (c0413z1.f6450n) {
            c0413z1.m1503d(c0413z1.f6337d);
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeChanged(int i, int i2) {
        C0413z1 c0413z1 = this.f6441a;
        if (c0413z1.f6450n) {
            for (int i3 = 0; i3 < i2; i3++) {
                c0413z1.m1500a(i + i3, c0413z1.mo1502c(), c0413z1.f6337d);
            }
        }
    }
}

package p000;

import androidx.leanback.widget.ObjectAdapter;

/* loaded from: classes.dex */
public final class t91 extends ObjectAdapter.DataObserver {

    /* renamed from: a */
    public final /* synthetic */ u91 f26728a;

    public t91(u91 u91Var) {
        this.f26728a = u91Var;
    }

    /* renamed from: a */
    public final void m7467a(int i, int i2, int i3) {
        u91 u91Var = this.f26728a;
        if (i != 2) {
            if (i != 4) {
                if (i != 8) {
                    if (i == 16) {
                        u91Var.notifyChanged();
                        return;
                    } else {
                        u91Var.getClass();
                        throw new IllegalArgumentException(ye0.m8291k(i, "Invalid event type "));
                    }
                }
                u91Var.notifyItemRangeRemoved(i2, i3);
                return;
            }
            u91Var.notifyItemRangeInserted(i2, i3);
            return;
        }
        u91Var.notifyItemRangeChanged(i2, i3);
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onChanged() {
        this.f26728a.m7683a();
        m7467a(16, -1, -1);
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeChanged(int i, int i2) {
        int i3 = this.f26728a.f27155e;
        if (i <= i3) {
            m7467a(2, i, Math.min(i2, (i3 - i) + 1));
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeInserted(int i, int i2) {
        u91 u91Var = this.f26728a;
        int i3 = u91Var.f27155e;
        if (i <= i3) {
            u91Var.f27155e = i3 + i2;
            m7467a(4, i, i2);
            return;
        }
        u91Var.m7683a();
        int i4 = u91Var.f27155e;
        if (i4 > i3) {
            m7467a(4, i3 + 1, i4 - i3);
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeRemoved(int i, int i2) {
        int i3 = (i + i2) - 1;
        u91 u91Var = this.f26728a;
        int i4 = u91Var.f27155e;
        if (i3 < i4) {
            u91Var.f27155e = i4 - i2;
            m7467a(8, i, i2);
            return;
        }
        u91Var.m7683a();
        int i5 = u91Var.f27155e;
        int i6 = i4 - i5;
        if (i6 > 0) {
            m7467a(8, Math.min(i5 + 1, i), i6);
        }
    }
}

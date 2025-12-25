package androidx.recyclerview.widget;

import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.j0 */
/* loaded from: classes.dex */
public final class C0484j0 extends RecyclerView.AdapterDataObserver {

    /* renamed from: a */
    public final /* synthetic */ C0487k0 f7413a;

    public C0484j0(C0487k0 c0487k0) {
        this.f7413a = c0487k0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        C0487k0 c0487k0 = this.f7413a;
        c0487k0.f7426e = c0487k0.f7424c.getItemCount();
        C0477h c0477h = c0487k0.f7425d;
        c0477h.f7394a.notifyDataSetChanged();
        c0477h.m1855b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i2) {
        C0487k0 c0487k0 = this.f7413a;
        C0477h c0477h = c0487k0.f7425d;
        c0477h.f7394a.notifyItemRangeChanged(i + c0477h.m1856c(c0487k0), i2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i, int i2) {
        C0487k0 c0487k0 = this.f7413a;
        c0487k0.f7426e += i2;
        C0477h c0477h = c0487k0.f7425d;
        c0477h.f7394a.notifyItemRangeInserted(i + c0477h.m1856c(c0487k0), i2);
        if (c0487k0.f7426e > 0 && c0487k0.f7424c.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
            c0477h.m1855b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int i, int i2, int i3) {
        boolean z = true;
        if (i3 != 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "moving more than 1 item is not supported in RecyclerView");
        C0487k0 c0487k0 = this.f7413a;
        C0477h c0477h = c0487k0.f7425d;
        int m1856c = c0477h.m1856c(c0487k0);
        c0477h.f7394a.notifyItemMoved(i + m1856c, i2 + m1856c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int i, int i2) {
        C0487k0 c0487k0 = this.f7413a;
        c0487k0.f7426e -= i2;
        C0477h c0477h = c0487k0.f7425d;
        c0477h.f7394a.notifyItemRangeRemoved(i + c0477h.m1856c(c0487k0), i2);
        if (c0487k0.f7426e < 1 && c0487k0.f7424c.getStateRestorationPolicy() == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY) {
            c0477h.m1855b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onStateRestorationPolicyChanged() {
        this.f7413a.f7425d.m1855b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int i, int i2, Object obj) {
        C0487k0 c0487k0 = this.f7413a;
        C0477h c0477h = c0487k0.f7425d;
        c0477h.f7394a.notifyItemRangeChanged(i + c0477h.m1856c(c0487k0), i2, obj);
    }
}

package p000;

import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: pf */
/* loaded from: classes.dex */
public final class C1685pf extends RecyclerView.AdapterDataObserver {

    /* renamed from: a */
    public boolean f25143a = false;

    /* renamed from: b */
    public final /* synthetic */ AbstractFragmentC1722qf f25144b;

    public C1685pf(AbstractFragmentC1722qf abstractFragmentC1722qf) {
        this.f25144b = abstractFragmentC1722qf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        boolean z = this.f25143a;
        AbstractFragmentC1722qf abstractFragmentC1722qf = this.f25144b;
        if (z) {
            this.f25143a = false;
            abstractFragmentC1722qf.f25563d.unregisterAdapterDataObserver(this);
        }
        VerticalGridView verticalGridView = abstractFragmentC1722qf.f25561b;
        if (verticalGridView != null) {
            verticalGridView.setSelectedPosition(abstractFragmentC1722qf.f25564e);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i, int i2) {
        boolean z = this.f25143a;
        AbstractFragmentC1722qf abstractFragmentC1722qf = this.f25144b;
        if (z) {
            this.f25143a = false;
            abstractFragmentC1722qf.f25563d.unregisterAdapterDataObserver(this);
        }
        VerticalGridView verticalGridView = abstractFragmentC1722qf.f25561b;
        if (verticalGridView != null) {
            verticalGridView.setSelectedPosition(abstractFragmentC1722qf.f25564e);
        }
    }
}

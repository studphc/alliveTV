package p000;

import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: sf */
/* loaded from: classes.dex */
public final class C1796sf extends RecyclerView.AdapterDataObserver {

    /* renamed from: a */
    public boolean f26401a = false;

    /* renamed from: b */
    public final /* synthetic */ AbstractC1833tf f26402b;

    public C1796sf(AbstractC1833tf abstractC1833tf) {
        this.f26402b = abstractC1833tf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        boolean z = this.f26401a;
        AbstractC1833tf abstractC1833tf = this.f26402b;
        if (z) {
            this.f26401a = false;
            abstractC1833tf.f26795h0.unregisterAdapterDataObserver(this);
        }
        VerticalGridView verticalGridView = abstractC1833tf.f26793f0;
        if (verticalGridView != null) {
            verticalGridView.setSelectedPosition(abstractC1833tf.f26796i0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int i, int i2) {
        boolean z = this.f26401a;
        AbstractC1833tf abstractC1833tf = this.f26402b;
        if (z) {
            this.f26401a = false;
            abstractC1833tf.f26795h0.unregisterAdapterDataObserver(this);
        }
        VerticalGridView verticalGridView = abstractC1833tf.f26793f0;
        if (verticalGridView != null) {
            verticalGridView.setSelectedPosition(abstractC1833tf.f26796i0);
        }
    }
}

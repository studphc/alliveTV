package androidx.leanback.widget;

import androidx.leanback.widget.ObjectAdapter;

/* renamed from: androidx.leanback.widget.h1 */
/* loaded from: classes.dex */
public final class C0342h1 extends ObjectAdapter.DataObserver {

    /* renamed from: a */
    public final /* synthetic */ ItemBridgeAdapter f6303a;

    public C0342h1(ItemBridgeAdapter itemBridgeAdapter) {
        this.f6303a = itemBridgeAdapter;
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onChanged() {
        this.f6303a.notifyDataSetChanged();
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemMoved(int i, int i2) {
        this.f6303a.notifyItemMoved(i, i2);
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeChanged(int i, int i2) {
        this.f6303a.notifyItemRangeChanged(i, i2);
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeInserted(int i, int i2) {
        this.f6303a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeRemoved(int i, int i2) {
        this.f6303a.notifyItemRangeRemoved(i, i2);
    }

    @Override // androidx.leanback.widget.ObjectAdapter.DataObserver
    public final void onItemRangeChanged(int i, int i2, Object obj) {
        this.f6303a.notifyItemRangeChanged(i, i2, obj);
    }
}

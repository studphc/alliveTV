package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a */
    public final RecyclerView.Adapter f6921a;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.f6921a = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i, int i2, Object obj) {
        this.f6921a.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.f6921a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.f6921a.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.f6921a.notifyItemRangeRemoved(i, i2);
    }
}

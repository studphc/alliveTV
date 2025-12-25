package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

/* loaded from: classes.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {

    /* renamed from: a */
    public final RecyclerView.Adapter f7265a;

    public SortedListAdapterCallback(@SuppressLint({"UnknownNullness", "MissingNullability"}) RecyclerView.Adapter<?> adapter) {
        this.f7265a = adapter;
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback
    public void onChanged(int i, int i2) {
        this.f7265a.notifyItemRangeChanged(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.f7265a.notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        this.f7265a.notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.f7265a.notifyItemRangeRemoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i, int i2, Object obj) {
        this.f7265a.notifyItemRangeChanged(i, i2, obj);
    }
}

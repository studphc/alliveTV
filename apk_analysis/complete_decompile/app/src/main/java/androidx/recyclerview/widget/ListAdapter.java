package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: d */
    public final AsyncListDiffer f7060d;

    public ListAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        C0481i0 c0481i0 = new C0481i0(this);
        AsyncListDiffer asyncListDiffer = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).build());
        this.f7060d = asyncListDiffer;
        asyncListDiffer.addListListener(c0481i0);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.f7060d.getCurrentList();
    }

    public T getItem(int i) {
        return this.f7060d.getCurrentList().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f7060d.getCurrentList().size();
    }

    public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
    }

    public void submitList(@Nullable List<T> list) {
        this.f7060d.submitList(list);
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        this.f7060d.submitList(list, runnable);
    }

    public ListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        C0481i0 c0481i0 = new C0481i0(this);
        AsyncListDiffer asyncListDiffer = new AsyncListDiffer(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.f7060d = asyncListDiffer;
        asyncListDiffer.addListListener(c0481i0);
    }
}

package p000;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.collection.LruCache;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: jf */
/* loaded from: classes.dex */
public final class C1352jf implements RecyclerView.RecyclerListener {

    /* renamed from: a */
    public final /* synthetic */ BaseGridView f20486a;

    public C1352jf(BaseGridView baseGridView) {
        this.f20486a = baseGridView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        GridLayoutManager gridLayoutManager = this.f20486a.f5584M0;
        gridLayoutManager.getClass();
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition != -1) {
            View view = viewHolder.itemView;
            C1617oc c1617oc = gridLayoutManager.f5708i0;
            int i = c1617oc.f23759a;
            if (i != 1) {
                if ((i == 2 || i == 3) && ((LruCache) c1617oc.f23761c) != null) {
                    String num = Integer.toString(absoluteAdapterPosition);
                    SparseArray<Parcelable> sparseArray = new SparseArray<>();
                    view.saveHierarchyState(sparseArray);
                    ((LruCache) c1617oc.f23761c).put(num, sparseArray);
                    return;
                }
                return;
            }
            LruCache lruCache = (LruCache) c1617oc.f23761c;
            if (lruCache != null && lruCache.size() != 0) {
                ((LruCache) c1617oc.f23761c).remove(Integer.toString(absoluteAdapterPosition));
            }
        }
    }
}

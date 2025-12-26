package androidx.recyclerview.widget;

import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import p000.C1487ku;
import p000.ye0;

/* loaded from: classes.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: d */
    public final C0477h f6959d;

    /* loaded from: classes.dex */
    public static final class Config {

        @NonNull
        public static final Config DEFAULT = new Config(true, StableIdMode.NO_STABLE_IDS);
        public final boolean isolateViewTypes;

        @NonNull
        public final StableIdMode stableIdMode;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public boolean f6960a;

            /* renamed from: b */
            public StableIdMode f6961b;

            public Builder() {
                Config config = Config.DEFAULT;
                this.f6960a = config.isolateViewTypes;
                this.f6961b = config.stableIdMode;
            }

            @NonNull
            public Config build() {
                return new Config(this.f6960a, this.f6961b);
            }

            @NonNull
            public Builder setIsolateViewTypes(boolean z) {
                this.f6960a = z;
                return this;
            }

            @NonNull
            public Builder setStableIdMode(@NonNull StableIdMode stableIdMode) {
                this.f6961b = stableIdMode;
                return this;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* loaded from: classes.dex */
        public static final class StableIdMode {
            public static final StableIdMode ISOLATED_STABLE_IDS;
            public static final StableIdMode NO_STABLE_IDS;
            public static final StableIdMode SHARED_STABLE_IDS;

            /* renamed from: a */
            public static final /* synthetic */ StableIdMode[] f6962a;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode] */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode] */
            /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode] */
            static {
                ?? r3 = new Enum("NO_STABLE_IDS", 0);
                NO_STABLE_IDS = r3;
                ?? r4 = new Enum("ISOLATED_STABLE_IDS", 1);
                ISOLATED_STABLE_IDS = r4;
                ?? r5 = new Enum("SHARED_STABLE_IDS", 2);
                SHARED_STABLE_IDS = r5;
                f6962a = new StableIdMode[]{r3, r4, r5};
            }

            public static StableIdMode valueOf(String str) {
                return (StableIdMode) Enum.valueOf(StableIdMode.class, str);
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) f6962a.clone();
            }
        }

        public Config(boolean z, StableIdMode stableIdMode) {
            this.isolateViewTypes = z;
            this.stableIdMode = stableIdMode;
        }
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... adapterArr) {
        this(Config.DEFAULT, adapterArr);
    }

    /* renamed from: a */
    public final void m1606a(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }

    public boolean addAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        C0477h c0477h = this.f6959d;
        return c0477h.m1854a(c0477h.f7398e.size(), adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int findRelativeAdapterPositionIn(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, @NonNull RecyclerView.ViewHolder viewHolder, int i) {
        C0477h c0477h = this.f6959d;
        C0487k0 c0487k0 = (C0487k0) c0477h.f7397d.get(viewHolder);
        if (c0487k0 == null) {
            return -1;
        }
        int m1856c = i - c0477h.m1856c(c0487k0);
        RecyclerView.Adapter adapter2 = c0487k0.f7424c;
        int itemCount = adapter2.getItemCount();
        if (m1856c >= 0 && m1856c < itemCount) {
            return adapter2.findRelativeAdapterPositionIn(adapter, viewHolder, m1856c);
        }
        StringBuilder m8302v = ye0.m8302v("Detected inconsistent adapter updates. The local position of the view holder maps to ", m1856c, " which is out of bounds for the adapter with size ", itemCount, ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:");
        m8302v.append(viewHolder);
        m8302v.append("adapter:");
        m8302v.append(adapter);
        throw new IllegalStateException(m8302v.toString());
    }

    @NonNull
    public List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters() {
        List list;
        ArrayList arrayList = this.f6959d.f7398e;
        if (arrayList.isEmpty()) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((C0487k0) it.next()).f7424c);
            }
            list = arrayList2;
        }
        return Collections.unmodifiableList(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Iterator it = this.f6959d.f7398e.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((C0487k0) it.next()).f7426e;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        C0477h c0477h = this.f6959d;
        C1487ku m1857d = c0477h.m1857d(i);
        C0487k0 c0487k0 = m1857d.f22200a;
        long localToGlobal = c0487k0.f7423b.localToGlobal(c0487k0.f7424c.getItemId(m1857d.f22201b));
        m1857d.f22202c = false;
        m1857d.f22200a = null;
        m1857d.f22201b = -1;
        c0477h.f7399f = m1857d;
        return localToGlobal;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        C0477h c0477h = this.f6959d;
        C1487ku m1857d = c0477h.m1857d(i);
        C0487k0 c0487k0 = m1857d.f22200a;
        int localToGlobal = c0487k0.f7422a.localToGlobal(c0487k0.f7424c.getItemViewType(m1857d.f22201b));
        m1857d.f22202c = false;
        m1857d.f22200a = null;
        m1857d.f22201b = -1;
        c0477h.f7399f = m1857d;
        return localToGlobal;
    }

    @NonNull
    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> getWrappedAdapterAndPosition(int i) {
        C0477h c0477h = this.f6959d;
        C1487ku m1857d = c0477h.m1857d(i);
        Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> pair = new Pair<>(m1857d.f22200a.f7424c, Integer.valueOf(m1857d.f22201b));
        m1857d.f22202c = false;
        m1857d.f22200a = null;
        m1857d.f22201b = -1;
        c0477h.f7399f = m1857d;
        return pair;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        C0477h c0477h = this.f6959d;
        ArrayList arrayList = c0477h.f7396c;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == recyclerView) {
                return;
            }
        }
        arrayList.add(new WeakReference(recyclerView));
        Iterator it2 = c0477h.f7398e.iterator();
        while (it2.hasNext()) {
            ((C0487k0) it2.next()).f7424c.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        C0477h c0477h = this.f6959d;
        C1487ku m1857d = c0477h.m1857d(i);
        c0477h.f7397d.put(viewHolder, m1857d.f22200a);
        C0487k0 c0487k0 = m1857d.f22200a;
        c0487k0.f7424c.bindViewHolder(viewHolder, m1857d.f22201b);
        m1857d.f22202c = false;
        m1857d.f22200a = null;
        m1857d.f22201b = -1;
        c0477h.f7399f = m1857d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        C0487k0 wrapperForGlobalType = this.f6959d.f7395b.getWrapperForGlobalType(i);
        return wrapperForGlobalType.f7424c.onCreateViewHolder(viewGroup, wrapperForGlobalType.f7422a.globalToLocal(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        C0477h c0477h = this.f6959d;
        ArrayList arrayList = c0477h.f7396c;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference weakReference = (WeakReference) arrayList.get(size);
            if (weakReference.get() == null) {
                arrayList.remove(size);
            } else if (weakReference.get() == recyclerView) {
                arrayList.remove(size);
                break;
            }
            size--;
        }
        Iterator it = c0477h.f7398e.iterator();
        while (it.hasNext()) {
            ((C0487k0) it.next()).f7424c.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        C0477h c0477h = this.f6959d;
        IdentityHashMap identityHashMap = c0477h.f7397d;
        C0487k0 c0487k0 = (C0487k0) identityHashMap.get(viewHolder);
        if (c0487k0 != null) {
            boolean onFailedToRecycleView = c0487k0.f7424c.onFailedToRecycleView(viewHolder);
            identityHashMap.remove(viewHolder);
            return onFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + c0477h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f6959d.m1858e(viewHolder).f7424c.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f6959d.m1858e(viewHolder).f7424c.onViewDetachedFromWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        C0477h c0477h = this.f6959d;
        IdentityHashMap identityHashMap = c0477h.f7397d;
        C0487k0 c0487k0 = (C0487k0) identityHashMap.get(viewHolder);
        if (c0487k0 != null) {
            c0487k0.f7424c.onViewRecycled(viewHolder);
            identityHashMap.remove(viewHolder);
        } else {
            throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + c0477h);
        }
    }

    public boolean removeAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        C0477h c0477h = this.f6959d;
        int m1859f = c0477h.m1859f(adapter);
        if (m1859f == -1) {
            return false;
        }
        ArrayList arrayList = c0477h.f7398e;
        C0487k0 c0487k0 = (C0487k0) arrayList.get(m1859f);
        int m1856c = c0477h.m1856c(c0487k0);
        arrayList.remove(m1859f);
        c0477h.f7394a.notifyItemRangeRemoved(m1856c, c0487k0.f7426e);
        Iterator it = c0477h.f7396c.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = (RecyclerView) ((WeakReference) it.next()).get();
            if (recyclerView != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
        c0487k0.f7424c.unregisterAdapterDataObserver(c0487k0.f7427f);
        c0487k0.f7422a.dispose();
        c0477h.m1855b();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(@NonNull RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull Config config, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... adapterArr) {
        this(config, (List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>>) Arrays.asList(adapterArr));
    }

    public ConcatAdapter(@NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this(Config.DEFAULT, list);
    }

    public boolean addAdapter(int i, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.f6959d.m1854a(i, adapter);
    }

    public ConcatAdapter(@NonNull Config config, @NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this.f6959d = new C0477h(this, config);
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> it = list.iterator();
        while (it.hasNext()) {
            addAdapter(it.next());
        }
        super.setHasStableIds(this.f6959d.f7400g != Config.StableIdMode.NO_STABLE_IDS);
    }
}

package androidx.recyclerview.widget;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import p000.C1487ku;
import p000.dx0;
import p000.g43;
import p000.pm2;
import p000.wd0;
import p000.ye0;

/* renamed from: androidx.recyclerview.widget.h */
/* loaded from: classes.dex */
public final class C0477h {

    /* renamed from: a */
    public final ConcatAdapter f7394a;

    /* renamed from: b */
    public final g43 f7395b;

    /* renamed from: c */
    public final ArrayList f7396c = new ArrayList();

    /* renamed from: d */
    public final IdentityHashMap f7397d = new IdentityHashMap();

    /* renamed from: e */
    public final ArrayList f7398e = new ArrayList();

    /* renamed from: f */
    public C1487ku f7399f = new Object();

    /* renamed from: g */
    public final ConcatAdapter.Config.StableIdMode f7400g;

    /* renamed from: h */
    public final pm2 f7401h;

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, ku] */
    public C0477h(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        this.f7394a = concatAdapter;
        if (config.isolateViewTypes) {
            this.f7395b = new ViewTypeStorage$IsolatedViewTypeStorage();
        } else {
            this.f7395b = new ViewTypeStorage$SharedIdRangeViewTypeStorage();
        }
        ConcatAdapter.Config.StableIdMode stableIdMode = config.stableIdMode;
        this.f7400g = stableIdMode;
        if (stableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.f7401h = new pm2() { // from class: androidx.recyclerview.widget.StableIdStorage$NoStableIdStorage

                /* renamed from: a */
                public final dx0 f7267a = new dx0(23);

                @Override // p000.pm2
                @NonNull
                public StableIdStorage$StableIdLookup createStableIdLookup() {
                    return this.f7267a;
                }
            };
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.f7401h = new StableIdStorage$IsolatedStableIdStorage();
        } else {
            if (stableIdMode == ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
                this.f7401h = new pm2() { // from class: androidx.recyclerview.widget.StableIdStorage$SharedPoolStableIdStorage

                    /* renamed from: a */
                    public final wd0 f7268a = new wd0(24);

                    @Override // p000.pm2
                    @NonNull
                    public StableIdStorage$StableIdLookup createStableIdLookup() {
                        return this.f7268a;
                    }
                };
                return;
            }
            throw new IllegalArgumentException("unknown stable id mode");
        }
    }

    /* renamed from: a */
    public final boolean m1854a(int i, RecyclerView.Adapter adapter) {
        C0487k0 c0487k0;
        ArrayList arrayList = this.f7398e;
        if (i >= 0 && i <= arrayList.size()) {
            if (this.f7400g != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
                Preconditions.checkArgument(adapter.hasStableIds(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
            } else if (adapter.hasStableIds()) {
                Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
            }
            int m1859f = m1859f(adapter);
            if (m1859f == -1) {
                c0487k0 = null;
            } else {
                c0487k0 = (C0487k0) arrayList.get(m1859f);
            }
            if (c0487k0 != null) {
                return false;
            }
            C0487k0 c0487k02 = new C0487k0(adapter, this, this.f7395b, this.f7401h.createStableIdLookup());
            arrayList.add(i, c0487k02);
            Iterator it = this.f7396c.iterator();
            while (it.hasNext()) {
                RecyclerView recyclerView = (RecyclerView) ((WeakReference) it.next()).get();
                if (recyclerView != null) {
                    adapter.onAttachedToRecyclerView(recyclerView);
                }
            }
            if (c0487k02.f7426e > 0) {
                this.f7394a.notifyItemRangeInserted(m1856c(c0487k02), c0487k02.f7426e);
            }
            m1855b();
            return true;
        }
        throw new IndexOutOfBoundsException("Index must be between 0 and " + arrayList.size() + ". Given:" + i);
    }

    /* renamed from: b */
    public final void m1855b() {
        RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy;
        Iterator it = this.f7398e.iterator();
        while (true) {
            if (it.hasNext()) {
                C0487k0 c0487k0 = (C0487k0) it.next();
                RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy2 = c0487k0.f7424c.getStateRestorationPolicy();
                stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
                if (stateRestorationPolicy2 == stateRestorationPolicy || (stateRestorationPolicy2 == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && c0487k0.f7426e == 0)) {
                    break;
                }
            } else {
                stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
                break;
            }
        }
        ConcatAdapter concatAdapter = this.f7394a;
        if (stateRestorationPolicy != concatAdapter.getStateRestorationPolicy()) {
            concatAdapter.m1606a(stateRestorationPolicy);
        }
    }

    /* renamed from: c */
    public final int m1856c(C0487k0 c0487k0) {
        C0487k0 c0487k02;
        Iterator it = this.f7398e.iterator();
        int i = 0;
        while (it.hasNext() && (c0487k02 = (C0487k0) it.next()) != c0487k0) {
            i += c0487k02.f7426e;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final C1487ku m1857d(int i) {
        C1487ku c1487ku;
        C1487ku c1487ku2 = this.f7399f;
        if (c1487ku2.f22202c) {
            c1487ku = new Object();
        } else {
            c1487ku2.f22202c = true;
            c1487ku = c1487ku2;
        }
        Iterator it = this.f7398e.iterator();
        int i2 = i;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0487k0 c0487k0 = (C0487k0) it.next();
            int i3 = c0487k0.f7426e;
            if (i3 > i2) {
                c1487ku.f22200a = c0487k0;
                c1487ku.f22201b = i2;
                break;
            }
            i2 -= i3;
        }
        if (c1487ku.f22200a != null) {
            return c1487ku;
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "Cannot find wrapper for "));
    }

    /* renamed from: e */
    public final C0487k0 m1858e(RecyclerView.ViewHolder viewHolder) {
        C0487k0 c0487k0 = (C0487k0) this.f7397d.get(viewHolder);
        if (c0487k0 != null) {
            return c0487k0;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    /* renamed from: f */
    public final int m1859f(RecyclerView.Adapter adapter) {
        ArrayList arrayList = this.f7398e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((C0487k0) arrayList.get(i)).f7424c == adapter) {
                return i;
            }
        }
        return -1;
    }
}

package androidx.recyclerview.widget;

import android.database.Observable;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.t0 */
/* loaded from: classes.dex */
public final class C0507t0 extends Observable {
    /* renamed from: a */
    public final boolean m1890a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    /* renamed from: b */
    public final void m1891b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
        }
    }

    /* renamed from: c */
    public final void m1892c(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
        }
    }

    /* renamed from: d */
    public final void m1893d(int i, int i2, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
        }
    }

    /* renamed from: e */
    public final void m1894e(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
        }
    }

    /* renamed from: f */
    public final void m1895f(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
        }
    }

    /* renamed from: g */
    public final void m1896g() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView.AdapterDataObserver) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
        }
    }
}

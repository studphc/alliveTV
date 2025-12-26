package androidx.leanback.widget;

import android.database.Observable;
import androidx.leanback.widget.ObjectAdapter;

/* renamed from: androidx.leanback.widget.p1 */
/* loaded from: classes.dex */
public final class C0374p1 extends Observable {
    /* renamed from: a */
    public final boolean m1504a() {
        if (((Observable) this).mObservers.size() > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final void m1505b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((ObjectAdapter.DataObserver) ((Observable) this).mObservers.get(size)).onChanged();
        }
    }

    /* renamed from: c */
    public final void m1506c(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((ObjectAdapter.DataObserver) ((Observable) this).mObservers.get(size)).onItemMoved(i, i2);
        }
    }

    /* renamed from: d */
    public final void m1507d(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((ObjectAdapter.DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2);
        }
    }

    /* renamed from: e */
    public final void m1508e(int i, int i2, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((ObjectAdapter.DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
        }
    }

    /* renamed from: f */
    public final void m1509f(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((ObjectAdapter.DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
        }
    }

    /* renamed from: g */
    public final void m1510g(int i, int i2) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((ObjectAdapter.DataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
        }
    }
}

package androidx.leanback.widget;

import android.util.SparseArray;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class SparseArrayObjectAdapter extends ObjectAdapter {

    /* renamed from: d */
    public final SparseArray f6215d;

    public SparseArrayObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.f6215d = new SparseArray();
    }

    public void clear(int i) {
        SparseArray sparseArray = this.f6215d;
        int indexOfKey = sparseArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            sparseArray.removeAt(indexOfKey);
            notifyItemRangeRemoved(indexOfKey, 1);
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    @Nullable
    public Object get(int i) {
        return this.f6215d.valueAt(i);
    }

    public int indexOf(Object obj) {
        return this.f6215d.indexOfValue(obj);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public Object lookup(int i) {
        return this.f6215d.get(i);
    }

    public void notifyArrayItemRangeChanged(int i, int i2) {
        notifyItemRangeChanged(i, i2);
    }

    public void set(int i, Object obj) {
        SparseArray sparseArray = this.f6215d;
        int indexOfKey = sparseArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            if (sparseArray.valueAt(indexOfKey) != obj) {
                sparseArray.setValueAt(indexOfKey, obj);
                notifyItemRangeChanged(indexOfKey, 1);
                return;
            }
            return;
        }
        sparseArray.append(i, obj);
        notifyItemRangeInserted(sparseArray.indexOfKey(i), 1);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.f6215d.size();
    }

    public int indexOf(int i) {
        return this.f6215d.indexOfKey(i);
    }

    public SparseArrayObjectAdapter(Presenter presenter) {
        super(presenter);
        this.f6215d = new SparseArray();
    }

    public void clear() {
        SparseArray sparseArray = this.f6215d;
        int size = sparseArray.size();
        if (size == 0) {
            return;
        }
        sparseArray.clear();
        notifyItemRangeRemoved(0, size);
    }

    public SparseArrayObjectAdapter() {
        this.f6215d = new SparseArray();
    }
}

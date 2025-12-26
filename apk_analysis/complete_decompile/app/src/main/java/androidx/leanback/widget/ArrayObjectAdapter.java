package androidx.leanback.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p000.C1348jb;
import p000.b01;

/* loaded from: classes.dex */
public class ArrayObjectAdapter extends ObjectAdapter {

    /* renamed from: d */
    public final ArrayList f5562d;

    /* renamed from: e */
    public final ArrayList f5563e;

    /* renamed from: f */
    public List f5564f;

    /* renamed from: g */
    public b01 f5565g;

    public ArrayObjectAdapter(@NonNull PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.f5562d = new ArrayList();
        this.f5563e = new ArrayList();
    }

    public void add(@NonNull Object obj) {
        add(this.f5562d.size(), obj);
    }

    public void addAll(int i, @NonNull Collection<?> collection) {
        int size = collection.size();
        if (size == 0) {
            return;
        }
        this.f5562d.addAll(i, collection);
        notifyItemRangeInserted(i, size);
    }

    public void clear() {
        ArrayList arrayList = this.f5562d;
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        arrayList.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    @Nullable
    public Object get(int i) {
        return this.f5562d.get(i);
    }

    public int indexOf(@NonNull Object obj) {
        return this.f5562d.indexOf(obj);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public void move(int i, int i2) {
        if (i == i2) {
            return;
        }
        ArrayList arrayList = this.f5562d;
        arrayList.add(i2, arrayList.remove(i));
        notifyItemMoved(i, i2);
    }

    public void notifyArrayItemRangeChanged(int i, int i2) {
        notifyItemRangeChanged(i, i2);
    }

    public boolean remove(@NonNull Object obj) {
        ArrayList arrayList = this.f5562d;
        int indexOf = arrayList.indexOf(obj);
        if (indexOf >= 0) {
            arrayList.remove(indexOf);
            notifyItemRangeRemoved(indexOf, 1);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public int removeItems(int i, int i2) {
        ArrayList arrayList = this.f5562d;
        int min = Math.min(i2, arrayList.size() - i);
        if (min <= 0) {
            return 0;
        }
        for (int i3 = 0; i3 < min; i3++) {
            arrayList.remove(i);
        }
        notifyItemRangeRemoved(i, min);
        return min;
    }

    public void replace(int i, @NonNull Object obj) {
        this.f5562d.set(i, obj);
        notifyItemRangeChanged(i, 1);
    }

    public void setItems(@NonNull List list, @Nullable DiffCallback diffCallback) {
        ArrayList arrayList = this.f5562d;
        if (diffCallback == null) {
            arrayList.clear();
            arrayList.addAll(list);
            notifyChanged();
            return;
        }
        ArrayList arrayList2 = this.f5563e;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new C1348jb(this, list, diffCallback));
        arrayList.clear();
        arrayList.addAll(list);
        if (this.f5565g == null) {
            this.f5565g = new b01(5, this);
        }
        calculateDiff.dispatchUpdatesTo(this.f5565g);
        arrayList2.clear();
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        return this.f5562d.size();
    }

    @NonNull
    public <E> List<E> unmodifiableList() {
        if (this.f5564f == null) {
            this.f5564f = Collections.unmodifiableList(this.f5562d);
        }
        return this.f5564f;
    }

    public void add(int i, @NonNull Object obj) {
        this.f5562d.add(i, obj);
        notifyItemRangeInserted(i, 1);
    }

    public ArrayObjectAdapter(@NonNull Presenter presenter) {
        super(presenter);
        this.f5562d = new ArrayList();
        this.f5563e = new ArrayList();
    }

    public ArrayObjectAdapter() {
        this.f5562d = new ArrayList();
        this.f5563e = new ArrayList();
    }
}

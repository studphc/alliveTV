package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import p000.ye0;

/* loaded from: classes.dex */
public class SortedList<T> {
    public static final int INVALID_POSITION = -1;

    /* renamed from: a */
    public Object[] f7254a;

    /* renamed from: b */
    public Object[] f7255b;

    /* renamed from: c */
    public int f7256c;

    /* renamed from: d */
    public int f7257d;

    /* renamed from: e */
    public int f7258e;

    /* renamed from: f */
    public Callback f7259f;

    /* renamed from: g */
    public BatchedCallback f7260g;

    /* renamed from: h */
    public int f7261h;

    /* renamed from: i */
    public final Class f7262i;

    /* loaded from: classes.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {

        /* renamed from: a */
        public final Callback f7263a;

        /* renamed from: b */
        public final BatchingListUpdateCallback f7264b;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.f7263a = callback;
            this.f7264b = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.f7263a.areContentsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.f7263a.areItemsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.f7263a.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            this.f7264b.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.f7263a.getChangePayload(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i, int i2) {
            this.f7264b.onChanged(i, i2, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            this.f7264b.onInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            this.f7264b.onMoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            this.f7264b.onRemoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i, int i2, Object obj) {
            this.f7264b.onChanged(i, i2, obj);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i, int i2);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i, int i2, Object obj) {
            onChanged(i, i2);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    /* renamed from: a */
    public final int m1771a(Object obj, boolean z) {
        int m1773c = m1773c(this.f7254a, 0, this.f7261h, 1, obj);
        if (m1773c == -1) {
            m1773c = 0;
        } else if (m1773c < this.f7261h) {
            Object obj2 = this.f7254a[m1773c];
            if (this.f7259f.areItemsTheSame(obj2, obj)) {
                if (this.f7259f.areContentsTheSame(obj2, obj)) {
                    this.f7254a[m1773c] = obj;
                    return m1773c;
                }
                this.f7254a[m1773c] = obj;
                Callback callback = this.f7259f;
                callback.onChanged(m1773c, 1, callback.getChangePayload(obj2, obj));
                return m1773c;
            }
        }
        int i = this.f7261h;
        if (m1773c <= i) {
            Object[] objArr = this.f7254a;
            if (i == objArr.length) {
                Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.f7262i, objArr.length + 10);
                System.arraycopy(this.f7254a, 0, objArr2, 0, m1773c);
                objArr2[m1773c] = obj;
                System.arraycopy(this.f7254a, m1773c, objArr2, m1773c + 1, this.f7261h - m1773c);
                this.f7254a = objArr2;
            } else {
                System.arraycopy(objArr, m1773c, objArr, m1773c + 1, i - m1773c);
                this.f7254a[m1773c] = obj;
            }
            this.f7261h++;
            if (z) {
                this.f7259f.onInserted(m1773c, 1);
            }
            return m1773c;
        }
        StringBuilder m8299s = ye0.m8299s(m1773c, "cannot add item to ", " because size is ");
        m8299s.append(this.f7261h);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public int add(T t) {
        m1777g();
        return m1771a(t, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z) {
        m1777g();
        if (tArr.length == 0) {
            return;
        }
        if (z) {
            m1772b(tArr);
            return;
        }
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.f7262i, tArr.length);
        System.arraycopy(tArr, 0, objArr, 0, tArr.length);
        m1772b(objArr);
    }

    /* renamed from: b */
    public final void m1772b(Object[] objArr) {
        if (objArr.length < 1) {
            return;
        }
        int m1776f = m1776f(objArr);
        int i = 0;
        if (this.f7261h == 0) {
            this.f7254a = objArr;
            this.f7261h = m1776f;
            this.f7259f.onInserted(0, m1776f);
            return;
        }
        boolean z = this.f7259f instanceof BatchedCallback;
        if (!z) {
            beginBatchedUpdates();
        }
        this.f7255b = this.f7254a;
        this.f7256c = 0;
        int i2 = this.f7261h;
        this.f7257d = i2;
        this.f7254a = (Object[]) Array.newInstance((Class<?>) this.f7262i, i2 + m1776f + 10);
        this.f7258e = 0;
        while (true) {
            int i3 = this.f7256c;
            int i4 = this.f7257d;
            if (i3 >= i4 && i >= m1776f) {
                break;
            }
            if (i3 == i4) {
                int i5 = m1776f - i;
                System.arraycopy(objArr, i, this.f7254a, this.f7258e, i5);
                int i6 = this.f7258e + i5;
                this.f7258e = i6;
                this.f7261h += i5;
                this.f7259f.onInserted(i6 - i5, i5);
                break;
            }
            if (i == m1776f) {
                int i7 = i4 - i3;
                System.arraycopy(this.f7255b, i3, this.f7254a, this.f7258e, i7);
                this.f7258e += i7;
                break;
            }
            Object obj = this.f7255b[i3];
            Object obj2 = objArr[i];
            int compare = this.f7259f.compare(obj, obj2);
            if (compare > 0) {
                Object[] objArr2 = this.f7254a;
                int i8 = this.f7258e;
                this.f7258e = i8 + 1;
                objArr2[i8] = obj2;
                this.f7261h++;
                i++;
                this.f7259f.onInserted(i8, 1);
            } else if (compare == 0 && this.f7259f.areItemsTheSame(obj, obj2)) {
                Object[] objArr3 = this.f7254a;
                int i9 = this.f7258e;
                this.f7258e = i9 + 1;
                objArr3[i9] = obj2;
                i++;
                this.f7256c++;
                if (!this.f7259f.areContentsTheSame(obj, obj2)) {
                    Callback callback = this.f7259f;
                    callback.onChanged(this.f7258e - 1, 1, callback.getChangePayload(obj, obj2));
                }
            } else {
                Object[] objArr4 = this.f7254a;
                int i10 = this.f7258e;
                this.f7258e = i10 + 1;
                objArr4[i10] = obj;
                this.f7256c++;
            }
        }
        this.f7255b = null;
        if (!z) {
            endBatchedUpdates();
        }
    }

    public void beginBatchedUpdates() {
        m1777g();
        Callback callback = this.f7259f;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.f7260g == null) {
            this.f7260g = new BatchedCallback(callback);
        }
        this.f7259f = this.f7260g;
    }

    /* renamed from: c */
    public final int m1773c(Object[] objArr, int i, int i2, int i3, Object obj) {
        while (i < i2) {
            int i4 = (i + i2) / 2;
            Object obj2 = objArr[i4];
            int compare = this.f7259f.compare(obj2, obj);
            if (compare < 0) {
                i = i4 + 1;
            } else {
                if (compare == 0) {
                    if (this.f7259f.areItemsTheSame(obj2, obj)) {
                        return i4;
                    }
                    int i5 = i4 - 1;
                    while (i5 >= i) {
                        Object obj3 = this.f7254a[i5];
                        if (this.f7259f.compare(obj3, obj) != 0) {
                            break;
                        }
                        if (this.f7259f.areItemsTheSame(obj3, obj)) {
                            break;
                        }
                        i5--;
                    }
                    i5 = i4 + 1;
                    while (i5 < i2) {
                        Object obj4 = this.f7254a[i5];
                        if (this.f7259f.compare(obj4, obj) != 0) {
                            break;
                        }
                        if (this.f7259f.areItemsTheSame(obj4, obj)) {
                            break;
                        }
                        i5++;
                    }
                    i5 = -1;
                    if (i3 == 1) {
                        if (i5 != -1) {
                            return i5;
                        }
                        return i4;
                    }
                    return i5;
                }
                i2 = i4;
            }
        }
        if (i3 != 1) {
            return -1;
        }
        return i;
    }

    public void clear() {
        m1777g();
        int i = this.f7261h;
        if (i == 0) {
            return;
        }
        Arrays.fill(this.f7254a, 0, i, (Object) null);
        this.f7261h = 0;
        this.f7259f.onRemoved(0, i);
    }

    /* renamed from: d */
    public final void m1774d(int i, boolean z) {
        Object[] objArr = this.f7254a;
        System.arraycopy(objArr, i + 1, objArr, i, (this.f7261h - i) - 1);
        int i2 = this.f7261h - 1;
        this.f7261h = i2;
        this.f7254a[i2] = null;
        if (z) {
            this.f7259f.onRemoved(i, 1);
        }
    }

    /* renamed from: e */
    public final void m1775e(Object[] objArr) {
        boolean z = this.f7259f instanceof BatchedCallback;
        if (!z) {
            beginBatchedUpdates();
        }
        this.f7256c = 0;
        this.f7257d = this.f7261h;
        this.f7255b = this.f7254a;
        this.f7258e = 0;
        int m1776f = m1776f(objArr);
        this.f7254a = (Object[]) Array.newInstance((Class<?>) this.f7262i, m1776f);
        while (true) {
            int i = this.f7258e;
            if (i >= m1776f && this.f7256c >= this.f7257d) {
                break;
            }
            int i2 = this.f7256c;
            int i3 = this.f7257d;
            if (i2 >= i3) {
                int i4 = m1776f - i;
                System.arraycopy(objArr, i, this.f7254a, i, i4);
                this.f7258e += i4;
                this.f7261h += i4;
                this.f7259f.onInserted(i, i4);
                break;
            }
            if (i >= m1776f) {
                int i5 = i3 - i2;
                this.f7261h -= i5;
                this.f7259f.onRemoved(i, i5);
                break;
            }
            Object obj = this.f7255b[i2];
            Object obj2 = objArr[i];
            int compare = this.f7259f.compare(obj, obj2);
            if (compare < 0) {
                this.f7261h--;
                this.f7256c++;
                this.f7259f.onRemoved(this.f7258e, 1);
            } else if (compare > 0) {
                Object[] objArr2 = this.f7254a;
                int i6 = this.f7258e;
                objArr2[i6] = obj2;
                this.f7258e = i6 + 1;
                this.f7261h++;
                this.f7259f.onInserted(i6, 1);
            } else if (!this.f7259f.areItemsTheSame(obj, obj2)) {
                this.f7261h--;
                this.f7256c++;
                this.f7259f.onRemoved(this.f7258e, 1);
                Object[] objArr3 = this.f7254a;
                int i7 = this.f7258e;
                objArr3[i7] = obj2;
                this.f7258e = i7 + 1;
                this.f7261h++;
                this.f7259f.onInserted(i7, 1);
            } else {
                Object[] objArr4 = this.f7254a;
                int i8 = this.f7258e;
                objArr4[i8] = obj2;
                this.f7256c++;
                this.f7258e = i8 + 1;
                if (!this.f7259f.areContentsTheSame(obj, obj2)) {
                    Callback callback = this.f7259f;
                    callback.onChanged(this.f7258e - 1, 1, callback.getChangePayload(obj, obj2));
                }
            }
        }
        this.f7255b = null;
        if (!z) {
            endBatchedUpdates();
        }
    }

    public void endBatchedUpdates() {
        m1777g();
        Callback callback = this.f7259f;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.f7259f;
        BatchedCallback batchedCallback = this.f7260g;
        if (callback2 == batchedCallback) {
            this.f7259f = batchedCallback.f7263a;
        }
    }

    /* renamed from: f */
    public final int m1776f(Object[] objArr) {
        if (objArr.length == 0) {
            return 0;
        }
        Arrays.sort(objArr, this.f7259f);
        int i = 0;
        int i2 = 1;
        for (int i3 = 1; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (this.f7259f.compare(objArr[i], obj) == 0) {
                int i4 = i;
                while (true) {
                    if (i4 < i2) {
                        if (this.f7259f.areItemsTheSame(objArr[i4], obj)) {
                            break;
                        }
                        i4++;
                    } else {
                        i4 = -1;
                        break;
                    }
                }
                if (i4 != -1) {
                    objArr[i4] = obj;
                } else {
                    if (i2 != i3) {
                        objArr[i2] = obj;
                    }
                    i2++;
                }
            } else {
                if (i2 != i3) {
                    objArr[i2] = obj;
                }
                i = i2;
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: g */
    public final void m1777g() {
        if (this.f7255b == null) {
        } else {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public T get(int i) {
        int i2;
        if (i < this.f7261h && i >= 0) {
            Object[] objArr = this.f7255b;
            if (objArr != null && i >= (i2 = this.f7258e)) {
                return (T) objArr[(i - i2) + this.f7256c];
            }
            return (T) this.f7254a[i];
        }
        StringBuilder m8299s = ye0.m8299s(i, "Asked to get item at ", " but size is ");
        m8299s.append(this.f7261h);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public int indexOf(T t) {
        if (this.f7255b != null) {
            int m1773c = m1773c(this.f7254a, 0, this.f7258e, 4, t);
            if (m1773c != -1) {
                return m1773c;
            }
            int m1773c2 = m1773c(this.f7255b, this.f7256c, this.f7257d, 4, t);
            if (m1773c2 == -1) {
                return -1;
            }
            return (m1773c2 - this.f7256c) + this.f7258e;
        }
        return m1773c(this.f7254a, 0, this.f7261h, 4, t);
    }

    public void recalculatePositionOfItemAt(int i) {
        m1777g();
        T t = get(i);
        m1774d(i, false);
        int m1771a = m1771a(t, false);
        if (i != m1771a) {
            this.f7259f.onMoved(i, m1771a);
        }
    }

    public boolean remove(T t) {
        m1777g();
        int m1773c = m1773c(this.f7254a, 0, this.f7261h, 2, t);
        if (m1773c == -1) {
            return false;
        }
        m1774d(m1773c, true);
        return true;
    }

    public T removeItemAt(int i) {
        m1777g();
        T t = get(i);
        m1774d(i, true);
        return t;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z) {
        m1777g();
        if (z) {
            m1775e(tArr);
            return;
        }
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.f7262i, tArr.length);
        System.arraycopy(tArr, 0, objArr, 0, tArr.length);
        m1775e(objArr);
    }

    public int size() {
        return this.f7261h;
    }

    public void updateItemAt(int i, T t) {
        boolean z;
        m1777g();
        T t2 = get(i);
        if (t2 != t && this.f7259f.areContentsTheSame(t2, t)) {
            z = false;
        } else {
            z = true;
        }
        if (t2 != t && this.f7259f.compare(t2, t) == 0) {
            this.f7254a[i] = t;
            if (z) {
                Callback callback = this.f7259f;
                callback.onChanged(i, 1, callback.getChangePayload(t2, t));
                return;
            }
            return;
        }
        if (z) {
            Callback callback2 = this.f7259f;
            callback2.onChanged(i, 1, callback2.getChangePayload(t2, t));
        }
        m1774d(i, false);
        int m1771a = m1771a(t, false);
        if (i != m1771a) {
            this.f7259f.onMoved(i, m1771a);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i) {
        this.f7262i = cls;
        this.f7254a = (Object[]) Array.newInstance((Class<?>) cls, i);
        this.f7259f = callback;
        this.f7261h = 0;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.f7262i, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.f7262i, collection.size())), true);
    }
}

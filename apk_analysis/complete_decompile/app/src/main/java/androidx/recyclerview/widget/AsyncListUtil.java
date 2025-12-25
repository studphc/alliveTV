package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import p000.h71;
import p000.mt2;
import p000.tn1;

/* loaded from: classes.dex */
public class AsyncListUtil<T> {

    /* renamed from: a */
    public final Class f6938a;

    /* renamed from: b */
    public final int f6939b;

    /* renamed from: c */
    public final DataCallback f6940c;

    /* renamed from: d */
    public final ViewCallback f6941d;

    /* renamed from: e */
    public final h71 f6942e;

    /* renamed from: f */
    public final mt2 f6943f;

    /* renamed from: g */
    public final tn1 f6944g;

    /* renamed from: k */
    public boolean f6948k;

    /* renamed from: h */
    public final int[] f6945h = new int[2];

    /* renamed from: i */
    public final int[] f6946i = new int[2];

    /* renamed from: j */
    public final int[] f6947j = new int[2];

    /* renamed from: l */
    public int f6949l = 0;

    /* renamed from: m */
    public int f6950m = 0;

    /* renamed from: n */
    public int f6951n = 0;

    /* renamed from: o */
    public int f6952o = 0;

    /* renamed from: p */
    public final SparseIntArray f6953p = new SparseIntArray();

    /* loaded from: classes.dex */
    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i, int i2);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i) {
            int i2;
            int i3 = iArr[1];
            int i4 = iArr[0];
            int i5 = (i3 - i4) + 1;
            int i6 = i5 / 2;
            if (i == 1) {
                i2 = i5;
            } else {
                i2 = i6;
            }
            iArr2[0] = i4 - i2;
            if (i != 2) {
                i5 = i6;
            }
            iArr2[1] = i3 + i5;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        C0468e c0468e = new C0468e(this);
        C0471f c0471f = new C0471f(this);
        this.f6938a = cls;
        this.f6939b = i;
        this.f6940c = dataCallback;
        this.f6941d = viewCallback;
        this.f6942e = new h71(i);
        this.f6943f = new mt2(c0468e);
        this.f6944g = new tn1(c0471f);
        refresh();
    }

    /* renamed from: a */
    public final void m1605a() {
        int i;
        int[] iArr = this.f6945h;
        ViewCallback viewCallback = this.f6941d;
        viewCallback.getItemRangeInto(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (i2 > i3 || i2 < 0 || i3 >= this.f6950m) {
            return;
        }
        boolean z = this.f6948k;
        int[] iArr2 = this.f6946i;
        if (!z) {
            this.f6949l = 0;
        } else if (i2 <= iArr2[1] && (i = iArr2[0]) <= i3) {
            if (i2 < i) {
                this.f6949l = 1;
            } else if (i2 > i) {
                this.f6949l = 2;
            }
        } else {
            this.f6949l = 0;
        }
        iArr2[0] = i2;
        iArr2[1] = i3;
        int i4 = this.f6949l;
        int[] iArr3 = this.f6947j;
        viewCallback.extendRangeInto(iArr, iArr3, i4);
        iArr3[0] = Math.min(iArr[0], Math.max(iArr3[0], 0));
        int max = Math.max(iArr[1], Math.min(iArr3[1], this.f6950m - 1));
        iArr3[1] = max;
        this.f6944g.updateRange(iArr[0], iArr[1], iArr3[0], max, this.f6949l);
    }

    @Nullable
    public T getItem(int i) {
        T t;
        int i2;
        if (i >= 0 && i < this.f6950m) {
            h71 h71Var = this.f6942e;
            TileList$Tile tileList$Tile = (TileList$Tile) h71Var.f17966c;
            if (tileList$Tile == null || (i2 = tileList$Tile.mStartPosition) > i || i >= i2 + tileList$Tile.mItemCount) {
                int i3 = i - (i % h71Var.f17964a);
                SparseArray sparseArray = (SparseArray) h71Var.f17965b;
                int indexOfKey = sparseArray.indexOfKey(i3);
                if (indexOfKey < 0) {
                    t = null;
                    if (t == null && this.f6952o == this.f6951n) {
                        this.f6953p.put(i, 0);
                    }
                    return t;
                }
                h71Var.f17966c = (TileList$Tile) sparseArray.valueAt(indexOfKey);
            }
            TileList$Tile tileList$Tile2 = (TileList$Tile) h71Var.f17966c;
            t = tileList$Tile2.mItems[i - tileList$Tile2.mStartPosition];
            if (t == null) {
                this.f6953p.put(i, 0);
            }
            return t;
        }
        throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.f6950m);
    }

    public int getItemCount() {
        return this.f6950m;
    }

    public void onRangeChanged() {
        if (this.f6952o != this.f6951n) {
            return;
        }
        m1605a();
        this.f6948k = true;
    }

    public void refresh() {
        this.f6953p.clear();
        int i = this.f6952o + 1;
        this.f6952o = i;
        this.f6944g.refresh(i);
    }
}

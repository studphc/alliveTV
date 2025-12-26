package androidx.recyclerview.widget;

import android.util.SparseBooleanArray;
import androidx.recyclerview.widget.AsyncListUtil;

/* renamed from: androidx.recyclerview.widget.f */
/* loaded from: classes.dex */
public final class C0471f implements ThreadUtil$BackgroundCallback {

    /* renamed from: a */
    public TileList$Tile f7363a;

    /* renamed from: b */
    public final SparseBooleanArray f7364b = new SparseBooleanArray();

    /* renamed from: c */
    public int f7365c;

    /* renamed from: d */
    public int f7366d;

    /* renamed from: e */
    public int f7367e;

    /* renamed from: f */
    public int f7368f;

    /* renamed from: g */
    public final /* synthetic */ AsyncListUtil f7369g;

    public C0471f(AsyncListUtil asyncListUtil) {
        this.f7369g = asyncListUtil;
    }

    /* renamed from: a */
    public final void m1826a(int i, int i2, int i3, boolean z) {
        int i4;
        int i5 = i;
        while (i5 <= i2) {
            if (z) {
                i4 = (i2 + i) - i5;
            } else {
                i4 = i5;
            }
            AsyncListUtil asyncListUtil = this.f7369g;
            asyncListUtil.f6944g.loadTile(i4, i3);
            i5 += asyncListUtil.f6939b;
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public final void loadTile(int i, int i2) {
        SparseBooleanArray sparseBooleanArray = this.f7364b;
        if (sparseBooleanArray.get(i)) {
            return;
        }
        TileList$Tile tileList$Tile = this.f7363a;
        AsyncListUtil asyncListUtil = this.f7369g;
        if (tileList$Tile != null) {
            this.f7363a = tileList$Tile.f7309a;
        } else {
            tileList$Tile = new TileList$Tile(asyncListUtil.f6939b, asyncListUtil.f6938a);
        }
        tileList$Tile.mStartPosition = i;
        int min = Math.min(asyncListUtil.f6939b, this.f7366d - i);
        tileList$Tile.mItemCount = min;
        T[] tArr = tileList$Tile.mItems;
        int i3 = tileList$Tile.mStartPosition;
        AsyncListUtil.DataCallback dataCallback = asyncListUtil.f6940c;
        dataCallback.fillData(tArr, i3, min);
        int maxCachedTiles = dataCallback.getMaxCachedTiles();
        while (sparseBooleanArray.size() >= maxCachedTiles) {
            int keyAt = sparseBooleanArray.keyAt(0);
            int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
            int i4 = this.f7367e - keyAt;
            int i5 = keyAt2 - this.f7368f;
            if (i4 > 0 && (i4 >= i5 || i2 == 2)) {
                sparseBooleanArray.delete(keyAt);
                asyncListUtil.f6943f.removeTile(this.f7365c, keyAt);
            } else {
                if (i5 <= 0 || (i4 >= i5 && i2 != 1)) {
                    break;
                }
                sparseBooleanArray.delete(keyAt2);
                asyncListUtil.f6943f.removeTile(this.f7365c, keyAt2);
            }
        }
        sparseBooleanArray.put(tileList$Tile.mStartPosition, true);
        asyncListUtil.f6943f.addTile(this.f7365c, tileList$Tile);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public final void recycleTile(TileList$Tile tileList$Tile) {
        this.f7369g.f6940c.recycleData(tileList$Tile.mItems, tileList$Tile.mItemCount);
        tileList$Tile.f7309a = this.f7363a;
        this.f7363a = tileList$Tile;
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public final void refresh(int i) {
        this.f7365c = i;
        this.f7364b.clear();
        AsyncListUtil asyncListUtil = this.f7369g;
        int refreshData = asyncListUtil.f6940c.refreshData();
        this.f7366d = refreshData;
        asyncListUtil.f6943f.updateItemCount(this.f7365c, refreshData);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
    public final void updateRange(int i, int i2, int i3, int i4, int i5) {
        if (i > i2) {
            return;
        }
        AsyncListUtil asyncListUtil = this.f7369g;
        int i6 = asyncListUtil.f6939b;
        int i7 = i - (i % i6);
        int i8 = i2 - (i2 % i6);
        int i9 = i3 - (i3 % i6);
        this.f7367e = i9;
        int i10 = i4 - (i4 % i6);
        this.f7368f = i10;
        if (i5 == 1) {
            m1826a(i9, i8, i5, true);
            m1826a(i8 + asyncListUtil.f6939b, this.f7368f, i5, false);
        } else {
            m1826a(i7, i10, i5, false);
            m1826a(this.f7367e, i7 - asyncListUtil.f6939b, i5, true);
        }
    }
}

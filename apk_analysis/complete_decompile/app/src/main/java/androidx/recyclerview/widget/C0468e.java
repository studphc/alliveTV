package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import p000.h71;

/* renamed from: androidx.recyclerview.widget.e */
/* loaded from: classes.dex */
public final class C0468e implements ThreadUtil$MainThreadCallback {

    /* renamed from: a */
    public final /* synthetic */ AsyncListUtil f7352a;

    public C0468e(AsyncListUtil asyncListUtil) {
        this.f7352a = asyncListUtil;
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public final void addTile(int i, TileList$Tile tileList$Tile) {
        boolean z;
        TileList$Tile tileList$Tile2;
        AsyncListUtil asyncListUtil = this.f7352a;
        int i2 = 0;
        if (i == asyncListUtil.f6952o) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            asyncListUtil.f6944g.recycleTile(tileList$Tile);
            return;
        }
        h71 h71Var = asyncListUtil.f6942e;
        SparseArray sparseArray = (SparseArray) h71Var.f17965b;
        int indexOfKey = sparseArray.indexOfKey(tileList$Tile.mStartPosition);
        if (indexOfKey < 0) {
            sparseArray.put(tileList$Tile.mStartPosition, tileList$Tile);
            tileList$Tile2 = null;
        } else {
            TileList$Tile tileList$Tile3 = (TileList$Tile) sparseArray.valueAt(indexOfKey);
            sparseArray.setValueAt(indexOfKey, tileList$Tile);
            if (((TileList$Tile) h71Var.f17966c) == tileList$Tile3) {
                h71Var.f17966c = tileList$Tile;
            }
            tileList$Tile2 = tileList$Tile3;
        }
        if (tileList$Tile2 != null) {
            Log.e("AsyncListUtil", "duplicate tile @" + tileList$Tile2.mStartPosition);
            asyncListUtil.f6944g.recycleTile(tileList$Tile2);
        }
        int i3 = tileList$Tile.mStartPosition + tileList$Tile.mItemCount;
        while (true) {
            SparseIntArray sparseIntArray = asyncListUtil.f6953p;
            if (i2 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i2);
                if (tileList$Tile.mStartPosition <= keyAt && keyAt < i3) {
                    sparseIntArray.removeAt(i2);
                    asyncListUtil.f6941d.onItemLoaded(keyAt);
                } else {
                    i2++;
                }
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public final void removeTile(int i, int i2) {
        AsyncListUtil asyncListUtil = this.f7352a;
        if (i == asyncListUtil.f6952o) {
            h71 h71Var = asyncListUtil.f6942e;
            SparseArray sparseArray = (SparseArray) h71Var.f17965b;
            TileList$Tile tileList$Tile = (TileList$Tile) sparseArray.get(i2);
            if (((TileList$Tile) h71Var.f17966c) == tileList$Tile) {
                h71Var.f17966c = null;
            }
            sparseArray.delete(i2);
            if (tileList$Tile == null) {
                Log.e("AsyncListUtil", "tile not found @" + i2);
                return;
            }
            asyncListUtil.f6944g.recycleTile(tileList$Tile);
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
    public final void updateItemCount(int i, int i2) {
        TileList$Tile tileList$Tile;
        AsyncListUtil asyncListUtil = this.f7352a;
        if (i == asyncListUtil.f6952o) {
            asyncListUtil.f6950m = i2;
            asyncListUtil.f6941d.onDataRefresh();
            asyncListUtil.f6951n = asyncListUtil.f6952o;
            int i3 = 0;
            while (true) {
                h71 h71Var = asyncListUtil.f6942e;
                if (i3 < ((SparseArray) h71Var.f17965b).size()) {
                    if (i3 >= 0) {
                        SparseArray sparseArray = (SparseArray) h71Var.f17965b;
                        if (i3 < sparseArray.size()) {
                            tileList$Tile = (TileList$Tile) sparseArray.valueAt(i3);
                            asyncListUtil.f6944g.recycleTile(tileList$Tile);
                            i3++;
                        }
                    } else {
                        h71Var.getClass();
                    }
                    tileList$Tile = null;
                    asyncListUtil.f6944g.recycleTile(tileList$Tile);
                    i3++;
                } else {
                    ((SparseArray) h71Var.f17965b).clear();
                    asyncListUtil.f6948k = false;
                    asyncListUtil.m1605a();
                    return;
                }
            }
        }
    }
}

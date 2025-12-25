package androidx.recyclerview.widget;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public interface ThreadUtil$MainThreadCallback<T> {
    @SuppressLint({"UnknownNullness"})
    void addTile(int i, TileList$Tile<T> tileList$Tile);

    void removeTile(int i, int i2);

    void updateItemCount(int i, int i2);
}

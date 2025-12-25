package androidx.recyclerview.widget;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public interface ThreadUtil$BackgroundCallback<T> {
    void loadTile(int i, int i2);

    @SuppressLint({"UnknownNullness"})
    void recycleTile(TileList$Tile<T> tileList$Tile);

    void refresh(int i);

    void updateRange(int i, int i2, int i3, int i4, int i5);
}

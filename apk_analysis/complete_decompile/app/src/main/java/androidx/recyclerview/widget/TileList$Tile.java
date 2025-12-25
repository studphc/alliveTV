package androidx.recyclerview.widget;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class TileList$Tile<T> {

    /* renamed from: a */
    public TileList$Tile f7309a;
    public int mItemCount;
    public final T[] mItems;
    public int mStartPosition;

    public TileList$Tile(int i, Class cls) {
        this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }
}

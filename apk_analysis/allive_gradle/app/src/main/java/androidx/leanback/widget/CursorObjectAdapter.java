package androidx.leanback.widget;

import android.database.Cursor;
import android.util.LruCache;
import androidx.annotation.Nullable;
import androidx.leanback.database.CursorMapper;

/* loaded from: classes.dex */
public class CursorObjectAdapter extends ObjectAdapter {

    /* renamed from: d */
    public Cursor f5609d;

    /* renamed from: e */
    public CursorMapper f5610e;

    /* renamed from: f */
    public final LruCache f5611f;

    public CursorObjectAdapter(PresenterSelector presenterSelector) {
        super(presenterSelector);
        this.f5611f = new LruCache(100);
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2 = this.f5609d;
        if (cursor == cursor2) {
            return;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        this.f5609d = cursor;
        this.f5611f.trimToSize(0);
        onCursorChanged();
    }

    public void close() {
        Cursor cursor = this.f5609d;
        if (cursor != null) {
            cursor.close();
            this.f5609d = null;
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    @Nullable
    public Object get(int i) {
        Cursor cursor = this.f5609d;
        if (cursor == null) {
            return null;
        }
        if (cursor.moveToPosition(i)) {
            LruCache lruCache = this.f5611f;
            Object obj = lruCache.get(Integer.valueOf(i));
            if (obj != null) {
                return obj;
            }
            Object convert = this.f5610e.convert(this.f5609d);
            lruCache.put(Integer.valueOf(i), convert);
            return convert;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final Cursor getCursor() {
        return this.f5609d;
    }

    public final CursorMapper getMapper() {
        return this.f5610e;
    }

    public final void invalidateCache(int i) {
        this.f5611f.remove(Integer.valueOf(i));
    }

    public boolean isClosed() {
        Cursor cursor = this.f5609d;
        if (cursor != null && !cursor.isClosed()) {
            return false;
        }
        return true;
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public boolean isImmediateNotifySupported() {
        return true;
    }

    public void onCursorChanged() {
        notifyChanged();
    }

    public void onMapperChanged() {
    }

    public final void setMapper(CursorMapper cursorMapper) {
        boolean z;
        if (this.f5610e != cursorMapper) {
            z = true;
        } else {
            z = false;
        }
        this.f5610e = cursorMapper;
        if (z) {
            onMapperChanged();
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public int size() {
        Cursor cursor = this.f5609d;
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.f5609d;
        if (cursor == cursor2) {
            return cursor2;
        }
        this.f5609d = cursor;
        this.f5611f.trimToSize(0);
        onCursorChanged();
        return cursor2;
    }

    public final void invalidateCache(int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            invalidateCache(i);
            i++;
        }
    }

    public CursorObjectAdapter(Presenter presenter) {
        super(presenter);
        this.f5611f = new LruCache(100);
    }

    public CursorObjectAdapter() {
        this.f5611f = new LruCache(100);
    }
}

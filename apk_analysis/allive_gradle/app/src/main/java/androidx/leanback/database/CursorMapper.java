package androidx.leanback.database;

import android.database.Cursor;

/* loaded from: classes.dex */
public abstract class CursorMapper {

    /* renamed from: a */
    public Cursor f5353a;

    public abstract Object bind(Cursor cursor);

    public abstract void bindColumns(Cursor cursor);

    public Object convert(Cursor cursor) {
        if (cursor != this.f5353a) {
            this.f5353a = cursor;
            bindColumns(cursor);
        }
        return bind(this.f5353a);
    }
}

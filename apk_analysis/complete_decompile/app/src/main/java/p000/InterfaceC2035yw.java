package p000;

import android.database.Cursor;

/* renamed from: yw */
/* loaded from: classes.dex */
public interface InterfaceC2035yw {
    void changeCursor(Cursor cursor);

    CharSequence convertToString(Cursor cursor);

    Cursor getCursor();

    Cursor runQueryOnBackgroundThread(CharSequence charSequence);
}

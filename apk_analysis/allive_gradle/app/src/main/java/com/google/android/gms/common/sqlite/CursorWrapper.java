package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {

    /* renamed from: a */
    public final AbstractWindowedCursor f13616a;

    @KeepForSdk
    public CursorWrapper(@NonNull Cursor cursor) {
        super(cursor);
        for (int i = 0; i < 10 && (cursor instanceof android.database.CursorWrapper); i++) {
            cursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        }
        if (cursor instanceof AbstractWindowedCursor) {
            this.f13616a = (AbstractWindowedCursor) cursor;
            return;
        }
        throw new IllegalArgumentException("Unknown type: ".concat(cursor.getClass().getName()));
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public void fillWindow(int i, @NonNull CursorWindow cursorWindow) {
        this.f13616a.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @Nullable
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.f13616a.getWindow();
    }

    @Override // android.database.CursorWrapper
    @NonNull
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.f13616a;
    }

    @Override // android.database.CrossProcessCursor
    public final boolean onMove(int i, int i2) {
        return this.f13616a.onMove(i, i2);
    }

    @KeepForSdk
    public void setWindow(@Nullable CursorWindow cursorWindow) {
        this.f13616a.setWindow(cursorWindow);
    }
}

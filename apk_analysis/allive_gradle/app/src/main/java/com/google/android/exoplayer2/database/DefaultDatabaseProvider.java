package com.google.android.exoplayer2.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public final class DefaultDatabaseProvider implements DatabaseProvider {

    /* renamed from: a */
    public final SQLiteOpenHelper f9916a;

    public DefaultDatabaseProvider(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f9916a = sQLiteOpenHelper;
    }

    @Override // com.google.android.exoplayer2.database.DatabaseProvider
    public SQLiteDatabase getReadableDatabase() {
        return this.f9916a.getReadableDatabase();
    }

    @Override // com.google.android.exoplayer2.database.DatabaseProvider
    public SQLiteDatabase getWritableDatabase() {
        return this.f9916a.getWritableDatabase();
    }
}

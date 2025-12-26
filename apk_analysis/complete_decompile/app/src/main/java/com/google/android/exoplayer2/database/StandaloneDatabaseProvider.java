package com.google.android.exoplayer2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* loaded from: classes.dex */
public class StandaloneDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider {
    public static final String DATABASE_NAME = "exoplayer_internal.db";

    public StandaloneDatabaseProvider(Context context) {
        super(context.getApplicationContext(), DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"type", AppMeasurementSdk.ConditionalUserProperty.NAME}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                String string = query.getString(0);
                String string2 = query.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    String str = "DROP " + string + " IF EXISTS " + string2;
                    try {
                        sQLiteDatabase.execSQL(str);
                    } catch (SQLException e) {
                        Log.m3024e("SADatabaseProvider", "Error executing " + str, e);
                    }
                }
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        query.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}

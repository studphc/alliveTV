package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import p000.ga3;

/* loaded from: classes.dex */
public final class zzax {
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        if (r3 == false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m3513a(zzhe zzheVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        SQLiteException e;
        Cursor cursor;
        if (zzheVar != null) {
            Cursor cursor2 = null;
            try {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME}, "name=?", new String[]{str}, null, null, null);
                try {
                    try {
                        boolean moveToFirst = cursor.moveToFirst();
                        cursor.close();
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzheVar.zzk().zzc("Error querying for table", str, e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabase.execSQL(str2);
                        try {
                            HashSet hashSet = new HashSet();
                            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
                            try {
                                Collections.addAll(hashSet, rawQuery.getColumnNames());
                                rawQuery.close();
                                for (String str4 : str3.split(",")) {
                                    if (!hashSet.remove(str4)) {
                                        throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                                    }
                                }
                                if (strArr != null) {
                                    for (int i = 0; i < strArr.length; i += 2) {
                                        if (!hashSet.remove(strArr[i])) {
                                            sQLiteDatabase.execSQL(strArr[i + 1]);
                                        }
                                    }
                                }
                                if (!hashSet.isEmpty()) {
                                    zzheVar.zzk().zzc("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                                }
                            } catch (Throwable th) {
                                rawQuery.close();
                                throw th;
                            }
                        } catch (SQLiteException e3) {
                            zzheVar.zze().zzb("Failed to verify columns on table that was just created", str);
                            throw e3;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    /* renamed from: b */
    public static void m3514b(zzhe zzheVar, SQLiteDatabase sQLiteDatabase) {
        if (zzheVar != null) {
            com.google.android.gms.internal.measurement.zzbx.zza();
            String path = sQLiteDatabase.getPath();
            ga3 ga3Var = com.google.android.gms.internal.measurement.zzcc.f13800a;
            File file = new File(path);
            if (!file.setReadable(false, false)) {
                zzheVar.zzk().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzheVar.zzk().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzheVar.zzk().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzheVar.zzk().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}

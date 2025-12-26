package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;
import p000.AbstractC1726qj;
import p000.mb3;

/* loaded from: classes.dex */
public final class zzgv extends mb3 {

    /* renamed from: d */
    public static final String[] f14175d = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};

    /* renamed from: b */
    public final C0791c f14176b;

    /* renamed from: c */
    public boolean f14177c;

    public zzgv(zzio zzioVar) {
        super(zzioVar);
        Context zzaT = this.zzu.zzaT();
        this.zzu.zzf();
        this.f14176b = new C0791c(this, zzaT);
    }

    /* renamed from: a */
    public final SQLiteDatabase m3529a() {
        if (this.f14177c) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f14176b.getWritableDatabase();
        if (writableDatabase == null) {
            this.f14177c = true;
            return null;
        }
        return writableDatabase;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015f  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m3530b(int i, byte[] bArr) {
        zzr zzrVar;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        zzg();
        boolean z = false;
        z = false;
        if (!this.f14177c) {
            zzio zzioVar = this.zzu;
            zzam zzf = zzioVar.zzf();
            zzgg zzggVar = zzgi.zzbl;
            Cursor cursor2 = null;
            if (zzf.zzx(null, zzggVar)) {
                zzrVar = this.zzu.zzh().m3525a(null);
            } else {
                zzrVar = null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("entry", bArr);
            if (zzioVar.zzf().zzx(null, zzggVar) && zzrVar != null) {
                contentValues.put("app_version", zzrVar.zzc);
                contentValues.put("app_version_int", Long.valueOf(zzrVar.zzj));
            }
            zzioVar.zzf();
            int i2 = 0;
            int i3 = 5;
            for (int i4 = 5; i2 < i4; i4 = 5) {
                try {
                    sQLiteDatabase = m3529a();
                    if (sQLiteDatabase == null) {
                        this.f14177c = true;
                    } else {
                        try {
                            sQLiteDatabase.beginTransaction();
                            cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                            long j = 0;
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        j = cursor.getLong(z ? 1 : 0);
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    SystemClock.sleep(i3);
                                    i3 += 20;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i2++;
                                        z = false;
                                    }
                                    sQLiteDatabase.close();
                                    i2++;
                                    z = false;
                                } catch (SQLiteFullException e) {
                                    e = e;
                                    this.zzu.zzaW().zze().zzb("Error writing entry; local database full", e);
                                    this.f14177c = true;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i2++;
                                        z = false;
                                    }
                                    sQLiteDatabase.close();
                                    i2++;
                                    z = false;
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    if (sQLiteDatabase != null) {
                                        try {
                                            if (sQLiteDatabase.inTransaction()) {
                                                sQLiteDatabase.endTransaction();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    this.zzu.zzaW().zze().zzb("Error writing entry to local database", e);
                                    this.f14177c = true;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase == null) {
                                        i2++;
                                        z = false;
                                    }
                                    sQLiteDatabase.close();
                                    i2++;
                                    z = false;
                                }
                            }
                            if (j >= 100000) {
                                zzioVar.zzaW().zze().zza("Data loss, local db full");
                                long j2 = 100001 - j;
                                long delete = sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                                if (delete != j2) {
                                    zzioVar.zzaW().zze().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(delete), Long.valueOf(j2 - delete));
                                }
                            }
                            sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                            if (cursor != null) {
                                cursor.close();
                            }
                            sQLiteDatabase.close();
                            return true;
                        } catch (SQLiteDatabaseLockedException unused2) {
                            cursor = null;
                        } catch (SQLiteFullException e3) {
                            e = e3;
                            cursor = null;
                        } catch (SQLiteException e4) {
                            e = e4;
                            cursor = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused3) {
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (SQLiteFullException e5) {
                    e = e5;
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (SQLiteException e6) {
                    e = e6;
                    sQLiteDatabase = null;
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = null;
                }
            }
            this.zzu.zzaW().zzj().zza("Failed to write entry to local database");
            return false;
        }
        return z;
    }

    @Override // p000.mb3
    public final boolean zzf() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x034f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x034f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x034f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x035d  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzi(int i) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        ArrayList arrayList;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor3;
        long j;
        long j2;
        String str;
        String[] strArr;
        SQLiteDatabase sQLiteDatabase3;
        long j3;
        String str2;
        Parcel obtain;
        zzbf zzbfVar;
        zzai zzaiVar;
        zzqb zzqbVar;
        zzg();
        ?? r6 = 0;
        if (this.f14177c) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        zzio zzioVar = this.zzu;
        Context zzaT = zzioVar.zzaT();
        zzioVar.zzf();
        if (zzaT.getDatabasePath("google_app_measurement_local.db").exists()) {
            int i2 = 5;
            int i3 = 0;
            for (int i4 = 5; i3 < i4; i4 = 5) {
                int i5 = 1;
                try {
                    SQLiteDatabase m3529a = m3529a();
                    if (m3529a == null) {
                        this.f14177c = true;
                        return r6;
                    }
                    try {
                        m3529a.beginTransaction();
                        try {
                            try {
                                cursor3 = m3529a.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
                            } catch (Throwable th) {
                                th = th;
                                sQLiteDatabase2 = m3529a;
                                arrayList = arrayList2;
                                cursor3 = null;
                                if (cursor3 != null) {
                                    try {
                                        cursor3.close();
                                    } catch (SQLiteDatabaseLockedException unused) {
                                        sQLiteDatabase = sQLiteDatabase2;
                                        cursor2 = null;
                                        SystemClock.sleep(i2);
                                        i2 += 20;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i3++;
                                        arrayList2 = arrayList;
                                        r6 = 0;
                                    } catch (SQLiteFullException e) {
                                        e = e;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        cursor2 = null;
                                        this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                        this.f14177c = true;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i3++;
                                        arrayList2 = arrayList;
                                        r6 = 0;
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        cursor2 = null;
                                        if (sQLiteDatabase != null) {
                                        }
                                        this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                        this.f14177c = true;
                                        if (cursor2 != null) {
                                        }
                                        if (sQLiteDatabase == null) {
                                        }
                                        sQLiteDatabase.close();
                                        i3++;
                                        arrayList2 = arrayList;
                                        r6 = 0;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        cursor = null;
                                        if (cursor != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        throw th;
                                    }
                                }
                                throw th;
                                break;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            arrayList = arrayList2;
                            sQLiteDatabase2 = m3529a;
                        }
                        try {
                            j = -1;
                            if (cursor3.moveToFirst()) {
                                j2 = cursor3.getLong(0);
                                try {
                                    cursor3.close();
                                } catch (SQLiteDatabaseLockedException unused2) {
                                    sQLiteDatabase2 = m3529a;
                                    arrayList = arrayList2;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor2 = null;
                                    SystemClock.sleep(i2);
                                    i2 += 20;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase == null) {
                                    }
                                    sQLiteDatabase.close();
                                    i3++;
                                    arrayList2 = arrayList;
                                    r6 = 0;
                                } catch (SQLiteFullException e3) {
                                    e = e3;
                                    sQLiteDatabase2 = m3529a;
                                    arrayList = arrayList2;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor2 = null;
                                    this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                    this.f14177c = true;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase == null) {
                                    }
                                    sQLiteDatabase.close();
                                    i3++;
                                    arrayList2 = arrayList;
                                    r6 = 0;
                                } catch (SQLiteException e4) {
                                    e = e4;
                                    sQLiteDatabase2 = m3529a;
                                    arrayList = arrayList2;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor2 = null;
                                    if (sQLiteDatabase != null) {
                                    }
                                    this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                    this.f14177c = true;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase == null) {
                                    }
                                    sQLiteDatabase.close();
                                    i3++;
                                    arrayList2 = arrayList;
                                    r6 = 0;
                                } catch (Throwable th4) {
                                    th = th4;
                                    sQLiteDatabase2 = m3529a;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor = null;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                cursor3.close();
                                j2 = -1;
                            }
                            if (j2 != -1) {
                                str = "rowid<?";
                                strArr = new String[]{String.valueOf(j2)};
                            } else {
                                str = r6;
                                strArr = str;
                            }
                            String[] strArr2 = {"rowid", "type", "entry"};
                            zzio zzioVar2 = this.zzu;
                            boolean zzx = zzioVar2.zzf().zzx(r6, zzgi.zzbl);
                            int i6 = 3;
                            if (zzx) {
                                strArr2 = new String[i4];
                                strArr2[0] = "rowid";
                                strArr2[1] = "type";
                                strArr2[2] = "entry";
                                strArr2[3] = "app_version";
                                strArr2[4] = "app_version_int";
                            }
                            int i7 = 2;
                            cursor2 = m3529a.query("messages", strArr2, str, strArr, null, null, "rowid asc", Integer.toString(100));
                            while (cursor2.moveToNext()) {
                                try {
                                    try {
                                        try {
                                            j = cursor2.getLong(0);
                                            int i8 = cursor2.getInt(i5);
                                            byte[] blob = cursor2.getBlob(i7);
                                            if (zzioVar2.zzf().zzx(null, zzgi.zzbl)) {
                                                str2 = cursor2.getString(i6);
                                                arrayList = arrayList2;
                                                j3 = cursor2.getLong(4);
                                            } else {
                                                arrayList = arrayList2;
                                                j3 = 0;
                                                str2 = null;
                                            }
                                            if (i8 == 0) {
                                                try {
                                                    obtain = Parcel.obtain();
                                                    try {
                                                        try {
                                                            obtain.unmarshall(blob, 0, blob.length);
                                                            obtain.setDataPosition(0);
                                                            zzbh createFromParcel = zzbh.CREATOR.createFromParcel(obtain);
                                                            if (createFromParcel != null) {
                                                                arrayList.add(new zzgu(createFromParcel, str2, j3));
                                                            }
                                                        } finally {
                                                        }
                                                    } catch (SafeParcelReader.ParseException unused3) {
                                                        this.zzu.zzaW().zze().zza("Failed to load event from local database");
                                                        obtain.recycle();
                                                    }
                                                } catch (SQLiteDatabaseLockedException unused4) {
                                                    sQLiteDatabase3 = m3529a;
                                                    sQLiteDatabase = sQLiteDatabase3;
                                                    SystemClock.sleep(i2);
                                                    i2 += 20;
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                        i3++;
                                                        arrayList2 = arrayList;
                                                        r6 = 0;
                                                    }
                                                    sQLiteDatabase.close();
                                                    i3++;
                                                    arrayList2 = arrayList;
                                                    r6 = 0;
                                                } catch (SQLiteFullException e5) {
                                                    e = e5;
                                                    sQLiteDatabase3 = m3529a;
                                                    sQLiteDatabase = sQLiteDatabase3;
                                                    this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                                    this.f14177c = true;
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                        i3++;
                                                        arrayList2 = arrayList;
                                                        r6 = 0;
                                                    }
                                                    sQLiteDatabase.close();
                                                    i3++;
                                                    arrayList2 = arrayList;
                                                    r6 = 0;
                                                } catch (SQLiteException e6) {
                                                    e = e6;
                                                    sQLiteDatabase3 = m3529a;
                                                    sQLiteDatabase = sQLiteDatabase3;
                                                    if (sQLiteDatabase != null) {
                                                        try {
                                                            if (sQLiteDatabase.inTransaction()) {
                                                                sQLiteDatabase.endTransaction();
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            cursor = cursor2;
                                                            if (cursor != null) {
                                                                cursor.close();
                                                            }
                                                            if (sQLiteDatabase != null) {
                                                                sQLiteDatabase.close();
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                                                    this.f14177c = true;
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    if (sQLiteDatabase == null) {
                                                        i3++;
                                                        arrayList2 = arrayList;
                                                        r6 = 0;
                                                    }
                                                    sQLiteDatabase.close();
                                                    i3++;
                                                    arrayList2 = arrayList;
                                                    r6 = 0;
                                                }
                                            } else if (i8 == 1) {
                                                obtain = Parcel.obtain();
                                                try {
                                                    try {
                                                        obtain.unmarshall(blob, 0, blob.length);
                                                        obtain.setDataPosition(0);
                                                        zzqbVar = zzqb.CREATOR.createFromParcel(obtain);
                                                    } finally {
                                                    }
                                                } catch (SafeParcelReader.ParseException unused5) {
                                                    this.zzu.zzaW().zze().zza("Failed to load user property from local database");
                                                    obtain.recycle();
                                                    zzqbVar = null;
                                                }
                                                if (zzqbVar != null) {
                                                    arrayList.add(new zzgu(zzqbVar, str2, j3));
                                                }
                                            } else if (i8 == 2) {
                                                obtain = Parcel.obtain();
                                                try {
                                                    try {
                                                        obtain.unmarshall(blob, 0, blob.length);
                                                        obtain.setDataPosition(0);
                                                        zzaiVar = zzai.CREATOR.createFromParcel(obtain);
                                                    } finally {
                                                    }
                                                } catch (SafeParcelReader.ParseException unused6) {
                                                    this.zzu.zzaW().zze().zza("Failed to load conditional user property from local database");
                                                    obtain.recycle();
                                                    zzaiVar = null;
                                                }
                                                if (zzaiVar != null) {
                                                    arrayList.add(new zzgu(zzaiVar, str2, j3));
                                                }
                                            } else if (i8 == 4) {
                                                obtain = Parcel.obtain();
                                                try {
                                                    try {
                                                        obtain.unmarshall(blob, 0, blob.length);
                                                        obtain.setDataPosition(0);
                                                        zzbfVar = zzbf.CREATOR.createFromParcel(obtain);
                                                    } finally {
                                                    }
                                                } catch (SafeParcelReader.ParseException unused7) {
                                                    this.zzu.zzaW().zze().zza("Failed to load default event parameters from local database");
                                                    obtain.recycle();
                                                    zzbfVar = null;
                                                }
                                                if (zzbfVar != null) {
                                                    arrayList.add(new zzgu(zzbfVar, str2, j3));
                                                }
                                            } else {
                                                i6 = 3;
                                                if (i8 == 3) {
                                                    this.zzu.zzaW().zzk().zza("Skipping app launch break");
                                                } else {
                                                    this.zzu.zzaW().zze().zza("Unknown record type in local database");
                                                }
                                                arrayList2 = arrayList;
                                                i7 = 2;
                                                i5 = 1;
                                            }
                                            i6 = 3;
                                            arrayList2 = arrayList;
                                            i7 = 2;
                                            i5 = 1;
                                        } catch (SQLiteDatabaseLockedException unused8) {
                                            arrayList = arrayList2;
                                        } catch (SQLiteFullException e7) {
                                            e = e7;
                                            arrayList = arrayList2;
                                        } catch (SQLiteException e8) {
                                            e = e8;
                                            arrayList = arrayList2;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        sQLiteDatabase3 = m3529a;
                                    }
                                } catch (SQLiteDatabaseLockedException unused9) {
                                    sQLiteDatabase3 = m3529a;
                                    arrayList = arrayList2;
                                } catch (SQLiteFullException e9) {
                                    e = e9;
                                    sQLiteDatabase3 = m3529a;
                                    arrayList = arrayList2;
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    sQLiteDatabase3 = m3529a;
                                    arrayList = arrayList2;
                                }
                            }
                            arrayList = arrayList2;
                            sQLiteDatabase3 = m3529a;
                        } catch (Throwable th7) {
                            th = th7;
                            sQLiteDatabase2 = m3529a;
                            arrayList = arrayList2;
                            if (cursor3 != null) {
                            }
                            throw th;
                            break;
                            break;
                        }
                    } catch (SQLiteDatabaseLockedException unused10) {
                        arrayList = arrayList2;
                        sQLiteDatabase2 = m3529a;
                    } catch (SQLiteFullException e11) {
                        e = e11;
                        arrayList = arrayList2;
                        sQLiteDatabase2 = m3529a;
                    } catch (SQLiteException e12) {
                        e = e12;
                        arrayList = arrayList2;
                        sQLiteDatabase2 = m3529a;
                    } catch (Throwable th8) {
                        th = th8;
                        sQLiteDatabase2 = m3529a;
                    }
                    try {
                        if (sQLiteDatabase3.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                            this.zzu.zzaW().zze().zza("Fewer entries removed from local database than expected");
                        }
                        sQLiteDatabase3.setTransactionSuccessful();
                        sQLiteDatabase3.endTransaction();
                        cursor2.close();
                        sQLiteDatabase3.close();
                        return arrayList;
                    } catch (SQLiteDatabaseLockedException unused11) {
                        sQLiteDatabase = sQLiteDatabase3;
                        SystemClock.sleep(i2);
                        i2 += 20;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i3++;
                        arrayList2 = arrayList;
                        r6 = 0;
                    } catch (SQLiteFullException e13) {
                        e = e13;
                        sQLiteDatabase = sQLiteDatabase3;
                        this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                        this.f14177c = true;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i3++;
                        arrayList2 = arrayList;
                        r6 = 0;
                    } catch (SQLiteException e14) {
                        e = e14;
                        sQLiteDatabase = sQLiteDatabase3;
                        if (sQLiteDatabase != null) {
                        }
                        this.zzu.zzaW().zze().zzb("Error reading entries from local database", e);
                        this.f14177c = true;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        sQLiteDatabase.close();
                        i3++;
                        arrayList2 = arrayList;
                        r6 = 0;
                    } catch (Throwable th9) {
                        th = th9;
                        sQLiteDatabase = sQLiteDatabase3;
                        cursor = cursor2;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                } catch (SQLiteDatabaseLockedException unused12) {
                    arrayList = arrayList2;
                    cursor2 = null;
                    sQLiteDatabase = null;
                } catch (SQLiteFullException e15) {
                    e = e15;
                    arrayList = arrayList2;
                    cursor2 = null;
                    sQLiteDatabase = null;
                } catch (SQLiteException e16) {
                    e = e16;
                    arrayList = arrayList2;
                    cursor2 = null;
                    sQLiteDatabase = null;
                } catch (Throwable th10) {
                    th = th10;
                    cursor = null;
                    sQLiteDatabase = null;
                }
            }
            AbstractC1726qj.m7037B(this.zzu, "Failed to read events from database in reasonable time");
            return null;
        }
        return arrayList2;
    }

    @WorkerThread
    public final void zzj() {
        int delete;
        zzg();
        try {
            SQLiteDatabase m3529a = m3529a();
            if (m3529a != null && (delete = m3529a.delete("messages", null, null)) > 0) {
                this.zzu.zzaW().zzj().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzb("Error resetting local analytics data. error", e);
        }
    }

    @WorkerThread
    public final boolean zzk() {
        return m3530b(3, new byte[0]);
    }

    @WorkerThread
    public final boolean zzm() {
        zzg();
        if (!this.f14177c) {
            zzio zzioVar = this.zzu;
            Context zzaT = zzioVar.zzaT();
            zzioVar.zzf();
            if (zzaT.getDatabasePath("google_app_measurement_local.db").exists()) {
                int i = 5;
                int i2 = 0;
                while (true) {
                    if (i2 < 5) {
                        SQLiteDatabase sQLiteDatabase = null;
                        try {
                            try {
                                try {
                                    SQLiteDatabase m3529a = m3529a();
                                    if (m3529a == null) {
                                        this.f14177c = true;
                                    } else {
                                        m3529a.beginTransaction();
                                        m3529a.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                        m3529a.setTransactionSuccessful();
                                        m3529a.endTransaction();
                                        m3529a.close();
                                        return true;
                                    }
                                } catch (SQLiteException e) {
                                    if (0 != 0) {
                                        try {
                                            if (sQLiteDatabase.inTransaction()) {
                                                sQLiteDatabase.endTransaction();
                                            }
                                        } catch (Throwable th) {
                                            if (0 != 0) {
                                                sQLiteDatabase.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    this.zzu.zzaW().zze().zzb("Error deleting app launch break from local database", e);
                                    this.f14177c = true;
                                    if (0 != 0) {
                                        sQLiteDatabase.close();
                                    }
                                }
                            } catch (SQLiteDatabaseLockedException unused) {
                                SystemClock.sleep(i);
                                i += 20;
                                if (0 == 0) {
                                }
                                sQLiteDatabase.close();
                            }
                        } catch (SQLiteFullException e2) {
                            this.zzu.zzaW().zze().zzb("Error deleting app launch break from local database", e2);
                            this.f14177c = true;
                            if (0 == 0) {
                            }
                            sQLiteDatabase.close();
                        }
                    } else {
                        AbstractC1726qj.m7037B(this.zzu, "Error deleting app launch break from local database in reasonable time");
                        break;
                    }
                    i2++;
                }
            }
        }
        return false;
    }

    public final boolean zzn(zzai zzaiVar) {
        zzio zzioVar = this.zzu;
        zzioVar.zzw().getClass();
        byte[] m3704L = zzqf.m3704L(zzaiVar);
        if (m3704L.length > 131072) {
            zzioVar.zzaW().zzh().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return m3530b(2, m3704L);
    }

    public final boolean zzo(zzbf zzbfVar) {
        zzio zzioVar = this.zzu;
        zzioVar.zzw().getClass();
        byte[] m3704L = zzqf.m3704L(zzbfVar);
        if (m3704L == null) {
            zzioVar.zzaW().zzh().zza("Null default event parameters; not writing to database");
            return false;
        }
        if (m3704L.length > 131072) {
            zzioVar.zzaW().zzh().zza("Default event parameters too long for local database. Sending directly to service");
            return false;
        }
        return m3530b(4, m3704L);
    }

    public final boolean zzp(zzbh zzbhVar) {
        Parcel obtain = Parcel.obtain();
        zzbi.m3520a(zzbhVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaW().zzh().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return m3530b(0, marshall);
    }

    public final boolean zzq(zzqb zzqbVar) {
        Parcel obtain = Parcel.obtain();
        zzqc.m3697a(zzqbVar, obtain);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaW().zzh().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return m3530b(1, marshall);
    }
}

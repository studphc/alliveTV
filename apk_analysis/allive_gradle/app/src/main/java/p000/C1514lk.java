package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: lk */
/* loaded from: classes.dex */
public final class C1514lk implements InterfaceC1588nk {

    /* renamed from: e */
    public static final String[] f22540e = {"id", "key", "metadata"};

    /* renamed from: a */
    public final DatabaseProvider f22541a;

    /* renamed from: b */
    public final SparseArray f22542b = new SparseArray();

    /* renamed from: c */
    public String f22543c;

    /* renamed from: d */
    public String f22544d;

    public C1514lk(DatabaseProvider databaseProvider) {
        this.f22541a = databaseProvider;
    }

    /* renamed from: i */
    public static void m5929i(DatabaseProvider databaseProvider, String str) {
        try {
            String str2 = "ExoPlayerCacheIndex" + str;
            SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                VersionTable.removeVersion(writableDatabase, 1, str);
                writableDatabase.execSQL("DROP TABLE IF EXISTS " + str2);
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: a */
    public final void mo5930a(HashMap hashMap) {
        try {
            SQLiteDatabase writableDatabase = this.f22541a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                m5938j(writableDatabase);
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    m5937h(writableDatabase, (C1394kk) it.next());
                }
                writableDatabase.setTransactionSuccessful();
                this.f22542b.clear();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: b */
    public final void mo5931b(C1394kk c1394kk, boolean z) {
        SparseArray sparseArray = this.f22542b;
        int i = c1394kk.f20877a;
        if (z) {
            sparseArray.delete(i);
        } else {
            sparseArray.put(i, null);
        }
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: c */
    public final void mo5932c(C1394kk c1394kk) {
        this.f22542b.put(c1394kk.f20877a, c1394kk);
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: d */
    public final boolean mo5933d() {
        if (VersionTable.getVersion(this.f22541a.getReadableDatabase(), 1, (String) Assertions.checkNotNull(this.f22543c)) != -1) {
            return true;
        }
        return false;
    }

    @Override // p000.InterfaceC1588nk
    public final void delete() {
        m5929i(this.f22541a, (String) Assertions.checkNotNull(this.f22543c));
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: e */
    public final void mo5934e(HashMap hashMap) {
        SparseArray sparseArray = this.f22542b;
        if (sparseArray.size() == 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f22541a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (int i = 0; i < sparseArray.size(); i++) {
                try {
                    C1394kk c1394kk = (C1394kk) sparseArray.valueAt(i);
                    if (c1394kk == null) {
                        writableDatabase.delete((String) Assertions.checkNotNull(this.f22544d), "id = ?", new String[]{Integer.toString(sparseArray.keyAt(i))});
                    } else {
                        m5937h(writableDatabase, c1394kk);
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            writableDatabase.setTransactionSuccessful();
            sparseArray.clear();
            writableDatabase.endTransaction();
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: f */
    public final void mo5935f(long j) {
        String hexString = Long.toHexString(j);
        this.f22543c = hexString;
        this.f22544d = AbstractC1726qj.m7038C("ExoPlayerCacheIndex", hexString);
    }

    @Override // p000.InterfaceC1588nk
    /* renamed from: g */
    public final void mo5936g(HashMap hashMap, SparseArray sparseArray) {
        boolean z;
        DatabaseProvider databaseProvider = this.f22541a;
        if (this.f22542b.size() == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        try {
            if (VersionTable.getVersion(databaseProvider.getReadableDatabase(), 1, (String) Assertions.checkNotNull(this.f22543c)) != 1) {
                SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    m5938j(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            Cursor query = databaseProvider.getReadableDatabase().query((String) Assertions.checkNotNull(this.f22544d), f22540e, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String str = (String) Assertions.checkNotNull(query.getString(1));
                    hashMap.put(str, new C1394kk(i, str, C1625ok.m6572a(new DataInputStream(new ByteArrayInputStream(query.getBlob(2))))));
                    sparseArray.put(i, str);
                } finally {
                }
            }
            query.close();
        } catch (SQLiteException e) {
            hashMap.clear();
            sparseArray.clear();
            throw new DatabaseIOException(e);
        }
    }

    /* renamed from: h */
    public final void m5937h(SQLiteDatabase sQLiteDatabase, C1394kk c1394kk) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1625ok.m6573b(c1394kk.f20881e, new DataOutputStream(byteArrayOutputStream));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(c1394kk.f20877a));
        contentValues.put("key", c1394kk.f20878b);
        contentValues.put("metadata", byteArray);
        sQLiteDatabase.replaceOrThrow((String) Assertions.checkNotNull(this.f22544d), null, contentValues);
    }

    /* renamed from: j */
    public final void m5938j(SQLiteDatabase sQLiteDatabase) {
        VersionTable.setVersion(sQLiteDatabase, 1, (String) Assertions.checkNotNull(this.f22543c), 1);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ((String) Assertions.checkNotNull(this.f22544d)));
        sQLiteDatabase.execSQL("CREATE TABLE " + this.f22544d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
    }
}

package com.google.android.exoplayer2.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.AbstractC1726qj;
import p000.l00;

/* loaded from: classes.dex */
public final class DefaultDownloadIndex implements WritableDownloadIndex {

    /* renamed from: f */
    public static final String f10770f = m2697f(3, 4);

    /* renamed from: g */
    public static final String[] f10771g = {"id", "mime_type", "uri", "stream_keys", "custom_cache_key", DataSchemeDataSource.SCHEME_DATA, "state", "start_time_ms", "update_time_ms", "content_length", DownloadService.KEY_STOP_REASON, "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};

    /* renamed from: a */
    public final String f10772a;

    /* renamed from: b */
    public final String f10773b;

    /* renamed from: c */
    public final DatabaseProvider f10774c;

    /* renamed from: d */
    public final Object f10775d;

    /* renamed from: e */
    public boolean f10776e;

    public DefaultDownloadIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, "");
    }

    /* renamed from: a */
    public static ArrayList m2694a(String str) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : Util.split(str, ",")) {
            String[] split = Util.split(str2, "\\.");
            if (split.length == 3) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkState(z);
            arrayList.add(new StreamKey(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }
        return arrayList;
    }

    /* renamed from: d */
    public static Download m2695d(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        int i = 0;
        DownloadRequest.Builder streamKeys = new DownloadRequest.Builder((String) Assertions.checkNotNull(cursor.getString(0)), Uri.parse((String) Assertions.checkNotNull(cursor.getString(2)))).setMimeType(cursor.getString(1)).setStreamKeys(m2694a(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest build = streamKeys.setKeySetId(blob).setCustomCacheKey(cursor.getString(4)).setData(cursor.getBlob(5)).build();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i2 = cursor.getInt(6);
        if (i2 == 4) {
            i = cursor.getInt(11);
        }
        return new Download(build, i2, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i, downloadProgress);
    }

    /* renamed from: e */
    public static Download m2696e(Cursor cursor) {
        String str;
        int i = 0;
        DownloadRequest.Builder builder = new DownloadRequest.Builder((String) Assertions.checkNotNull(cursor.getString(0)), Uri.parse((String) Assertions.checkNotNull(cursor.getString(2))));
        String string = cursor.getString(1);
        if ("dash".equals(string)) {
            str = MimeTypes.APPLICATION_MPD;
        } else if ("hls".equals(string)) {
            str = MimeTypes.APPLICATION_M3U8;
        } else if ("ss".equals(string)) {
            str = MimeTypes.APPLICATION_SS;
        } else {
            str = MimeTypes.VIDEO_UNKNOWN;
        }
        DownloadRequest build = builder.setMimeType(str).setStreamKeys(m2694a(cursor.getString(3))).setCustomCacheKey(cursor.getString(4)).setData(cursor.getBlob(5)).build();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i2 = cursor.getInt(6);
        if (i2 == 4) {
            i = cursor.getInt(11);
        }
        return new Download(build, i2, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i, downloadProgress);
    }

    /* renamed from: f */
    public static String m2697f(int... iArr) {
        if (iArr.length == 0) {
            return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
        }
        StringBuilder sb = new StringBuilder("state IN (");
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(iArr[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: b */
    public final void m2698b() {
        ArrayList arrayList;
        synchronized (this.f10775d) {
            if (this.f10776e) {
                return;
            }
            try {
                int version = VersionTable.getVersion(this.f10774c.getReadableDatabase(), 0, this.f10772a);
                if (version != 3) {
                    SQLiteDatabase writableDatabase = this.f10774c.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        VersionTable.setVersion(writableDatabase, 0, this.f10772a, 3);
                        if (version == 2) {
                            arrayList = m2700g(writableDatabase);
                        } else {
                            arrayList = new ArrayList();
                        }
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f10773b);
                        writableDatabase.execSQL("CREATE TABLE " + this.f10773b + " (id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            m2701h((Download) it.next(), writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                this.f10776e = true;
            } catch (SQLException e) {
                throw new DatabaseIOException(e);
            }
        }
    }

    /* renamed from: c */
    public final Cursor m2699c(String str, String[] strArr) {
        try {
            return this.f10774c.getReadableDatabase().query(this.f10773b, f10771g, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e) {
            throw new DatabaseIOException(e);
        }
    }

    /* renamed from: g */
    public final ArrayList m2700g(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (!Util.tableExists(sQLiteDatabase, this.f10773b)) {
            return arrayList;
        }
        Cursor query = sQLiteDatabase.query(this.f10773b, new String[]{"id", "title", "uri", "stream_keys", "custom_cache_key", DataSchemeDataSource.SCHEME_DATA, "state", "start_time_ms", "update_time_ms", "content_length", DownloadService.KEY_STOP_REASON, "failure_reason", "percent_downloaded", "bytes_downloaded"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(m2696e(query));
            } finally {
            }
        }
        query.close();
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.offline.DownloadIndex
    @Nullable
    public Download getDownload(String str) {
        m2698b();
        try {
            Cursor m2699c = m2699c("id = ?", new String[]{str});
            try {
                if (m2699c.getCount() == 0) {
                    m2699c.close();
                    return null;
                }
                m2699c.moveToNext();
                Download m2695d = m2695d(m2699c);
                m2699c.close();
                return m2695d;
            } finally {
            }
        } catch (SQLiteException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadIndex
    public DownloadCursor getDownloads(int... iArr) {
        m2698b();
        return new l00(m2699c(m2697f(iArr), null));
    }

    /* renamed from: h */
    public final void m2701h(Download download, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.request.keySetId;
        if (bArr == null) {
            bArr = Util.EMPTY_BYTE_ARRAY;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.request.f10811id);
        contentValues.put("mime_type", download.request.mimeType);
        contentValues.put("uri", download.request.uri.toString());
        List<StreamKey> list = download.request.streamKeys;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            StreamKey streamKey = list.get(i);
            sb.append(streamKey.periodIndex);
            sb.append('.');
            sb.append(streamKey.groupIndex);
            sb.append('.');
            sb.append(streamKey.streamIndex);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        contentValues.put("stream_keys", sb.toString());
        contentValues.put("custom_cache_key", download.request.customCacheKey);
        contentValues.put(DataSchemeDataSource.SCHEME_DATA, download.request.data);
        contentValues.put("state", Integer.valueOf(download.state));
        contentValues.put("start_time_ms", Long.valueOf(download.startTimeMs));
        contentValues.put("update_time_ms", Long.valueOf(download.updateTimeMs));
        contentValues.put("content_length", Long.valueOf(download.contentLength));
        contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(download.stopReason));
        contentValues.put("failure_reason", Integer.valueOf(download.failureReason));
        contentValues.put("percent_downloaded", Float.valueOf(download.getPercentDownloaded()));
        contentValues.put("bytes_downloaded", Long.valueOf(download.getBytesDownloaded()));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.f10773b, null, contentValues);
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void putDownload(Download download) {
        m2698b();
        try {
            m2701h(download, this.f10774c.getWritableDatabase());
        } catch (SQLiteException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void removeDownload(String str) {
        m2698b();
        try {
            this.f10774c.getWritableDatabase().delete(this.f10773b, "id = ?", new String[]{str});
        } catch (SQLiteException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setDownloadingStatesToQueued() {
        m2698b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.f10774c.getWritableDatabase().update(this.f10773b, contentValues, "state = 2", null);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStatesToRemoving() {
        m2698b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put("failure_reason", (Integer) 0);
            this.f10774c.getWritableDatabase().update(this.f10773b, contentValues, null, null);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(int i) {
        m2698b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(i));
            this.f10774c.getWritableDatabase().update(this.f10773b, contentValues, f10770f, null);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider, String str) {
        this.f10772a = str;
        this.f10774c = databaseProvider;
        this.f10773b = AbstractC1726qj.m7038C("ExoPlayerDownloads", str);
        this.f10775d = new Object();
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(String str, int i) {
        m2698b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(i));
            this.f10774c.getWritableDatabase().update(this.f10773b, contentValues, f10770f + " AND id = ?", new String[]{str});
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}

package com.google.android.exoplayer2.upstream.cache;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import p000.lc2;

/* loaded from: classes.dex */
public final class CacheDataSink implements DataSink {
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    public static final long DEFAULT_FRAGMENT_SIZE = 5242880;

    /* renamed from: a */
    public final Cache f12580a;

    /* renamed from: b */
    public final long f12581b;

    /* renamed from: c */
    public final int f12582c;

    /* renamed from: d */
    public DataSpec f12583d;

    /* renamed from: e */
    public long f12584e;

    /* renamed from: f */
    public File f12585f;

    /* renamed from: g */
    public OutputStream f12586g;

    /* renamed from: h */
    public long f12587h;

    /* renamed from: i */
    public long f12588i;

    /* renamed from: j */
    public lc2 f12589j;

    /* loaded from: classes.dex */
    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    /* loaded from: classes.dex */
    public static final class Factory implements DataSink.Factory {

        /* renamed from: a */
        public Cache f12590a;

        /* renamed from: b */
        public long f12591b = CacheDataSink.DEFAULT_FRAGMENT_SIZE;

        /* renamed from: c */
        public int f12592c = CacheDataSink.DEFAULT_BUFFER_SIZE;

        @Override // com.google.android.exoplayer2.upstream.DataSink.Factory
        public DataSink createDataSink() {
            return new CacheDataSink((Cache) Assertions.checkNotNull(this.f12590a), this.f12591b, this.f12592c);
        }

        public Factory setBufferSize(int i) {
            this.f12592c = i;
            return this;
        }

        public Factory setCache(Cache cache) {
            this.f12590a = cache;
            return this;
        }

        public Factory setFragmentSize(long j) {
            this.f12591b = j;
            return this;
        }
    }

    public CacheDataSink(Cache cache, long j) {
        this(cache, j, DEFAULT_BUFFER_SIZE);
    }

    /* renamed from: a */
    public final void m2990a() {
        OutputStream outputStream = this.f12586g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            Util.closeQuietly(this.f12586g);
            this.f12586g = null;
            File file = (File) Util.castNonNull(this.f12585f);
            this.f12585f = null;
            this.f12580a.commitFile(file, this.f12587h);
        } catch (Throwable th) {
            Util.closeQuietly(this.f12586g);
            this.f12586g = null;
            File file2 = (File) Util.castNonNull(this.f12585f);
            this.f12585f = null;
            file2.delete();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [lc2, java.io.BufferedOutputStream] */
    /* renamed from: b */
    public final void m2991b(DataSpec dataSpec) {
        long j = dataSpec.length;
        long j2 = -1;
        if (j != -1) {
            j2 = Math.min(j - this.f12588i, this.f12584e);
        }
        long j3 = j2;
        this.f12585f = this.f12580a.startFile((String) Util.castNonNull(dataSpec.key), dataSpec.position + this.f12588i, j3);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f12585f);
        int i = this.f12582c;
        if (i > 0) {
            lc2 lc2Var = this.f12589j;
            if (lc2Var == null) {
                this.f12589j = new BufferedOutputStream(fileOutputStream, i);
            } else {
                lc2Var.m5920a(fileOutputStream);
            }
            this.f12586g = this.f12589j;
        } else {
            this.f12586g = fileOutputStream;
        }
        this.f12587h = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() {
        if (this.f12583d == null) {
            return;
        }
        try {
            m2990a();
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec) {
        long j;
        Assertions.checkNotNull(dataSpec.key);
        if (dataSpec.length == -1 && dataSpec.isFlagSet(2)) {
            this.f12583d = null;
            return;
        }
        this.f12583d = dataSpec;
        if (dataSpec.isFlagSet(4)) {
            j = this.f12581b;
        } else {
            j = Long.MAX_VALUE;
        }
        this.f12584e = j;
        this.f12588i = 0L;
        try {
            m2991b(dataSpec);
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) {
        DataSpec dataSpec = this.f12583d;
        if (dataSpec == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.f12587h == this.f12584e) {
                    m2990a();
                    m2991b(dataSpec);
                }
                int min = (int) Math.min(i2 - i3, this.f12584e - this.f12587h);
                ((OutputStream) Util.castNonNull(this.f12586g)).write(bArr, i + i3, min);
                i3 += min;
                long j = min;
                this.f12587h += j;
                this.f12588i += j;
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }

    public CacheDataSink(Cache cache, long j, int i) {
        Assertions.checkState(j > 0 || j == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j != -1 && j < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            Log.m3027w("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f12580a = (Cache) Assertions.checkNotNull(cache);
        this.f12581b = j == -1 ? Long.MAX_VALUE : j;
        this.f12582c = i;
    }
}

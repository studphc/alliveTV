package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import p000.AbstractC1997xv;

/* loaded from: classes.dex */
public final class CacheWriter {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;

    /* renamed from: a */
    public final CacheDataSource f12624a;

    /* renamed from: b */
    public final Cache f12625b;

    /* renamed from: c */
    public final DataSpec f12626c;

    /* renamed from: d */
    public final String f12627d;

    /* renamed from: e */
    public final byte[] f12628e;

    /* renamed from: f */
    public final ProgressListener f12629f;

    /* renamed from: g */
    public long f12630g;

    /* renamed from: h */
    public long f12631h;

    /* renamed from: i */
    public long f12632i;

    /* renamed from: j */
    public volatile boolean f12633j;

    /* loaded from: classes.dex */
    public interface ProgressListener {
        void onProgress(long j, long j2, long j3);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, @Nullable byte[] bArr, @Nullable ProgressListener progressListener) {
        this.f12624a = cacheDataSource;
        this.f12625b = cacheDataSource.getCache();
        this.f12626c = dataSpec;
        this.f12628e = bArr == null ? new byte[131072] : bArr;
        this.f12629f = progressListener;
        this.f12627d = cacheDataSource.getCacheKeyFactory().buildCacheKey(dataSpec);
        this.f12630g = dataSpec.position;
    }

    /* renamed from: a */
    public final long m2995a() {
        long j = this.f12631h;
        if (j == -1) {
            return -1L;
        }
        return j - this.f12626c.position;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0138, code lost:
    
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef A[Catch: IOException -> 0x0131, TryCatch #2 {IOException -> 0x0131, blocks: (B:58:0x00e8, B:61:0x00ef, B:63:0x00f5, B:71:0x0107, B:73:0x010b, B:76:0x0114, B:78:0x011e, B:79:0x012c, B:84:0x0133, B:85:0x0138, B:89:0x013b, B:92:0x0144, B:94:0x014a), top: B:57:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0107 A[Catch: IOException -> 0x0131, TryCatch #2 {IOException -> 0x0131, blocks: (B:58:0x00e8, B:61:0x00ef, B:63:0x00f5, B:71:0x0107, B:73:0x010b, B:76:0x0114, B:78:0x011e, B:79:0x012c, B:84:0x0133, B:85:0x0138, B:89:0x013b, B:92:0x0144, B:94:0x014a), top: B:57:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013b A[Catch: IOException -> 0x0131, TryCatch #2 {IOException -> 0x0131, blocks: (B:58:0x00e8, B:61:0x00ef, B:63:0x00f5, B:71:0x0107, B:73:0x010b, B:76:0x0114, B:78:0x011e, B:79:0x012c, B:84:0x0133, B:85:0x0138, B:89:0x013b, B:92:0x0144, B:94:0x014a), top: B:57:0x00e8 }] */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cache() {
        long j;
        boolean z;
        long j2;
        int i;
        long j3;
        if (!this.f12633j) {
            DataSpec dataSpec = this.f12626c;
            this.f12632i = this.f12625b.getCachedBytes(this.f12627d, dataSpec.position, dataSpec.length);
            long j4 = dataSpec.length;
            long j5 = -1;
            if (j4 != -1) {
                this.f12631h = dataSpec.position + j4;
            } else {
                long m8193a = AbstractC1997xv.m8193a(this.f12625b.getContentMetadata(this.f12627d));
                if (m8193a == -1) {
                    m8193a = -1;
                }
                this.f12631h = m8193a;
            }
            ProgressListener progressListener = this.f12629f;
            if (progressListener != null) {
                progressListener.onProgress(m2995a(), this.f12632i, 0L);
            }
            loop0: while (true) {
                long j6 = this.f12631h;
                if (j6 != j5 && this.f12630g >= j6) {
                    return;
                }
                if (!this.f12633j) {
                    long j7 = this.f12631h;
                    if (j7 == j5) {
                        j = Long.MAX_VALUE;
                    } else {
                        j = j7 - this.f12630g;
                    }
                    long cachedLength = this.f12625b.getCachedLength(this.f12627d, this.f12630g, j);
                    if (cachedLength > 0) {
                        this.f12630g += cachedLength;
                    } else {
                        long j8 = -cachedLength;
                        if (j8 == Long.MAX_VALUE) {
                            j8 = j5;
                        }
                        long j9 = this.f12630g;
                        boolean z2 = true;
                        int i2 = 0;
                        if (j9 + j8 != this.f12631h && j8 != j5) {
                            z = false;
                        } else {
                            z = true;
                        }
                        CacheDataSource cacheDataSource = this.f12624a;
                        if (j8 != j5) {
                            try {
                                j2 = cacheDataSource.open(dataSpec.buildUpon().setPosition(j9).setLength(j8).build());
                            } catch (IOException unused) {
                                DataSourceUtil.closeQuietly(cacheDataSource);
                            }
                            if (!z2) {
                                if (!this.f12633j) {
                                    try {
                                        j2 = cacheDataSource.open(dataSpec.buildUpon().setPosition(j9).setLength(j5).build());
                                    } catch (IOException e) {
                                        DataSourceUtil.closeQuietly(cacheDataSource);
                                        throw e;
                                    }
                                } else {
                                    throw new InterruptedIOException();
                                }
                            }
                            if (z && j2 != j5) {
                                j3 = j2 + j9;
                                try {
                                    if (this.f12631h == j3) {
                                        this.f12631h = j3;
                                        ProgressListener progressListener2 = this.f12629f;
                                        if (progressListener2 != null) {
                                            progressListener2.onProgress(m2995a(), this.f12632i, 0L);
                                        }
                                    }
                                } catch (IOException e2) {
                                    DataSourceUtil.closeQuietly(cacheDataSource);
                                    throw e2;
                                }
                            }
                            i = 0;
                            int i3 = 0;
                            while (i != -1) {
                                if (this.f12633j) {
                                    break loop0;
                                }
                                byte[] bArr = this.f12628e;
                                i = cacheDataSource.read(bArr, i2, bArr.length);
                                if (i != -1) {
                                    long j10 = i;
                                    this.f12632i += j10;
                                    ProgressListener progressListener3 = this.f12629f;
                                    if (progressListener3 != null) {
                                        progressListener3.onProgress(m2995a(), this.f12632i, j10);
                                    }
                                    i3 += i;
                                    i2 = 0;
                                }
                            }
                            if (z) {
                                long j11 = i3 + j9;
                                if (this.f12631h != j11) {
                                    this.f12631h = j11;
                                    ProgressListener progressListener4 = this.f12629f;
                                    if (progressListener4 != null) {
                                        progressListener4.onProgress(m2995a(), this.f12632i, 0L);
                                    }
                                }
                            }
                            cacheDataSource.close();
                            this.f12630g = j9 + i3;
                        }
                        j2 = j5;
                        z2 = false;
                        if (!z2) {
                        }
                        if (z) {
                            j3 = j2 + j9;
                            if (this.f12631h == j3) {
                            }
                        }
                        i = 0;
                        int i32 = 0;
                        while (i != -1) {
                        }
                        if (z) {
                        }
                        cacheDataSource.close();
                        this.f12630g = j9 + i32;
                    }
                    j5 = -1;
                } else {
                    throw new InterruptedIOException();
                }
            }
        } else {
            throw new InterruptedIOException();
        }
    }

    public void cancel() {
        this.f12633j = true;
    }
}

package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.PlaceholderDataSource;
import com.google.android.exoplayer2.upstream.PriorityDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p000.AbstractC1997xv;

/* loaded from: classes.dex */
public final class CacheDataSource implements DataSource {
    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;

    /* renamed from: a */
    public final Cache f12593a;

    /* renamed from: b */
    public final DataSource f12594b;

    /* renamed from: c */
    public final TeeDataSource f12595c;

    /* renamed from: d */
    public final DataSource f12596d;

    /* renamed from: e */
    public final CacheKeyFactory f12597e;

    /* renamed from: f */
    public final EventListener f12598f;

    /* renamed from: g */
    public final boolean f12599g;

    /* renamed from: h */
    public final boolean f12600h;

    /* renamed from: i */
    public final boolean f12601i;

    /* renamed from: j */
    public Uri f12602j;

    /* renamed from: k */
    public DataSpec f12603k;

    /* renamed from: l */
    public DataSpec f12604l;

    /* renamed from: m */
    public DataSource f12605m;

    /* renamed from: n */
    public long f12606n;

    /* renamed from: o */
    public long f12607o;

    /* renamed from: p */
    public long f12608p;

    /* renamed from: q */
    public CacheSpan f12609q;

    /* renamed from: r */
    public boolean f12610r;

    /* renamed from: s */
    public boolean f12611s;

    /* renamed from: t */
    public long f12612t;

    /* renamed from: u */
    public long f12613u;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface CacheIgnoredReason {
    }

    /* loaded from: classes.dex */
    public interface EventListener {
        void onCacheIgnored(int i);

        void onCachedBytesRead(long j, long j2);
    }

    /* loaded from: classes.dex */
    public static final class Factory implements DataSource.Factory {

        /* renamed from: a */
        public Cache f12614a;

        /* renamed from: c */
        public DataSink.Factory f12616c;

        /* renamed from: e */
        public boolean f12618e;

        /* renamed from: f */
        public DataSource.Factory f12619f;

        /* renamed from: g */
        public PriorityTaskManager f12620g;

        /* renamed from: h */
        public int f12621h;

        /* renamed from: i */
        public int f12622i;

        /* renamed from: j */
        public EventListener f12623j;

        /* renamed from: b */
        public DataSource.Factory f12615b = new FileDataSource.Factory();

        /* renamed from: d */
        public CacheKeyFactory f12617d = CacheKeyFactory.DEFAULT;

        /* renamed from: a */
        public final CacheDataSource m2994a(DataSource dataSource, int i, int i2) {
            DataSink dataSink;
            Cache cache = (Cache) Assertions.checkNotNull(this.f12614a);
            if (!this.f12618e && dataSource != null) {
                DataSink.Factory factory = this.f12616c;
                if (factory != null) {
                    dataSink = factory.createDataSink();
                } else {
                    dataSink = new CacheDataSink.Factory().setCache(cache).createDataSink();
                }
            } else {
                dataSink = null;
            }
            return new CacheDataSource(cache, dataSource, this.f12615b.createDataSource(), dataSink, this.f12617d, i, this.f12620g, i2, this.f12623j);
        }

        public CacheDataSource createDataSourceForDownloading() {
            DataSource dataSource;
            DataSource.Factory factory = this.f12619f;
            if (factory != null) {
                dataSource = factory.createDataSource();
            } else {
                dataSource = null;
            }
            return m2994a(dataSource, this.f12622i | 1, -1000);
        }

        public CacheDataSource createDataSourceForRemovingDownload() {
            return m2994a(null, this.f12622i | 1, -1000);
        }

        @Nullable
        public Cache getCache() {
            return this.f12614a;
        }

        public CacheKeyFactory getCacheKeyFactory() {
            return this.f12617d;
        }

        @Nullable
        public PriorityTaskManager getUpstreamPriorityTaskManager() {
            return this.f12620g;
        }

        public Factory setCache(Cache cache) {
            this.f12614a = cache;
            return this;
        }

        public Factory setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.f12617d = cacheKeyFactory;
            return this;
        }

        public Factory setCacheReadDataSourceFactory(DataSource.Factory factory) {
            this.f12615b = factory;
            return this;
        }

        public Factory setCacheWriteDataSinkFactory(@Nullable DataSink.Factory factory) {
            boolean z;
            this.f12616c = factory;
            if (factory == null) {
                z = true;
            } else {
                z = false;
            }
            this.f12618e = z;
            return this;
        }

        public Factory setEventListener(@Nullable EventListener eventListener) {
            this.f12623j = eventListener;
            return this;
        }

        public Factory setFlags(int i) {
            this.f12622i = i;
            return this;
        }

        public Factory setUpstreamDataSourceFactory(@Nullable DataSource.Factory factory) {
            this.f12619f = factory;
            return this;
        }

        public Factory setUpstreamPriority(int i) {
            this.f12621h = i;
            return this;
        }

        public Factory setUpstreamPriorityTaskManager(@Nullable PriorityTaskManager priorityTaskManager) {
            this.f12620g = priorityTaskManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public CacheDataSource createDataSource() {
            DataSource.Factory factory = this.f12619f;
            return m2994a(factory != null ? factory.createDataSource() : null, this.f12622i, this.f12621h);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource) {
        this(cache, dataSource, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m2992a() {
        Cache cache = this.f12593a;
        DataSource dataSource = this.f12605m;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
        } finally {
            this.f12604l = null;
            this.f12605m = null;
            CacheSpan cacheSpan = this.f12609q;
            if (cacheSpan != null) {
                cache.releaseHoleSpan(cacheSpan);
                this.f12609q = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.f12594b.addTransferListener(transferListener);
        this.f12596d.addTransferListener(transferListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0153  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2993b(DataSpec dataSpec, boolean z) {
        CacheSpan startReadWrite;
        DataSource dataSource;
        Cache cache;
        DataSource dataSource2;
        long j;
        DataSpec build;
        Cache cache2;
        DataSource dataSource3;
        long j2;
        long open;
        ContentMetadataMutations contentMetadataMutations;
        boolean z2;
        Uri uri;
        boolean z3;
        String str = (String) Util.castNonNull(dataSpec.key);
        if (this.f12611s) {
            startReadWrite = null;
        } else if (this.f12599g) {
            try {
                startReadWrite = this.f12593a.startReadWrite(str, this.f12607o, this.f12608p);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            startReadWrite = this.f12593a.startReadWriteNonBlocking(str, this.f12607o, this.f12608p);
        }
        TeeDataSource teeDataSource = this.f12595c;
        DataSource dataSource4 = this.f12594b;
        Cache cache3 = this.f12593a;
        DataSource dataSource5 = this.f12596d;
        if (startReadWrite == null) {
            build = dataSpec.buildUpon().setPosition(this.f12607o).setLength(this.f12608p).build();
            dataSource = dataSource4;
            cache2 = cache3;
            dataSource2 = dataSource5;
        } else {
            if (startReadWrite.isCached) {
                Uri fromFile = Uri.fromFile((File) Util.castNonNull(startReadWrite.file));
                long j3 = startReadWrite.position;
                long j4 = this.f12607o - j3;
                dataSource2 = dataSource5;
                long j5 = startReadWrite.length - j4;
                dataSource = dataSource4;
                cache = cache3;
                long j6 = this.f12608p;
                if (j6 != -1) {
                    j5 = Math.min(j5, j6);
                }
                build = dataSpec.buildUpon().setUri(fromFile).setUriPositionOffset(j3).setPosition(j4).setLength(j5).build();
                dataSource5 = dataSource;
            } else {
                dataSource = dataSource4;
                cache = cache3;
                dataSource2 = dataSource5;
                if (startReadWrite.isOpenEnded()) {
                    j = this.f12608p;
                } else {
                    j = startReadWrite.length;
                    long j7 = this.f12608p;
                    if (j7 != -1) {
                        j = Math.min(j, j7);
                    }
                }
                build = dataSpec.buildUpon().setPosition(this.f12607o).setLength(j).build();
                if (teeDataSource != null) {
                    dataSource5 = teeDataSource;
                } else {
                    cache2 = cache;
                    cache2.releaseHoleSpan(startReadWrite);
                    dataSource5 = dataSource2;
                    startReadWrite = null;
                }
            }
            cache2 = cache;
        }
        if (!this.f12611s) {
            dataSource3 = dataSource2;
            if (dataSource5 == dataSource3) {
                j2 = this.f12607o + 102400;
                this.f12613u = j2;
                if (z) {
                    if (this.f12605m == dataSource3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Assertions.checkState(z3);
                    if (dataSource5 == dataSource3) {
                        return;
                    }
                    try {
                        m2992a();
                    } finally {
                    }
                }
                if (startReadWrite != null && startReadWrite.isHoleSpan()) {
                    this.f12609q = startReadWrite;
                }
                this.f12605m = dataSource5;
                this.f12604l = build;
                this.f12606n = 0L;
                open = dataSource5.open(build);
                contentMetadataMutations = new ContentMetadataMutations();
                DataSource dataSource6 = dataSource5;
                if (build.length == -1 && open != -1) {
                    this.f12608p = open;
                    ContentMetadataMutations.setContentLength(contentMetadataMutations, this.f12607o + open);
                }
                if (this.f12605m != dataSource) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    Uri uri2 = dataSource6.getUri();
                    this.f12602j = uri2;
                    if (!dataSpec.uri.equals(uri2)) {
                        uri = this.f12602j;
                    } else {
                        uri = null;
                    }
                    ContentMetadataMutations.setRedirectedUri(contentMetadataMutations, uri);
                }
                if (this.f12605m != teeDataSource) {
                    cache2.applyContentMetadataMutations(str, contentMetadataMutations);
                    return;
                }
                return;
            }
        } else {
            dataSource3 = dataSource2;
        }
        j2 = Long.MAX_VALUE;
        this.f12613u = j2;
        if (z) {
        }
        if (startReadWrite != null) {
            this.f12609q = startReadWrite;
        }
        this.f12605m = dataSource5;
        this.f12604l = build;
        this.f12606n = 0L;
        open = dataSource5.open(build);
        contentMetadataMutations = new ContentMetadataMutations();
        DataSource dataSource62 = dataSource5;
        if (build.length == -1) {
            this.f12608p = open;
            ContentMetadataMutations.setContentLength(contentMetadataMutations, this.f12607o + open);
        }
        if (this.f12605m != dataSource) {
        }
        if (!z2) {
        }
        if (this.f12605m != teeDataSource) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12603k = null;
        this.f12602j = null;
        this.f12607o = 0L;
        EventListener eventListener = this.f12598f;
        if (eventListener != null && this.f12612t > 0) {
            eventListener.onCachedBytesRead(this.f12593a.getCacheSpace(), this.f12612t);
            this.f12612t = 0L;
        }
        try {
            m2992a();
        } catch (Throwable th) {
            if (this.f12605m == this.f12594b || (th instanceof Cache.CacheException)) {
                this.f12610r = true;
            }
            throw th;
        }
    }

    public Cache getCache() {
        return this.f12593a;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.f12597e;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        boolean z;
        if (this.f12605m == this.f12594b) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return this.f12596d.getResponseHeaders();
        }
        return Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12602j;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        int i;
        boolean z;
        EventListener eventListener;
        Cache cache = this.f12593a;
        try {
            String buildCacheKey = this.f12597e.buildCacheKey(dataSpec);
            DataSpec build = dataSpec.buildUpon().setKey(buildCacheKey).build();
            this.f12603k = build;
            Uri uri = build.uri;
            Uri m8194b = AbstractC1997xv.m8194b(cache.getContentMetadata(buildCacheKey));
            if (m8194b != null) {
                uri = m8194b;
            }
            this.f12602j = uri;
            this.f12607o = dataSpec.position;
            if (this.f12600h && this.f12610r) {
                i = 0;
            } else if (this.f12601i && dataSpec.length == -1) {
                i = 1;
            } else {
                i = -1;
            }
            if (i != -1) {
                z = true;
            } else {
                z = false;
            }
            this.f12611s = z;
            if (z && (eventListener = this.f12598f) != null) {
                eventListener.onCacheIgnored(i);
            }
            if (this.f12611s) {
                this.f12608p = -1L;
            } else {
                long m8193a = AbstractC1997xv.m8193a(cache.getContentMetadata(buildCacheKey));
                this.f12608p = m8193a;
                if (m8193a != -1) {
                    long j = m8193a - dataSpec.position;
                    this.f12608p = j;
                    if (j < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long j2 = dataSpec.length;
            if (j2 != -1) {
                long j3 = this.f12608p;
                if (j3 != -1) {
                    j2 = Math.min(j3, j2);
                }
                this.f12608p = j2;
            }
            long j4 = this.f12608p;
            if (j4 > 0 || j4 == -1) {
                m2993b(build, false);
            }
            long j5 = dataSpec.length;
            if (j5 == -1) {
                return this.f12608p;
            }
            return j5;
        } catch (Throwable th) {
            if (this.f12605m == this.f12594b || (th instanceof Cache.CacheException)) {
                this.f12610r = true;
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        boolean z;
        int i3;
        DataSource dataSource = this.f12594b;
        boolean z2 = false;
        if (i2 == 0) {
            return 0;
        }
        if (this.f12608p == 0) {
            return -1;
        }
        DataSpec dataSpec = (DataSpec) Assertions.checkNotNull(this.f12603k);
        DataSpec dataSpec2 = (DataSpec) Assertions.checkNotNull(this.f12604l);
        try {
            if (this.f12607o >= this.f12613u) {
                m2993b(dataSpec, true);
            }
            int read = ((DataSource) Assertions.checkNotNull(this.f12605m)).read(bArr, i, i2);
            if (read != -1) {
                if (this.f12605m == dataSource) {
                    z2 = true;
                }
                if (z2) {
                    this.f12612t += read;
                }
                long j = read;
                this.f12607o += j;
                this.f12606n += j;
                long j2 = this.f12608p;
                if (j2 != -1) {
                    this.f12608p = j2 - j;
                }
                return read;
            }
            if (this.f12605m == dataSource) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i3 = read;
                long j3 = dataSpec2.length;
                if (j3 == -1 || this.f12606n < j3) {
                    String str = (String) Util.castNonNull(dataSpec.key);
                    this.f12608p = 0L;
                    if (this.f12605m == this.f12595c) {
                        z2 = true;
                    }
                    if (z2) {
                        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                        ContentMetadataMutations.setContentLength(contentMetadataMutations, this.f12607o);
                        this.f12593a.applyContentMetadataMutations(str, contentMetadataMutations);
                        return i3;
                    }
                    return i3;
                }
            } else {
                i3 = read;
            }
            long j4 = this.f12608p;
            if (j4 <= 0 && j4 != -1) {
                return i3;
            }
            m2992a();
            m2993b(dataSpec, false);
            return read(bArr, i, i2);
        } catch (Throwable th) {
            if (this.f12605m == dataSource || (th instanceof Cache.CacheException)) {
                this.f12610r = true;
            }
            throw th;
        }
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, int i) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, CacheDataSink.DEFAULT_FRAGMENT_SIZE), i, null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i, @Nullable EventListener eventListener) {
        this(cache, dataSource, dataSource2, dataSink, i, eventListener, null);
    }

    public CacheDataSource(Cache cache, @Nullable DataSource dataSource, DataSource dataSource2, @Nullable DataSink dataSink, int i, @Nullable EventListener eventListener, @Nullable CacheKeyFactory cacheKeyFactory) {
        this(cache, dataSource, dataSource2, dataSink, cacheKeyFactory, i, null, 0, eventListener);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, CacheKeyFactory cacheKeyFactory, int i, PriorityTaskManager priorityTaskManager, int i2, EventListener eventListener) {
        this.f12593a = cache;
        this.f12594b = dataSource2;
        this.f12597e = cacheKeyFactory == null ? CacheKeyFactory.DEFAULT : cacheKeyFactory;
        this.f12599g = (i & 1) != 0;
        this.f12600h = (i & 2) != 0;
        this.f12601i = (i & 4) != 0;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new PriorityDataSource(dataSource, priorityTaskManager, i2) : dataSource;
            this.f12596d = dataSource;
            this.f12595c = dataSink != null ? new TeeDataSource(dataSource, dataSink) : null;
        } else {
            this.f12596d = PlaceholderDataSource.INSTANCE;
            this.f12595c = null;
        }
        this.f12598f = eventListener;
    }
}

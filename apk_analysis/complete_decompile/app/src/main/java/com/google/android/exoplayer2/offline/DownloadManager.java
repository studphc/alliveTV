package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import p000.C1294i5;
import p000.C1524lu;
import p000.ExecutorC0582c6;
import p000.d60;

/* loaded from: classes.dex */
public final class DownloadManager {
    public static final int DEFAULT_MAX_PARALLEL_DOWNLOADS = 3;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    public static final Requirements DEFAULT_REQUIREMENTS = new Requirements(1);

    /* renamed from: a */
    public final Context f10795a;

    /* renamed from: b */
    public final WritableDownloadIndex f10796b;

    /* renamed from: c */
    public final Handler f10797c;

    /* renamed from: d */
    public final d60 f10798d;

    /* renamed from: e */
    public final C1294i5 f10799e;

    /* renamed from: f */
    public final CopyOnWriteArraySet f10800f;

    /* renamed from: g */
    public int f10801g;

    /* renamed from: h */
    public int f10802h;

    /* renamed from: i */
    public boolean f10803i;

    /* renamed from: j */
    public boolean f10804j;

    /* renamed from: k */
    public int f10805k;

    /* renamed from: l */
    public int f10806l;

    /* renamed from: m */
    public int f10807m;

    /* renamed from: n */
    public boolean f10808n;

    /* renamed from: o */
    public List f10809o;

    /* renamed from: p */
    public RequirementsWatcher f10810p;

    /* loaded from: classes.dex */
    public interface Listener {
        void onDownloadChanged(DownloadManager downloadManager, Download download, @Nullable Exception exc);

        void onDownloadRemoved(DownloadManager downloadManager, Download download);

        void onDownloadsPausedChanged(DownloadManager downloadManager, boolean z);

        void onIdle(DownloadManager downloadManager);

        void onInitialized(DownloadManager downloadManager);

        void onRequirementsStateChanged(DownloadManager downloadManager, Requirements requirements, int i);

        void onWaitingForRequirementsChanged(DownloadManager downloadManager, boolean z);
    }

    @Deprecated
    public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory) {
        this(context, databaseProvider, cache, factory, new ExecutorC0582c6(0));
    }

    /* renamed from: a */
    public final void m2707a() {
        Iterator it = this.f10800f.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onWaitingForRequirementsChanged(this, this.f10808n);
        }
    }

    public void addDownload(DownloadRequest downloadRequest) {
        addDownload(downloadRequest, 0);
    }

    public void addListener(Listener listener) {
        Assertions.checkNotNull(listener);
        this.f10800f.add(listener);
    }

    /* renamed from: b */
    public final void m2708b(RequirementsWatcher requirementsWatcher, int i) {
        Requirements requirements = requirementsWatcher.getRequirements();
        if (this.f10807m != i) {
            this.f10807m = i;
            this.f10801g++;
            this.f10798d.obtainMessage(2, i, 0).sendToTarget();
        }
        boolean m2710d = m2710d();
        Iterator it = this.f10800f.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onRequirementsStateChanged(this, requirements, i);
        }
        if (m2710d) {
            m2707a();
        }
    }

    /* renamed from: c */
    public final void m2709c(boolean z) {
        if (this.f10804j == z) {
            return;
        }
        this.f10804j = z;
        this.f10801g++;
        this.f10798d.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        boolean m2710d = m2710d();
        Iterator it = this.f10800f.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onDownloadsPausedChanged(this, z);
        }
        if (m2710d) {
            m2707a();
        }
    }

    /* renamed from: d */
    public final boolean m2710d() {
        boolean z;
        boolean z2 = true;
        if (!this.f10804j && this.f10807m != 0) {
            for (int i = 0; i < this.f10809o.size(); i++) {
                if (((Download) this.f10809o.get(i)).state == 0) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (this.f10808n == z) {
            z2 = false;
        }
        this.f10808n = z;
        return z2;
    }

    public Looper getApplicationLooper() {
        return this.f10797c.getLooper();
    }

    public List<Download> getCurrentDownloads() {
        return this.f10809o;
    }

    public DownloadIndex getDownloadIndex() {
        return this.f10796b;
    }

    public boolean getDownloadsPaused() {
        return this.f10804j;
    }

    public int getMaxParallelDownloads() {
        return this.f10805k;
    }

    public int getMinRetryCount() {
        return this.f10806l;
    }

    public int getNotMetRequirements() {
        return this.f10807m;
    }

    public Requirements getRequirements() {
        return this.f10810p.getRequirements();
    }

    public boolean isIdle() {
        if (this.f10802h == 0 && this.f10801g == 0) {
            return true;
        }
        return false;
    }

    public boolean isInitialized() {
        return this.f10803i;
    }

    public boolean isWaitingForRequirements() {
        return this.f10808n;
    }

    public void pauseDownloads() {
        m2709c(true);
    }

    public void release() {
        synchronized (this.f10798d) {
            try {
                d60 d60Var = this.f10798d;
                if (d60Var.f16259a) {
                    return;
                }
                d60Var.sendEmptyMessage(12);
                boolean z = false;
                while (true) {
                    d60 d60Var2 = this.f10798d;
                    if (d60Var2.f16259a) {
                        break;
                    }
                    try {
                        d60Var2.wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
                this.f10797c.removeCallbacksAndMessages(null);
                this.f10809o = Collections.emptyList();
                this.f10801g = 0;
                this.f10802h = 0;
                this.f10803i = false;
                this.f10807m = 0;
                this.f10808n = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeAllDownloads() {
        this.f10801g++;
        this.f10798d.obtainMessage(8).sendToTarget();
    }

    public void removeDownload(String str) {
        this.f10801g++;
        this.f10798d.obtainMessage(7, str).sendToTarget();
    }

    public void removeListener(Listener listener) {
        this.f10800f.remove(listener);
    }

    public void resumeDownloads() {
        m2709c(false);
    }

    public void setMaxParallelDownloads(@IntRange(from = 1) int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        if (this.f10805k == i) {
            return;
        }
        this.f10805k = i;
        this.f10801g++;
        this.f10798d.obtainMessage(4, i, 0).sendToTarget();
    }

    public void setMinRetryCount(int i) {
        boolean z;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        if (this.f10806l == i) {
            return;
        }
        this.f10806l = i;
        this.f10801g++;
        this.f10798d.obtainMessage(5, i, 0).sendToTarget();
    }

    public void setRequirements(Requirements requirements) {
        if (requirements.equals(this.f10810p.getRequirements())) {
            return;
        }
        this.f10810p.stop();
        RequirementsWatcher requirementsWatcher = new RequirementsWatcher(this.f10795a, this.f10799e, requirements);
        this.f10810p = requirementsWatcher;
        m2708b(this.f10810p, requirementsWatcher.start());
    }

    public void setStopReason(@Nullable String str, int i) {
        this.f10801g++;
        this.f10798d.obtainMessage(3, i, 0, str).sendToTarget();
    }

    public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory, Executor executor) {
        this(context, new DefaultDownloadIndex(databaseProvider), new DefaultDownloaderFactory(new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(factory), executor));
    }

    public void addDownload(DownloadRequest downloadRequest, int i) {
        this.f10801g++;
        this.f10798d.obtainMessage(6, i, 0, downloadRequest).sendToTarget();
    }

    public DownloadManager(Context context, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory) {
        this.f10795a = context.getApplicationContext();
        this.f10796b = writableDownloadIndex;
        this.f10805k = 3;
        this.f10806l = 5;
        this.f10804j = true;
        this.f10809o = Collections.emptyList();
        this.f10800f = new CopyOnWriteArraySet();
        Handler createHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper(new C1524lu(2, this));
        this.f10797c = createHandlerForCurrentOrMainLooper;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        d60 d60Var = new d60(handlerThread, writableDownloadIndex, downloaderFactory, createHandlerForCurrentOrMainLooper, this.f10805k, this.f10806l, this.f10804j);
        this.f10798d = d60Var;
        C1294i5 c1294i5 = new C1294i5(4, this);
        this.f10799e = c1294i5;
        RequirementsWatcher requirementsWatcher = new RequirementsWatcher(context, c1294i5, DEFAULT_REQUIREMENTS);
        this.f10810p = requirementsWatcher;
        int start = requirementsWatcher.start();
        this.f10807m = start;
        this.f10801g = 1;
        d60Var.obtainMessage(0, start, 0).sendToTarget();
    }
}

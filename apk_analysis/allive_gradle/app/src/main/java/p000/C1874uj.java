package p000;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Cache$RealCacheRequest$1;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;
import okio.ForwardingSink;
import okio.Sink;
import p000.C1874uj;

/* renamed from: uj */
/* loaded from: classes2.dex */
public final class C1874uj implements CacheRequest {

    /* renamed from: a */
    public final DiskLruCache.Editor f27293a;

    /* renamed from: b */
    public final Sink f27294b;

    /* renamed from: c */
    public final Cache$RealCacheRequest$1 f27295c;

    /* renamed from: d */
    public boolean f27296d;

    /* renamed from: e */
    public final /* synthetic */ Cache f27297e;

    /* JADX WARN: Type inference failed for: r0v2, types: [okhttp3.Cache$RealCacheRequest$1] */
    public C1874uj(final Cache cache, DiskLruCache.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.f27297e = cache;
        this.f27293a = editor;
        final Sink newSink = editor.newSink(1);
        this.f27294b = newSink;
        this.f27295c = new ForwardingSink(newSink) { // from class: okhttp3.Cache$RealCacheRequest$1
            @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Cache cache2 = Cache.this;
                C1874uj c1874uj = this;
                synchronized (cache2) {
                    if (c1874uj.f27296d) {
                        return;
                    }
                    c1874uj.f27296d = true;
                    cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount() + 1);
                    super.close();
                    this.f27293a.commit();
                }
            }
        };
    }

    @Override // okhttp3.internal.cache.CacheRequest
    public final void abort() {
        Cache cache = this.f27297e;
        synchronized (cache) {
            if (this.f27296d) {
                return;
            }
            this.f27296d = true;
            cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount() + 1);
            _UtilCommonKt.closeQuietly(this.f27294b);
            try {
                this.f27293a.abort();
            } catch (IOException unused) {
            }
        }
    }

    @Override // okhttp3.internal.cache.CacheRequest
    public final Sink body() {
        return this.f27295c;
    }
}

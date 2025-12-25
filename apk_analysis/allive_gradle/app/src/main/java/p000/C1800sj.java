package p000;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.cache.DiskLruCache;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* renamed from: sj */
/* loaded from: classes2.dex */
public final class C1800sj extends ResponseBody {

    /* renamed from: b */
    public final DiskLruCache.Snapshot f26446b;

    /* renamed from: c */
    public final String f26447c;

    /* renamed from: d */
    public final String f26448d;

    /* renamed from: e */
    public final BufferedSource f26449e;

    public C1800sj(DiskLruCache.Snapshot snapshot, String str, String str2) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.f26446b = snapshot;
        this.f26447c = str;
        this.f26448d = str2;
        final Source source = snapshot.getSource(1);
        this.f26449e = Okio.buffer(new ForwardingSource(source) { // from class: okhttp3.Cache$CacheResponseBody$1
            @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.f26446b.close();
                super.close();
            }
        });
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength */
    public final long getF24154c() {
        String str = this.f26448d;
        if (str == null) {
            return -1L;
        }
        return _UtilCommonKt.toLongOrDefault(str, -1L);
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentType */
    public final MediaType getF24153b() {
        String str = this.f26447c;
        if (str != null) {
            return MediaType.INSTANCE.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: source */
    public final BufferedSource getF24155d() {
        return this.f26449e;
    }
}

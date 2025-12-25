package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.internal.cache.DiskLruCache;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"okhttp3/Cache$urls$1", "", "", "", "hasNext", "()Z", "next", "()Ljava/lang/String;", "", "remove", "()V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Cache$urls$1 implements Iterator<String>, KMutableIterator {

    /* renamed from: a */
    public final Iterator f23872a;

    /* renamed from: b */
    public String f23873b;

    /* renamed from: c */
    public boolean f23874c;

    public Cache$urls$1(Cache cache) {
        this.f23872a = cache.getCache().snapshots();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f23873b != null) {
            return true;
        }
        this.f23874c = false;
        while (true) {
            Iterator it = this.f23872a;
            if (!it.hasNext()) {
                return false;
            }
            try {
                Closeable closeable = (Closeable) it.next();
                try {
                    continue;
                    this.f23873b = Okio.buffer(((DiskLruCache.Snapshot) closeable).getSource(0)).readUtf8LineStrict();
                    CloseableKt.closeFinally(closeable, null);
                    return true;
                } finally {
                    try {
                        continue;
                        break;
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.f23874c) {
            this.f23872a.remove();
            return;
        }
        throw new IllegalStateException("remove() before next()");
    }

    @Override // java.util.Iterator
    @NotNull
    public String next() {
        if (hasNext()) {
            String str = this.f23873b;
            Intrinsics.checkNotNull(str);
            this.f23873b = null;
            this.f23874c = true;
            return str;
        }
        throw new NoSuchElementException();
    }
}

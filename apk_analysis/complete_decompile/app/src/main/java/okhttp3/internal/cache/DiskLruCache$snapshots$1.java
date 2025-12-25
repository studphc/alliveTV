package okhttp3.internal.cache;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import okhttp3.internal.cache.DiskLruCache;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000!\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, m5569d2 = {"okhttp3/internal/cache/DiskLruCache$snapshots$1", "", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "", "hasNext", "()Z", "next", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "remove", "()V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DiskLruCache$snapshots$1 implements Iterator<DiskLruCache.Snapshot>, KMutableIterator {

    /* renamed from: a */
    public final Iterator f24224a;

    /* renamed from: b */
    public DiskLruCache.Snapshot f24225b;

    /* renamed from: c */
    public DiskLruCache.Snapshot f24226c;

    /* renamed from: d */
    public final /* synthetic */ DiskLruCache f24227d;

    public DiskLruCache$snapshots$1(DiskLruCache diskLruCache) {
        this.f24227d = diskLruCache;
        Iterator it = new ArrayList(diskLruCache.getLruEntries$okhttp().values()).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "ArrayList(lruEntries.values).iterator()");
        this.f24224a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        DiskLruCache.Snapshot snapshot$okhttp;
        if (this.f24225b != null) {
            return true;
        }
        DiskLruCache diskLruCache = this.f24227d;
        synchronized (diskLruCache) {
            if (diskLruCache.getClosed()) {
                return false;
            }
            while (this.f24224a.hasNext()) {
                DiskLruCache.Entry entry = (DiskLruCache.Entry) this.f24224a.next();
                if (entry != null && (snapshot$okhttp = entry.snapshot$okhttp()) != null) {
                    this.f24225b = snapshot$okhttp;
                    return true;
                }
            }
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        DiskLruCache.Snapshot snapshot = this.f24226c;
        if (snapshot != null) {
            try {
                this.f24227d.remove(snapshot.getF24218a());
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f24226c = null;
                throw th;
            }
            this.f24226c = null;
            return;
        }
        throw new IllegalStateException("remove() before next()");
    }

    @Override // java.util.Iterator
    @NotNull
    public DiskLruCache.Snapshot next() {
        if (hasNext()) {
            DiskLruCache.Snapshot snapshot = this.f24225b;
            this.f24226c = snapshot;
            this.f24225b = null;
            Intrinsics.checkNotNull(snapshot);
            return snapshot;
        }
        throw new NoSuchElementException();
    }
}

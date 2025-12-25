package androidx.collection;

import androidx.annotation.IntRange;
import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\fJ1\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00012\b\u0010\u0015\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0018\u0010\fJ\u001f\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\u001eJ\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001eJ\r\u0010!\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\u001eJ\r\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\u001eJ\r\u0010#\u001a\u00020\u0004¢\u0006\u0004\b#\u0010\u001eJ\u0019\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)¨\u0006*"}, m5569d2 = {"Landroidx/collection/LruCache;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "<init>", "(I)V", "", "resize", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "trimToSize", "remove", "", "evicted", "oldValue", "newValue", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "create", "sizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "evictAll", "()V", "size", "()I", "hitCount", "missCount", "createCount", "putCount", "evictionCount", "", "snapshot", "()Ljava/util/Map;", "", "toString", "()Ljava/lang/String;", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/collection/LruCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 LockExt.kt\nandroidx/collection/internal/LockExtKt\n+ 4 Lock.jvm.kt\nandroidx/collection/internal/Lock\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,355:1\n1#2:356\n23#3,3:357\n23#3,3:361\n23#3,3:365\n23#3,3:369\n23#3,3:373\n23#3,3:377\n23#3,3:381\n23#3,3:385\n23#3,3:389\n23#3,3:393\n23#3,3:397\n23#3,3:401\n23#3,3:405\n23#3,3:409\n23#3,3:415\n26#4:360\n26#4:364\n26#4:368\n26#4:372\n26#4:376\n26#4:380\n26#4:384\n26#4:388\n26#4:392\n26#4:396\n26#4:400\n26#4:404\n26#4:408\n26#4:412\n26#4:418\n1855#5,2:413\n*S KotlinDebug\n*F\n+ 1 LruCache.kt\nandroidx/collection/LruCache\n*L\n65#1:357,3\n78#1:361,3\n95#1:365,3\n122#1:369,3\n151#1:373,3\n180#1:377,3\n255#1:381,3\n262#1:385,3\n268#1:389,3\n274#1:393,3\n279#1:397,3\n284#1:401,3\n289#1:405,3\n299#1:409,3\n308#1:415,3\n65#1:360\n78#1:364\n95#1:368\n122#1:372\n151#1:376\n180#1:380\n255#1:384\n262#1:388\n268#1:392\n274#1:396\n279#1:400\n284#1:404\n289#1:408\n299#1:412\n308#1:418\n300#1:413,2\n*E\n"})
/* loaded from: classes.dex */
public class LruCache<K, V> {

    /* renamed from: a */
    public int f1693a;

    /* renamed from: b */
    public final LruHashMap f1694b;

    /* renamed from: c */
    public final Lock f1695c;

    /* renamed from: d */
    public int f1696d;

    /* renamed from: e */
    public int f1697e;

    /* renamed from: f */
    public int f1698f;

    /* renamed from: g */
    public int f1699g;

    /* renamed from: h */
    public int f1700h;

    /* renamed from: i */
    public int f1701i;

    public LruCache(@IntRange(from = 1, m153to = Long.MAX_VALUE) int i) {
        this.f1693a = i;
        if (i > 0) {
            this.f1694b = new LruHashMap(0, 0.75f);
            this.f1695c = new Lock();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final int m329a(Object obj, Object obj2) {
        int sizeOf = sizeOf(obj, obj2);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    @Nullable
    public V create(@NotNull K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    public final int createCount() {
        int i;
        synchronized (this.f1695c) {
            i = this.f1698f;
        }
        return i;
    }

    public void entryRemoved(boolean evicted, @NotNull K key, @NotNull V oldValue, @Nullable V newValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i;
        synchronized (this.f1695c) {
            i = this.f1699g;
        }
        return i;
    }

    @Nullable
    public final V get(@NotNull K key) {
        V v;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.f1695c) {
            V v2 = (V) this.f1694b.get(key);
            if (v2 != null) {
                this.f1700h++;
                return v2;
            }
            this.f1701i++;
            V create = create(key);
            if (create == null) {
                return null;
            }
            synchronized (this.f1695c) {
                try {
                    this.f1698f++;
                    v = (V) this.f1694b.put(key, create);
                    if (v != null) {
                        this.f1694b.put(key, v);
                    } else {
                        this.f1696d += m329a(key, create);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v != null) {
                entryRemoved(false, key, create, v);
                return v;
            }
            trimToSize(this.f1693a);
            return create;
        }
    }

    public final int hitCount() {
        int i;
        synchronized (this.f1695c) {
            i = this.f1700h;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this.f1695c) {
            i = this.f1693a;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.f1695c) {
            i = this.f1701i;
        }
        return i;
    }

    @Nullable
    public final V put(@NotNull K key, @NotNull V value) {
        V v;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.f1695c) {
            this.f1697e++;
            this.f1696d += m329a(key, value);
            v = (V) this.f1694b.put(key, value);
            if (v != null) {
                this.f1696d -= m329a(key, v);
            }
        }
        if (v != null) {
            entryRemoved(false, key, v, value);
        }
        trimToSize(this.f1693a);
        return v;
    }

    public final int putCount() {
        int i;
        synchronized (this.f1695c) {
            i = this.f1697e;
        }
        return i;
    }

    @Nullable
    public final V remove(@NotNull K key) {
        V v;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.f1695c) {
            v = (V) this.f1694b.remove(key);
            if (v != null) {
                this.f1696d -= m329a(key, v);
            }
        }
        if (v != null) {
            entryRemoved(false, key, v, null);
        }
        return v;
    }

    public void resize(@IntRange(from = 1, m153to = Long.MAX_VALUE) int maxSize) {
        if (maxSize > 0) {
            synchronized (this.f1695c) {
                this.f1693a = maxSize;
            }
            trimToSize(maxSize);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final int size() {
        int i;
        synchronized (this.f1695c) {
            i = this.f1696d;
        }
        return i;
    }

    public int sizeOf(@NotNull K key, @NotNull V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.f1695c) {
            Iterator<T> it = this.f1694b.getEntries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public String toString() {
        int i;
        String str;
        synchronized (this.f1695c) {
            try {
                int i2 = this.f1700h;
                int i3 = this.f1701i + i2;
                if (i3 != 0) {
                    i = (i2 * 100) / i3;
                } else {
                    i = 0;
                }
                str = "LruCache[maxSize=" + this.f1693a + ",hits=" + this.f1700h + ",misses=" + this.f1701i + ",hitRate=" + i + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005e, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int maxSize) {
        Object key;
        Object value;
        while (true) {
            synchronized (this.f1695c) {
                try {
                    if (this.f1696d < 0 || (this.f1694b.isEmpty() && this.f1696d != 0)) {
                        break;
                    }
                    if (this.f1696d <= maxSize || this.f1694b.isEmpty()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) CollectionsKt___CollectionsKt.firstOrNull(this.f1694b.getEntries());
                    if (entry == null) {
                        return;
                    }
                    key = entry.getKey();
                    value = entry.getValue();
                    this.f1694b.remove(key);
                    this.f1696d -= m329a(key, value);
                    this.f1699g++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            entryRemoved(true, key, value, null);
        }
    }
}

package kotlinx.coroutines.debug.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1922vu;
import p000.C1952wn;
import p000.C1996xu;
import p000.oh1;

@Metadata(m5568d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003\"$%B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c0\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u000b\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004R!\u0010#\u001a\u0018\u0012\u0014\u0012\u00120\"R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000!8\u0002X\u0082\u0004¨\u0006&"}, m5569d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMutableMap;", "", "weakRefQueue", "<init>", "(Z)V", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "clear", "()V", "runWeakRefQueueCleaningLoopUntilInterrupted", "", "getSize", "()I", "size", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getEntries", "entries", "Lkotlinx/atomicfu/AtomicInt;", "_size", "Lkotlinx/atomicfu/AtomicRef;", "Lvu;", "core", "wu", "xu", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nConcurrentWeakMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentWeakMap.kt\nkotlinx/coroutines/debug/internal/ConcurrentWeakMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,284:1\n1#2:285\n*E\n"})
/* loaded from: classes2.dex */
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* renamed from: b */
    public static final AtomicIntegerFieldUpdater f21506b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");

    /* renamed from: c */
    public static final AtomicReferenceFieldUpdater f21507c = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core");

    @Volatile
    private volatile int _size;

    /* renamed from: a */
    public final ReferenceQueue f21508a;

    @Volatile
    @Nullable
    private volatile Object core;

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public static final void access$decrementSize(ConcurrentWeakMap concurrentWeakMap) {
        concurrentWeakMap.getClass();
        f21506b.decrementAndGet(concurrentWeakMap);
    }

    /* renamed from: a */
    public final synchronized Object m5706a(Object obj, Object obj2) {
        Object m7940a;
        Symbol symbol;
        C1922vu c1922vu = (C1922vu) f21507c.get(this);
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C1922vu.f27965g;
            m7940a = c1922vu.m7940a(obj, obj2, null);
            symbol = ConcurrentWeakMapKt.f21509a;
            if (m7940a == symbol) {
                c1922vu = c1922vu.m7941b();
                f21507c.set(this, c1922vu);
            }
        }
        return m7940a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        C1922vu c1922vu = (C1922vu) f21507c.get(this);
        c1922vu.getClass();
        int hashCode = (key.hashCode() * (-1640531527)) >>> c1922vu.f27967b;
        while (true) {
            HashedWeakRef hashedWeakRef = (HashedWeakRef) c1922vu.f27969d.get(hashCode);
            if (hashedWeakRef == null) {
                return null;
            }
            T t = hashedWeakRef.get();
            if (Intrinsics.areEqual(key, t)) {
                Object obj = c1922vu.f27970e.get(hashCode);
                if (obj instanceof oh1) {
                    obj = ((oh1) obj).f23809a;
                }
                return (V) obj;
            }
            if (t == 0) {
                c1922vu.m7942c(hashCode);
            }
            if (hashCode == 0) {
                hashCode = c1922vu.f27966a;
            }
            hashCode--;
        }
    }

    @Override // kotlin.collections.AbstractMutableMap
    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return new C1996xu(this, C1952wn.f28246e);
    }

    @Override // kotlin.collections.AbstractMutableMap
    @NotNull
    public Set<K> getKeys() {
        return new C1996xu(this, C1952wn.f28247f);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return f21506b.get(this);
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K key, @NotNull V value) {
        Symbol symbol;
        C1922vu c1922vu = (C1922vu) f21507c.get(this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C1922vu.f27965g;
        V v = (V) c1922vu.m7940a(key, value, null);
        symbol = ConcurrentWeakMapKt.f21509a;
        if (v == symbol) {
            v = (V) m5706a(key, value);
        }
        if (v == null) {
            f21506b.incrementAndGet(this);
        }
        return v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@Nullable Object key) {
        Symbol symbol;
        if (key == null) {
            return null;
        }
        C1922vu c1922vu = (C1922vu) f21507c.get(this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C1922vu.f27965g;
        V v = (V) c1922vu.m7940a(key, null, null);
        symbol = ConcurrentWeakMapKt.f21509a;
        if (v == symbol) {
            v = (V) m5706a(key, null);
        }
        if (v != null) {
            f21506b.decrementAndGet(this);
        }
        return v;
    }

    public final void runWeakRefQueueCleaningLoopUntilInterrupted() {
        ReferenceQueue referenceQueue = this.f21508a;
        if (referenceQueue == null) {
            throw new IllegalStateException("Must be created with weakRefQueue = true");
        }
        while (true) {
            try {
                Reference remove = referenceQueue.remove();
                Intrinsics.checkNotNull(remove, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                HashedWeakRef hashedWeakRef = (HashedWeakRef) remove;
                C1922vu c1922vu = (C1922vu) f21507c.get(this);
                c1922vu.getClass();
                int i = (hashedWeakRef.hash * (-1640531527)) >>> c1922vu.f27967b;
                while (true) {
                    HashedWeakRef hashedWeakRef2 = (HashedWeakRef) c1922vu.f27969d.get(i);
                    if (hashedWeakRef2 != null) {
                        if (hashedWeakRef2 == hashedWeakRef) {
                            c1922vu.m7942c(i);
                            break;
                        } else {
                            if (i == 0) {
                                i = c1922vu.f27966a;
                            }
                            i--;
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public ConcurrentWeakMap(boolean z) {
        this.core = new C1922vu(this, 16);
        this.f21508a = z ? new ReferenceQueue() : null;
    }
}

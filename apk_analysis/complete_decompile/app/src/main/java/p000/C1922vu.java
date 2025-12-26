package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt;
import kotlinx.coroutines.debug.internal.HashedWeakRef;
import kotlinx.coroutines.internal.Symbol;

/* renamed from: vu */
/* loaded from: classes2.dex */
public final class C1922vu {

    /* renamed from: g */
    public static final AtomicIntegerFieldUpdater f27965g = AtomicIntegerFieldUpdater.newUpdater(C1922vu.class, "load");

    /* renamed from: a */
    public final int f27966a;

    /* renamed from: b */
    public final int f27967b;

    /* renamed from: c */
    public final int f27968c;

    /* renamed from: d */
    public final AtomicReferenceArray f27969d;

    /* renamed from: e */
    public final AtomicReferenceArray f27970e;

    /* renamed from: f */
    public final /* synthetic */ ConcurrentWeakMap f27971f;

    @Volatile
    private volatile int load;

    public C1922vu(ConcurrentWeakMap concurrentWeakMap, int i) {
        this.f27971f = concurrentWeakMap;
        this.f27966a = i;
        this.f27967b = Integer.numberOfLeadingZeros(i) + 1;
        this.f27968c = (i * 2) / 3;
        this.f27969d = new AtomicReferenceArray(i);
        this.f27970e = new AtomicReferenceArray(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        r3 = r8.f27970e;
        r4 = r3.get(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        if ((r4 instanceof p000.oh1) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
    
        if (r3.compareAndSet(r0, r4, r10) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        if (r3.get(r0) == r4) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006c, code lost:
    
        r9 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.f21509a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x001c, code lost:
    
        if (r1 == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x001e, code lost:
    
        r1 = r4.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0024, code lost:
    
        if (r1 < r8.f27968c) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0031, code lost:
    
        if (r4.compareAndSet(r8, r1, r1 + 1) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0033, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0026, code lost:
    
        r9 = kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt.f21509a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x002a, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0034, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0035, code lost:
    
        if (r11 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0037, code lost:
    
        r1 = r8.f27971f.f21508a;
        r11 = new kotlinx.coroutines.debug.internal.HashedWeakRef(r9, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0042, code lost:
    
        r7 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0047, code lost:
    
        if (r2.compareAndSet(r0, null, r7) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x004e, code lost:
    
        if (r2.get(r0) == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0050, code lost:
    
        r1 = r6;
        r11 = r7;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m7940a(Object obj, Object obj2, HashedWeakRef hashedWeakRef) {
        int hashCode = (obj.hashCode() * (-1640531527)) >>> this.f27967b;
        boolean z = false;
        loop0: while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f27969d;
            HashedWeakRef hashedWeakRef2 = (HashedWeakRef) atomicReferenceArray.get(hashCode);
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f27965g;
            if (hashedWeakRef2 == null) {
                if (obj2 == null) {
                    return null;
                }
            } else {
                T t = hashedWeakRef2.get();
                if (Intrinsics.areEqual(obj, t)) {
                    if (z) {
                        atomicIntegerFieldUpdater.decrementAndGet(this);
                    }
                } else {
                    if (t == 0) {
                        m7942c(hashCode);
                    }
                    if (hashCode == 0) {
                        hashCode = this.f27966a;
                    }
                    hashCode--;
                }
            }
        }
    }

    /* renamed from: b */
    public final C1922vu m7941b() {
        Object obj;
        Object obj2;
        Symbol symbol;
        while (true) {
            ConcurrentWeakMap concurrentWeakMap = this.f27971f;
            C1922vu c1922vu = new C1922vu(concurrentWeakMap, Integer.highestOneBit(r82.coerceAtLeast(concurrentWeakMap.size(), 4)) * 4);
            for (int i = 0; i < this.f27966a; i++) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.f27969d.get(i);
                if (hashedWeakRef != null) {
                    obj = hashedWeakRef.get();
                } else {
                    obj = null;
                }
                if (hashedWeakRef != null && obj == null) {
                    m7942c(i);
                }
                while (true) {
                    AtomicReferenceArray atomicReferenceArray = this.f27970e;
                    obj2 = atomicReferenceArray.get(i);
                    if (obj2 instanceof oh1) {
                        obj2 = ((oh1) obj2).f23809a;
                        break;
                    }
                    oh1 access$mark = ConcurrentWeakMapKt.access$mark(obj2);
                    while (!atomicReferenceArray.compareAndSet(i, obj2, access$mark)) {
                        if (atomicReferenceArray.get(i) != obj2) {
                            break;
                        }
                    }
                    break;
                }
                if (obj != null && obj2 != null) {
                    Object m7940a = c1922vu.m7940a(obj, obj2, hashedWeakRef);
                    symbol = ConcurrentWeakMapKt.f21509a;
                    if (m7940a != symbol) {
                    }
                }
            }
            return c1922vu;
        }
    }

    /* renamed from: c */
    public final void m7942c(int i) {
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f27970e;
            Object obj = atomicReferenceArray.get(i);
            if (obj == null || (obj instanceof oh1)) {
                return;
            }
            while (!atomicReferenceArray.compareAndSet(i, obj, null)) {
                if (atomicReferenceArray.get(i) != obj) {
                    break;
                }
            }
            ConcurrentWeakMap.access$decrementSize(this.f27971f);
            return;
        }
    }
}

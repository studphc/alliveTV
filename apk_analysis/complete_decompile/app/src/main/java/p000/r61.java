package p000;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.NodeList;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class r61 implements Incomplete {

    /* renamed from: b */
    public static final AtomicIntegerFieldUpdater f25878b = AtomicIntegerFieldUpdater.newUpdater(r61.class, "_isCompleting");

    /* renamed from: c */
    public static final AtomicReferenceFieldUpdater f25879c = AtomicReferenceFieldUpdater.newUpdater(r61.class, Object.class, "_rootCause");

    /* renamed from: d */
    public static final AtomicReferenceFieldUpdater f25880d = AtomicReferenceFieldUpdater.newUpdater(r61.class, Object.class, "_exceptionsHolder");

    @Volatile
    @Nullable
    private volatile Object _exceptionsHolder;

    @Volatile
    private volatile int _isCompleting = 0;

    @Volatile
    @Nullable
    private volatile Object _rootCause;

    /* renamed from: a */
    public final NodeList f25881a;

    public r61(NodeList nodeList, Throwable th) {
        this.f25881a = nodeList;
        this._rootCause = th;
    }

    /* renamed from: a */
    public final void m7221a(Throwable th) {
        Throwable m7222b = m7222b();
        if (m7222b == null) {
            f25879c.set(this, th);
            return;
        }
        if (th == m7222b) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f25880d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (obj instanceof Throwable) {
            if (th == obj) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(th);
            atomicReferenceFieldUpdater.set(this, arrayList);
            return;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(th);
        } else {
            throw new IllegalStateException(("State is " + obj).toString());
        }
    }

    /* renamed from: b */
    public final Throwable m7222b() {
        return (Throwable) f25879c.get(this);
    }

    /* renamed from: c */
    public final boolean m7223c() {
        if (m7222b() != null) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public final boolean m7224d() {
        if (f25878b.get(this) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final ArrayList m7225e(Throwable th) {
        ArrayList arrayList;
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f25880d;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            throw new IllegalStateException(("State is " + obj).toString());
        }
        Throwable m7222b = m7222b();
        if (m7222b != null) {
            arrayList.add(0, m7222b);
        }
        if (th != null && !Intrinsics.areEqual(th, m7222b)) {
            arrayList.add(th);
        }
        symbol = JobSupportKt.f21428d;
        atomicReferenceFieldUpdater.set(this, symbol);
        return arrayList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return this.f25881a;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        if (m7222b() == null) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "Finishing[cancelling=" + m7223c() + ", completing=" + m7224d() + ", rootCause=" + m7222b() + ", exceptions=" + f25880d.get(this) + ", list=" + this.f25881a + ']';
    }
}

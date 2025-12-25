package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt;
import kotlinx.coroutines.debug.internal.HashedWeakRef;

/* renamed from: uu */
/* loaded from: classes2.dex */
public final class C1885uu implements Iterator, KMutableIterator {

    /* renamed from: a */
    public final Lambda f27442a;

    /* renamed from: b */
    public int f27443b = -1;

    /* renamed from: c */
    public Object f27444c;

    /* renamed from: d */
    public Object f27445d;

    /* renamed from: e */
    public final /* synthetic */ C1922vu f27446e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1885uu(C1922vu c1922vu, Function2 function2) {
        this.f27446e = c1922vu;
        this.f27442a = (Lambda) function2;
        m7769a();
    }

    /* renamed from: a */
    public final void m7769a() {
        T t;
        while (true) {
            int i = this.f27443b + 1;
            this.f27443b = i;
            C1922vu c1922vu = this.f27446e;
            if (i < c1922vu.f27966a) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) c1922vu.f27969d.get(i);
                if (hashedWeakRef != null && (t = hashedWeakRef.get()) != 0) {
                    this.f27444c = t;
                    Object obj = c1922vu.f27970e.get(this.f27443b);
                    if (obj instanceof oh1) {
                        obj = ((oh1) obj).f23809a;
                    }
                    if (obj != null) {
                        this.f27445d = obj;
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f27443b < this.f27446e.f27966a) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    @Override // java.util.Iterator
    public final Object next() {
        if (this.f27443b < this.f27446e.f27966a) {
            Object obj = this.f27444c;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("key");
                obj = Unit.INSTANCE;
            }
            Object obj2 = this.f27445d;
            if (obj2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("value");
                obj2 = Unit.INSTANCE;
            }
            Object invoke = this.f27442a.invoke(obj, obj2);
            m7769a();
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        ConcurrentWeakMapKt.access$noImpl();
        throw new KotlinNothingValueException();
    }
}

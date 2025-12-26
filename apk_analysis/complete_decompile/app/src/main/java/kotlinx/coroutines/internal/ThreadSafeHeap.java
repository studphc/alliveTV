package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InternalCoroutinesApi
@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0007J2\u0010\u0010\u001a\u0004\u0018\u00018\u00002!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0013J&\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\nH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J.\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u00002\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u000e0\nH\u0086\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010!\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00028\u0000H\u0001¢\u0006\u0004\b#\u0010\u0018R$\u0010(\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u001f8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010)\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000b\u0010,\u001a\u00020+8\u0002X\u0082\u0004¨\u0006-"}, m5569d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "", "clear", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", "", "predicate", "find", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "removeFirstIf", "node", "addLast", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "", FirebaseAnalytics.Param.INDEX, "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "getSize", "()I", "setSize", "(I)V", "size", "isEmpty", "()Z", "Lkotlinx/atomicfu/AtomicInt;", "_size", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n28#2,4:169\n28#2,4:174\n28#2,4:179\n28#2,4:184\n28#2,4:189\n28#2,4:194\n28#2,4:199\n28#2,4:204\n20#3:173\n20#3:178\n20#3:183\n20#3:188\n20#3:193\n20#3:198\n20#3:203\n20#3:208\n1#4:209\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n35#1:169,4\n42#1:174,4\n50#1:179,4\n52#1:184,4\n60#1:189,4\n69#1:194,4\n72#1:199,4\n81#1:204,4\n35#1:173\n42#1:178\n50#1:183\n52#1:188\n60#1:193\n69#1:198\n72#1:203\n81#1:208\n*E\n"})
/* loaded from: classes2.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {

    /* renamed from: b */
    public static final AtomicIntegerFieldUpdater f22050b = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");

    @Volatile
    private volatile int _size;

    /* renamed from: a */
    public ThreadSafeHeapNode[] f22051a;

    /* renamed from: a */
    public final void m5734a(int i) {
        while (i > 0) {
            ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f22051a;
            Intrinsics.checkNotNull(threadSafeHeapNodeArr);
            int i2 = (i - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i2];
            Intrinsics.checkNotNull(threadSafeHeapNode);
            ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
            Intrinsics.checkNotNull(threadSafeHeapNode2);
            if (((Comparable) threadSafeHeapNode).compareTo(threadSafeHeapNode2) <= 0) {
                return;
            }
            m5735b(i, i2);
            i = i2;
        }
    }

    @PublishedApi
    public final void addImpl(@NotNull T node) {
        node.setHeap(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f22051a;
        if (threadSafeHeapNodeArr == null) {
            threadSafeHeapNodeArr = new ThreadSafeHeapNode[4];
            this.f22051a = threadSafeHeapNodeArr;
        } else if (getSize() >= threadSafeHeapNodeArr.length) {
            Object[] copyOf = Arrays.copyOf(threadSafeHeapNodeArr, getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            threadSafeHeapNodeArr = (ThreadSafeHeapNode[]) copyOf;
            this.f22051a = threadSafeHeapNodeArr;
        }
        int size = getSize();
        f22050b.set(this, size + 1);
        threadSafeHeapNodeArr[size] = node;
        node.setIndex(size);
        m5734a(size);
    }

    public final void addLast(@NotNull T node) {
        synchronized (this) {
            addImpl(node);
        }
    }

    public final boolean addLastIf(@NotNull T node, @NotNull Function1<? super T, Boolean> cond) {
        boolean z;
        synchronized (this) {
            try {
                if (cond.invoke(firstImpl()).booleanValue()) {
                    addImpl(node);
                    z = true;
                } else {
                    z = false;
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return z;
    }

    /* renamed from: b */
    public final void m5735b(int i, int i2) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f22051a;
        Intrinsics.checkNotNull(threadSafeHeapNodeArr);
        ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[i2];
        Intrinsics.checkNotNull(threadSafeHeapNode);
        ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
        Intrinsics.checkNotNull(threadSafeHeapNode2);
        threadSafeHeapNodeArr[i] = threadSafeHeapNode;
        threadSafeHeapNodeArr[i2] = threadSafeHeapNode2;
        threadSafeHeapNode.setIndex(i);
        threadSafeHeapNode2.setIndex(i2);
    }

    public final void clear() {
        synchronized (this) {
            try {
                ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f22051a;
                if (threadSafeHeapNodeArr != null) {
                    ArraysKt___ArraysJvmKt.fill$default(threadSafeHeapNodeArr, (Object) null, 0, 0, 6, (Object) null);
                }
                f22050b.set(this, 0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final T find(@NotNull Function1<? super T, Boolean> predicate) {
        ThreadSafeHeapNode threadSafeHeapNode;
        synchronized (this) {
            try {
                int size = getSize();
                int i = 0;
                while (true) {
                    threadSafeHeapNode = null;
                    if (i >= size) {
                        break;
                    }
                    ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f22051a;
                    if (threadSafeHeapNodeArr != null) {
                        threadSafeHeapNode = threadSafeHeapNodeArr[i];
                    }
                    Intrinsics.checkNotNull(threadSafeHeapNode);
                    if (predicate.invoke(threadSafeHeapNode).booleanValue()) {
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return threadSafeHeapNode;
    }

    @PublishedApi
    @Nullable
    public final T firstImpl() {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f22051a;
        if (threadSafeHeapNodeArr != null) {
            return (T) threadSafeHeapNodeArr[0];
        }
        return null;
    }

    public final int getSize() {
        return f22050b.get(this);
    }

    public final boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final boolean remove(@NotNull T node) {
        boolean z;
        synchronized (this) {
            if (node.getHeap() == null) {
                z = false;
            } else {
                removeAtImpl(node.getIndex());
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0064, code lost:
    
        if (((java.lang.Comparable) r5).compareTo(r6) < 0) goto L18;
     */
    @PublishedApi
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T removeAtImpl(int index) {
        ThreadSafeHeapNode[] threadSafeHeapNodeArr = this.f22051a;
        Intrinsics.checkNotNull(threadSafeHeapNodeArr);
        f22050b.set(this, getSize() - 1);
        if (index < getSize()) {
            m5735b(index, getSize());
            int i = (index - 1) / 2;
            if (index > 0) {
                ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr[index];
                Intrinsics.checkNotNull(threadSafeHeapNode);
                ThreadSafeHeapNode threadSafeHeapNode2 = threadSafeHeapNodeArr[i];
                Intrinsics.checkNotNull(threadSafeHeapNode2);
                if (((Comparable) threadSafeHeapNode).compareTo(threadSafeHeapNode2) < 0) {
                    m5735b(index, i);
                    m5734a(i);
                }
            }
            while (true) {
                int i2 = index * 2;
                int i3 = i2 + 1;
                if (i3 >= getSize()) {
                    break;
                }
                ThreadSafeHeapNode[] threadSafeHeapNodeArr2 = this.f22051a;
                Intrinsics.checkNotNull(threadSafeHeapNodeArr2);
                int i4 = i2 + 2;
                if (i4 < getSize()) {
                    ThreadSafeHeapNode threadSafeHeapNode3 = threadSafeHeapNodeArr2[i4];
                    Intrinsics.checkNotNull(threadSafeHeapNode3);
                    ThreadSafeHeapNode threadSafeHeapNode4 = threadSafeHeapNodeArr2[i3];
                    Intrinsics.checkNotNull(threadSafeHeapNode4);
                }
                i4 = i3;
                ThreadSafeHeapNode threadSafeHeapNode5 = threadSafeHeapNodeArr2[index];
                Intrinsics.checkNotNull(threadSafeHeapNode5);
                ThreadSafeHeapNode threadSafeHeapNode6 = threadSafeHeapNodeArr2[i4];
                Intrinsics.checkNotNull(threadSafeHeapNode6);
                if (((Comparable) threadSafeHeapNode5).compareTo(threadSafeHeapNode6) <= 0) {
                    break;
                }
                m5735b(index, i4);
                index = i4;
            }
        }
        T t = (T) threadSafeHeapNodeArr[getSize()];
        Intrinsics.checkNotNull(t);
        t.setHeap(null);
        t.setIndex(-1);
        threadSafeHeapNodeArr[getSize()] = null;
        return t;
    }

    @Nullable
    public final T removeFirstIf(@NotNull Function1<? super T, Boolean> predicate) {
        synchronized (this) {
            try {
                T firstImpl = firstImpl();
                T t = null;
                if (firstImpl == null) {
                    InlineMarker.finallyStart(2);
                    InlineMarker.finallyEnd(2);
                    return null;
                }
                if (predicate.invoke(firstImpl).booleanValue()) {
                    t = removeAtImpl(0);
                }
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                return t;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    @Nullable
    public final T removeFirstOrNull() {
        T t;
        synchronized (this) {
            if (getSize() > 0) {
                t = removeAtImpl(0);
            } else {
                t = null;
            }
        }
        return t;
    }
}

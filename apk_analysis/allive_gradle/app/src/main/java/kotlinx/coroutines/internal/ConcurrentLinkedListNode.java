package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\u0004\u0018\u00018\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0017\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001b8\u0002X\u0082\u0004R\u0013\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001b8\u0002X\u0082\u0004¨\u0006\u001e"}, m5569d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "Lkotlin/Function0;", "", "onClosedAction", "nextOrIfClosed", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "value", "", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "", "cleanPrev", "()V", "markAsClosed", "()Z", "remove", "getNext", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "next", "isTail", "getPrev", "isRemoved", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n107#1,7:270\n1#2:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n115#1:270,7\n*E\n"})
/* loaded from: classes2.dex */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* renamed from: a */
    public static final AtomicReferenceFieldUpdater f22006a = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");

    /* renamed from: b */
    public static final AtomicReferenceFieldUpdater f22007b = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    @Nullable
    private volatile Object _prev;

    public ConcurrentLinkedListNode(@Nullable N n) {
        this._prev = n;
    }

    public static final Object access$getNextOrClosed(ConcurrentLinkedListNode concurrentLinkedListNode) {
        concurrentLinkedListNode.getClass();
        return f22006a.get(concurrentLinkedListNode);
    }

    public final void cleanPrev() {
        f22007b.lazySet(this, null);
    }

    @Nullable
    public final N getNext() {
        Object access$getNextOrClosed = access$getNextOrClosed(this);
        if (access$getNextOrClosed == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            return null;
        }
        return (N) access$getNextOrClosed;
    }

    @Nullable
    public final N getPrev() {
        return (N) f22007b.get(this);
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        if (getNext() == null) {
            return true;
        }
        return false;
    }

    public final boolean markAsClosed() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Symbol access$getCLOSED$p = ConcurrentLinkedListKt.access$getCLOSED$p();
        do {
            atomicReferenceFieldUpdater = f22006a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, access$getCLOSED$p)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return false;
    }

    @Nullable
    public final N nextOrIfClosed(@NotNull Function0 onClosedAction) {
        Object access$getNextOrClosed = access$getNextOrClosed(this);
        if (access$getNextOrClosed != ConcurrentLinkedListKt.access$getCLOSED$p()) {
            return (N) access$getNextOrClosed;
        }
        onClosedAction.invoke();
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    public final void remove() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ConcurrentLinkedListNode concurrentLinkedListNode;
        ?? next;
        if (isTail()) {
            return;
        }
        while (true) {
            N prev = getPrev();
            while (true) {
                atomicReferenceFieldUpdater = f22007b;
                if (prev == null || !prev.isRemoved()) {
                    break;
                } else {
                    prev = (N) atomicReferenceFieldUpdater.get(prev);
                }
            }
            N next2 = getNext();
            Intrinsics.checkNotNull(next2);
            while (next2.isRemoved() && (next = next2.getNext()) != 0) {
                next2 = next;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(next2);
                if (((ConcurrentLinkedListNode) obj) == null) {
                    concurrentLinkedListNode = null;
                } else {
                    concurrentLinkedListNode = prev;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(next2, obj, concurrentLinkedListNode)) {
                    if (atomicReferenceFieldUpdater.get(next2) != obj) {
                        break;
                    }
                }
            }
            if (prev != null) {
                f22006a.set(prev, next2);
            }
            if (!next2.isRemoved() || next2.isTail()) {
                if (prev == null || !prev.isRemoved()) {
                    return;
                }
            }
        }
    }

    public final boolean trySetNext(@NotNull N value) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f22006a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, value)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return false;
    }
}

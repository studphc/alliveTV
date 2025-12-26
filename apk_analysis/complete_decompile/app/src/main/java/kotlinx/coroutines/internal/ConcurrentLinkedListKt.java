package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001al\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u000226\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00028\u00000\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u000e\u001a\u00028\u0000\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\f*\u00028\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a?\u0010\u0017\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00112!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0082\b¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m5569d2 = {"Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "", "id", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "prev", "createNewSegment", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/atomicfu/AtomicInt;", "", "delta", "Lkotlin/Function1;", "cur", "", "condition", "addConditionally", "(Lkotlinx/atomicfu/AtomicInt;ILkotlin/jvm/functions/Function1;)Z", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,269:1\n46#1,8:284\n107#2,7:270\n107#2,7:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n74#1:284,8\n27#1:270,7\n85#1:277,7\n*E\n"})
/* loaded from: classes2.dex */
public final class ConcurrentLinkedListKt {

    /* renamed from: a */
    public static final Symbol f22005a = new Symbol("CLOSED");

    public static final /* synthetic */ Symbol access$getCLOSED$p() {
        return f22005a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    @NotNull
    public static final <N extends ConcurrentLinkedListNode<N>> N close(@NotNull N n) {
        while (true) {
            Object access$getNextOrClosed = ConcurrentLinkedListNode.access$getNextOrClosed(n);
            if (access$getNextOrClosed == f22005a) {
                return n;
            }
            ?? r0 = (ConcurrentLinkedListNode) access$getNextOrClosed;
            if (r0 == 0) {
                if (n.markAsClosed()) {
                    return n;
                }
            } else {
                n = r0;
            }
        }
    }

    @NotNull
    public static final Object findSegmentAndMoveForward$atomicfu(@Nullable Object obj, @NotNull AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long j, @NotNull Segment segment, @NotNull Function2 function2) {
        Object findSegmentInternal;
        loop0: while (true) {
            findSegmentInternal = findSegmentInternal(segment, j, function2);
            if (!SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
                Segment m8904getSegmentimpl = SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater.get(obj);
                    if (segment2.id >= m8904getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!m8904getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(obj, segment2, m8904getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(obj) != segment2) {
                            if (m8904getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                m8904getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment2.decPointers$kotlinx_coroutines_core()) {
                        segment2.remove();
                    }
                }
            } else {
                break;
            }
        }
        return findSegmentInternal;
    }

    @NotNull
    public static final Object findSegmentAndMoveForward$atomicfu$array(@Nullable Object obj, @NotNull AtomicReferenceArray atomicReferenceArray, int i, long j, @NotNull Segment segment, @NotNull Function2 function2) {
        Object findSegmentInternal;
        loop0: while (true) {
            findSegmentInternal = findSegmentInternal(segment, j, function2);
            if (!SegmentOrClosed.m8906isClosedimpl(findSegmentInternal)) {
                Segment m8904getSegmentimpl = SegmentOrClosed.m8904getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment2 = (Segment) atomicReferenceArray.get(i);
                    if (segment2.id >= m8904getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!m8904getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceArray.compareAndSet(i, segment2, m8904getSegmentimpl)) {
                        if (atomicReferenceArray.get(i) != segment2) {
                            if (m8904getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                m8904getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment2.decPointers$kotlinx_coroutines_core()) {
                        segment2.remove();
                    }
                }
            } else {
                break;
            }
        }
        return findSegmentInternal;
    }

    @NotNull
    public static final <S extends Segment<S>> Object findSegmentInternal(@NotNull S s, long j, @NotNull Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s.id >= j && !s.isRemoved()) {
                return SegmentOrClosed.m8901constructorimpl(s);
            }
            Object access$getNextOrClosed = ConcurrentLinkedListNode.access$getNextOrClosed(s);
            if (access$getNextOrClosed == f22005a) {
                return SegmentOrClosed.m8901constructorimpl(f22005a);
            }
            S s2 = (S) ((ConcurrentLinkedListNode) access$getNextOrClosed);
            if (s2 == null) {
                s2 = function2.invoke(Long.valueOf(s.id + 1), s);
                if (s.trySetNext(s2)) {
                    if (s.isRemoved()) {
                        s.remove();
                    }
                }
            }
            s = s2;
        }
    }

    public static final boolean moveForward$atomicfu(@Nullable Object obj, @NotNull AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, @NotNull Segment segment) {
        while (true) {
            Segment segment2 = (Segment) atomicReferenceFieldUpdater.get(obj);
            if (segment2.id >= segment.id) {
                return true;
            }
            if (!segment.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(obj, segment2, segment)) {
                if (atomicReferenceFieldUpdater.get(obj) != segment2) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            }
            if (segment2.decPointers$kotlinx_coroutines_core()) {
                segment2.remove();
            }
            return true;
        }
    }

    public static final boolean moveForward$atomicfu$array(@Nullable Object obj, @NotNull AtomicReferenceArray atomicReferenceArray, int i, @NotNull Segment segment) {
        while (true) {
            Segment segment2 = (Segment) atomicReferenceArray.get(i);
            if (segment2.id >= segment.id) {
                return true;
            }
            if (!segment.tryIncPointers$kotlinx_coroutines_core()) {
                return false;
            }
            while (!atomicReferenceArray.compareAndSet(i, segment2, segment)) {
                if (atomicReferenceArray.get(i) != segment2) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            }
            if (segment2.decPointers$kotlinx_coroutines_core()) {
                segment2.remove();
            }
            return true;
        }
    }
}

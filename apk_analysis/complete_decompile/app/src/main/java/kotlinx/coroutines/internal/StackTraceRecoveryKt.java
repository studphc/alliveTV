package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ro2;

@Metadata(m5568d1 = {"\u00008\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0080\b¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0080Hø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0081\b¢\u0006\u0004\b\u000b\u0010\u0004\u001a!\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\f\u0010\u0004\u001a\u0017\u0010\u0010\u001a\u00020\u000f*\u00060\rj\u0002`\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0014\u0010\u0015*\f\b\u0000\u0010\u0017\"\u00020\u00162\u00020\u0016*\f\b\u0000\u0010\u0018\"\u00020\r2\u00020\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, m5569d2 = {"", ExifInterface.LONGITUDE_EAST, "exception", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "continuation", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "", "recoverAndThrow", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unwrap", "unwrapImpl", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "", "isArtificial", "(Ljava/lang/StackTraceElement;)Z", "cause", "", "initCause", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,216:1\n1735#2,6:217\n12744#2,2:225\n1627#2,6:229\n12744#2,2:235\n1627#2,6:238\n37#3,2:223\n26#4:227\n26#4:228\n1#5:237\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n43#1:217,6\n131#1:225,2\n141#1:229,6\n173#1:235,2\n194#1:238,6\n106#1:223,2\n133#1:227\n135#1:228\n*E\n"})
/* loaded from: classes2.dex */
public final class StackTraceRecoveryKt {

    /* renamed from: a */
    public static final StackTraceElement f22041a = new ArtificialStackFrames().coroutineBoundary();

    /* renamed from: b */
    public static final String f22042b;

    static {
        Object m8512constructorimpl;
        Object m8512constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            m8512constructorimpl = Result.m8512constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m8512constructorimpl = Result.m8512constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m8515exceptionOrNullimpl(m8512constructorimpl) != null) {
            m8512constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f22042b = (String) m8512constructorimpl;
        try {
            m8512constructorimpl2 = Result.m8512constructorimpl(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            m8512constructorimpl2 = Result.m8512constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8515exceptionOrNullimpl(m8512constructorimpl2) != null) {
            m8512constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    public static final Throwable access$recoverFromStackFrame(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        Pair m5575to;
        Throwable cause = th.getCause();
        int i = 0;
        if (cause != null && Intrinsics.areEqual(cause.getClass(), th.getClass())) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    if (isArtificial(stackTrace[i2])) {
                        m5575to = TuplesKt.m5575to(cause, stackTrace);
                        break;
                    }
                    i2++;
                } else {
                    m5575to = TuplesKt.m5575to(th, new StackTraceElement[0]);
                    break;
                }
            }
        } else {
            m5575to = TuplesKt.m5575to(th, new StackTraceElement[0]);
        }
        Throwable th2 = (Throwable) m5575to.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) m5575to.component2();
        Throwable tryCopyException = ExceptionsConstructorKt.tryCopyException(th2);
        if (tryCopyException != null) {
            ArrayDeque arrayDeque = new ArrayDeque();
            StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayDeque.add(stackTraceElement);
            }
            while (true) {
                coroutineStackFrame = coroutineStackFrame.getCallerFrame();
                if (coroutineStackFrame == null) {
                    break;
                }
                StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
                if (stackTraceElement2 != null) {
                    arrayDeque.add(stackTraceElement2);
                }
            }
            if (!arrayDeque.isEmpty()) {
                if (th2 != th) {
                    int length2 = stackTraceElementArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length2) {
                            if (isArtificial(stackTraceElementArr[i3])) {
                                break;
                            }
                            i3++;
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    int i4 = i3 + 1;
                    int length3 = stackTraceElementArr.length - 1;
                    if (i4 <= length3) {
                        while (true) {
                            StackTraceElement stackTraceElement3 = stackTraceElementArr[length3];
                            StackTraceElement stackTraceElement4 = (StackTraceElement) arrayDeque.getLast();
                            if (stackTraceElement3.getLineNumber() == stackTraceElement4.getLineNumber() && Intrinsics.areEqual(stackTraceElement3.getMethodName(), stackTraceElement4.getMethodName()) && Intrinsics.areEqual(stackTraceElement3.getFileName(), stackTraceElement4.getFileName()) && Intrinsics.areEqual(stackTraceElement3.getClassName(), stackTraceElement4.getClassName())) {
                                arrayDeque.removeLast();
                            }
                            arrayDeque.addFirst(stackTraceElementArr[length3]);
                            if (length3 == i4) {
                                break;
                            }
                            length3--;
                        }
                    }
                }
                arrayDeque.addFirst(f22041a);
                StackTraceElement[] stackTrace2 = th2.getStackTrace();
                int length4 = stackTrace2.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length4) {
                        if (Intrinsics.areEqual(f22042b, stackTrace2[i5].getClassName())) {
                            break;
                        }
                        i5++;
                    } else {
                        i5 = -1;
                        break;
                    }
                }
                if (i5 == -1) {
                    tryCopyException.setStackTrace((StackTraceElement[]) arrayDeque.toArray(new StackTraceElement[0]));
                } else {
                    StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[arrayDeque.size() + i5];
                    for (int i6 = 0; i6 < i5; i6++) {
                        stackTraceElementArr2[i6] = stackTrace2[i6];
                    }
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        stackTraceElementArr2[i + i5] = (StackTraceElement) it.next();
                        i++;
                    }
                    tryCopyException.setStackTrace(stackTraceElementArr2);
                }
                return tryCopyException;
            }
            return th;
        }
        return th;
    }

    public static final void initCause(@NotNull Throwable th, @NotNull Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean isArtificial(@NotNull StackTraceElement stackTraceElement) {
        return ro2.startsWith$default(stackTraceElement.getClassName(), CoroutineDebuggingKt.getARTIFICIAL_FRAME_PACKAGE_NAME(), false, 2, null);
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E e) {
        return e;
    }

    @PublishedApi
    @NotNull
    public static final <E extends Throwable> E unwrap(@NotNull E e) {
        return e;
    }

    @PublishedApi
    @NotNull
    public static final <E extends Throwable> E unwrapImpl(@NotNull E e) {
        E e2 = (E) e.getCause();
        if (e2 != null && Intrinsics.areEqual(e2.getClass(), e.getClass())) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (isArtificial(stackTraceElement)) {
                    return e2;
                }
            }
        }
        return e;
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E e, @NotNull Continuation<?> continuation) {
        return e;
    }

    @Nullable
    public static final Object recoverAndThrow(@NotNull Throwable th, @NotNull Continuation<?> continuation) {
        throw th;
    }
}

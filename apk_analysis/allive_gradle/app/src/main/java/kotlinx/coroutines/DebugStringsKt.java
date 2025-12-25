package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, m5569d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDebugStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugStrings.kt\nkotlinx/coroutines/DebugStringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
/* loaded from: classes2.dex */
public final class DebugStringsKt {
    @NotNull
    public static final String getClassSimpleName(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    public static final String getHexAddress(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    public static final String toDebugString(@NotNull Continuation<?> continuation) {
        Object m8512constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m8512constructorimpl = Result.m8512constructorimpl(continuation + '@' + getHexAddress(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m8512constructorimpl = Result.m8512constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m8515exceptionOrNullimpl(m8512constructorimpl) != null) {
            m8512constructorimpl = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) m8512constructorimpl;
    }
}

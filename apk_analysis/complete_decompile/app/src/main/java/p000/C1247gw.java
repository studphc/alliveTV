package p000;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* renamed from: gw */
/* loaded from: classes2.dex */
public final class C1247gw implements BiFunction {

    @JvmField
    @Nullable
    public volatile Continuation<Object> cont;

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        r2 = r2.getCause();
     */
    @Override // java.util.function.BiFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object apply(Object obj, Object obj2) {
        CompletionException completionException;
        Throwable cause;
        Throwable th = (Throwable) obj2;
        Continuation<Object> continuation = this.cont;
        if (continuation != null) {
            if (th == null) {
                continuation.resumeWith(Result.m8512constructorimpl(obj));
            } else {
                if (AbstractC1608o3.m6411C(th)) {
                    completionException = AbstractC1608o3.m6426n(th);
                } else {
                    completionException = null;
                }
                if (completionException != null && cause != null) {
                    th = cause;
                }
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m8512constructorimpl(ResultKt.createFailure(th)));
            }
        }
        return Unit.INSTANCE;
    }
}

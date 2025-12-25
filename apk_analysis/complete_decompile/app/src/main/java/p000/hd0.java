package p000;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletionException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.io.FileSystemException;
import kotlin.io.OnErrorAction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* loaded from: classes2.dex */
public final class hd0 extends Lambda implements Function2 {

    /* renamed from: b */
    public final /* synthetic */ int f18027b;

    /* renamed from: c */
    public final /* synthetic */ Object f18028c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ hd0(int i, Object obj) {
        super(2);
        this.f18027b = i;
        this.f18028c = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        r8 = r8.getCause();
     */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Object obj, Object obj2) {
        CompletionException completionException;
        boolean completeExceptionally;
        Throwable cause;
        switch (this.f18027b) {
            case 0:
                File file = (File) obj;
                IOException e = (IOException) obj2;
                Intrinsics.checkNotNullParameter(file, "f");
                Intrinsics.checkNotNullParameter(e, "e");
                if (((Function2) this.f18028c).invoke(file, e) != OnErrorAction.TERMINATE) {
                    return Unit.INSTANCE;
                }
                Intrinsics.checkNotNullParameter(file, "file");
                throw new FileSystemException(file, null, null, 6, null);
            case 1:
                ((Function2) this.f18028c).invoke(Integer.valueOf(((Number) obj).intValue()), obj2);
                return obj2;
            default:
                Throwable th = (Throwable) obj2;
                CompletableDeferred completableDeferred = (CompletableDeferred) this.f18028c;
                try {
                    if (th == null) {
                        completeExceptionally = completableDeferred.complete(obj);
                    } else {
                        if (AbstractC1608o3.m6411C(th)) {
                            completionException = AbstractC1608o3.m6426n(th);
                        } else {
                            completionException = null;
                        }
                        if (completionException != null && cause != null) {
                            th = cause;
                        }
                        completeExceptionally = completableDeferred.completeExceptionally(th);
                    }
                    return Boolean.valueOf(completeExceptionally);
                } catch (Throwable th2) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th2);
                    return Unit.INSTANCE;
                }
        }
    }
}

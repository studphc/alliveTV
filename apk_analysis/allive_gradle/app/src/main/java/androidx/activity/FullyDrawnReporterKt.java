package androidx.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.cv0;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, m5569d2 = {"reportWhenComplete", "", "Landroidx/activity/FullyDrawnReporter;", "reporter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class FullyDrawnReporterKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.Unit, java.lang.Object] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object reportWhenComplete(@NotNull FullyDrawnReporter fullyDrawnReporter, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1, @NotNull Continuation<? super Unit> continuation) {
        cv0 cv0Var;
        int i;
        FullyDrawnReporter fullyDrawnReporter2;
        try {
            if (continuation instanceof cv0) {
                cv0 cv0Var2 = (cv0) continuation;
                int i2 = cv0Var2.f16122f;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    cv0Var2.f16122f = i2 - Integer.MIN_VALUE;
                    cv0Var = cv0Var2;
                    Object obj = cv0Var.f16121e;
                    Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                    i = cv0Var.f16122f;
                    if (i == 0) {
                        if (i == 1) {
                            FullyDrawnReporter fullyDrawnReporter3 = cv0Var.f16120d;
                            ResultKt.throwOnFailure(obj);
                            fullyDrawnReporter2 = fullyDrawnReporter3;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        fullyDrawnReporter.addReporter();
                        if (fullyDrawnReporter.isFullyDrawnReported()) {
                            return Unit.INSTANCE;
                        }
                        cv0Var.f16120d = fullyDrawnReporter;
                        cv0Var.f16122f = 1;
                        fullyDrawnReporter2 = fullyDrawnReporter;
                        if (function1.invoke(cv0Var) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    InlineMarker.finallyStart(1);
                    fullyDrawnReporter2.removeReporter();
                    InlineMarker.finallyEnd(1);
                    fullyDrawnReporter = Unit.INSTANCE;
                    return fullyDrawnReporter;
                }
            }
            if (i == 0) {
            }
            InlineMarker.finallyStart(1);
            fullyDrawnReporter2.removeReporter();
            InlineMarker.finallyEnd(1);
            fullyDrawnReporter = Unit.INSTANCE;
            return fullyDrawnReporter;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            fullyDrawnReporter.removeReporter();
            InlineMarker.finallyEnd(1);
            throw th;
        }
        cv0Var = new ContinuationImpl(continuation);
        Object obj2 = cv0Var.f16121e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = cv0Var.f16122f;
    }
}

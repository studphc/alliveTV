package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.dg2;

/* loaded from: classes2.dex */
public abstract class SequencesKt__SequenceBuilderKt {
    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> Iterator<T> iterator(@BuilderInference @NotNull Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        dg2 dg2Var = (Iterator<T>) new SequenceScope();
        dg2Var.f16373d = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(block, dg2Var, dg2Var);
        return dg2Var;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> Sequence<T> sequence(@BuilderInference @NotNull final Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return SequencesKt__SequenceBuilderKt.iterator(Function2.this);
            }
        };
    }
}

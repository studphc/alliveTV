package p000;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class ko2 {
    @NotNull
    public static final <T extends Appendable> T append(@NotNull T t, @NotNull CharSequence... value) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (CharSequence charSequence : value) {
            t.append(charSequence);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void appendElement(@NotNull Appendable appendable, T t, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        boolean z;
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        if (function1 != null) {
            appendable.append(function1.invoke(t));
            return;
        }
        if (t == 0) {
            z = true;
        } else {
            z = t instanceof CharSequence;
        }
        if (z) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final <T extends Appendable> T appendRange(@NotNull T t, @NotNull CharSequence value, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        T t2 = (T) t.append(value, i, i2);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t2;
    }
}

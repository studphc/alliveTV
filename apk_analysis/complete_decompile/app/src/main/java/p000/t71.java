package p000;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt$WhenMappings;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UNINITIALIZED_VALUE;
import kotlin.UnsafeLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class t71 {
    @NotNull
    public static <T> Lazy<T> lazy(@NotNull Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new yr2(null, initializer);
    }

    @NotNull
    public static final <T> Lazy<T> lazy(@NotNull LazyThreadSafetyMode mode, @NotNull Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        int i = LazyKt__LazyJVMKt$WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return new yr2(null, initializer);
        }
        if (i != 2) {
            if (i == 3) {
                return new UnsafeLazyImpl(initializer);
            }
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        zd2 zd2Var = (Lazy<T>) new Object();
        zd2Var.f29324a = initializer;
        zd2Var.f29325b = UNINITIALIZED_VALUE.INSTANCE;
        return zd2Var;
    }

    @NotNull
    public static final <T> Lazy<T> lazy(@Nullable Object obj, @NotNull Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new yr2(obj, initializer);
    }
}

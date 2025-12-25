package p000;

import kotlin.InitializedLazyImpl;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public abstract class u71 extends t71 {
    @NotNull
    public static final <T> Lazy<T> lazyOf(T t) {
        return new InitializedLazyImpl(t);
    }
}

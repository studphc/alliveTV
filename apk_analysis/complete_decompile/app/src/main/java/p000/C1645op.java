package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ClassValueCtorCache$cache$1;
import kotlinx.coroutines.internal.CtorCache;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: op */
/* loaded from: classes2.dex */
public final class C1645op extends CtorCache {

    /* renamed from: a */
    public static final C1645op f24849a = new CtorCache();

    /* renamed from: b */
    public static final ClassValueCtorCache$cache$1 f24850b = new ClassValue<Function1<? super Throwable, ? extends Throwable>>() { // from class: kotlinx.coroutines.internal.ClassValueCtorCache$cache$1
        @Override // java.lang.ClassValue
        public /* bridge */ /* synthetic */ Function1<? super Throwable, ? extends Throwable> computeValue(Class cls) {
            return computeValue2((Class<?>) cls);
        }

        @Override // java.lang.ClassValue
        @NotNull
        /* renamed from: computeValue, reason: avoid collision after fix types in other method */
        public Function1<? super Throwable, ? extends Throwable> computeValue2(@Nullable Class<?> type) {
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
            return ExceptionsConstructorKt.access$createConstructor(type);
        }
    };

    @Override // kotlinx.coroutines.internal.CtorCache
    public final Function1 get(Class cls) {
        Object obj;
        obj = f24850b.get(cls);
        return (Function1) obj;
    }
}

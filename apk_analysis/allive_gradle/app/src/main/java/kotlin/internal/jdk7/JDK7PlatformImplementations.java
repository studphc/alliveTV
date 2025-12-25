package kotlin.internal.jdk7;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.d61;

@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, m5569d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "<init>", "()V", "", "cause", "exception", "", "addSuppressed", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "", "getSuppressed", "(Ljava/lang/Throwable;)Ljava/util/List;", "d61", "kotlin-stdlib-jdk7"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {
    @Override // kotlin.internal.PlatformImplementations
    public void addSuppressed(@NotNull Throwable cause, @NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Integer num = d61.f16271a;
        if (num != null && num.intValue() < 19) {
            super.addSuppressed(cause, exception);
        } else {
            cause.addSuppressed(exception);
        }
    }

    @Override // kotlin.internal.PlatformImplementations
    @NotNull
    public List<Throwable> getSuppressed(@NotNull Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Integer num = d61.f16271a;
        if (num != null && num.intValue() < 19) {
            return super.getSuppressed(exception);
        }
        Throwable[] suppressed = exception.getSuppressed();
        Intrinsics.checkNotNullExpressionValue(suppressed, "exception.suppressed");
        return ArraysKt___ArraysJvmKt.asList(suppressed);
    }
}

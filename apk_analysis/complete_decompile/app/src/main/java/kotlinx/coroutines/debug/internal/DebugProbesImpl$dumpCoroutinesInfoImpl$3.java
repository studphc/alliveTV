package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m5569d2 = {"<anonymous>", "R", "", "owner", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "invoke", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Object;"}, m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,620:1\n1#2:621\n*E\n"})
/* loaded from: classes2.dex */
public final class DebugProbesImpl$dumpCoroutinesInfoImpl$3 extends Lambda implements Function1<DebugProbesImpl.CoroutineOwner<?>, Object> {

    /* renamed from: b */
    public final /* synthetic */ Function2 f21534b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugProbesImpl$dumpCoroutinesInfoImpl$3(Function2<? super DebugProbesImpl.CoroutineOwner<?>, ? super CoroutineContext, Object> function2) {
        super(1);
        this.f21534b = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@NotNull DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        CoroutineContext context;
        if (DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, coroutineOwner) || (context = coroutineOwner.info.getContext()) == null) {
            return null;
        }
        return this.f21534b.invoke(coroutineOwner, context);
    }
}

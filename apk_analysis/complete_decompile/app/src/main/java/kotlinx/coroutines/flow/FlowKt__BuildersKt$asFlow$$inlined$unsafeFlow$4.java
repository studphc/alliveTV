package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,113:1\n99#2:114\n100#2,2:116\n102#2:119\n32#3:115\n33#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n99#1:115\n99#1:118\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Iterator f21563a;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4", m5601f = "Builders.kt", m5602i = {0}, m5603l = {116}, m5604m = "collect", m5605n = {"$this$asFlow_u24lambda_u245"}, m5606s = {"L$0"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1 */
    /* loaded from: classes2.dex */
    public static final class C14261 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21564d;

        /* renamed from: e */
        public int f21565e;

        /* renamed from: g */
        public FlowCollector f21567g;

        /* renamed from: h */
        public Iterator f21568h;

        public C14261(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21564d = obj;
            this.f21565e |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(Iterator it) {
        this.f21563a = it;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14261 c14261;
        int i;
        FlowCollector flowCollector2;
        Iterator it;
        if (continuation instanceof C14261) {
            c14261 = (C14261) continuation;
            int i2 = c14261.f21565e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14261.f21565e = i2 - Integer.MIN_VALUE;
                Object obj = c14261.f21564d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14261.f21565e;
                if (i == 0) {
                    if (i == 1) {
                        it = c14261.f21568h;
                        FlowCollector flowCollector3 = c14261.f21567g;
                        ResultKt.throwOnFailure(obj);
                        flowCollector2 = flowCollector3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    flowCollector2 = flowCollector;
                    it = this.f21563a;
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    c14261.f21567g = flowCollector2;
                    c14261.f21568h = it;
                    c14261.f21565e = 1;
                    if (flowCollector2.emit(next, c14261) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        c14261 = new C14261(continuation);
        Object obj2 = c14261.f21564d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14261.f21565e;
        if (i == 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}

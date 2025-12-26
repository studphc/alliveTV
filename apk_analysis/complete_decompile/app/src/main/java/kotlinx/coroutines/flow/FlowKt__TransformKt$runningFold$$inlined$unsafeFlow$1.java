package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.fi0;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m5569d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,113:1\n106#2,7:114\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Object f21831a;

    /* renamed from: b */
    public final /* synthetic */ Flow f21832b;

    /* renamed from: c */
    public final /* synthetic */ Function3 f21833c;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", m5601f = "Transform.kt", m5602i = {0, 0, 0}, m5603l = {115, 116}, m5604m = "collect", m5605n = {"this", "$this$runningFold_u24lambda_u249", "accumulator"}, m5606s = {"L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14611 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21834d;

        /* renamed from: e */
        public int f21835e;

        /* renamed from: g */
        public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 f21837g;

        /* renamed from: h */
        public FlowCollector f21838h;

        /* renamed from: i */
        public Ref.ObjectRef f21839i;

        public C14611(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21834d = obj;
            this.f21835e |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, Function3 function3) {
        this.f21831a = obj;
        this.f21832b = flow;
        this.f21833c = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14611 c14611;
        Object coroutine_suspended;
        int i;
        FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
        FlowCollector<? super Object> flowCollector2;
        Ref.ObjectRef objectRef;
        Flow flow;
        fi0 fi0Var;
        if (continuation instanceof C14611) {
            c14611 = (C14611) continuation;
            int i2 = c14611.f21835e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14611.f21835e = i2 - Integer.MIN_VALUE;
                Object obj = c14611.f21834d;
                coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14611.f21835e;
                if (i == 0) {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = c14611.f21839i;
                    flowCollector2 = c14611.f21838h;
                    flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = c14611.f21837g;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    ?? r2 = this.f21831a;
                    objectRef2.element = r2;
                    c14611.f21837g = this;
                    c14611.f21838h = flowCollector;
                    c14611.f21839i = objectRef2;
                    c14611.f21835e = 1;
                    if (flowCollector.emit(r2, c14611) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    objectRef = objectRef2;
                }
                flow = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.f21832b;
                fi0Var = new fi0(objectRef, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.f21833c, flowCollector2);
                c14611.f21837g = null;
                c14611.f21838h = null;
                c14611.f21839i = null;
                c14611.f21835e = 2;
                if (flow.collect(fi0Var, c14611) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        c14611 = new C14611(continuation);
        Object obj2 = c14611.f21834d;
        coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        i = c14611.f21835e;
        if (i == 0) {
        }
        flow = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.f21832b;
        fi0Var = new fi0(objectRef, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.f21833c, flowCollector2);
        c14611.f21837g = null;
        c14611.f21838h = null;
        c14611.f21839i = null;
        c14611.f21835e = 2;
        if (flow.collect(fi0Var, c14611) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}

package kotlinx.coroutines.flow;

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
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,113:1\n154#2:114\n155#2,2:116\n157#2:119\n13579#3:115\n13580#3:118\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n154#1:115\n154#1:118\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Object[] f21575a;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6", m5601f = "Builders.kt", m5602i = {0, 0}, m5603l = {116}, m5604m = "collect", m5605n = {"$this$asFlow_u24lambda_u2411", "$this$forEach$iv"}, m5606s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1 */
    /* loaded from: classes2.dex */
    public static final class C14281 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21576d;

        /* renamed from: e */
        public int f21577e;

        /* renamed from: g */
        public FlowCollector f21579g;

        /* renamed from: h */
        public Object[] f21580h;

        /* renamed from: i */
        public int f21581i;

        /* renamed from: j */
        public int f21582j;

        public C14281(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21576d = obj;
            this.f21577e |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(Object[] objArr) {
        this.f21575a = objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0058 -> B:10:0x005b). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14281 c14281;
        int i;
        FlowCollector flowCollector2;
        int i2;
        int i3;
        Object[] objArr;
        if (continuation instanceof C14281) {
            c14281 = (C14281) continuation;
            int i4 = c14281.f21577e;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c14281.f21577e = i4 - Integer.MIN_VALUE;
                Object obj = c14281.f21576d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14281.f21577e;
                if (i == 0) {
                    if (i == 1) {
                        i2 = c14281.f21582j;
                        i3 = c14281.f21581i;
                        objArr = c14281.f21580h;
                        FlowCollector flowCollector3 = c14281.f21579g;
                        ResultKt.throwOnFailure(obj);
                        flowCollector2 = flowCollector3;
                        i3++;
                        if (i3 < i2) {
                            Object obj2 = objArr[i3];
                            c14281.f21579g = flowCollector2;
                            c14281.f21580h = objArr;
                            c14281.f21581i = i3;
                            c14281.f21582j = i2;
                            c14281.f21577e = 1;
                            if (flowCollector2.emit(obj2, c14281) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i3++;
                            if (i3 < i2) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Object[] objArr2 = this.f21575a;
                    int length = objArr2.length;
                    flowCollector2 = flowCollector;
                    i2 = length;
                    i3 = 0;
                    objArr = objArr2;
                    if (i3 < i2) {
                    }
                }
            }
        }
        c14281 = new C14281(continuation);
        Object obj3 = c14281.f21576d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14281.f21577e;
        if (i == 0) {
        }
    }
}

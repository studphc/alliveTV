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
@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n123#2,4:114\n*E\n"})
/* loaded from: classes2.dex */
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* renamed from: a */
    public final /* synthetic */ Object[] f21605a;

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    @DebugMetadata(m5600c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", m5601f = "Builders.kt", m5602i = {0, 0}, m5603l = {115}, m5604m = "collect", m5605n = {"this", "$this$flowOf_u24lambda_u248"}, m5606s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,113:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 */
    /* loaded from: classes2.dex */
    public static final class C14321 extends ContinuationImpl {

        /* renamed from: d */
        public /* synthetic */ Object f21606d;

        /* renamed from: e */
        public int f21607e;

        /* renamed from: g */
        public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 f21609g;

        /* renamed from: h */
        public FlowCollector f21610h;

        /* renamed from: i */
        public int f21611i;

        /* renamed from: j */
        public int f21612j;

        public C14321(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21606d = obj;
            this.f21607e |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] objArr) {
        this.f21605a = objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0059 -> B:10:0x005c). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super Object> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        C14321 c14321;
        int i;
        int i2;
        FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
        FlowCollector flowCollector2;
        int length;
        if (continuation instanceof C14321) {
            c14321 = (C14321) continuation;
            int i3 = c14321.f21607e;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c14321.f21607e = i3 - Integer.MIN_VALUE;
                Object obj = c14321.f21606d;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c14321.f21607e;
                if (i == 0) {
                    if (i == 1) {
                        length = c14321.f21612j;
                        i2 = c14321.f21611i;
                        FlowCollector flowCollector3 = c14321.f21610h;
                        flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 = c14321.f21609g;
                        ResultKt.throwOnFailure(obj);
                        flowCollector2 = flowCollector3;
                        i2++;
                        if (i2 < length) {
                            Object obj2 = flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.f21605a[i2];
                            c14321.f21609g = flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
                            c14321.f21610h = flowCollector2;
                            c14321.f21611i = i2;
                            c14321.f21612j = length;
                            c14321.f21607e = 1;
                            if (flowCollector2.emit(obj2, c14321) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i2++;
                            if (i2 < length) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    i2 = 0;
                    flowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    length = this.f21605a.length;
                    if (i2 < length) {
                    }
                }
            }
        }
        c14321 = new C14321(continuation);
        Object obj3 = c14321.f21606d;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c14321.f21607e;
        if (i == 0) {
        }
    }
}

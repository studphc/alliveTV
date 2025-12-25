package p000;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* renamed from: rq */
/* loaded from: classes2.dex */
public final class C1770rq extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public Channel f26097e;

    /* renamed from: f */
    public byte[] f26098f;

    /* renamed from: g */
    public int f26099g;

    /* renamed from: h */
    public int f26100h;

    /* renamed from: i */
    public int f26101i;

    /* renamed from: j */
    public /* synthetic */ Object f26102j;

    /* renamed from: k */
    public final /* synthetic */ Flow[] f26103k;

    /* renamed from: l */
    public final /* synthetic */ Function0 f26104l;

    /* renamed from: m */
    public final /* synthetic */ Function3 f26105m;

    /* renamed from: n */
    public final /* synthetic */ FlowCollector f26106n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1770rq(FlowCollector flowCollector, Flow[] flowArr, Function0 function0, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f26103k = flowArr;
        this.f26104l = function0;
        this.f26105m = function3;
        this.f26106n = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1770rq c1770rq = new C1770rq(this.f26106n, this.f26103k, this.f26104l, this.f26105m, continuation);
        c1770rq.f26102j = obj;
        return c1770rq;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1770rq) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fe A[EDGE_INSN: B:38:0x00fe->B:25:0x00fe BREAK  A[LOOP:0: B:17:0x00d9->B:37:?], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x014c -> B:7:0x014d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object[] objArr;
        byte b;
        byte[] bArr;
        int i;
        Channel channel;
        Object obj2;
        Object[] objArr2;
        byte b2;
        IndexedValue indexedValue;
        int index;
        Object obj3;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f26101i;
        int i3 = 1;
        int i4 = 2;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        ?? r2 = this.f26100h;
                        i = this.f26099g;
                        byte[] bArr2 = this.f26098f;
                        Channel channel2 = this.f26097e;
                        Object[] objArr3 = (Object[]) this.f26102j;
                        ResultKt.throwOnFailure(obj);
                        objArr = objArr3;
                        b2 = r2;
                        bArr = bArr2;
                        channel = channel2;
                        b = b2;
                        i3 = 1;
                        i4 = 2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ?? r22 = this.f26100h;
                    i = this.f26099g;
                    byte[] bArr3 = this.f26098f;
                    Channel channel3 = this.f26097e;
                    Object[] objArr4 = (Object[]) this.f26102j;
                    ResultKt.throwOnFailure(obj);
                    b = r22;
                    bArr = bArr3;
                    channel = channel3;
                    objArr = objArr4;
                }
            } else {
                ?? r23 = this.f26100h;
                i = this.f26099g;
                byte[] bArr4 = this.f26098f;
                Channel channel4 = this.f26097e;
                objArr2 = (Object[]) this.f26102j;
                ResultKt.throwOnFailure(obj);
                obj2 = ((ChannelResult) obj).getHolder();
                b2 = r23;
                bArr = bArr4;
                channel = channel4;
                indexedValue = (IndexedValue) ChannelResult.m8872getOrNullimpl(obj2);
                if (indexedValue == null) {
                    return Unit.INSTANCE;
                }
                do {
                    index = indexedValue.getIndex();
                    obj3 = objArr2[index];
                    objArr2[index] = indexedValue.getValue();
                    if (obj3 == NullSurrogateKt.UNINITIALIZED) {
                        i--;
                    }
                    if (bArr[index] != b2) {
                        break;
                    }
                    bArr[index] = b2;
                    indexedValue = (IndexedValue) ChannelResult.m8872getOrNullimpl(channel.mo8861tryReceivePtdJZtk());
                } while (indexedValue != null);
                if (i == 0) {
                    Object[] objArr5 = (Object[]) this.f26104l.invoke();
                    FlowCollector flowCollector = this.f26106n;
                    Function3 function3 = this.f26105m;
                    if (objArr5 == null) {
                        this.f26102j = objArr2;
                        this.f26097e = channel;
                        this.f26098f = bArr;
                        this.f26099g = i;
                        this.f26100h = b2;
                        this.f26101i = i4;
                        if (function3.invoke(flowCollector, objArr2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        ArraysKt___ArraysJvmKt.copyInto$default(objArr2, objArr5, 0, 0, 0, 14, (Object) null);
                        this.f26102j = objArr2;
                        this.f26097e = channel;
                        this.f26098f = bArr;
                        this.f26099g = i;
                        this.f26100h = b2;
                        this.f26101i = 3;
                        if (function3.invoke(flowCollector, objArr5, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objArr = objArr2;
                        b = b2;
                        i3 = 1;
                        i4 = 2;
                    }
                }
                b = b2;
                objArr = objArr2;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f26102j;
            int length = this.f26103k.length;
            if (length == 0) {
                return Unit.INSTANCE;
            }
            objArr = new Object[length];
            ArraysKt___ArraysJvmKt.fill$default(objArr, NullSurrogateKt.UNINITIALIZED, 0, 0, 6, (Object) null);
            Channel Channel$default = ChannelKt.Channel$default(length, null, null, 6, null);
            AtomicInteger atomicInteger = new AtomicInteger(length);
            b = 0;
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5;
                BuildersKt.launch$default(coroutineScope, null, null, new C1733qq(this.f26103k, i6, atomicInteger, Channel$default, null), 3, null);
                i5 = i6 + 1;
                atomicInteger = atomicInteger;
            }
            bArr = new byte[length];
            i = length;
            channel = Channel$default;
        }
        b2 = (byte) (b + 1);
        this.f26102j = objArr;
        this.f26097e = channel;
        this.f26098f = bArr;
        this.f26099g = i;
        this.f26100h = b2;
        this.f26101i = i3;
        obj2 = channel.mo8860receiveCatchingJP2dKIU(this);
        if (obj2 != coroutine_suspended) {
            return coroutine_suspended;
        }
        objArr2 = objArr;
        indexedValue = (IndexedValue) ChannelResult.m8872getOrNullimpl(obj2);
        if (indexedValue == null) {
        }
        do {
            index = indexedValue.getIndex();
            obj3 = objArr2[index];
            objArr2[index] = indexedValue.getValue();
            if (obj3 == NullSurrogateKt.UNINITIALIZED) {
            }
            if (bArr[index] != b2) {
            }
        } while (indexedValue != null);
        if (i == 0) {
        }
        b = b2;
        objArr = objArr2;
        b2 = (byte) (b + 1);
        this.f26102j = objArr;
        this.f26097e = channel;
        this.f26098f = bArr;
        this.f26099g = i;
        this.f26100h = b2;
        this.f26101i = i3;
        obj2 = channel.mo8860receiveCatchingJP2dKIU(this);
        if (obj2 != coroutine_suspended) {
        }
    }
}

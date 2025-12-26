package p000;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* loaded from: classes.dex */
public final class wq1 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 f28284c;

    /* renamed from: d */
    public MutableScatterMap f28285d;

    /* renamed from: e */
    public long[] f28286e;

    /* renamed from: f */
    public int f28287f;

    /* renamed from: g */
    public int f28288g;

    /* renamed from: h */
    public int f28289h;

    /* renamed from: i */
    public int f28290i;

    /* renamed from: j */
    public long f28291j;

    /* renamed from: k */
    public int f28292k;

    /* renamed from: l */
    public /* synthetic */ Object f28293l;

    /* renamed from: m */
    public final /* synthetic */ MutableScatterMap f28294m;

    /* renamed from: n */
    public final /* synthetic */ MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 f28295n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wq1(MutableScatterMap mutableScatterMap, MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 mutableScatterMap$MutableMapWrapper$entries$1$iterator$1, Continuation continuation) {
        super(2, continuation);
        this.f28294m = mutableScatterMap;
        this.f28295n = mutableScatterMap$MutableMapWrapper$entries$1$iterator$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        wq1 wq1Var = new wq1(this.f28294m, this.f28295n, continuation);
        wq1Var.f28293l = obj;
        return wq1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((wq1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x009d -> B:5:0x00a0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00a3 -> B:6:0x00a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0053 -> B:7:0x0066). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b2 -> B:18:0x00b3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        MutableScatterMap mutableScatterMap;
        long[] jArr;
        int length;
        MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 mutableScatterMap$MutableMapWrapper$entries$1$iterator$1;
        int i;
        long j;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f28292k;
        int i3 = 1;
        int i4 = 8;
        if (i2 != 0) {
            if (i2 == 1) {
                int i5 = this.f28290i;
                int i6 = this.f28289h;
                long j2 = this.f28291j;
                int i7 = this.f28288g;
                int i8 = this.f28287f;
                long[] jArr2 = this.f28286e;
                MutableScatterMap mutableScatterMap2 = this.f28285d;
                MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 mutableScatterMap$MutableMapWrapper$entries$1$iterator$12 = this.f28284c;
                SequenceScope sequenceScope2 = (SequenceScope) this.f28293l;
                ResultKt.throwOnFailure(obj);
                int i9 = 8;
                j2 >>= i9;
                i5 += i3;
                i4 = i9;
                if (i5 < i6) {
                    int i10 = i4;
                    if (i6 == i10) {
                        length = i8;
                        jArr = jArr2;
                        mutableScatterMap = mutableScatterMap2;
                        sequenceScope = sequenceScope2;
                        i = i7;
                        mutableScatterMap$MutableMapWrapper$entries$1$iterator$1 = mutableScatterMap$MutableMapWrapper$entries$1$iterator$12;
                        if (i != length) {
                            i++;
                            i4 = i10;
                            j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                sequenceScope2 = sequenceScope;
                                i5 = 0;
                                mutableScatterMap2 = mutableScatterMap;
                                jArr2 = jArr;
                                i6 = 8 - ((~(i - length)) >>> 31);
                                mutableScatterMap$MutableMapWrapper$entries$1$iterator$12 = mutableScatterMap$MutableMapWrapper$entries$1$iterator$1;
                                i7 = i;
                                i8 = length;
                                j2 = j;
                                if (i5 < i6) {
                                    if ((255 & j2) < 128) {
                                        mutableScatterMap$MutableMapWrapper$entries$1$iterator$12.setCurrent((i7 << 3) + i5);
                                        rq1 rq1Var = new rq1(mutableScatterMap2.keys, mutableScatterMap2.values, mutableScatterMap$MutableMapWrapper$entries$1$iterator$12.getCurrent());
                                        this.f28293l = sequenceScope2;
                                        this.f28284c = mutableScatterMap$MutableMapWrapper$entries$1$iterator$12;
                                        this.f28285d = mutableScatterMap2;
                                        this.f28286e = jArr2;
                                        this.f28287f = i8;
                                        this.f28288g = i7;
                                        this.f28291j = j2;
                                        this.f28289h = i6;
                                        this.f28290i = i5;
                                        i3 = 1;
                                        this.f28292k = 1;
                                        if (sequenceScope2.yield(rq1Var, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        int i92 = 8;
                                        j2 >>= i92;
                                        i5 += i3;
                                        i4 = i92;
                                        if (i5 < i6) {
                                        }
                                    } else {
                                        i92 = i4;
                                        j2 >>= i92;
                                        i5 += i3;
                                        i4 = i92;
                                        if (i5 < i6) {
                                        }
                                    }
                                }
                            } else {
                                i10 = i4;
                                if (i != length) {
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f28293l;
            mutableScatterMap = this.f28294m;
            jArr = mutableScatterMap.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                mutableScatterMap$MutableMapWrapper$entries$1$iterator$1 = this.f28295n;
                i = 0;
                j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                }
            }
            return Unit.INSTANCE;
        }
    }
}

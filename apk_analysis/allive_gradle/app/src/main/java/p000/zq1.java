package p000;

import androidx.collection.MutableScatterSet;
import androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* loaded from: classes.dex */
public final class zq1 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public MutableScatterSet$MutableSetWrapper$iterator$1 f29476c;

    /* renamed from: d */
    public MutableScatterSet f29477d;

    /* renamed from: e */
    public long[] f29478e;

    /* renamed from: f */
    public int f29479f;

    /* renamed from: g */
    public int f29480g;

    /* renamed from: h */
    public int f29481h;

    /* renamed from: i */
    public int f29482i;

    /* renamed from: j */
    public long f29483j;

    /* renamed from: k */
    public int f29484k;

    /* renamed from: l */
    public /* synthetic */ Object f29485l;

    /* renamed from: m */
    public final /* synthetic */ MutableScatterSet f29486m;

    /* renamed from: n */
    public final /* synthetic */ MutableScatterSet$MutableSetWrapper$iterator$1 f29487n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zq1(MutableScatterSet mutableScatterSet, MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1, Continuation continuation) {
        super(2, continuation);
        this.f29486m = mutableScatterSet;
        this.f29487n = mutableScatterSet$MutableSetWrapper$iterator$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zq1 zq1Var = new zq1(this.f29486m, this.f29487n, continuation);
        zq1Var.f29485l = obj;
        return zq1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((zq1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0093 -> B:5:0x0096). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0051 -> B:15:0x00a1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0053 -> B:6:0x0066). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x006f -> B:5:0x0096). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        MutableScatterSet mutableScatterSet;
        long[] jArr;
        int length;
        MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1;
        int i;
        long j;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f29484k;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = this.f29482i;
                int i4 = this.f29481h;
                long j2 = this.f29483j;
                int i5 = this.f29480g;
                int i6 = this.f29479f;
                long[] jArr2 = this.f29478e;
                MutableScatterSet mutableScatterSet2 = this.f29477d;
                MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$12 = this.f29476c;
                SequenceScope sequenceScope2 = (SequenceScope) this.f29485l;
                ResultKt.throwOnFailure(obj);
                j2 >>= 8;
                i3++;
                if (i3 < i4) {
                    if (i4 == 8) {
                        length = i6;
                        jArr = jArr2;
                        mutableScatterSet = mutableScatterSet2;
                        sequenceScope = sequenceScope2;
                        i = i5;
                        mutableScatterSet$MutableSetWrapper$iterator$1 = mutableScatterSet$MutableSetWrapper$iterator$12;
                        if (i != length) {
                            i++;
                            j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                sequenceScope2 = sequenceScope;
                                i3 = 0;
                                mutableScatterSet2 = mutableScatterSet;
                                jArr2 = jArr;
                                i4 = 8 - ((~(i - length)) >>> 31);
                                mutableScatterSet$MutableSetWrapper$iterator$12 = mutableScatterSet$MutableSetWrapper$iterator$1;
                                i5 = i;
                                i6 = length;
                                j2 = j;
                                if (i3 < i4) {
                                    if ((255 & j2) < 128) {
                                        int i7 = (i5 << 3) + i3;
                                        mutableScatterSet$MutableSetWrapper$iterator$12.setCurrent(i7);
                                        Object obj2 = mutableScatterSet2.elements[i7];
                                        this.f29485l = sequenceScope2;
                                        this.f29476c = mutableScatterSet$MutableSetWrapper$iterator$12;
                                        this.f29477d = mutableScatterSet2;
                                        this.f29478e = jArr2;
                                        this.f29479f = i6;
                                        this.f29480g = i5;
                                        this.f29483j = j2;
                                        this.f29481h = i4;
                                        this.f29482i = i3;
                                        this.f29484k = 1;
                                        if (sequenceScope2.yield(obj2, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    j2 >>= 8;
                                    i3++;
                                    if (i3 < i4) {
                                    }
                                }
                            }
                            if (i != length) {
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
            sequenceScope = (SequenceScope) this.f29485l;
            mutableScatterSet = this.f29486m;
            jArr = mutableScatterSet.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                mutableScatterSet$MutableSetWrapper$iterator$1 = this.f29487n;
                i = 0;
                j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                }
                if (i != length) {
                }
            }
            return Unit.INSTANCE;
        }
    }
}

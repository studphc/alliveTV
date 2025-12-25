package androidx.collection;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import p000.b51;

/* renamed from: androidx.collection.f */
/* loaded from: classes.dex */
public final class C0116f extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Object[] f1793c;

    /* renamed from: d */
    public long[] f1794d;

    /* renamed from: e */
    public int f1795e;

    /* renamed from: f */
    public int f1796f;

    /* renamed from: g */
    public int f1797g;

    /* renamed from: h */
    public int f1798h;

    /* renamed from: i */
    public long f1799i;

    /* renamed from: j */
    public int f1800j;

    /* renamed from: k */
    public /* synthetic */ Object f1801k;

    /* renamed from: l */
    public final /* synthetic */ ScatterSet f1802l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0116f(ScatterSet scatterSet, Continuation continuation) {
        super(2, continuation);
        this.f1802l = scatterSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0116f c0116f = new C0116f(this.f1802l, continuation);
        c0116f.f1801k = obj;
        return c0116f;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0116f) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0064  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0088 -> B:5:0x008b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004f -> B:15:0x0094). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0051 -> B:6:0x0062). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x006b -> B:5:0x008b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object[] objArr;
        long[] jArr;
        int length;
        int i;
        long j;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f1800j;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = this.f1798h;
                int i4 = this.f1797g;
                long j2 = this.f1799i;
                i = this.f1796f;
                int i5 = this.f1795e;
                long[] jArr2 = this.f1794d;
                Object[] objArr2 = this.f1793c;
                SequenceScope sequenceScope2 = (SequenceScope) this.f1801k;
                ResultKt.throwOnFailure(obj);
                j2 >>= 8;
                i3++;
                if (i3 < i4) {
                    if (i4 == 8) {
                        length = i5;
                        jArr = jArr2;
                        objArr = objArr2;
                        sequenceScope = sequenceScope2;
                        if (i != length) {
                            i++;
                            j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                sequenceScope2 = sequenceScope;
                                i3 = 0;
                                jArr2 = jArr;
                                i5 = length;
                                i4 = 8 - ((~(i - length)) >>> 31);
                                objArr2 = objArr;
                                j2 = j;
                                if (i3 < i4) {
                                    if ((255 & j2) < 128) {
                                        Object obj2 = objArr2[(i << 3) + i3];
                                        this.f1801k = sequenceScope2;
                                        this.f1793c = objArr2;
                                        this.f1794d = jArr2;
                                        this.f1795e = i5;
                                        this.f1796f = i;
                                        this.f1799i = j2;
                                        this.f1797g = i4;
                                        this.f1798h = i3;
                                        this.f1800j = 1;
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
            sequenceScope = (SequenceScope) this.f1801k;
            ScatterSet scatterSet = this.f1802l;
            objArr = scatterSet.elements;
            jArr = scatterSet.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
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

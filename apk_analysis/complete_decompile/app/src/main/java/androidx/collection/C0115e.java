package androidx.collection;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import p000.b51;

/* renamed from: androidx.collection.e */
/* loaded from: classes.dex */
public final class C0115e extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Object[] f1783c;

    /* renamed from: d */
    public long[] f1784d;

    /* renamed from: e */
    public int f1785e;

    /* renamed from: f */
    public int f1786f;

    /* renamed from: g */
    public int f1787g;

    /* renamed from: h */
    public int f1788h;

    /* renamed from: i */
    public long f1789i;

    /* renamed from: j */
    public int f1790j;

    /* renamed from: k */
    public /* synthetic */ Object f1791k;

    /* renamed from: l */
    public final /* synthetic */ ScatterMap f1792l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0115e(ScatterMap scatterMap, Continuation continuation) {
        super(2, continuation);
        this.f1792l = scatterMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0115e c0115e = new C0115e(this.f1792l, continuation);
        c0115e.f1791k = obj;
        return c0115e;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0115e) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
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
        int i2 = this.f1790j;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = this.f1788h;
                int i4 = this.f1787g;
                long j2 = this.f1789i;
                i = this.f1786f;
                int i5 = this.f1785e;
                long[] jArr2 = this.f1784d;
                Object[] objArr2 = this.f1783c;
                SequenceScope sequenceScope2 = (SequenceScope) this.f1791k;
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
                                        this.f1791k = sequenceScope2;
                                        this.f1783c = objArr2;
                                        this.f1784d = jArr2;
                                        this.f1785e = i5;
                                        this.f1786f = i;
                                        this.f1789i = j2;
                                        this.f1787g = i4;
                                        this.f1788h = i3;
                                        this.f1790j = 1;
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
            sequenceScope = (SequenceScope) this.f1791k;
            ScatterMap scatterMap = this.f1792l;
            objArr = scatterMap.values;
            jArr = scatterMap.metadata;
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

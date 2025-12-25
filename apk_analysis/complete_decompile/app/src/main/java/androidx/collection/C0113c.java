package androidx.collection;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import p000.b51;
import p000.te1;

/* renamed from: androidx.collection.c */
/* loaded from: classes.dex */
public final class C0113c extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public ScatterMap f1763c;

    /* renamed from: d */
    public long[] f1764d;

    /* renamed from: e */
    public int f1765e;

    /* renamed from: f */
    public int f1766f;

    /* renamed from: g */
    public int f1767g;

    /* renamed from: h */
    public int f1768h;

    /* renamed from: i */
    public long f1769i;

    /* renamed from: j */
    public int f1770j;

    /* renamed from: k */
    public /* synthetic */ Object f1771k;

    /* renamed from: l */
    public final /* synthetic */ ScatterMap f1772l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0113c(ScatterMap scatterMap, Continuation continuation) {
        super(2, continuation);
        this.f1772l = scatterMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C0113c c0113c = new C0113c(this.f1772l, continuation);
        c0113c.f1771k = obj;
        return c0113c;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C0113c) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0065  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0094 -> B:5:0x0097). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x009a -> B:6:0x009b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x004f -> B:7:0x0063). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a7 -> B:18:0x00a8). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        ScatterMap scatterMap;
        long[] jArr;
        int length;
        int i;
        long j;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f1770j;
        int i3 = 8;
        if (i2 != 0) {
            if (i2 == 1) {
                int i4 = this.f1768h;
                int i5 = this.f1767g;
                long j2 = this.f1769i;
                i = this.f1766f;
                int i6 = this.f1765e;
                long[] jArr2 = this.f1764d;
                ScatterMap scatterMap2 = this.f1763c;
                SequenceScope sequenceScope2 = (SequenceScope) this.f1771k;
                ResultKt.throwOnFailure(obj);
                int i7 = 8;
                j2 >>= i7;
                i4++;
                i3 = i7;
                if (i4 < i5) {
                    int i8 = i3;
                    if (i5 == i8) {
                        length = i6;
                        jArr = jArr2;
                        scatterMap = scatterMap2;
                        sequenceScope = sequenceScope2;
                        if (i != length) {
                            i++;
                            i3 = i8;
                            j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                sequenceScope2 = sequenceScope;
                                i4 = 0;
                                scatterMap2 = scatterMap;
                                i5 = 8 - ((~(i - length)) >>> 31);
                                jArr2 = jArr;
                                i6 = length;
                                j2 = j;
                                if (i4 < i5) {
                                    if ((255 & j2) < 128) {
                                        int i9 = (i << 3) + i4;
                                        te1 te1Var = new te1(scatterMap2.keys[i9], scatterMap2.values[i9]);
                                        this.f1771k = sequenceScope2;
                                        this.f1763c = scatterMap2;
                                        this.f1764d = jArr2;
                                        this.f1765e = i6;
                                        this.f1766f = i;
                                        this.f1769i = j2;
                                        this.f1767g = i5;
                                        this.f1768h = i4;
                                        this.f1770j = 1;
                                        if (sequenceScope2.yield(te1Var, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        int i72 = 8;
                                        j2 >>= i72;
                                        i4++;
                                        i3 = i72;
                                        if (i4 < i5) {
                                        }
                                    } else {
                                        i72 = i3;
                                        j2 >>= i72;
                                        i4++;
                                        i3 = i72;
                                        if (i4 < i5) {
                                        }
                                    }
                                }
                            } else {
                                i8 = i3;
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
            sequenceScope = (SequenceScope) this.f1771k;
            scatterMap = this.f1772l;
            jArr = scatterMap.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                i = 0;
                j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                }
            }
            return Unit.INSTANCE;
        }
    }
}

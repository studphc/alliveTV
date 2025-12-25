package p000;

import androidx.collection.MutableScatterMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* loaded from: classes.dex */
public final class xq1 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public long[] f28696c;

    /* renamed from: d */
    public int f28697d;

    /* renamed from: e */
    public int f28698e;

    /* renamed from: f */
    public int f28699f;

    /* renamed from: g */
    public int f28700g;

    /* renamed from: h */
    public long f28701h;

    /* renamed from: i */
    public int f28702i;

    /* renamed from: j */
    public /* synthetic */ Object f28703j;

    /* renamed from: k */
    public final /* synthetic */ MutableScatterMap f28704k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xq1(MutableScatterMap mutableScatterMap, Continuation continuation) {
        super(2, continuation);
        this.f28704k = mutableScatterMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        xq1 xq1Var = new xq1(this.f28704k, continuation);
        xq1Var.f28703j = obj;
        return xq1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((xq1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0087 -> B:5:0x008a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004b -> B:15:0x0093). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:6:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x006a -> B:5:0x008a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        long[] jArr;
        int length;
        int i;
        long j;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i2 = this.f28702i;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = this.f28700g;
                int i4 = this.f28699f;
                long j2 = this.f28701h;
                int i5 = this.f28698e;
                int i6 = this.f28697d;
                long[] jArr2 = this.f28696c;
                SequenceScope sequenceScope2 = (SequenceScope) this.f28703j;
                ResultKt.throwOnFailure(obj);
                j2 >>= 8;
                i3++;
                if (i3 < i4) {
                    if (i4 == 8) {
                        i = i5;
                        length = i6;
                        jArr = jArr2;
                        sequenceScope = sequenceScope2;
                        if (i != length) {
                            i++;
                            j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                sequenceScope2 = sequenceScope;
                                i3 = 0;
                                jArr2 = jArr;
                                i4 = 8 - ((~(i - length)) >>> 31);
                                i6 = length;
                                i5 = i;
                                j2 = j;
                                if (i3 < i4) {
                                    if ((255 & j2) < 128) {
                                        Integer boxInt = Boxing.boxInt((i5 << 3) + i3);
                                        this.f28703j = sequenceScope2;
                                        this.f28696c = jArr2;
                                        this.f28697d = i6;
                                        this.f28698e = i5;
                                        this.f28701h = j2;
                                        this.f28699f = i4;
                                        this.f28700g = i3;
                                        this.f28702i = 1;
                                        if (sequenceScope2.yield(boxInt, this) == coroutine_suspended) {
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
            sequenceScope = (SequenceScope) this.f28703j;
            jArr = this.f28704k.metadata;
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

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
public final class yq1 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public long[] f29065c;

    /* renamed from: d */
    public int f29066d;

    /* renamed from: e */
    public int f29067e;

    /* renamed from: f */
    public int f29068f;

    /* renamed from: g */
    public int f29069g;

    /* renamed from: h */
    public long f29070h;

    /* renamed from: i */
    public int f29071i;

    /* renamed from: j */
    public /* synthetic */ Object f29072j;

    /* renamed from: k */
    public final /* synthetic */ MutableScatterMap f29073k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yq1(MutableScatterMap mutableScatterMap, Continuation continuation) {
        super(2, continuation);
        this.f29073k = mutableScatterMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        yq1 yq1Var = new yq1(this.f29073k, continuation);
        yq1Var.f29072j = obj;
        return yq1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((yq1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
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
        int i2 = this.f29071i;
        if (i2 != 0) {
            if (i2 == 1) {
                int i3 = this.f29069g;
                int i4 = this.f29068f;
                long j2 = this.f29070h;
                int i5 = this.f29067e;
                int i6 = this.f29066d;
                long[] jArr2 = this.f29065c;
                SequenceScope sequenceScope2 = (SequenceScope) this.f29072j;
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
                                        this.f29072j = sequenceScope2;
                                        this.f29065c = jArr2;
                                        this.f29066d = i6;
                                        this.f29067e = i5;
                                        this.f29070h = j2;
                                        this.f29068f = i4;
                                        this.f29069g = i3;
                                        this.f29071i = 1;
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
            sequenceScope = (SequenceScope) this.f29072j;
            jArr = this.f29073k.metadata;
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

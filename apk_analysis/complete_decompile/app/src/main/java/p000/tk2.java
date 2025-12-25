package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class tk2 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public Object f26853c;

    /* renamed from: d */
    public Iterator f26854d;

    /* renamed from: e */
    public int f26855e;

    /* renamed from: f */
    public int f26856f;

    /* renamed from: g */
    public /* synthetic */ Object f26857g;

    /* renamed from: h */
    public final /* synthetic */ int f26858h;

    /* renamed from: i */
    public final /* synthetic */ int f26859i;

    /* renamed from: j */
    public final /* synthetic */ Iterator f26860j;

    /* renamed from: k */
    public final /* synthetic */ boolean f26861k;

    /* renamed from: l */
    public final /* synthetic */ boolean f26862l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tk2(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f26858h = i;
        this.f26859i = i2;
        this.f26860j = it;
        this.f26861k = z;
        this.f26862l = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        tk2 tk2Var = new tk2(this.f26858h, this.f26859i, this.f26860j, this.f26861k, this.f26862l, continuation);
        tk2Var.f26857g = obj;
        return tk2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((tk2) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ac  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0177 -> B:12:0x017a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0149 -> B:29:0x014c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x00a4 -> B:55:0x00a5). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        rc2 rc2Var;
        SequenceScope sequenceScope;
        Iterator it;
        SequenceScope sequenceScope2;
        ArrayList arrayList;
        int i;
        int i2;
        Iterator it2;
        rc2 rc2Var2;
        SequenceScope sequenceScope3;
        RandomAccess arrayList2;
        Object[] array;
        RandomAccess arrayList3;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i3 = this.f26856f;
        boolean z = this.f26862l;
        boolean z2 = this.f26861k;
        int i4 = this.f26859i;
        int i5 = this.f26858h;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            rc2Var2 = (rc2) this.f26853c;
                            sequenceScope3 = (SequenceScope) this.f26857g;
                            ResultKt.throwOnFailure(obj);
                            rc2Var2.m7267a(i4);
                            if (rc2Var2.size() <= i4) {
                                if (z2) {
                                    arrayList3 = rc2Var2;
                                } else {
                                    arrayList3 = new ArrayList(rc2Var2);
                                }
                                this.f26857g = sequenceScope3;
                                this.f26853c = rc2Var2;
                                this.f26854d = null;
                                this.f26856f = 4;
                                if (sequenceScope3.yield(arrayList3, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                rc2Var2.m7267a(i4);
                                if (rc2Var2.size() <= i4) {
                                    if (!rc2Var2.isEmpty()) {
                                        this.f26857g = null;
                                        this.f26853c = null;
                                        this.f26854d = null;
                                        this.f26856f = 5;
                                        if (sequenceScope3.yield(rc2Var2, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    } else {
                        it = this.f26854d;
                        rc2Var = (rc2) this.f26853c;
                        sequenceScope = (SequenceScope) this.f26857g;
                        ResultKt.throwOnFailure(obj);
                        rc2Var.m7267a(i4);
                        while (it.hasNext()) {
                            Object next = it.next();
                            int size = rc2Var.size();
                            int i6 = rc2Var.f25929b;
                            if (size != i6) {
                                int size2 = (rc2Var.size() + rc2Var.f25930c) % i6;
                                Object[] objArr = rc2Var.f25928a;
                                objArr[size2] = next;
                                rc2Var.f25931d = rc2Var.size() + 1;
                                if (rc2Var.size() == i6) {
                                    if (rc2Var.size() < i5) {
                                        int coerceAtMost = r82.coerceAtMost(i6 + (i6 >> 1) + 1, i5);
                                        if (rc2Var.f25930c == 0) {
                                            array = Arrays.copyOf(objArr, coerceAtMost);
                                            Intrinsics.checkNotNullExpressionValue(array, "copyOf(this, newSize)");
                                        } else {
                                            array = rc2Var.toArray(new Object[coerceAtMost]);
                                        }
                                        rc2Var = new rc2(rc2Var.size(), array);
                                    } else {
                                        if (z2) {
                                            arrayList2 = rc2Var;
                                        } else {
                                            arrayList2 = new ArrayList(rc2Var);
                                        }
                                        this.f26857g = sequenceScope;
                                        this.f26853c = rc2Var;
                                        this.f26854d = it;
                                        this.f26856f = 3;
                                        if (sequenceScope.yield(arrayList2, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        rc2Var.m7267a(i4);
                                        while (it.hasNext()) {
                                        }
                                    }
                                }
                            } else {
                                throw new IllegalStateException("ring buffer is full");
                            }
                        }
                        if (z) {
                            rc2Var2 = rc2Var;
                            sequenceScope3 = sequenceScope;
                            if (rc2Var2.size() <= i4) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            i = this.f26855e;
            it2 = this.f26854d;
            ArrayList arrayList4 = (ArrayList) this.f26853c;
            SequenceScope sequenceScope4 = (SequenceScope) this.f26857g;
            ResultKt.throwOnFailure(obj);
            sequenceScope2 = sequenceScope4;
            if (!z2) {
                arrayList4.clear();
            } else {
                arrayList4 = new ArrayList(i5);
            }
            arrayList = arrayList4;
            i2 = i;
            while (it2.hasNext()) {
                Object next2 = it2.next();
                if (i2 > 0) {
                    i2--;
                } else {
                    arrayList.add(next2);
                    if (arrayList.size() == i5) {
                        this.f26857g = sequenceScope2;
                        this.f26853c = arrayList;
                        this.f26854d = it2;
                        this.f26855e = i;
                        this.f26856f = 1;
                        if (sequenceScope2.yield(arrayList, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        arrayList4 = arrayList;
                        if (!z2) {
                        }
                        arrayList = arrayList4;
                        i2 = i;
                        while (it2.hasNext()) {
                        }
                    }
                }
            }
            if (!arrayList.isEmpty() && (z || arrayList.size() == i5)) {
                this.f26857g = null;
                this.f26853c = null;
                this.f26854d = null;
                this.f26856f = 2;
                if (sequenceScope2.yield(arrayList, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        SequenceScope sequenceScope5 = (SequenceScope) this.f26857g;
        int coerceAtMost2 = r82.coerceAtMost(i5, 1024);
        int i7 = i4 - i5;
        Iterator it3 = this.f26860j;
        if (i7 >= 0) {
            sequenceScope2 = sequenceScope5;
            arrayList = new ArrayList(coerceAtMost2);
            i = i7;
            i2 = 0;
            it2 = it3;
            while (it2.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
                this.f26857g = null;
                this.f26853c = null;
                this.f26854d = null;
                this.f26856f = 2;
                if (sequenceScope2.yield(arrayList, this) == coroutine_suspended) {
                }
            }
            return Unit.INSTANCE;
        }
        rc2Var = new rc2(0, new Object[coerceAtMost2]);
        sequenceScope = sequenceScope5;
        it = it3;
        while (it.hasNext()) {
        }
        if (z) {
        }
        return Unit.INSTANCE;
    }
}

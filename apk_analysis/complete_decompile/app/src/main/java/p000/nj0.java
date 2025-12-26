package p000;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeZipArray;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeZipIterable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.rxjava3.internal.operators.single.SingleZipArray;
import io.reactivex.rxjava3.internal.operators.single.SingleZipIterable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class nj0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f23379a;

    /* renamed from: b */
    public final Object f23380b;

    public /* synthetic */ nj0(int i, Object obj) {
        this.f23379a = i;
        this.f23380b = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Object apply(Object obj) {
        Object obj2 = this.f23380b;
        switch (this.f23379a) {
            case 0:
                return ((FlowableCombineLatest) obj2).f18775d.apply(new Object[]{obj});
            case 1:
                Object apply = ((FlowableWithLatestFromMany) obj2).f19091d.apply(new Object[]{obj});
                Objects.requireNonNull(apply, "The combiner returned a null value");
                return apply;
            case 2:
                Object[] objArr = (Object[]) obj;
                if (objArr.length == 2) {
                    return ((BiFunction) obj2).apply(objArr[0], objArr[1]);
                }
                throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
            case 3:
                Object[] objArr2 = (Object[]) obj;
                if (objArr2.length == 3) {
                    return ((Function3) obj2).apply(objArr2[0], objArr2[1], objArr2[2]);
                }
                throw new IllegalArgumentException("Array of size 3 expected but got " + objArr2.length);
            case 4:
                Object[] objArr3 = (Object[]) obj;
                if (objArr3.length == 4) {
                    return ((Function4) obj2).apply(objArr3[0], objArr3[1], objArr3[2], objArr3[3]);
                }
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr3.length);
            case 5:
                Object[] objArr4 = (Object[]) obj;
                if (objArr4.length == 5) {
                    return ((Function5) obj2).apply(objArr4[0], objArr4[1], objArr4[2], objArr4[3], objArr4[4]);
                }
                throw new IllegalArgumentException("Array of size 5 expected but got " + objArr4.length);
            case 6:
                Object[] objArr5 = (Object[]) obj;
                if (objArr5.length == 6) {
                    return ((Function6) obj2).apply(objArr5[0], objArr5[1], objArr5[2], objArr5[3], objArr5[4], objArr5[5]);
                }
                throw new IllegalArgumentException("Array of size 6 expected but got " + objArr5.length);
            case 7:
                Object[] objArr6 = (Object[]) obj;
                if (objArr6.length == 7) {
                    return ((Function7) obj2).apply(objArr6[0], objArr6[1], objArr6[2], objArr6[3], objArr6[4], objArr6[5], objArr6[6]);
                }
                throw new IllegalArgumentException("Array of size 7 expected but got " + objArr6.length);
            case 8:
                Object[] objArr7 = (Object[]) obj;
                if (objArr7.length == 8) {
                    return ((Function8) obj2).apply(objArr7[0], objArr7[1], objArr7[2], objArr7[3], objArr7[4], objArr7[5], objArr7[6], objArr7[7]);
                }
                throw new IllegalArgumentException("Array of size 8 expected but got " + objArr7.length);
            case 9:
                Object[] objArr8 = (Object[]) obj;
                if (objArr8.length == 9) {
                    return ((Function9) obj2).apply(objArr8[0], objArr8[1], objArr8[2], objArr8[3], objArr8[4], objArr8[5], objArr8[6], objArr8[7], objArr8[8]);
                }
                throw new IllegalArgumentException("Array of size 9 expected but got " + objArr8.length);
            case 10:
                return ((Class) obj2).cast(obj);
            case 11:
                List list = (List) obj;
                Collections.sort(list, (Comparator) obj2);
                return list;
            case 12:
                Object apply2 = ((MaybeZipArray) obj2).f19227b.apply(new Object[]{obj});
                Objects.requireNonNull(apply2, "The zipper returned a null value");
                return apply2;
            case 13:
                Object apply3 = ((MaybeZipIterable) obj2).f19229b.apply(new Object[]{obj});
                Objects.requireNonNull(apply3, "The zipper returned a null value");
                return apply3;
            case 14:
                Object apply4 = ((ObservableWithLatestFromMany) obj2).f19630c.apply(new Object[]{obj});
                Objects.requireNonNull(apply4, "The combiner returned a null value");
                return apply4;
            case 15:
                Object apply5 = ((SingleZipArray) obj2).f19824b.apply(new Object[]{obj});
                Objects.requireNonNull(apply5, "The zipper returned a null value");
                return apply5;
            default:
                Object apply6 = ((SingleZipIterable) obj2).f19826b.apply(new Object[]{obj});
                Objects.requireNonNull(apply6, "The zipper returned a null value");
                return apply6;
        }
    }
}

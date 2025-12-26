package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class u51 extends UnmodifiableIterator {

    /* renamed from: a */
    public final /* synthetic */ int f27114a;

    /* renamed from: b */
    public int f27115b;

    /* renamed from: c */
    public final Serializable f27116c;

    /* JADX WARN: Multi-variable type inference failed */
    public u51(Iterator[] itArr) {
        this.f27114a = 0;
        this.f27116c = itArr;
        this.f27115b = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f27114a) {
            case 0:
                if (this.f27115b < ((Iterator[]) this.f27116c).length) {
                    return true;
                }
                return false;
            default:
                if (this.f27115b != 0) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f27114a) {
            case 0:
                if (hasNext()) {
                    int i = this.f27115b;
                    Iterator[] itArr = (Iterator[]) this.f27116c;
                    Iterator it = itArr[i];
                    Objects.requireNonNull(it);
                    int i2 = this.f27115b;
                    itArr[i2] = null;
                    this.f27115b = i2 + 1;
                    return it;
                }
                throw new NoSuchElementException();
            default:
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(this.f27115b);
                if (numberOfTrailingZeros != 32) {
                    this.f27115b &= ~(1 << numberOfTrailingZeros);
                    return ((ImmutableList) this.f27116c).get(numberOfTrailingZeros);
                }
                throw new NoSuchElementException();
        }
    }

    public u51(ih2 ih2Var) {
        this.f27114a = 1;
        this.f27116c = ih2Var.f18415b.keySet().asList();
        this.f27115b = ih2Var.f18416c;
    }
}

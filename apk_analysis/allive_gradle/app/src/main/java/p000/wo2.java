package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;

/* loaded from: classes2.dex */
public final class wo2 extends ap2 {

    /* renamed from: b */
    public final Object[] f28262b;

    public wo2(int i, Supplier supplier) {
        super(i);
        boolean z;
        int i2 = 0;
        if (i <= 1073741824) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Stripes must be <= 2^30)");
        this.f28262b = new Object[this.f7698a + 1];
        while (true) {
            Object[] objArr = this.f28262b;
            if (i2 < objArr.length) {
                objArr[i2] = supplier.get();
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.common.util.concurrent.Striped
    public final Object getAt(int i) {
        return this.f28262b[i];
    }

    @Override // com.google.common.util.concurrent.Striped
    public final int size() {
        return this.f28262b.length;
    }
}

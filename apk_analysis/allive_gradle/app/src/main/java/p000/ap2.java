package p000;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.Striped;
import java.math.RoundingMode;

/* loaded from: classes2.dex */
public abstract class ap2 extends Striped {

    /* renamed from: a */
    public final int f7698a;

    public ap2(int i) {
        boolean z;
        int log2;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Stripes must be positive");
        if (i > 1073741824) {
            log2 = -1;
        } else {
            log2 = (1 << IntMath.log2(i, RoundingMode.CEILING)) - 1;
        }
        this.f7698a = log2;
    }

    @Override // com.google.common.util.concurrent.Striped
    /* renamed from: a */
    public final int mo1957a(Object obj) {
        int hashCode = obj.hashCode();
        int i = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        return ((i >>> 4) ^ ((i >>> 7) ^ i)) & this.f7698a;
    }

    @Override // com.google.common.util.concurrent.Striped
    public final Object get(Object obj) {
        return getAt(mo1957a(obj));
    }
}

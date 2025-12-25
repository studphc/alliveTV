package p000;

import com.google.android.gms.internal.common.zzaf;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class m93 extends zzaf {

    /* renamed from: a */
    public Object[] f22857a;

    /* renamed from: b */
    public int f22858b;

    /* renamed from: c */
    public boolean f22859c;

    public final m93 zza(Object obj) {
        int i;
        obj.getClass();
        int length = this.f22857a.length;
        int i2 = this.f22858b;
        int i3 = i2 + 1;
        if (i3 >= 0) {
            if (i3 <= length) {
                i = length;
            } else {
                i = (length >> 1) + length + 1;
                if (i < i3) {
                    int highestOneBit = Integer.highestOneBit(i2);
                    i = highestOneBit + highestOneBit;
                }
                if (i < 0) {
                    i = Integer.MAX_VALUE;
                }
            }
            if (i > length || this.f22859c) {
                this.f22857a = Arrays.copyOf(this.f22857a, i);
                this.f22859c = false;
            }
            Object[] objArr = this.f22857a;
            int i4 = this.f22858b;
            this.f22858b = i4 + 1;
            objArr[i4] = obj;
            return this;
        }
        throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
    }
}

package p000;

import android.util.SparseArray;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j80 {

    /* renamed from: a */
    public int f20414a = 1;

    /* renamed from: b */
    public final ao1 f20415b;

    /* renamed from: c */
    public ao1 f20416c;

    /* renamed from: d */
    public ao1 f20417d;

    /* renamed from: e */
    public int f20418e;

    /* renamed from: f */
    public int f20419f;

    /* renamed from: g */
    public final boolean f20420g;

    /* renamed from: h */
    public final int[] f20421h;

    public j80(ao1 ao1Var, boolean z, int[] iArr) {
        this.f20415b = ao1Var;
        this.f20416c = ao1Var;
        this.f20420g = z;
        this.f20421h = iArr;
    }

    /* renamed from: a */
    public final int m5416a(int i) {
        ao1 ao1Var;
        SparseArray sparseArray = this.f20416c.f7686a;
        if (sparseArray == null) {
            ao1Var = null;
        } else {
            ao1Var = (ao1) sparseArray.get(i);
        }
        int i2 = 1;
        int i3 = 2;
        if (this.f20414a != 2) {
            if (ao1Var == null) {
                m5417b();
            } else {
                this.f20414a = 2;
                this.f20416c = ao1Var;
                this.f20419f = 1;
                i2 = i3;
            }
        } else {
            if (ao1Var != null) {
                this.f20416c = ao1Var;
                this.f20419f++;
            } else if (i == 65038) {
                m5417b();
            } else if (i != 65039) {
                ao1 ao1Var2 = this.f20416c;
                if (ao1Var2.f7687b != null) {
                    i3 = 3;
                    if (this.f20419f == 1) {
                        if (m5418c()) {
                            this.f20417d = this.f20416c;
                            m5417b();
                        } else {
                            m5417b();
                        }
                    } else {
                        this.f20417d = ao1Var2;
                        m5417b();
                    }
                } else {
                    m5417b();
                }
            }
            i2 = i3;
        }
        this.f20418e = i;
        return i2;
    }

    /* renamed from: b */
    public final void m5417b() {
        this.f20414a = 1;
        this.f20416c = this.f20415b;
        this.f20419f = 0;
    }

    /* renamed from: c */
    public final boolean m5418c() {
        int[] iArr;
        if (this.f20416c.f7687b.isDefaultEmoji() || this.f20418e == 65039) {
            return true;
        }
        if (this.f20420g && ((iArr = this.f20421h) == null || Arrays.binarySearch(iArr, this.f20416c.f7687b.getCodepointAt(0)) < 0)) {
            return true;
        }
        return false;
    }
}

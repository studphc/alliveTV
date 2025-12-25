package p000;

/* loaded from: classes.dex */
public final class m53 {

    /* renamed from: c */
    public int f22808c;

    /* renamed from: d */
    public int f22809d;

    /* renamed from: i */
    public int f22814i;

    /* renamed from: j */
    public int f22815j;

    /* renamed from: k */
    public int f22816k;

    /* renamed from: l */
    public boolean f22817l;

    /* renamed from: e */
    public int f22810e = 2;

    /* renamed from: f */
    public int f22811f = 3;

    /* renamed from: g */
    public int f22812g = 0;

    /* renamed from: h */
    public float f22813h = 50.0f;

    /* renamed from: b */
    public int f22807b = Integer.MIN_VALUE;

    /* renamed from: a */
    public int f22806a = Integer.MAX_VALUE;

    /* renamed from: a */
    public final int m6079a() {
        int i;
        if (!this.f22817l) {
            int i2 = this.f22812g;
            if (i2 < 0) {
                i2 += this.f22814i;
            }
            float f = this.f22813h;
            if (f != -1.0f) {
                return i2 + ((int) ((this.f22814i * f) / 100.0f));
            }
            return i2;
        }
        int i3 = this.f22812g;
        if (i3 >= 0) {
            i = this.f22814i - i3;
        } else {
            i = -i3;
        }
        float f2 = this.f22813h;
        if (f2 != -1.0f) {
            return i - ((int) ((this.f22814i * f2) / 100.0f));
        }
        return i;
    }

    /* renamed from: b */
    public final int m6080b(int i) {
        boolean z;
        int i2;
        int i3;
        int i4 = this.f22814i;
        int m6079a = m6079a();
        int i5 = this.f22807b;
        boolean z2 = false;
        if (i5 == Integer.MIN_VALUE) {
            z = true;
        } else {
            z = false;
        }
        int i6 = this.f22806a;
        if (i6 == Integer.MAX_VALUE) {
            z2 = true;
        }
        if (!z) {
            int i7 = this.f22815j;
            int i8 = m6079a - i7;
            if (this.f22817l ? (this.f22811f & 2) != 0 : (this.f22811f & 1) != 0) {
                if (i - i5 <= i8) {
                    int i9 = i5 - i7;
                    if (!z2 && i9 > (i3 = this.f22808c)) {
                        return i3;
                    }
                    return i9;
                }
            }
        }
        if (!z2) {
            int i10 = this.f22816k;
            int i11 = (i4 - m6079a) - i10;
            if (this.f22817l ? (1 & this.f22811f) != 0 : (this.f22811f & 2) != 0) {
                if (i6 - i <= i11) {
                    int i12 = i6 - (i4 - i10);
                    if (!z && i12 < (i2 = this.f22809d)) {
                        return i2;
                    }
                    return i12;
                }
            }
        }
        return i - m6079a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        r6.f22809d = r0 - r6.f22815j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        r6.f22808c = (r4 - r6.f22815j) - r7;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m6081c(int i, int i2, int i3, int i4) {
        boolean z;
        this.f22807b = i;
        this.f22806a = i2;
        int i5 = (this.f22814i - this.f22815j) - this.f22816k;
        int m6079a = m6079a();
        int i6 = this.f22807b;
        boolean z2 = false;
        if (i6 == Integer.MIN_VALUE) {
            z = true;
        } else {
            z = false;
        }
        int i7 = this.f22806a;
        if (i7 == Integer.MAX_VALUE) {
            z2 = true;
        }
        if (!z) {
            if (!this.f22817l) {
                this.f22809d = i3 - m6079a;
            } else {
                this.f22809d = i3 - m6079a;
            }
        }
        if (!z2) {
            if (!this.f22817l) {
                this.f22808c = i4 - m6079a;
            } else {
                this.f22808c = i4 - m6079a;
            }
        }
        if (!z2 && !z) {
            if (!this.f22817l) {
                int i8 = this.f22811f;
                if ((i8 & 1) != 0) {
                    if ((this.f22810e & 1) != 0) {
                        this.f22809d = Math.min(this.f22809d, i4 - m6079a);
                    }
                    this.f22808c = Math.max(this.f22809d, this.f22808c);
                    return;
                } else {
                    if ((i8 & 2) != 0) {
                        if ((this.f22810e & 2) != 0) {
                            this.f22808c = Math.max(this.f22808c, i3 - m6079a);
                        }
                        this.f22809d = Math.min(this.f22809d, this.f22808c);
                        return;
                    }
                    return;
                }
            }
            int i9 = this.f22811f;
            if ((i9 & 1) != 0) {
                if ((this.f22810e & 1) != 0) {
                    this.f22808c = Math.max(this.f22808c, i3 - m6079a);
                }
                this.f22809d = Math.min(this.f22809d, this.f22808c);
            } else if ((i9 & 2) != 0) {
                if ((this.f22810e & 2) != 0) {
                    this.f22809d = Math.min(this.f22809d, i4 - m6079a);
                }
                this.f22808c = Math.max(this.f22809d, this.f22808c);
            }
        }
    }

    public final String toString() {
        return " min:" + this.f22807b + " " + this.f22809d + " max:" + this.f22806a + " " + this.f22808c;
    }
}

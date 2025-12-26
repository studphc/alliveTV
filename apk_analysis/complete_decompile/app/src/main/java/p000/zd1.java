package p000;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class zd1 extends kp2 implements Serializable, sd1 {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f22148c = 0;
        this.f22146a = null;
        this.f22147b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(mo7361b());
    }

    @Override // p000.sd1
    /* renamed from: a */
    public final void mo7360a() {
        mo7362c(1L);
    }

    @Override // p000.sd1
    /* renamed from: b */
    public final long mo7361b() {
        long j = this.f22147b;
        ip2[] ip2VarArr = this.f22146a;
        if (ip2VarArr != null) {
            for (ip2 ip2Var : ip2VarArr) {
                if (ip2Var != null) {
                    j += ip2Var.f20186a;
                }
            }
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x00b3, code lost:
    
        if (r13.f22146a != r6) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00b5, code lost:
    
        r5 = new p000.ip2[r7 << 1];
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00ba, code lost:
    
        if (r8 >= r7) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00bc, code lost:
    
        r5[r8] = r6[r8];
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00c5, code lost:
    
        r13.f22146a = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0049 A[SYNTHETIC] */
    @Override // p000.sd1
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo7362c(long j) {
        boolean z;
        int i;
        boolean z2;
        int length;
        boolean z3;
        int length2;
        int length3;
        ip2 ip2Var;
        ip2[] ip2VarArr = this.f22146a;
        if (ip2VarArr == null) {
            long j2 = this.f22147b;
            if (m5760e(j2, j2 + j)) {
                return;
            }
        }
        ThreadLocal threadLocal = kp2.f22140d;
        int[] iArr = (int[]) threadLocal.get();
        if (iArr != null && ip2VarArr != null && (length3 = ip2VarArr.length) >= 1 && (ip2Var = ip2VarArr[(length3 - 1) & iArr[0]]) != null) {
            long j3 = ip2Var.f20186a;
            z = ip2Var.m5336a(j3, j3 + j);
            if (z) {
                return;
            }
        } else {
            z = true;
        }
        if (iArr == null) {
            iArr = new int[1];
            threadLocal.set(iArr);
            i = kp2.f22141e.nextInt();
            if (i == 0) {
                i = 1;
            }
            iArr[0] = i;
        } else {
            i = iArr[0];
        }
        while (true) {
            boolean z4 = false;
            while (true) {
                ip2[] ip2VarArr2 = this.f22146a;
                if (ip2VarArr2 != null && (length = ip2VarArr2.length) > 0) {
                    ip2 ip2Var2 = ip2VarArr2[(length - 1) & i];
                    if (ip2Var2 == null) {
                        if (this.f22148c == 0) {
                            ip2 ip2Var3 = new ip2(j);
                            if (this.f22148c == 0 && m5761f()) {
                                try {
                                    ip2[] ip2VarArr3 = this.f22146a;
                                    if (ip2VarArr3 != null && (length2 = ip2VarArr3.length) > 0) {
                                        int i2 = (length2 - 1) & i;
                                        if (ip2VarArr3[i2] == null) {
                                            ip2VarArr3[i2] = ip2Var3;
                                            z3 = true;
                                            if (!z3) {
                                                return;
                                            }
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                    }
                                } finally {
                                }
                            }
                        }
                    } else {
                        if (!z) {
                            z = true;
                        } else {
                            long j4 = ip2Var2.f20186a;
                            if (!ip2Var2.m5336a(j4, j4 + j)) {
                                if (length < kp2.f22142f && this.f22146a == ip2VarArr2) {
                                    if (!z4) {
                                        z4 = true;
                                    } else if (this.f22148c == 0 && m5761f()) {
                                        try {
                                            break;
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        int i3 = i ^ (i << 13);
                        int i4 = i3 ^ (i3 >>> 17);
                        i = i4 ^ (i4 << 5);
                        iArr[0] = i;
                    }
                    z4 = false;
                    int i32 = i ^ (i << 13);
                    int i42 = i32 ^ (i32 >>> 17);
                    i = i42 ^ (i42 << 5);
                    iArr[0] = i;
                } else if (this.f22148c == 0 && this.f22146a == ip2VarArr2 && m5761f()) {
                    try {
                        if (this.f22146a == ip2VarArr2) {
                            ip2[] ip2VarArr4 = new ip2[2];
                            ip2VarArr4[i & 1] = new ip2(j);
                            this.f22146a = ip2VarArr4;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            return;
                        }
                    } finally {
                    }
                } else {
                    long j5 = this.f22147b;
                    if (m5760e(j5, j5 + j)) {
                        return;
                    }
                }
            }
        }
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return mo7361b();
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) mo7361b();
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) mo7361b();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return mo7361b();
    }

    public final String toString() {
        return Long.toString(mo7361b());
    }
}

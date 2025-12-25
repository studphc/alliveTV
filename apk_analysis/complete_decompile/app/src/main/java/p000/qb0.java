package p000;

import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class qb0 implements Comparable {

    /* renamed from: a */
    public final PlayerMessage f25502a;

    /* renamed from: b */
    public int f25503b;

    /* renamed from: c */
    public long f25504c;

    /* renamed from: d */
    public Object f25505d;

    public qb0(PlayerMessage playerMessage) {
        this.f25502a = playerMessage;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        boolean z;
        boolean z2;
        qb0 qb0Var = (qb0) obj;
        Object obj2 = this.f25505d;
        if (obj2 == null) {
            z = true;
        } else {
            z = false;
        }
        if (qb0Var.f25505d == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            if (obj2 == null) {
                return 1;
            }
            return -1;
        }
        if (obj2 == null) {
            return 0;
        }
        int i = this.f25503b - qb0Var.f25503b;
        if (i == 0) {
            return Util.compareLong(this.f25504c, qb0Var.f25504c);
        }
        return i;
    }
}

package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.TreeSet;

/* renamed from: kk */
/* loaded from: classes.dex */
public final class C1394kk {

    /* renamed from: a */
    public final int f20877a;

    /* renamed from: b */
    public final String f20878b;

    /* renamed from: c */
    public final TreeSet f20879c = new TreeSet();

    /* renamed from: d */
    public final ArrayList f20880d = new ArrayList();

    /* renamed from: e */
    public DefaultContentMetadata f20881e;

    public C1394kk(int i, String str, DefaultContentMetadata defaultContentMetadata) {
        this.f20877a = i;
        this.f20878b = str;
        this.f20881e = defaultContentMetadata;
    }

    /* renamed from: a */
    public final long m5560a(long j, long j2) {
        boolean z;
        boolean z2 = true;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkArgument(z);
        if (j2 < 0) {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        ji2 m5561b = m5561b(j, j2);
        long j3 = Long.MAX_VALUE;
        if (m5561b.isHoleSpan()) {
            if (!m5561b.isOpenEnded()) {
                j3 = m5561b.length;
            }
            return -Math.min(j3, j2);
        }
        long j4 = j + j2;
        if (j4 >= 0) {
            j3 = j4;
        }
        long j5 = m5561b.position + m5561b.length;
        if (j5 < j3) {
            for (ji2 ji2Var : this.f20879c.tailSet(m5561b, false)) {
                long j6 = ji2Var.position;
                if (j6 > j5) {
                    break;
                }
                j5 = Math.max(j5, j6 + ji2Var.length);
                if (j5 >= j3) {
                    break;
                }
            }
        }
        return Math.min(j5 - j, j2);
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [ji2, com.google.android.exoplayer2.upstream.cache.CacheSpan] */
    /* renamed from: b */
    public final ji2 m5561b(long j, long j2) {
        CacheSpan cacheSpan = new CacheSpan(this.f20878b, j, -1L, C0643C.TIME_UNSET, null);
        TreeSet treeSet = this.f20879c;
        ji2 ji2Var = (ji2) treeSet.floor(cacheSpan);
        if (ji2Var != null && ji2Var.position + ji2Var.length > j) {
            return ji2Var;
        }
        ji2 ji2Var2 = (ji2) treeSet.ceiling(cacheSpan);
        if (ji2Var2 != null) {
            long j3 = ji2Var2.position - j;
            if (j2 == -1) {
                j2 = j3;
            } else {
                j2 = Math.min(j3, j2);
            }
        }
        return new CacheSpan(this.f20878b, j, j2, C0643C.TIME_UNSET, null);
    }

    /* renamed from: c */
    public final boolean m5562c(long j, long j2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f20880d;
            if (i >= arrayList.size()) {
                return false;
            }
            C1357jk c1357jk = (C1357jk) arrayList.get(i);
            long j3 = c1357jk.f20527b;
            long j4 = c1357jk.f20526a;
            if (j3 == -1) {
                if (j >= j4) {
                    return true;
                }
            } else if (j2 != -1 && j4 <= j && j + j2 <= j4 + j3) {
                return true;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1394kk.class != obj.getClass()) {
            return false;
        }
        C1394kk c1394kk = (C1394kk) obj;
        if (this.f20877a == c1394kk.f20877a && this.f20878b.equals(c1394kk.f20878b) && this.f20879c.equals(c1394kk.f20879c) && this.f20881e.equals(c1394kk.f20881e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f20881e.hashCode() + ye0.m8286f(this.f20877a * 31, 31, this.f20878b);
    }
}

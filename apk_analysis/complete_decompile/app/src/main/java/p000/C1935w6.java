package p000;

/* renamed from: w6 */
/* loaded from: classes.dex */
public final class C1935w6 {

    /* renamed from: a */
    public int f28079a;

    /* renamed from: b */
    public int f28080b;

    /* renamed from: c */
    public Object f28081c;

    /* renamed from: d */
    public int f28082d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1935w6)) {
            return false;
        }
        C1935w6 c1935w6 = (C1935w6) obj;
        int i = this.f28079a;
        if (i != c1935w6.f28079a) {
            return false;
        }
        if (i == 8 && Math.abs(this.f28082d - this.f28080b) == 1 && this.f28082d == c1935w6.f28080b && this.f28080b == c1935w6.f28082d) {
            return true;
        }
        if (this.f28082d != c1935w6.f28082d || this.f28080b != c1935w6.f28080b) {
            return false;
        }
        Object obj2 = this.f28081c;
        if (obj2 != null) {
            if (!obj2.equals(c1935w6.f28081c)) {
                return false;
            }
        } else if (c1935w6.f28081c != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f28079a * 31) + this.f28080b) * 31) + this.f28082d;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i = this.f28079a;
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        str = "??";
                    } else {
                        str = "mv";
                    }
                } else {
                    str = "up";
                }
            } else {
                str = "rm";
            }
        } else {
            str = "add";
        }
        sb.append(str);
        sb.append(",s:");
        sb.append(this.f28080b);
        sb.append("c:");
        sb.append(this.f28082d);
        sb.append(",p:");
        sb.append(this.f28081c);
        sb.append("]");
        return sb.toString();
    }
}

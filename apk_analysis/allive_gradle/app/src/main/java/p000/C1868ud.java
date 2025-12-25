package p000;

/* renamed from: ud */
/* loaded from: classes2.dex */
public final class C1868ud {

    /* renamed from: a */
    public final String f27226a;

    /* renamed from: b */
    public final String f27227b;

    public C1868ud(String str, String str2) {
        if (str != null) {
            this.f27226a = str;
            if (str2 != null) {
                this.f27227b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1868ud)) {
            return false;
        }
        C1868ud c1868ud = (C1868ud) obj;
        if (this.f27226a.equals(c1868ud.f27226a) && this.f27227b.equals(c1868ud.f27227b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f27226a.hashCode() ^ 1000003) * 1000003) ^ this.f27227b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.f27226a);
        sb.append(", version=");
        return AbstractC1726qj.m7061q(sb, this.f27227b, "}");
    }
}

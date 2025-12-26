package p000;

/* renamed from: kc */
/* loaded from: classes.dex */
public abstract class AbstractC1386kc {

    /* renamed from: a */
    public final int f20817a;

    public AbstractC1386kc(int i) {
        this.f20817a = i;
    }

    /* renamed from: a */
    public static String m5517a(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    /* renamed from: b */
    public static int m5518b(int i) {
        return (i >> 24) & 255;
    }

    public String toString() {
        return m5517a(this.f20817a);
    }
}

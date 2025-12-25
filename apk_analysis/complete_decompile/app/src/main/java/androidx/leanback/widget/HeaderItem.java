package androidx.leanback.widget;

/* loaded from: classes.dex */
public class HeaderItem {

    /* renamed from: a */
    public final long f5834a;

    /* renamed from: b */
    public final String f5835b;

    /* renamed from: c */
    public CharSequence f5836c;

    /* renamed from: d */
    public CharSequence f5837d;

    public HeaderItem(long j, String str) {
        this.f5834a = j;
        this.f5835b = str;
    }

    public CharSequence getContentDescription() {
        return this.f5837d;
    }

    public CharSequence getDescription() {
        return this.f5836c;
    }

    public final long getId() {
        return this.f5834a;
    }

    public final String getName() {
        return this.f5835b;
    }

    public void setContentDescription(CharSequence charSequence) {
        this.f5837d = charSequence;
    }

    public void setDescription(CharSequence charSequence) {
        this.f5836c = charSequence;
    }

    public HeaderItem(String str) {
        this(-1L, str);
    }
}

package p000;

/* renamed from: oo */
/* loaded from: classes.dex */
public final class C1644oo extends AbstractC1842to {

    /* renamed from: b */
    public static final C1644oo f24844b = new AbstractC1842to("CharMatcher.javaIsoControl()");

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        if (c > 31 && (c < 127 || c > 159)) {
            return false;
        }
        return true;
    }
}

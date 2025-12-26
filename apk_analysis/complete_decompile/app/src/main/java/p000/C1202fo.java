package p000;

/* renamed from: fo */
/* loaded from: classes.dex */
public final class C1202fo extends AbstractC1842to {

    /* renamed from: b */
    public static final C1202fo f17350b = new AbstractC1842to("CharMatcher.ascii()");

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        if (c <= 127) {
            return true;
        }
        return false;
    }
}

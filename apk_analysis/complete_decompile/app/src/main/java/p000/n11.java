package p000;

import java.security.PrivilegedAction;

/* loaded from: classes2.dex */
public final class n11 implements PrivilegedAction {

    /* renamed from: a */
    public final /* synthetic */ String f23194a;

    /* renamed from: b */
    public final /* synthetic */ String f23195b;

    public n11(String str, String str2) {
        this.f23194a = str;
        this.f23195b = str2;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        return System.setProperty(this.f23194a, this.f23195b);
    }
}

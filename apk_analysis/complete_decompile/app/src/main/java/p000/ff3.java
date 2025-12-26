package p000;

import android.util.Log;

/* loaded from: classes.dex */
public class ff3 {

    /* renamed from: e */
    public static final ff3 f17242e = new ff3(true, 3, null, null);

    /* renamed from: a */
    public final boolean f17243a;

    /* renamed from: b */
    public final String f17244b;

    /* renamed from: c */
    public final Exception f17245c;

    /* renamed from: d */
    public final int f17246d;

    public ff3(boolean z, int i, String str, Exception exc) {
        this.f17243a = z;
        this.f17246d = i;
        this.f17244b = str;
        this.f17245c = exc;
    }

    /* renamed from: a */
    public String mo2092a() {
        return this.f17244b;
    }

    /* renamed from: b */
    public final void m4806b() {
        if (!this.f17243a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            Exception exc = this.f17245c;
            if (exc != null) {
                Log.d("GoogleCertificatesRslt", mo2092a(), exc);
            } else {
                Log.d("GoogleCertificatesRslt", mo2092a());
            }
        }
    }
}

package p000;

import android.content.IntentFilter;
import androidx.appcompat.app.LayoutInflaterFactory2C0084e;

/* renamed from: f9 */
/* loaded from: classes.dex */
public abstract class AbstractC1187f9 {

    /* renamed from: a */
    public C1150e9 f17179a;

    /* renamed from: b */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f17180b;

    public AbstractC1187f9(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        this.f17180b = layoutInflaterFactory2C0084e;
    }

    /* renamed from: a */
    public final void m4779a() {
        C1150e9 c1150e9 = this.f17179a;
        if (c1150e9 != null) {
            try {
                this.f17180b.f721k.unregisterReceiver(c1150e9);
            } catch (IllegalArgumentException unused) {
            }
            this.f17179a = null;
        }
    }

    /* renamed from: b */
    public abstract IntentFilter mo4553b();

    /* renamed from: c */
    public abstract int mo4554c();

    /* renamed from: d */
    public abstract void mo4555d();

    /* renamed from: e */
    public final void m4780e() {
        m4779a();
        IntentFilter mo4553b = mo4553b();
        if (mo4553b.countActions() == 0) {
            return;
        }
        if (this.f17179a == null) {
            this.f17179a = new C1150e9(0, this);
        }
        this.f17180b.f721k.registerReceiver(this.f17179a, mo4553b);
    }
}

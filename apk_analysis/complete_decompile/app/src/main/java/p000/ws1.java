package p000;

import android.app.Notification;

/* loaded from: classes.dex */
public final class ws1 {

    /* renamed from: a */
    public final String f28316a;

    /* renamed from: b */
    public final int f28317b;

    /* renamed from: c */
    public final String f28318c;

    /* renamed from: d */
    public final Notification f28319d;

    public ws1(String str, int i, String str2, Notification notification) {
        this.f28316a = str;
        this.f28317b = i;
        this.f28318c = str2;
        this.f28319d = notification;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NotifyTask[packageName:");
        sb.append(this.f28316a);
        sb.append(", id:");
        sb.append(this.f28317b);
        sb.append(", tag:");
        return AbstractC1726qj.m7061q(sb, this.f28318c, "]");
    }
}

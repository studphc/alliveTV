package p000;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public final class ab1 {

    /* renamed from: a */
    public final IntentFilter f106a;

    /* renamed from: b */
    public final BroadcastReceiver f107b;

    /* renamed from: c */
    public boolean f108c;

    /* renamed from: d */
    public boolean f109d;

    public ab1(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.f106a = intentFilter;
        this.f107b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.f107b);
        sb.append(" filter=");
        sb.append(this.f106a);
        if (this.f109d) {
            sb.append(" DEAD");
        }
        sb.append("}");
        return sb.toString();
    }
}

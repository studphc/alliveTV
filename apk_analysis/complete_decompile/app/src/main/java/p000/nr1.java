package p000;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import com.google.android.exoplayer2.util.NetworkTypeObserver;

/* loaded from: classes.dex */
public final class nr1 extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

    /* renamed from: a */
    public final NetworkTypeObserver f23466a;

    public nr1(NetworkTypeObserver networkTypeObserver) {
        this.f23466a = networkTypeObserver;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        boolean z;
        int m7083a = ql1.m7083a(telephonyDisplayInfo);
        int i = 5;
        if (m7083a != 3 && m7083a != 4 && m7083a != 5) {
            z = false;
        } else {
            z = true;
        }
        NetworkTypeObserver networkTypeObserver = this.f23466a;
        if (z) {
            i = 10;
        }
        NetworkTypeObserver.m3035a(networkTypeObserver, i);
    }
}

package p000;

import android.net.TrafficStats;
import androidx.annotation.DoNotInline;
import java.net.DatagramSocket;

/* loaded from: classes.dex */
public abstract class hv2 {
    @DoNotInline
    /* renamed from: a */
    public static void m5133a(DatagramSocket datagramSocket) {
        TrafficStats.tagDatagramSocket(datagramSocket);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m5134b(DatagramSocket datagramSocket) {
        TrafficStats.untagDatagramSocket(datagramSocket);
    }
}

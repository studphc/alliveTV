package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.net.DatagramSocket;
import java.net.Socket;
import p000.C1852ty;
import p000.hv2;

/* loaded from: classes.dex */
public final class TrafficStatsCompat {
    @Deprecated
    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated
    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated
    public static void incrementOperationCount(int i) {
        TrafficStats.incrementOperationCount(i);
    }

    @Deprecated
    public static void setThreadStatsTag(int i) {
        TrafficStats.setThreadStatsTag(i);
    }

    public static void tagDatagramSocket(@NonNull DatagramSocket datagramSocket) {
        if (Build.VERSION.SDK_INT >= 24) {
            hv2.m5133a(datagramSocket);
            return;
        }
        ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.tagSocket(new C1852ty(datagramSocket, fromDatagramSocket.getFileDescriptor()));
        fromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void tagSocket(Socket socket) {
        TrafficStats.tagSocket(socket);
    }

    public static void untagDatagramSocket(@NonNull DatagramSocket datagramSocket) {
        if (Build.VERSION.SDK_INT >= 24) {
            hv2.m5134b(datagramSocket);
            return;
        }
        ParcelFileDescriptor fromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.untagSocket(new C1852ty(datagramSocket, fromDatagramSocket.getFileDescriptor()));
        fromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void untagSocket(Socket socket) {
        TrafficStats.untagSocket(socket);
    }

    @Deprecated
    public static void incrementOperationCount(int i, int i2) {
        TrafficStats.incrementOperationCount(i, i2);
    }
}

package p000;

import java.io.FileDescriptor;
import java.net.DatagramSocket;
import java.net.Socket;

/* renamed from: ty */
/* loaded from: classes.dex */
public final class C1852ty extends Socket {
    public C1852ty(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
        super(new C1815sy(datagramSocket, fileDescriptor));
    }
}

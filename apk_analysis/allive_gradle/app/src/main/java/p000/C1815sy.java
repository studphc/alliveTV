package p000;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;

/* renamed from: sy */
/* loaded from: classes.dex */
public final class C1815sy extends SocketImpl {
    public C1815sy(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
        ((SocketImpl) this).localport = datagramSocket.getLocalPort();
        ((SocketImpl) this).fd = fileDescriptor;
    }

    @Override // java.net.SocketImpl
    public final void accept(SocketImpl socketImpl) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final int available() {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final void bind(InetAddress inetAddress, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final void connect(String str, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final void create(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final InputStream getInputStream() {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketOptions
    public final Object getOption(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final OutputStream getOutputStream() {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final void listen(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final void sendUrgentData(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketOptions
    public final void setOption(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final void connect(InetAddress inetAddress, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.net.SocketImpl
    public final void connect(SocketAddress socketAddress, int i) {
        throw new UnsupportedOperationException();
    }
}

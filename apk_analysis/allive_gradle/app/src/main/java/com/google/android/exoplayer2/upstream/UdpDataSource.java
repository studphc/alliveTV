package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public final class UdpDataSource extends BaseDataSource {
    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 8000;
    public static final int UDP_PORT_UNSET = -1;

    /* renamed from: e */
    public final int f12557e;

    /* renamed from: f */
    public final byte[] f12558f;

    /* renamed from: g */
    public final DatagramPacket f12559g;

    /* renamed from: h */
    public Uri f12560h;

    /* renamed from: i */
    public DatagramSocket f12561i;

    /* renamed from: j */
    public MulticastSocket f12562j;

    /* renamed from: k */
    public InetAddress f12563k;

    /* renamed from: l */
    public boolean f12564l;

    /* renamed from: m */
    public int f12565m;

    /* loaded from: classes.dex */
    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i) {
            super(th, i);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f12560h = null;
        MulticastSocket multicastSocket = this.f12562j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) Assertions.checkNotNull(this.f12563k));
            } catch (IOException unused) {
            }
            this.f12562j = null;
        }
        DatagramSocket datagramSocket = this.f12561i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f12561i = null;
        }
        this.f12563k = null;
        this.f12565m = 0;
        if (this.f12564l) {
            this.f12564l = false;
            transferEnded();
        }
    }

    public int getLocalPort() {
        DatagramSocket datagramSocket = this.f12561i;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f12560h;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        Uri uri = dataSpec.uri;
        this.f12560h = uri;
        String str = (String) Assertions.checkNotNull(uri.getHost());
        int port = this.f12560h.getPort();
        transferInitializing(dataSpec);
        try {
            this.f12563k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f12563k, port);
            if (this.f12563k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f12562j = multicastSocket;
                multicastSocket.joinGroup(this.f12563k);
                this.f12561i = this.f12562j;
            } else {
                this.f12561i = new DatagramSocket(inetSocketAddress);
            }
            this.f12561i.setSoTimeout(this.f12557e);
            this.f12564l = true;
            transferStarted(dataSpec);
            return -1L;
        } catch (IOException e) {
            throw new UdpDataSourceException(e, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED);
        } catch (SecurityException e2) {
            throw new UdpDataSourceException(e2, PlaybackException.ERROR_CODE_IO_NO_PERMISSION);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f12565m;
        DatagramPacket datagramPacket = this.f12559g;
        if (i3 == 0) {
            try {
                ((DatagramSocket) Assertions.checkNotNull(this.f12561i)).receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.f12565m = length;
                bytesTransferred(length);
            } catch (SocketTimeoutException e) {
                throw new UdpDataSourceException(e, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT);
            } catch (IOException e2) {
                throw new UdpDataSourceException(e2, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED);
            }
        }
        int length2 = datagramPacket.getLength();
        int i4 = this.f12565m;
        int min = Math.min(i4, i2);
        System.arraycopy(this.f12558f, length2 - i4, bArr, i, min);
        this.f12565m -= min;
        return min;
    }

    public UdpDataSource(int i) {
        this(i, 8000);
    }

    public UdpDataSource(int i, int i2) {
        super(true);
        this.f12557e = i2;
        byte[] bArr = new byte[i];
        this.f12558f = bArr;
        this.f12559g = new DatagramPacket(bArr, 0, i);
    }
}

package p000;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import okio.Okio;

/* loaded from: classes2.dex */
public final class cl2 extends AsyncTimeout {

    /* renamed from: j */
    public final Socket f8411j;

    public cl2(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.f8411j = socket;
    }

    @Override // okio.AsyncTimeout
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public final void timedOut() {
        Socket socket = this.f8411j;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (Okio.isAndroidGetsocknameError(e)) {
                t02.f26653a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                return;
            }
            throw e;
        } catch (Exception e2) {
            t02.f26653a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        }
    }
}

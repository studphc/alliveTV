package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class g extends HttpRequest.CloseOperation {
    public final /* synthetic */ InputStream c;
    public final /* synthetic */ OutputStream d;
    public final /* synthetic */ HttpRequest e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(HttpRequest httpRequest, InputStream inputStream, boolean z, InputStream inputStream2, OutputStream outputStream) {
        super(inputStream, z);
        this.e = httpRequest;
        this.c = inputStream2;
        this.d = outputStream;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        HttpRequest httpRequest = this.e;
        byte[] bArr = new byte[httpRequest.i];
        while (true) {
            int read = this.c.read(bArr);
            if (read != -1) {
                this.d.write(bArr, 0, read);
                long j = httpRequest.k + read;
                httpRequest.k = j;
                httpRequest.n.onUpload(j, httpRequest.j);
            } else {
                return httpRequest;
            }
        }
    }
}

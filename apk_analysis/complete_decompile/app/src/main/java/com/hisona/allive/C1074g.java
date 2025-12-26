package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.hisona.allive.g */
/* loaded from: classes2.dex */
public final class C1074g extends HttpRequest.CloseOperation {

    /* renamed from: c */
    public final /* synthetic */ InputStream f15990c;

    /* renamed from: d */
    public final /* synthetic */ OutputStream f15991d;

    /* renamed from: e */
    public final /* synthetic */ HttpRequest f15992e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1074g(HttpRequest httpRequest, InputStream inputStream, boolean z, InputStream inputStream2, OutputStream outputStream) {
        super(inputStream, z);
        this.f15992e = httpRequest;
        this.f15990c = inputStream2;
        this.f15991d = outputStream;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        HttpRequest httpRequest = this.f15992e;
        byte[] bArr = new byte[httpRequest.f15846i];
        while (true) {
            int read = this.f15990c.read(bArr);
            if (read != -1) {
                this.f15991d.write(bArr, 0, read);
                long j = httpRequest.f15848k + read;
                httpRequest.f15848k = j;
                httpRequest.f15851n.onUpload(j, httpRequest.f15847j);
            } else {
                return httpRequest;
            }
        }
    }
}

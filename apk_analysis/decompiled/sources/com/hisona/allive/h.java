package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.Reader;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class h extends HttpRequest.CloseOperation {
    public final /* synthetic */ Reader c;
    public final /* synthetic */ Writer d;
    public final /* synthetic */ HttpRequest e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(HttpRequest httpRequest, Reader reader, boolean z, Reader reader2, Writer writer) {
        super(reader, z);
        this.e = httpRequest;
        this.c = reader2;
        this.d = writer;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        HttpRequest httpRequest = this.e;
        char[] cArr = new char[httpRequest.i];
        while (true) {
            int read = this.c.read(cArr);
            if (read != -1) {
                this.d.write(cArr, 0, read);
                long j = httpRequest.k + read;
                httpRequest.k = j;
                httpRequest.n.onUpload(j, -1L);
            } else {
                return httpRequest;
            }
        }
    }
}

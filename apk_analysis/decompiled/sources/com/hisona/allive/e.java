package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.BufferedReader;
import java.nio.CharBuffer;

/* loaded from: classes2.dex */
public final class e extends HttpRequest.CloseOperation {
    public final /* synthetic */ BufferedReader c;
    public final /* synthetic */ Appendable d;
    public final /* synthetic */ HttpRequest e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(HttpRequest httpRequest, BufferedReader bufferedReader, boolean z, BufferedReader bufferedReader2, Appendable appendable) {
        super(bufferedReader, z);
        this.e = httpRequest;
        this.c = bufferedReader2;
        this.d = appendable;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        HttpRequest httpRequest = this.e;
        CharBuffer allocate = CharBuffer.allocate(httpRequest.i);
        while (true) {
            int read = this.c.read(allocate);
            if (read != -1) {
                allocate.rewind();
                this.d.append(allocate, 0, read);
                allocate.rewind();
            } else {
                return httpRequest;
            }
        }
    }
}

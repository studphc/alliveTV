package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.OutputStreamWriter;
import java.io.Reader;

/* loaded from: classes2.dex */
public final class c extends HttpRequest.FlushOperation {
    public final /* synthetic */ Reader b;
    public final /* synthetic */ OutputStreamWriter c;
    public final /* synthetic */ HttpRequest d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(HttpRequest httpRequest, OutputStreamWriter outputStreamWriter, Reader reader, OutputStreamWriter outputStreamWriter2) {
        super(outputStreamWriter);
        this.d = httpRequest;
        this.b = reader;
        this.c = outputStreamWriter2;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        return this.d.copy(this.b, this.c);
    }
}

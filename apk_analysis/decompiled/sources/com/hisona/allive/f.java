package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.BufferedReader;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class f extends HttpRequest.CloseOperation {
    public final /* synthetic */ BufferedReader c;
    public final /* synthetic */ Writer d;
    public final /* synthetic */ HttpRequest e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(HttpRequest httpRequest, BufferedReader bufferedReader, boolean z, BufferedReader bufferedReader2, Writer writer) {
        super(bufferedReader, z);
        this.e = httpRequest;
        this.c = bufferedReader2;
        this.d = writer;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        return this.e.copy(this.c, this.d);
    }
}

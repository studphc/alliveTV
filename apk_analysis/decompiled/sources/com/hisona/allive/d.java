package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.BufferedOutputStream;

/* loaded from: classes2.dex */
public final class d extends HttpRequest.CloseOperation {
    public final /* synthetic */ BufferedOutputStream c;
    public final /* synthetic */ HttpRequest d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(HttpRequest httpRequest, BufferedOutputStream bufferedOutputStream, boolean z, BufferedOutputStream bufferedOutputStream2) {
        super(bufferedOutputStream, z);
        this.d = httpRequest;
        this.c = bufferedOutputStream2;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        return this.d.receive(this.c);
    }
}

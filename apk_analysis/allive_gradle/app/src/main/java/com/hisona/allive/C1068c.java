package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.OutputStreamWriter;
import java.io.Reader;

/* renamed from: com.hisona.allive.c */
/* loaded from: classes2.dex */
public final class C1068c extends HttpRequest.FlushOperation {

    /* renamed from: b */
    public final /* synthetic */ Reader f15975b;

    /* renamed from: c */
    public final /* synthetic */ OutputStreamWriter f15976c;

    /* renamed from: d */
    public final /* synthetic */ HttpRequest f15977d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1068c(HttpRequest httpRequest, OutputStreamWriter outputStreamWriter, Reader reader, OutputStreamWriter outputStreamWriter2) {
        super(outputStreamWriter);
        this.f15977d = httpRequest;
        this.f15975b = reader;
        this.f15976c = outputStreamWriter2;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        return this.f15977d.copy(this.f15975b, this.f15976c);
    }
}

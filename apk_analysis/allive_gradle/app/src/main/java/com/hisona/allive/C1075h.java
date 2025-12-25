package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.Reader;
import java.io.Writer;

/* renamed from: com.hisona.allive.h */
/* loaded from: classes2.dex */
public final class C1075h extends HttpRequest.CloseOperation {

    /* renamed from: c */
    public final /* synthetic */ Reader f15993c;

    /* renamed from: d */
    public final /* synthetic */ Writer f15994d;

    /* renamed from: e */
    public final /* synthetic */ HttpRequest f15995e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1075h(HttpRequest httpRequest, Reader reader, boolean z, Reader reader2, Writer writer) {
        super(reader, z);
        this.f15995e = httpRequest;
        this.f15993c = reader2;
        this.f15994d = writer;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        HttpRequest httpRequest = this.f15995e;
        char[] cArr = new char[httpRequest.f15846i];
        while (true) {
            int read = this.f15993c.read(cArr);
            if (read != -1) {
                this.f15994d.write(cArr, 0, read);
                long j = httpRequest.f15848k + read;
                httpRequest.f15848k = j;
                httpRequest.f15851n.onUpload(j, -1L);
            } else {
                return httpRequest;
            }
        }
    }
}

package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.BufferedReader;
import java.nio.CharBuffer;

/* renamed from: com.hisona.allive.e */
/* loaded from: classes2.dex */
public final class C1072e extends HttpRequest.CloseOperation {

    /* renamed from: c */
    public final /* synthetic */ BufferedReader f15984c;

    /* renamed from: d */
    public final /* synthetic */ Appendable f15985d;

    /* renamed from: e */
    public final /* synthetic */ HttpRequest f15986e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1072e(HttpRequest httpRequest, BufferedReader bufferedReader, boolean z, BufferedReader bufferedReader2, Appendable appendable) {
        super(bufferedReader, z);
        this.f15986e = httpRequest;
        this.f15984c = bufferedReader2;
        this.f15985d = appendable;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        HttpRequest httpRequest = this.f15986e;
        CharBuffer allocate = CharBuffer.allocate(httpRequest.f15846i);
        while (true) {
            int read = this.f15984c.read(allocate);
            if (read != -1) {
                allocate.rewind();
                this.f15985d.append(allocate, 0, read);
                allocate.rewind();
            } else {
                return httpRequest;
            }
        }
    }
}

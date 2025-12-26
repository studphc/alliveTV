package com.hisona.allive;

import com.hisona.allive.HttpRequest;
import java.io.BufferedReader;
import java.io.Writer;

/* renamed from: com.hisona.allive.f */
/* loaded from: classes2.dex */
public final class C1073f extends HttpRequest.CloseOperation {

    /* renamed from: c */
    public final /* synthetic */ BufferedReader f15987c;

    /* renamed from: d */
    public final /* synthetic */ Writer f15988d;

    /* renamed from: e */
    public final /* synthetic */ HttpRequest f15989e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1073f(HttpRequest httpRequest, BufferedReader bufferedReader, boolean z, BufferedReader bufferedReader2, Writer writer) {
        super(bufferedReader, z);
        this.f15989e = httpRequest;
        this.f15987c = bufferedReader2;
        this.f15988d = writer;
    }

    @Override // com.hisona.allive.HttpRequest.Operation
    public final Object run() {
        return this.f15989e.copy(this.f15987c, this.f15988d);
    }
}

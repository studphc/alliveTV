package p000;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import java.io.Serializable;

/* renamed from: fh */
/* loaded from: classes2.dex */
public final class C1195fh implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public final long[] f17263a;

    /* renamed from: b */
    public final int f17264b;

    /* renamed from: c */
    public final Funnel f17265c;

    /* renamed from: d */
    public final EnumC1354jh f17266d;

    public C1195fh(BloomFilter bloomFilter) {
        this.f17263a = C1306ih.m5240e(bloomFilter.f15053a.f18407a);
        this.f17264b = bloomFilter.f15054b;
        this.f17265c = bloomFilter.f15055c;
        this.f17266d = bloomFilter.f15056d;
    }

    public Object readResolve() {
        return new BloomFilter(new C1306ih(this.f17263a), this.f17264b, this.f17265c, this.f17266d);
    }
}

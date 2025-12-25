package p000;

import com.google.android.exoplayer2.text.webvtt.WebvttCssStyle;

/* loaded from: classes.dex */
public final class b53 implements Comparable {

    /* renamed from: a */
    public final int f7903a;

    /* renamed from: b */
    public final WebvttCssStyle f7904b;

    public b53(int i, WebvttCssStyle webvttCssStyle) {
        this.f7903a = i;
        this.f7904b = webvttCssStyle;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f7903a, ((b53) obj).f7903a);
    }
}

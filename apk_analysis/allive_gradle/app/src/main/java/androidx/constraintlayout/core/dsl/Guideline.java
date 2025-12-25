package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Helper;

/* loaded from: classes.dex */
public abstract class Guideline extends Helper {

    /* renamed from: a */
    public int f1934a;

    /* renamed from: b */
    public int f1935b;

    /* renamed from: c */
    public float f1936c;

    public Guideline(String str) {
        super(str, new Helper.HelperType(""));
        this.f1934a = Integer.MIN_VALUE;
        this.f1935b = Integer.MIN_VALUE;
        this.f1936c = Float.NaN;
    }

    public int getEnd() {
        return this.f1935b;
    }

    public float getPercent() {
        return this.f1936c;
    }

    public int getStart() {
        return this.f1934a;
    }

    public void setEnd(int i) {
        this.f1935b = i;
        this.configMap.put("end", String.valueOf(i));
    }

    public void setPercent(float f) {
        this.f1936c = f;
        this.configMap.put("percent", String.valueOf(f));
    }

    public void setStart(int i) {
        this.f1934a = i;
        this.configMap.put("start", String.valueOf(i));
    }
}

package androidx.leanback.widget.picker;

/* loaded from: classes.dex */
public class PickerColumn {

    /* renamed from: a */
    public int f6375a;

    /* renamed from: b */
    public int f6376b;

    /* renamed from: c */
    public int f6377c;

    /* renamed from: d */
    public CharSequence[] f6378d;

    /* renamed from: e */
    public String f6379e;

    public int getCount() {
        return (this.f6377c - this.f6376b) + 1;
    }

    public int getCurrentValue() {
        return this.f6375a;
    }

    public CharSequence getLabelFor(int i) {
        CharSequence[] charSequenceArr = this.f6378d;
        if (charSequenceArr == null) {
            return String.format(this.f6379e, Integer.valueOf(i));
        }
        return charSequenceArr[i];
    }

    public String getLabelFormat() {
        return this.f6379e;
    }

    public int getMaxValue() {
        return this.f6377c;
    }

    public int getMinValue() {
        return this.f6376b;
    }

    public CharSequence[] getStaticLabels() {
        return this.f6378d;
    }

    public void setCurrentValue(int i) {
        this.f6375a = i;
    }

    public void setLabelFormat(String str) {
        this.f6379e = str;
    }

    public void setMaxValue(int i) {
        this.f6377c = i;
    }

    public void setMinValue(int i) {
        this.f6376b = i;
    }

    public void setStaticLabels(CharSequence[] charSequenceArr) {
        this.f6378d = charSequenceArr;
    }
}

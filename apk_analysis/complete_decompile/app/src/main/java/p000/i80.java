package p000;

import androidx.emoji2.text.TypefaceEmojiRasterizer;

/* loaded from: classes.dex */
public final class i80 implements h80 {

    /* renamed from: a */
    public final int f18333a;

    /* renamed from: b */
    public int f18334b = -1;

    /* renamed from: c */
    public int f18335c = -1;

    public i80(int i) {
        this.f18333a = i;
    }

    @Override // p000.h80
    /* renamed from: b */
    public final boolean mo1081b(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        int i3 = this.f18333a;
        if (i <= i3 && i3 < i2) {
            this.f18334b = i;
            this.f18335c = i2;
            return false;
        }
        if (i2 > i3) {
            return false;
        }
        return true;
    }

    @Override // p000.h80
    public final Object getResult() {
        return this;
    }
}

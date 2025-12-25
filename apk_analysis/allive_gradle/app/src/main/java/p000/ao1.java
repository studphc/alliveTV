package p000;

import android.util.SparseArray;
import androidx.emoji2.text.TypefaceEmojiRasterizer;

/* loaded from: classes.dex */
public final class ao1 {

    /* renamed from: a */
    public final SparseArray f7686a;

    /* renamed from: b */
    public TypefaceEmojiRasterizer f7687b;

    public ao1(int i) {
        this.f7686a = new SparseArray(i);
    }

    /* renamed from: a */
    public final void m1955a(TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i, int i2) {
        ao1 ao1Var;
        int codepointAt = typefaceEmojiRasterizer.getCodepointAt(i);
        SparseArray sparseArray = this.f7686a;
        if (sparseArray == null) {
            ao1Var = null;
        } else {
            ao1Var = (ao1) sparseArray.get(codepointAt);
        }
        if (ao1Var == null) {
            ao1Var = new ao1(1);
            sparseArray.put(typefaceEmojiRasterizer.getCodepointAt(i), ao1Var);
        }
        if (i2 > i) {
            ao1Var.m1955a(typefaceEmojiRasterizer, i + 1, i2);
        } else {
            ao1Var.f7687b = typefaceEmojiRasterizer;
        }
    }
}

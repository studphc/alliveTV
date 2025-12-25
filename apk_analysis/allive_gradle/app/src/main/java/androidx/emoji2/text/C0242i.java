package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.view.KeyEvent;
import androidx.emoji2.text.EmojiCompat;
import java.util.Iterator;
import java.util.Set;
import p000.C1368jv;
import p000.h80;
import p000.j80;

/* renamed from: androidx.emoji2.text.i */
/* loaded from: classes.dex */
public final class C0242i {

    /* renamed from: a */
    public final EmojiCompat.SpanFactory f4292a;

    /* renamed from: b */
    public final MetadataRepo f4293b;

    /* renamed from: c */
    public final EmojiCompat.GlyphChecker f4294c;

    /* renamed from: d */
    public final boolean f4295d;

    /* renamed from: e */
    public final int[] f4296e;

    public C0242i(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean z, int[] iArr, Set set) {
        this.f4292a = spanFactory;
        this.f4293b = metadataRepo;
        this.f4294c = glyphChecker;
        this.f4295d = z;
        this.f4296e = iArr;
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                int[] iArr2 = (int[]) it.next();
                String str = new String(iArr2, 0, iArr2.length);
                m1084c(str, 0, str.length(), 1, true, new C1368jv(str, 3));
            }
        }
    }

    /* renamed from: a */
    public static boolean m1082a(Editable editable, KeyEvent keyEvent, boolean z) {
        EmojiSpan[] emojiSpanArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public final int m1083b(CharSequence charSequence, int i) {
        j80 j80Var = new j80(this.f4293b.f4220c, this.f4295d, this.f4296e);
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int codePointAt = Character.codePointAt(charSequence, i2);
            int m5416a = j80Var.m5416a(codePointAt);
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = j80Var.f20416c.f7687b;
            if (m5416a != 1) {
                if (m5416a != 2) {
                    if (m5416a == 3) {
                        typefaceEmojiRasterizer = j80Var.f20417d.f7687b;
                        if (typefaceEmojiRasterizer.getCompatAdded() <= i) {
                            i3++;
                        }
                    }
                } else {
                    i2 += Character.charCount(codePointAt);
                }
            } else {
                i2 += Character.charCount(codePointAt);
                i4 = 0;
            }
            if (typefaceEmojiRasterizer != null && typefaceEmojiRasterizer.getCompatAdded() <= i) {
                i4++;
            }
        }
        if (i3 != 0) {
            return 2;
        }
        if (j80Var.f20414a == 2 && j80Var.f20416c.f7687b != null && ((j80Var.f20419f > 1 || j80Var.m5418c()) && j80Var.f20416c.f7687b.getCompatAdded() <= i)) {
            return 1;
        }
        if (i4 == 0) {
            return 0;
        }
        return 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b5, code lost:
    
        if (r2.getHasGlyph() == 2) goto L47;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1084c(CharSequence charSequence, int i, int i2, int i3, boolean z, h80 h80Var) {
        int i4;
        j80 j80Var = new j80(this.f4293b.f4220c, this.f4295d, this.f4296e);
        int codePointAt = Character.codePointAt(charSequence, i);
        boolean z2 = true;
        int i5 = 0;
        int i6 = i;
        loop0: while (true) {
            i4 = i6;
            while (i6 < i2 && i5 < i3 && z2) {
                int m5416a = j80Var.m5416a(codePointAt);
                if (m5416a != 1) {
                    if (m5416a != 2) {
                        if (m5416a == 3) {
                            if (!z) {
                                TypefaceEmojiRasterizer typefaceEmojiRasterizer = j80Var.f20417d.f7687b;
                                if (typefaceEmojiRasterizer.getHasGlyph() == 0) {
                                    typefaceEmojiRasterizer.setHasGlyph(this.f4294c.hasGlyph(charSequence, i4, i6, typefaceEmojiRasterizer.getSdkAdded()));
                                }
                                if (typefaceEmojiRasterizer.getHasGlyph() == 2) {
                                }
                            }
                            z2 = h80Var.mo1081b(charSequence, i4, i6, j80Var.f20417d.f7687b);
                            i5++;
                        }
                    } else {
                        int charCount = Character.charCount(codePointAt) + i6;
                        if (charCount < i2) {
                            codePointAt = Character.codePointAt(charSequence, charCount);
                        }
                        i6 = charCount;
                    }
                } else {
                    i6 = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                    if (i6 < i2) {
                        codePointAt = Character.codePointAt(charSequence, i6);
                    }
                }
            }
        }
        if (j80Var.f20414a == 2 && j80Var.f20416c.f7687b != null && ((j80Var.f20419f > 1 || j80Var.m5418c()) && i5 < i3 && z2)) {
            if (!z) {
                TypefaceEmojiRasterizer typefaceEmojiRasterizer2 = j80Var.f20416c.f7687b;
                if (typefaceEmojiRasterizer2.getHasGlyph() == 0) {
                    typefaceEmojiRasterizer2.setHasGlyph(this.f4294c.hasGlyph(charSequence, i4, i6, typefaceEmojiRasterizer2.getSdkAdded()));
                }
            }
            h80Var.mo1081b(charSequence, i4, i6, j80Var.f20416c.f7687b);
        }
        return h80Var.getResult();
    }
}

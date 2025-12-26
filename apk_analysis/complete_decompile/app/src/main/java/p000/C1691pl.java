package p000;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;

/* renamed from: pl */
/* loaded from: classes.dex */
public final class C1691pl {

    /* renamed from: c */
    public static final C0556bg f25206c = new C0556bg(2);

    /* renamed from: a */
    public final Cue f25207a;

    /* renamed from: b */
    public final int f25208b;

    public C1691pl(SpannableStringBuilder spannableStringBuilder, Layout.Alignment alignment, float f, int i, float f2, int i2, boolean z, int i3, int i4) {
        Cue.Builder size = new Cue.Builder().setText(spannableStringBuilder).setTextAlignment(alignment).setLine(f, 0).setLineAnchor(i).setPosition(f2).setPositionAnchor(i2).setSize(-3.4028235E38f);
        if (z) {
            size.setWindowColor(i3);
        }
        this.f25207a = size.build();
        this.f25208b = i4;
    }
}

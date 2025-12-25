package p000;

import android.text.Layout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.Cue;

/* loaded from: classes.dex */
public final class c53 {

    /* renamed from: c */
    public CharSequence f8257c;

    /* renamed from: a */
    public long f8255a = 0;

    /* renamed from: b */
    public long f8256b = 0;

    /* renamed from: d */
    public int f8258d = 2;

    /* renamed from: e */
    public float f8259e = -3.4028235E38f;

    /* renamed from: f */
    public int f8260f = 1;

    /* renamed from: g */
    public int f8261g = 0;

    /* renamed from: h */
    public float f8262h = -3.4028235E38f;

    /* renamed from: i */
    public int f8263i = Integer.MIN_VALUE;

    /* renamed from: j */
    public float f8264j = 1.0f;

    /* renamed from: k */
    public int f8265k = Integer.MIN_VALUE;

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0073, code lost:
    
        if (r8 == 0) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0073  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Cue.Builder m2204a() {
        Layout.Alignment alignment;
        float f;
        CharSequence charSequence;
        float f2 = this.f8262h;
        float f3 = -3.4028235E38f;
        if (f2 == -3.4028235E38f) {
            int i = this.f8258d;
            if (i != 4) {
                if (i != 5) {
                    f2 = 0.5f;
                } else {
                    f2 = 1.0f;
                }
            } else {
                f2 = 0.0f;
            }
        }
        int i2 = this.f8263i;
        if (i2 == Integer.MIN_VALUE) {
            int i3 = this.f8258d;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            i2 = 1;
                        }
                    }
                }
                i2 = 2;
            }
            i2 = 0;
        }
        Cue.Builder builder = new Cue.Builder();
        int i4 = this.f8258d;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            AbstractC1726qj.m7036A(i4, "Unknown textAlignment: ", "WebvttCueParser");
                            alignment = null;
                        }
                    }
                }
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Cue.Builder textAlignment = builder.setTextAlignment(alignment);
            f = this.f8259e;
            int i5 = this.f8260f;
            if (f != -3.4028235E38f || i5 != 0 || (f >= RecyclerView.f7068F0 && f <= 1.0f)) {
                if (f == -3.4028235E38f) {
                    f3 = f;
                }
                Cue.Builder positionAnchor = textAlignment.setLine(f3, i5).setLineAnchor(this.f8261g).setPosition(f2).setPositionAnchor(i2);
                float f4 = this.f8264j;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException(String.valueOf(i2));
                        }
                    } else if (f2 <= 0.5f) {
                        f2 *= 2.0f;
                    } else {
                        f2 = (1.0f - f2) * 2.0f;
                    }
                } else {
                    f2 = 1.0f - f2;
                }
                Cue.Builder verticalType = positionAnchor.setSize(Math.min(f4, f2)).setVerticalType(this.f8265k);
                charSequence = this.f8257c;
                if (charSequence != null) {
                    verticalType.setText(charSequence);
                }
                return verticalType;
            }
            f3 = 1.0f;
            Cue.Builder positionAnchor2 = textAlignment.setLine(f3, i5).setLineAnchor(this.f8261g).setPosition(f2).setPositionAnchor(i2);
            float f42 = this.f8264j;
            if (i2 != 0) {
            }
            Cue.Builder verticalType2 = positionAnchor2.setSize(Math.min(f42, f2)).setVerticalType(this.f8265k);
            charSequence = this.f8257c;
            if (charSequence != null) {
            }
            return verticalType2;
        }
        alignment = Layout.Alignment.ALIGN_NORMAL;
        Cue.Builder textAlignment2 = builder.setTextAlignment(alignment);
        f = this.f8259e;
        int i52 = this.f8260f;
        if (f != -3.4028235E38f) {
        }
        if (f == -3.4028235E38f) {
        }
        Cue.Builder positionAnchor22 = textAlignment2.setLine(f3, i52).setLineAnchor(this.f8261g).setPosition(f2).setPositionAnchor(i2);
        float f422 = this.f8264j;
        if (i2 != 0) {
        }
        Cue.Builder verticalType22 = positionAnchor22.setSize(Math.min(f422, f2)).setVerticalType(this.f8265k);
        charSequence = this.f8257c;
        if (charSequence != null) {
        }
        return verticalType22;
    }
}

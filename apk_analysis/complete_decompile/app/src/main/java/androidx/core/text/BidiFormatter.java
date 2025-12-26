package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import p000.C1268hg;

/* loaded from: classes.dex */
public final class BidiFormatter {

    /* renamed from: d */
    public static final TextDirectionHeuristicCompat f3772d;

    /* renamed from: e */
    public static final String f3773e;

    /* renamed from: f */
    public static final String f3774f;

    /* renamed from: g */
    public static final BidiFormatter f3775g;

    /* renamed from: h */
    public static final BidiFormatter f3776h;

    /* renamed from: a */
    public final boolean f3777a;

    /* renamed from: b */
    public final int f3778b;

    /* renamed from: c */
    public final TextDirectionHeuristicCompat f3779c;

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        f3772d = textDirectionHeuristicCompat;
        f3773e = Character.toString((char) 8206);
        f3774f = Character.toString((char) 8207);
        f3775g = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        f3776h = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    public BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f3777a = z;
        this.f3778b = i;
        this.f3779c = textDirectionHeuristicCompat;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0070, code lost:
    
        if (r1 != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0073, code lost:
    
        if (r2 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0079, code lost:
    
        if (r0.f18050c <= 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007f, code lost:
    
        switch(r0.m5086a()) {
            case 14: goto L66;
            case 15: goto L66;
            case 16: goto L65;
            case 17: goto L65;
            case 18: goto L64;
            default: goto L70;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0083, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0086, code lost:
    
        if (r1 != r3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0089, code lost:
    
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x008c, code lost:
    
        if (r1 != r3) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return 0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m886a(CharSequence charSequence) {
        byte directionality;
        C1268hg c1268hg = new C1268hg(charSequence);
        c1268hg.f18050c = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = c1268hg.f18050c;
            if (i4 < c1268hg.f18049b && i == 0) {
                CharSequence charSequence2 = c1268hg.f18048a;
                char charAt = charSequence2.charAt(i4);
                c1268hg.f18051d = charAt;
                if (Character.isHighSurrogate(charAt)) {
                    int codePointAt = Character.codePointAt(charSequence2, c1268hg.f18050c);
                    c1268hg.f18050c = Character.charCount(codePointAt) + c1268hg.f18050c;
                    directionality = Character.getDirectionality(codePointAt);
                } else {
                    c1268hg.f18050c++;
                    char c = c1268hg.f18051d;
                    if (c < 1792) {
                        directionality = C1268hg.f18047e[c];
                    } else {
                        directionality = Character.getDirectionality(c);
                    }
                }
                if (directionality != 0) {
                    if (directionality != 1 && directionality != 2) {
                        if (directionality != 9) {
                            switch (directionality) {
                                case 14:
                                case 15:
                                    i3++;
                                    i2 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i3++;
                                    i2 = 1;
                                    continue;
                                case 18:
                                    i3--;
                                    i2 = 0;
                                    continue;
                            }
                        }
                    } else if (i3 == 0) {
                    }
                } else if (i3 == 0) {
                }
                i = i3;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
    
        return 1;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x0021. Please report as an issue. */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m887b(CharSequence charSequence) {
        C1268hg c1268hg = new C1268hg(charSequence);
        c1268hg.f18050c = c1268hg.f18049b;
        int i = 0;
        while (true) {
            int i2 = i;
            while (c1268hg.f18050c > 0) {
                byte m5086a = c1268hg.m5086a();
                if (m5086a != 0) {
                    if (m5086a != 1 && m5086a != 2) {
                        if (m5086a != 9) {
                            switch (m5086a) {
                                case 14:
                                case 15:
                                    if (i2 == i) {
                                        break;
                                    }
                                    i--;
                                    break;
                                case 16:
                                case 17:
                                    if (i2 == i) {
                                        break;
                                    }
                                    i--;
                                    break;
                                case 18:
                                    i++;
                                    break;
                                default:
                                    if (i2 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                                    break;
                            }
                        } else {
                            continue;
                        }
                    } else if (i != 0) {
                        if (i2 == 0) {
                            break;
                        }
                    }
                } else if (i != 0) {
                    if (i2 == 0) {
                        break;
                    }
                }
            }
            return 0;
        }
        return -1;
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public boolean getStereoReset() {
        if ((this.f3778b & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.f3777a;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.f3779c.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean stereoReset = getStereoReset();
        String str2 = "";
        String str3 = f3774f;
        String str4 = f3773e;
        boolean z2 = this.f3777a;
        if (stereoReset && z) {
            boolean isRtl2 = (isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR).isRtl(charSequence, 0, charSequence.length());
            if (z2 || !(isRtl2 || m886a(charSequence) == 1)) {
                str = (!z2 || (isRtl2 && m886a(charSequence) != -1)) ? "" : str3;
            } else {
                str = str4;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        if (isRtl != z2) {
            spannableStringBuilder.append(isRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean isRtl3 = (isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR).isRtl(charSequence, 0, charSequence.length());
            if (!z2 && (isRtl3 || m887b(charSequence) == 1)) {
                str2 = str4;
            } else if (z2 && (!isRtl3 || m887b(charSequence) == -1)) {
                str2 = str3;
            }
            spannableStringBuilder.append((CharSequence) str2);
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final boolean f3780a;

        /* renamed from: b */
        public int f3781b;

        /* renamed from: c */
        public TextDirectionHeuristicCompat f3782c;

        public Builder() {
            Locale locale = Locale.getDefault();
            TextDirectionHeuristicCompat textDirectionHeuristicCompat = BidiFormatter.f3772d;
            this.f3780a = TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
            this.f3782c = BidiFormatter.f3772d;
            this.f3781b = 2;
        }

        public BidiFormatter build() {
            if (this.f3781b == 2 && this.f3782c == BidiFormatter.f3772d) {
                if (this.f3780a) {
                    return BidiFormatter.f3776h;
                }
                return BidiFormatter.f3775g;
            }
            return new BidiFormatter(this.f3780a, this.f3781b, this.f3782c);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.f3782c = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.f3781b |= 2;
            } else {
                this.f3781b &= -3;
            }
            return this;
        }

        public Builder(boolean z) {
            this.f3780a = z;
            this.f3782c = BidiFormatter.f3772d;
            this.f3781b = 2;
        }

        public Builder(Locale locale) {
            TextDirectionHeuristicCompat textDirectionHeuristicCompat = BidiFormatter.f3772d;
            this.f3780a = TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
            this.f3782c = BidiFormatter.f3772d;
            this.f3781b = 2;
        }
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.f3779c, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.f3779c, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.f3779c, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.f3779c, true);
    }
}

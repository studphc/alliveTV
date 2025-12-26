package com.google.android.exoplayer2.p003ui;

import android.content.Context;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.SparseArray;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.TextEmphasisSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import p000.jq2;
import p000.kq2;
import p000.w43;
import p000.wl2;
import p000.x43;
import p000.xl2;
import p000.ye0;
import p000.yl2;
import p000.yy2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WebViewSubtitleOutput extends FrameLayout implements jq2 {

    /* renamed from: a */
    public final CanvasSubtitleOutput f12317a;

    /* renamed from: b */
    public final w43 f12318b;

    /* renamed from: c */
    public List f12319c;

    /* renamed from: d */
    public CaptionStyleCompat f12320d;

    /* renamed from: e */
    public float f12321e;

    /* renamed from: f */
    public int f12322f;

    /* renamed from: g */
    public float f12323g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [w43, android.view.View, android.webkit.WebView] */
    public WebViewSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12319c = Collections.emptyList();
        this.f12320d = CaptionStyleCompat.DEFAULT;
        this.f12321e = 0.0533f;
        this.f12322f = 0;
        this.f12323g = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.f12317a = canvasSubtitleOutput;
        ?? webView = new WebView(context, attributeSet);
        this.f12318b = webView;
        webView.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(webView);
    }

    @Override // p000.jq2
    /* renamed from: a */
    public final void mo2890a(List list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.f12320d = captionStyleCompat;
        this.f12321e = f;
        this.f12322f = i;
        this.f12323g = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = (Cue) list.get(i2);
            if (cue.bitmap != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.f12319c.isEmpty() || !arrayList2.isEmpty()) {
            this.f12319c = arrayList2;
            m2958c();
        }
        this.f12317a.mo2890a(arrayList, captionStyleCompat, f, i, f2);
        invalidate();
    }

    /* renamed from: b */
    public final String m2957b(float f, int i) {
        float m5764b = kq2.m5764b(i, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom(), f);
        if (m5764b == -3.4028235E38f) {
            return "unset";
        }
        return Util.formatInvariant("%.2fpx", Float.valueOf(m5764b / getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX WARN: Code restructure failed: missing block: B:255:0x01d2, code lost:
    
        if (r3 != 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x01d5, code lost:
    
        r26 = "left";
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x01d8, code lost:
    
        if (r3 != 0) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:257:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x062c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0227  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2958c() {
        String formatInvariant;
        float f;
        int i;
        String formatInvariant2;
        int i2;
        float f2;
        String str;
        Layout.Alignment alignment;
        Object obj;
        int i3;
        String str2;
        int i4;
        int i5;
        int i6;
        String str3;
        int i7;
        CharSequence charSequence;
        String str4;
        String str5;
        String str6;
        Object obj2;
        String str7;
        String str8;
        String str9;
        String str10;
        Cue cue;
        SpannedToHtmlConverter$HtmlAndCss spannedToHtmlConverter$HtmlAndCss;
        int i8;
        String str11;
        String str12;
        float f3;
        Cue cue2;
        int i9;
        String str13;
        String formatInvariant3;
        float size;
        String str14;
        float f4;
        char c;
        char c2;
        char c3;
        Layout.Alignment alignment2;
        int i10;
        Object obj3;
        String str15;
        boolean z;
        int i11;
        WebViewSubtitleOutput webViewSubtitleOutput = this;
        int i12 = 2;
        int i13 = 0;
        int i14 = 1;
        StringBuilder sb = new StringBuilder();
        String m8343R = yy2.m8343R(webViewSubtitleOutput.f12320d.foregroundColor);
        String m2957b = webViewSubtitleOutput.m2957b(webViewSubtitleOutput.f12321e, webViewSubtitleOutput.f12322f);
        float f5 = 1.2f;
        Float valueOf = Float.valueOf(1.2f);
        CaptionStyleCompat captionStyleCompat = webViewSubtitleOutput.f12320d;
        int i15 = captionStyleCompat.edgeType;
        if (i15 != 1) {
            if (i15 != 2) {
                if (i15 != 3) {
                    if (i15 != 4) {
                        formatInvariant = "unset";
                    } else {
                        formatInvariant = Util.formatInvariant("-0.05em -0.05em 0.15em %s", yy2.m8343R(captionStyleCompat.edgeColor));
                    }
                } else {
                    formatInvariant = Util.formatInvariant("0.06em 0.08em 0.15em %s", yy2.m8343R(captionStyleCompat.edgeColor));
                }
            } else {
                formatInvariant = Util.formatInvariant("0.1em 0.12em 0.15em %s", yy2.m8343R(captionStyleCompat.edgeColor));
            }
        } else {
            formatInvariant = Util.formatInvariant("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", yy2.m8343R(captionStyleCompat.edgeColor));
        }
        sb.append(Util.formatInvariant("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", m8343R, m2957b, valueOf, formatInvariant));
        HashMap hashMap = new HashMap();
        String str16 = "background-color:%s;";
        hashMap.put(".default_bg,.default_bg *", Util.formatInvariant("background-color:%s;", yy2.m8343R(webViewSubtitleOutput.f12320d.backgroundColor)));
        int i16 = 0;
        while (i16 < webViewSubtitleOutput.f12319c.size()) {
            Cue cue3 = (Cue) webViewSubtitleOutput.f12319c.get(i16);
            float f6 = cue3.position;
            if (f6 != -3.4028235E38f) {
                f = f6 * 100.0f;
            } else {
                f = 50.0f;
            }
            int i17 = cue3.positionAnchor;
            int i18 = -50;
            int i19 = -100;
            if (i17 != i14) {
                if (i17 != i12) {
                    i = i13;
                } else {
                    i = -100;
                }
            } else {
                i = -50;
            }
            float f7 = cue3.line;
            if (f7 != -3.4028235E38f) {
                if (cue3.lineType != i14) {
                    Object[] objArr = new Object[i14];
                    objArr[i13] = Float.valueOf(f7 * 100.0f);
                    formatInvariant2 = Util.formatInvariant("%.2f%%", objArr);
                    if (cue3.verticalType == i14) {
                        int i20 = cue3.lineAnchor;
                        if (i20 != i14) {
                            if (i20 != i12) {
                                i11 = i13;
                            } else {
                                i11 = -100;
                            }
                        } else {
                            i11 = -50;
                        }
                        i19 = -i11;
                    } else {
                        int i21 = cue3.lineAnchor;
                        if (i21 != i14) {
                            if (i21 != i12) {
                                i18 = i13;
                            } else {
                                i18 = -100;
                            }
                        }
                        i19 = i18;
                    }
                } else {
                    if (f7 >= RecyclerView.f7068F0) {
                        Object[] objArr2 = new Object[i14];
                        objArr2[i13] = Float.valueOf(f7 * f5);
                        formatInvariant2 = Util.formatInvariant("%.2fem", objArr2);
                        i2 = i13;
                        i19 = i2;
                    } else {
                        Object[] objArr3 = new Object[i14];
                        objArr3[i13] = Float.valueOf(((-f7) - 1.0f) * f5);
                        formatInvariant2 = Util.formatInvariant("%.2fem", objArr3);
                        i19 = i13;
                        i2 = i14;
                    }
                    f2 = cue3.size;
                    if (f2 == -3.4028235E38f) {
                        Object[] objArr4 = new Object[i14];
                        objArr4[i13] = Float.valueOf(f2 * 100.0f);
                        str = Util.formatInvariant("%.2f%%", objArr4);
                    } else {
                        str = "fit-content";
                    }
                    alignment = cue3.textAlignment;
                    if (alignment != null) {
                        int i22 = x43.f28440a[alignment.ordinal()];
                        if (i22 == i14) {
                            obj = "start";
                        } else if (i22 == 2) {
                            obj = "end";
                        }
                        i3 = cue3.verticalType;
                        if (i3 != i14) {
                            if (i3 != 2) {
                                str2 = "horizontal-tb";
                            } else {
                                str2 = "vertical-lr";
                            }
                        } else {
                            str2 = "vertical-rl";
                        }
                        String m2957b2 = webViewSubtitleOutput.m2957b(cue3.textSize, cue3.textSizeType);
                        if (cue3.windowColorSet) {
                            i4 = cue3.windowColor;
                        } else {
                            i4 = webViewSubtitleOutput.f12320d.windowColor;
                        }
                        String m8343R2 = yy2.m8343R(i4);
                        i5 = i;
                        i6 = cue3.verticalType;
                        String str17 = "right";
                        String str18 = "top";
                        if (i6 != 1) {
                            if (i6 != 2) {
                                if (i2 != 0) {
                                    str18 = "bottom";
                                }
                                str17 = str18;
                                str18 = "left";
                            }
                        }
                        if (i6 == 2 && i6 != 1) {
                            str3 = "width";
                            i7 = i5;
                        } else {
                            str3 = "height";
                            i7 = i19;
                            i19 = i5;
                        }
                        charSequence = cue3.text;
                        StringBuilder sb2 = sb;
                        float f8 = getContext().getResources().getDisplayMetrics().density;
                        Pattern pattern = yl2.f29015a;
                        if (charSequence != null) {
                            str4 = "";
                            if (!(charSequence instanceof Spanned)) {
                                str8 = str3;
                                str9 = formatInvariant2;
                                str7 = str;
                                str6 = str2;
                                str5 = m2957b2;
                                spannedToHtmlConverter$HtmlAndCss = new SpannedToHtmlConverter$HtmlAndCss(yl2.m8310a(charSequence), ImmutableMap.m3923of());
                                str10 = str16;
                                obj2 = obj;
                                cue = cue3;
                            } else {
                                Spanned spanned = (Spanned) charSequence;
                                HashSet hashSet = new HashSet();
                                str5 = m2957b2;
                                str6 = str2;
                                obj2 = obj;
                                BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
                                int length = backgroundColorSpanArr.length;
                                int i23 = 0;
                                while (i23 < length) {
                                    hashSet.add(Integer.valueOf(backgroundColorSpanArr[i23].getBackgroundColor()));
                                    i23++;
                                    backgroundColorSpanArr = backgroundColorSpanArr;
                                }
                                HashMap hashMap2 = new HashMap();
                                Iterator it = hashSet.iterator();
                                while (it.hasNext()) {
                                    int intValue = ((Integer) it.next()).intValue();
                                    String m8291k = ye0.m8291k(intValue, "bg_");
                                    hashMap2.put("." + m8291k + ",." + m8291k + " *", Util.formatInvariant(str16, yy2.m8343R(intValue)));
                                    it = it;
                                    str = str;
                                }
                                str7 = str;
                                SparseArray sparseArray = new SparseArray();
                                Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
                                int length2 = spans.length;
                                int i24 = 0;
                                while (i24 < length2) {
                                    String str19 = str16;
                                    Object obj4 = spans[i24];
                                    Object[] objArr5 = spans;
                                    boolean z2 = obj4 instanceof StrikethroughSpan;
                                    String str20 = null;
                                    if (z2) {
                                        str11 = str3;
                                        str12 = formatInvariant2;
                                        f3 = f8;
                                        cue2 = cue3;
                                        formatInvariant3 = "<span style='text-decoration:line-through;'>";
                                        i8 = length2;
                                    } else {
                                        i8 = length2;
                                        if (obj4 instanceof ForegroundColorSpan) {
                                            str11 = str3;
                                            str12 = formatInvariant2;
                                            formatInvariant3 = Util.formatInvariant("<span style='color:%s;'>", yy2.m8343R(((ForegroundColorSpan) obj4).getForegroundColor()));
                                        } else {
                                            str11 = str3;
                                            str12 = formatInvariant2;
                                            if (obj4 instanceof BackgroundColorSpan) {
                                                formatInvariant3 = Util.formatInvariant("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj4).getBackgroundColor()));
                                            } else if (obj4 instanceof HorizontalTextInVerticalContextSpan) {
                                                formatInvariant3 = "<span style='text-combine-upright:all;'>";
                                            } else if (obj4 instanceof AbsoluteSizeSpan) {
                                                AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj4;
                                                if (absoluteSizeSpan.getDip()) {
                                                    size = absoluteSizeSpan.getSize();
                                                } else {
                                                    size = absoluteSizeSpan.getSize() / f8;
                                                }
                                                formatInvariant3 = Util.formatInvariant("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
                                            } else if (obj4 instanceof RelativeSizeSpan) {
                                                formatInvariant3 = Util.formatInvariant("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj4).getSizeChange() * 100.0f));
                                            } else {
                                                if (obj4 instanceof TypefaceSpan) {
                                                    String family = ((TypefaceSpan) obj4).getFamily();
                                                    if (family != null) {
                                                        f3 = f8;
                                                        formatInvariant3 = Util.formatInvariant("<span style='font-family:\"%s\";'>", family);
                                                    } else {
                                                        f3 = f8;
                                                        formatInvariant3 = null;
                                                    }
                                                } else {
                                                    f3 = f8;
                                                    if (obj4 instanceof StyleSpan) {
                                                        int style = ((StyleSpan) obj4).getStyle();
                                                        if (style != 1) {
                                                            if (style != 2) {
                                                                if (style == 3) {
                                                                    formatInvariant3 = "<b><i>";
                                                                }
                                                                cue2 = cue3;
                                                                formatInvariant3 = null;
                                                            } else {
                                                                formatInvariant3 = "<i>";
                                                            }
                                                        } else {
                                                            formatInvariant3 = "<b>";
                                                        }
                                                    } else if (obj4 instanceof RubySpan) {
                                                        int i25 = ((RubySpan) obj4).position;
                                                        if (i25 != -1) {
                                                            if (i25 != 1) {
                                                                if (i25 == 2) {
                                                                    formatInvariant3 = "<ruby style='ruby-position:under;'>";
                                                                }
                                                                cue2 = cue3;
                                                                formatInvariant3 = null;
                                                            } else {
                                                                formatInvariant3 = "<ruby style='ruby-position:over;'>";
                                                            }
                                                        } else {
                                                            formatInvariant3 = "<ruby style='ruby-position:unset;'>";
                                                        }
                                                    } else if (obj4 instanceof UnderlineSpan) {
                                                        formatInvariant3 = "<u>";
                                                    } else {
                                                        if (obj4 instanceof TextEmphasisSpan) {
                                                            TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan) obj4;
                                                            int i26 = textEmphasisSpan.markShape;
                                                            int i27 = textEmphasisSpan.markFill;
                                                            StringBuilder sb3 = new StringBuilder();
                                                            cue2 = cue3;
                                                            if (i27 != 1) {
                                                                i9 = 2;
                                                                if (i27 == 2) {
                                                                    sb3.append("open ");
                                                                }
                                                            } else {
                                                                i9 = 2;
                                                                sb3.append("filled ");
                                                            }
                                                            if (i26 != 0) {
                                                                if (i26 != 1) {
                                                                    if (i26 != i9) {
                                                                        if (i26 != 3) {
                                                                            sb3.append("unset");
                                                                        } else {
                                                                            sb3.append("sesame");
                                                                        }
                                                                    } else {
                                                                        sb3.append("dot");
                                                                    }
                                                                } else {
                                                                    sb3.append("circle");
                                                                }
                                                            } else {
                                                                sb3.append(SchedulerSupport.NONE);
                                                            }
                                                            String sb4 = sb3.toString();
                                                            if (textEmphasisSpan.position != 2) {
                                                                str13 = "over right";
                                                            } else {
                                                                str13 = "under left";
                                                            }
                                                            formatInvariant3 = Util.formatInvariant("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", sb4, str13);
                                                        }
                                                        cue2 = cue3;
                                                        formatInvariant3 = null;
                                                    }
                                                }
                                                cue2 = cue3;
                                            }
                                        }
                                        f3 = f8;
                                        cue2 = cue3;
                                    }
                                    if (z2 || (obj4 instanceof ForegroundColorSpan) || (obj4 instanceof BackgroundColorSpan) || (obj4 instanceof HorizontalTextInVerticalContextSpan) || (obj4 instanceof AbsoluteSizeSpan) || (obj4 instanceof RelativeSizeSpan) || (obj4 instanceof TextEmphasisSpan)) {
                                        str14 = "</span>";
                                    } else {
                                        if (obj4 instanceof TypefaceSpan) {
                                            if (((TypefaceSpan) obj4).getFamily() != null) {
                                                str20 = "</span>";
                                            }
                                        } else if (obj4 instanceof StyleSpan) {
                                            int style2 = ((StyleSpan) obj4).getStyle();
                                            if (style2 != 1) {
                                                if (style2 != 2) {
                                                    if (style2 == 3) {
                                                        str20 = "</i></b>";
                                                    }
                                                } else {
                                                    str20 = "</i>";
                                                }
                                            } else {
                                                str20 = "</b>";
                                            }
                                        } else if (obj4 instanceof RubySpan) {
                                            str20 = "<rt>" + yl2.m8310a(((RubySpan) obj4).rubyText) + "</rt></ruby>";
                                        } else if (obj4 instanceof UnderlineSpan) {
                                            str20 = "</u>";
                                        }
                                        str14 = str20;
                                    }
                                    int spanStart = spanned.getSpanStart(obj4);
                                    int spanEnd = spanned.getSpanEnd(obj4);
                                    if (formatInvariant3 != null) {
                                        Assertions.checkNotNull(str14);
                                        wl2 wl2Var = new wl2(spanStart, formatInvariant3, str14, spanEnd);
                                        xl2 xl2Var = (xl2) sparseArray.get(spanStart);
                                        if (xl2Var == null) {
                                            xl2Var = new xl2();
                                            sparseArray.put(spanStart, xl2Var);
                                        }
                                        xl2Var.f28620a.add(wl2Var);
                                        xl2 xl2Var2 = (xl2) sparseArray.get(spanEnd);
                                        if (xl2Var2 == null) {
                                            xl2Var2 = new xl2();
                                            sparseArray.put(spanEnd, xl2Var2);
                                        }
                                        xl2Var2.f28621b.add(wl2Var);
                                    }
                                    i24++;
                                    str16 = str19;
                                    spans = objArr5;
                                    length2 = i8;
                                    str3 = str11;
                                    formatInvariant2 = str12;
                                    f8 = f3;
                                    cue3 = cue2;
                                }
                                str8 = str3;
                                str9 = formatInvariant2;
                                str10 = str16;
                                cue = cue3;
                                StringBuilder sb5 = new StringBuilder(spanned.length());
                                int i28 = 0;
                                int i29 = 0;
                                while (i28 < sparseArray.size()) {
                                    int keyAt = sparseArray.keyAt(i28);
                                    sb5.append(yl2.m8310a(spanned.subSequence(i29, keyAt)));
                                    xl2 xl2Var3 = (xl2) sparseArray.get(keyAt);
                                    Collections.sort(xl2Var3.f28621b, wl2.f28227f);
                                    Iterator it2 = xl2Var3.f28621b.iterator();
                                    while (it2.hasNext()) {
                                        sb5.append(((wl2) it2.next()).f28231d);
                                    }
                                    ArrayList arrayList = xl2Var3.f28620a;
                                    Collections.sort(arrayList, wl2.f28226e);
                                    Iterator it3 = arrayList.iterator();
                                    while (it3.hasNext()) {
                                        sb5.append(((wl2) it3.next()).f28230c);
                                    }
                                    i28++;
                                    i29 = keyAt;
                                }
                                sb5.append(yl2.m8310a(spanned.subSequence(i29, spanned.length())));
                                spannedToHtmlConverter$HtmlAndCss = new SpannedToHtmlConverter$HtmlAndCss(sb5.toString(), hashMap2);
                            }
                        } else {
                            spannedToHtmlConverter$HtmlAndCss = new SpannedToHtmlConverter$HtmlAndCss("", ImmutableMap.m3923of());
                            str8 = str3;
                            str9 = formatInvariant2;
                            str7 = str;
                            str6 = str2;
                            str5 = m2957b2;
                            str10 = str16;
                            obj2 = obj;
                            cue = cue3;
                            str4 = "";
                        }
                        for (String str21 : hashMap.keySet()) {
                            String str22 = (String) hashMap.put(str21, (String) hashMap.get(str21));
                            if (str22 != null && !str22.equals(hashMap.get(str21))) {
                                z = false;
                            } else {
                                z = true;
                            }
                            Assertions.checkState(z);
                        }
                        Integer valueOf2 = Integer.valueOf(i16);
                        Float valueOf3 = Float.valueOf(f);
                        Integer valueOf4 = Integer.valueOf(i7);
                        Integer valueOf5 = Integer.valueOf(i19);
                        Cue cue4 = cue;
                        f4 = cue4.shearDegrees;
                        if (f4 != RecyclerView.f7068F0) {
                            int i30 = cue4.verticalType;
                            c = 2;
                            c2 = 1;
                            if (i30 != 2 && i30 != 1) {
                                str15 = "skewX";
                            } else {
                                str15 = "skewY";
                            }
                            c3 = 0;
                            str4 = Util.formatInvariant("%s(%.2fdeg)", str15, Float.valueOf(f4));
                        } else {
                            c = 2;
                            c2 = 1;
                            c3 = 0;
                        }
                        Object[] objArr6 = new Object[14];
                        objArr6[c3] = valueOf2;
                        objArr6[c2] = str18;
                        objArr6[c] = valueOf3;
                        objArr6[3] = str17;
                        objArr6[4] = str9;
                        objArr6[5] = str8;
                        objArr6[6] = str7;
                        objArr6[7] = obj2;
                        objArr6[8] = str6;
                        objArr6[9] = str5;
                        objArr6[10] = m8343R2;
                        objArr6[11] = valueOf4;
                        objArr6[12] = valueOf5;
                        objArr6[13] = str4;
                        sb2.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr6));
                        sb2.append(Util.formatInvariant("<span class='%s'>", "default_bg"));
                        alignment2 = cue4.multiRowAlignment;
                        if (alignment2 != null) {
                            int i31 = x43.f28440a[alignment2.ordinal()];
                            if (i31 != 1) {
                                i10 = 2;
                                if (i31 == 2) {
                                    obj3 = "end";
                                } else {
                                    obj3 = "center";
                                }
                            } else {
                                i10 = 2;
                                obj3 = "start";
                            }
                            sb2.append(Util.formatInvariant("<span style='display:inline-block; text-align:%s;'>", obj3));
                            sb2.append(spannedToHtmlConverter$HtmlAndCss.html);
                            sb2.append("</span>");
                        } else {
                            i10 = 2;
                            sb2.append(spannedToHtmlConverter$HtmlAndCss.html);
                        }
                        sb2.append("</span></div>");
                        i16++;
                        i14 = 1;
                        i12 = i10;
                        str16 = str10;
                        f5 = 1.2f;
                        sb = sb2;
                        i13 = 0;
                        webViewSubtitleOutput = this;
                    }
                    obj = "center";
                    i3 = cue3.verticalType;
                    if (i3 != i14) {
                    }
                    String m2957b22 = webViewSubtitleOutput.m2957b(cue3.textSize, cue3.textSizeType);
                    if (cue3.windowColorSet) {
                    }
                    String m8343R22 = yy2.m8343R(i4);
                    i5 = i;
                    i6 = cue3.verticalType;
                    String str172 = "right";
                    String str182 = "top";
                    if (i6 != 1) {
                    }
                    if (i6 == 2) {
                    }
                    str3 = "height";
                    i7 = i19;
                    i19 = i5;
                    charSequence = cue3.text;
                    StringBuilder sb22 = sb;
                    float f82 = getContext().getResources().getDisplayMetrics().density;
                    Pattern pattern2 = yl2.f29015a;
                    if (charSequence != null) {
                    }
                    while (r0.hasNext()) {
                    }
                    Integer valueOf22 = Integer.valueOf(i16);
                    Float valueOf32 = Float.valueOf(f);
                    Integer valueOf42 = Integer.valueOf(i7);
                    Integer valueOf52 = Integer.valueOf(i19);
                    Cue cue42 = cue;
                    f4 = cue42.shearDegrees;
                    if (f4 != RecyclerView.f7068F0) {
                    }
                    Object[] objArr62 = new Object[14];
                    objArr62[c3] = valueOf22;
                    objArr62[c2] = str182;
                    objArr62[c] = valueOf32;
                    objArr62[3] = str172;
                    objArr62[4] = str9;
                    objArr62[5] = str8;
                    objArr62[6] = str7;
                    objArr62[7] = obj2;
                    objArr62[8] = str6;
                    objArr62[9] = str5;
                    objArr62[10] = m8343R22;
                    objArr62[11] = valueOf42;
                    objArr62[12] = valueOf52;
                    objArr62[13] = str4;
                    sb22.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr62));
                    sb22.append(Util.formatInvariant("<span class='%s'>", "default_bg"));
                    alignment2 = cue42.multiRowAlignment;
                    if (alignment2 != null) {
                    }
                    sb22.append("</span></div>");
                    i16++;
                    i14 = 1;
                    i12 = i10;
                    str16 = str10;
                    f5 = 1.2f;
                    sb = sb22;
                    i13 = 0;
                    webViewSubtitleOutput = this;
                }
            } else {
                Object[] objArr7 = new Object[i14];
                objArr7[i13] = Float.valueOf((1.0f - webViewSubtitleOutput.f12323g) * 100.0f);
                formatInvariant2 = Util.formatInvariant("%.2f%%", objArr7);
            }
            i2 = i13;
            f2 = cue3.size;
            if (f2 == -3.4028235E38f) {
            }
            alignment = cue3.textAlignment;
            if (alignment != null) {
            }
            obj = "center";
            i3 = cue3.verticalType;
            if (i3 != i14) {
            }
            String m2957b222 = webViewSubtitleOutput.m2957b(cue3.textSize, cue3.textSizeType);
            if (cue3.windowColorSet) {
            }
            String m8343R222 = yy2.m8343R(i4);
            i5 = i;
            i6 = cue3.verticalType;
            String str1722 = "right";
            String str1822 = "top";
            if (i6 != 1) {
            }
            if (i6 == 2) {
            }
            str3 = "height";
            i7 = i19;
            i19 = i5;
            charSequence = cue3.text;
            StringBuilder sb222 = sb;
            float f822 = getContext().getResources().getDisplayMetrics().density;
            Pattern pattern22 = yl2.f29015a;
            if (charSequence != null) {
            }
            while (r0.hasNext()) {
            }
            Integer valueOf222 = Integer.valueOf(i16);
            Float valueOf322 = Float.valueOf(f);
            Integer valueOf422 = Integer.valueOf(i7);
            Integer valueOf522 = Integer.valueOf(i19);
            Cue cue422 = cue;
            f4 = cue422.shearDegrees;
            if (f4 != RecyclerView.f7068F0) {
            }
            Object[] objArr622 = new Object[14];
            objArr622[c3] = valueOf222;
            objArr622[c2] = str1822;
            objArr622[c] = valueOf322;
            objArr622[3] = str1722;
            objArr622[4] = str9;
            objArr622[5] = str8;
            objArr622[6] = str7;
            objArr622[7] = obj2;
            objArr622[8] = str6;
            objArr622[9] = str5;
            objArr622[10] = m8343R222;
            objArr622[11] = valueOf422;
            objArr622[12] = valueOf522;
            objArr622[13] = str4;
            sb222.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr622));
            sb222.append(Util.formatInvariant("<span class='%s'>", "default_bg"));
            alignment2 = cue422.multiRowAlignment;
            if (alignment2 != null) {
            }
            sb222.append("</span></div>");
            i16++;
            i14 = 1;
            i12 = i10;
            str16 = str10;
            f5 = 1.2f;
            sb = sb222;
            i13 = 0;
            webViewSubtitleOutput = this;
        }
        StringBuilder sb6 = sb;
        sb6.append("</div></body></html>");
        StringBuilder sb7 = new StringBuilder("<html><head><style>");
        for (String str23 : hashMap.keySet()) {
            sb7.append(str23);
            sb7.append("{");
            sb7.append((String) hashMap.get(str23));
            sb7.append("}");
        }
        sb7.append("</style></head>");
        sb6.insert(0, sb7.toString());
        this.f12318b.loadData(Base64.encodeToString(sb6.toString().getBytes(Charsets.UTF_8), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.f12319c.isEmpty()) {
            m2958c();
        }
    }
}

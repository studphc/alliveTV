package com.google.android.exoplayer2.p003ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.iq2;
import p000.jq2;
import p000.kq2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CanvasSubtitleOutput extends View implements jq2 {

    /* renamed from: a */
    public final ArrayList f12005a;

    /* renamed from: b */
    public List f12006b;

    /* renamed from: c */
    public int f12007c;

    /* renamed from: d */
    public float f12008d;

    /* renamed from: e */
    public CaptionStyleCompat f12009e;

    /* renamed from: f */
    public float f12010f;

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12005a = new ArrayList();
        this.f12006b = Collections.emptyList();
        this.f12007c = 0;
        this.f12008d = 0.0533f;
        this.f12009e = CaptionStyleCompat.DEFAULT;
        this.f12010f = 0.08f;
    }

    @Override // p000.jq2
    /* renamed from: a */
    public final void mo2890a(List list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.f12006b = list;
        this.f12009e = captionStyleCompat;
        this.f12008d = f;
        this.f12007c = i;
        this.f12010f = f2;
        while (true) {
            ArrayList arrayList = this.f12005a;
            if (arrayList.size() < list.size()) {
                arrayList.add(new iq2(getContext()));
            } else {
                invalidate();
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0485  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void dispatchDraw(Canvas canvas) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        float f;
        boolean z2;
        boolean z3;
        int round;
        float f2;
        int i9;
        float f3;
        SpannableStringBuilder spannableStringBuilder;
        int i10;
        int i11;
        int i12;
        int i13;
        CanvasSubtitleOutput canvasSubtitleOutput = this;
        List list = canvasSubtitleOutput.f12006b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom > paddingTop && width > paddingLeft) {
            int i14 = paddingBottom - paddingTop;
            float m5764b = kq2.m5764b(canvasSubtitleOutput.f12007c, height, i14, canvasSubtitleOutput.f12008d);
            if (m5764b <= RecyclerView.f7068F0) {
                return;
            }
            int size = list.size();
            int i15 = 0;
            while (i15 < size) {
                Cue cue = (Cue) list.get(i15);
                if (cue.verticalType != Integer.MIN_VALUE) {
                    Cue.Builder textAlignment = cue.buildUpon().setPosition(-3.4028235E38f).setPositionAnchor(Integer.MIN_VALUE).setTextAlignment(null);
                    if (cue.lineType == 0) {
                        textAlignment.setLine(1.0f - cue.line, 0);
                    } else {
                        textAlignment.setLine((-cue.line) - 1.0f, 1);
                    }
                    int i16 = cue.lineAnchor;
                    if (i16 != 0) {
                        if (i16 == 2) {
                            textAlignment.setLineAnchor(0);
                        }
                    } else {
                        textAlignment.setLineAnchor(2);
                    }
                    cue = textAlignment.build();
                }
                float m5764b2 = kq2.m5764b(cue.textSizeType, height, i14, cue.textSize);
                iq2 iq2Var = (iq2) canvasSubtitleOutput.f12005a.get(i15);
                CaptionStyleCompat captionStyleCompat = canvasSubtitleOutput.f12009e;
                List list2 = list;
                float f4 = canvasSubtitleOutput.f12010f;
                iq2Var.getClass();
                if (cue.bitmap == null) {
                    z = true;
                } else {
                    z = false;
                }
                int i17 = height;
                if (z) {
                    if (TextUtils.isEmpty(cue.text)) {
                        i5 = paddingLeft;
                        i6 = paddingTop;
                        i7 = width;
                        i8 = paddingBottom;
                        i2 = i14;
                        f = m5764b;
                        i3 = size;
                        i4 = i15;
                        z3 = false;
                        i15 = i4 + 1;
                        canvasSubtitleOutput = this;
                        list = list2;
                        height = i17;
                        i14 = i2;
                        size = i3;
                        paddingLeft = i5;
                        paddingTop = i6;
                        width = i7;
                        paddingBottom = i8;
                        m5764b = f;
                    } else if (cue.windowColorSet) {
                        i = cue.windowColor;
                    } else {
                        i = captionStyleCompat.windowColor;
                    }
                } else {
                    i = ViewCompat.MEASURED_STATE_MASK;
                }
                i2 = i14;
                CharSequence charSequence = iq2Var.f20208i;
                i3 = size;
                CharSequence charSequence2 = cue.text;
                i4 = i15;
                TextPaint textPaint = iq2Var.f20205f;
                if ((charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2))) && Util.areEqual(iq2Var.f20209j, cue.textAlignment) && iq2Var.f20210k == cue.bitmap && iq2Var.f20211l == cue.line && iq2Var.f20212m == cue.lineType && Util.areEqual(Integer.valueOf(iq2Var.f20213n), Integer.valueOf(cue.lineAnchor)) && iq2Var.f20214o == cue.position && Util.areEqual(Integer.valueOf(iq2Var.f20215p), Integer.valueOf(cue.positionAnchor)) && iq2Var.f20216q == cue.size && iq2Var.f20217r == cue.bitmapHeight && iq2Var.f20218s == captionStyleCompat.foregroundColor && iq2Var.f20219t == captionStyleCompat.backgroundColor && iq2Var.f20220u == i && iq2Var.f20222w == captionStyleCompat.edgeType && iq2Var.f20221v == captionStyleCompat.edgeColor && Util.areEqual(textPaint.getTypeface(), captionStyleCompat.typeface) && iq2Var.f20223x == m5764b && iq2Var.f20224y == m5764b2 && iq2Var.f20225z == f4 && iq2Var.f20190A == paddingLeft && iq2Var.f20191B == paddingTop && iq2Var.f20192C == width && iq2Var.f20193D == paddingBottom) {
                    iq2Var.m5339a(canvas, z);
                    i5 = paddingLeft;
                    i6 = paddingTop;
                    i7 = width;
                    i8 = paddingBottom;
                    f = m5764b;
                    z3 = false;
                    i15 = i4 + 1;
                    canvasSubtitleOutput = this;
                    list = list2;
                    height = i17;
                    i14 = i2;
                    size = i3;
                    paddingLeft = i5;
                    paddingTop = i6;
                    width = i7;
                    paddingBottom = i8;
                    m5764b = f;
                } else {
                    iq2Var.f20208i = cue.text;
                    iq2Var.f20209j = cue.textAlignment;
                    iq2Var.f20210k = cue.bitmap;
                    iq2Var.f20211l = cue.line;
                    iq2Var.f20212m = cue.lineType;
                    iq2Var.f20213n = cue.lineAnchor;
                    iq2Var.f20214o = cue.position;
                    iq2Var.f20215p = cue.positionAnchor;
                    iq2Var.f20216q = cue.size;
                    iq2Var.f20217r = cue.bitmapHeight;
                    iq2Var.f20218s = captionStyleCompat.foregroundColor;
                    iq2Var.f20219t = captionStyleCompat.backgroundColor;
                    iq2Var.f20220u = i;
                    iq2Var.f20222w = captionStyleCompat.edgeType;
                    iq2Var.f20221v = captionStyleCompat.edgeColor;
                    textPaint.setTypeface(captionStyleCompat.typeface);
                    iq2Var.f20223x = m5764b;
                    iq2Var.f20224y = m5764b2;
                    iq2Var.f20225z = f4;
                    iq2Var.f20190A = paddingLeft;
                    iq2Var.f20191B = paddingTop;
                    iq2Var.f20192C = width;
                    iq2Var.f20193D = paddingBottom;
                    if (z) {
                        Assertions.checkNotNull(iq2Var.f20208i);
                        CharSequence charSequence3 = iq2Var.f20208i;
                        if (charSequence3 instanceof SpannableStringBuilder) {
                            spannableStringBuilder = (SpannableStringBuilder) charSequence3;
                        } else {
                            spannableStringBuilder = new SpannableStringBuilder(iq2Var.f20208i);
                        }
                        int i18 = iq2Var.f20192C - iq2Var.f20190A;
                        int i19 = iq2Var.f20193D - iq2Var.f20191B;
                        textPaint.setTextSize(iq2Var.f20223x);
                        int i20 = (int) ((iq2Var.f20223x * 0.125f) + 0.5f);
                        int i21 = i20 * 2;
                        int i22 = i18 - i21;
                        float f5 = iq2Var.f20216q;
                        if (f5 != -3.4028235E38f) {
                            i22 = (int) (i22 * f5);
                        }
                        if (i22 <= 0) {
                            Log.m3027w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                            z2 = z;
                            i5 = paddingLeft;
                            i6 = paddingTop;
                            i7 = width;
                            i8 = paddingBottom;
                            f = m5764b;
                        } else {
                            i5 = paddingLeft;
                            i6 = paddingTop;
                            if (iq2Var.f20224y > RecyclerView.f7068F0) {
                                i7 = width;
                                i8 = paddingBottom;
                                i10 = 0;
                                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) iq2Var.f20224y), 0, spannableStringBuilder.length(), 16711680);
                            } else {
                                i7 = width;
                                i8 = paddingBottom;
                                i10 = 0;
                            }
                            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                            if (iq2Var.f20222w == 1) {
                                ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i10, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                                int i23 = 0;
                                for (int length = foregroundColorSpanArr.length; i23 < length; length = length) {
                                    spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i23]);
                                    i23++;
                                }
                            }
                            if (Color.alpha(iq2Var.f20219t) > 0) {
                                int i24 = iq2Var.f20222w;
                                if (i24 == 0 || i24 == 2) {
                                    f = m5764b;
                                    spannableStringBuilder.setSpan(new BackgroundColorSpan(iq2Var.f20219t), 0, spannableStringBuilder.length(), 16711680);
                                } else {
                                    f = m5764b;
                                    spannableStringBuilder2.setSpan(new BackgroundColorSpan(iq2Var.f20219t), 0, spannableStringBuilder2.length(), 16711680);
                                }
                            } else {
                                f = m5764b;
                            }
                            Layout.Alignment alignment = iq2Var.f20209j;
                            if (alignment == null) {
                                alignment = Layout.Alignment.ALIGN_CENTER;
                            }
                            StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, textPaint, i22, alignment, iq2Var.f20203d, iq2Var.f20204e, true);
                            iq2Var.f20194E = staticLayout;
                            int height2 = staticLayout.getHeight();
                            int lineCount = iq2Var.f20194E.getLineCount();
                            z2 = z;
                            int i25 = 0;
                            int i26 = 0;
                            while (i26 < lineCount) {
                                i25 = Math.max((int) Math.ceil(iq2Var.f20194E.getLineWidth(i26)), i25);
                                i26++;
                                lineCount = lineCount;
                                spannableStringBuilder2 = spannableStringBuilder2;
                                alignment = alignment;
                            }
                            SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder2;
                            Layout.Alignment alignment2 = alignment;
                            if (iq2Var.f20216q == -3.4028235E38f || i25 >= i22) {
                                i22 = i25;
                            }
                            int i27 = i22 + i21;
                            float f6 = iq2Var.f20214o;
                            if (f6 != -3.4028235E38f) {
                                int round2 = Math.round(i18 * f6);
                                int i28 = iq2Var.f20190A;
                                int i29 = round2 + i28;
                                int i30 = iq2Var.f20215p;
                                if (i30 != 1) {
                                    if (i30 == 2) {
                                        i29 -= i27;
                                    }
                                } else {
                                    i29 = ((i29 * 2) - i27) / 2;
                                }
                                i11 = Math.max(i29, i28);
                                i12 = Math.min(i27 + i11, iq2Var.f20192C);
                            } else {
                                i11 = iq2Var.f20190A + ((i18 - i27) / 2);
                                i12 = i11 + i27;
                            }
                            int i31 = i12 - i11;
                            if (i31 <= 0) {
                                Log.m3027w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
                            } else {
                                float f7 = iq2Var.f20211l;
                                if (f7 != -3.4028235E38f) {
                                    if (iq2Var.f20212m == 0) {
                                        i13 = Math.round(i19 * f7) + iq2Var.f20191B;
                                        int i32 = iq2Var.f20213n;
                                        if (i32 == 2) {
                                            i13 -= height2;
                                        } else if (i32 == 1) {
                                            i13 = ((i13 * 2) - height2) / 2;
                                        }
                                        z3 = false;
                                    } else {
                                        int lineBottom = iq2Var.f20194E.getLineBottom(0) - iq2Var.f20194E.getLineTop(0);
                                        float f8 = iq2Var.f20211l;
                                        z3 = false;
                                        if (f8 >= RecyclerView.f7068F0) {
                                            i13 = Math.round(f8 * lineBottom) + iq2Var.f20191B;
                                        } else {
                                            i13 = (Math.round((f8 + 1.0f) * lineBottom) + iq2Var.f20193D) - height2;
                                        }
                                    }
                                    int i33 = i13 + height2;
                                    int i34 = iq2Var.f20193D;
                                    if (i33 > i34) {
                                        i13 = i34 - height2;
                                    } else {
                                        int i35 = iq2Var.f20191B;
                                        if (i13 < i35) {
                                            i13 = i35;
                                        }
                                    }
                                } else {
                                    z3 = false;
                                    i13 = (iq2Var.f20193D - height2) - ((int) (i19 * iq2Var.f20225z));
                                }
                                iq2Var.f20194E = new StaticLayout(spannableStringBuilder, textPaint, i31, alignment2, iq2Var.f20203d, iq2Var.f20204e, true);
                                iq2Var.f20195F = new StaticLayout(spannableStringBuilder3, textPaint, i31, alignment2, iq2Var.f20203d, iq2Var.f20204e, true);
                                iq2Var.f20196G = i11;
                                iq2Var.f20197H = i13;
                                iq2Var.f20198I = i20;
                            }
                        }
                        z3 = false;
                    } else {
                        z2 = z;
                        i5 = paddingLeft;
                        i6 = paddingTop;
                        i7 = width;
                        i8 = paddingBottom;
                        f = m5764b;
                        z3 = false;
                        Assertions.checkNotNull(iq2Var.f20210k);
                        Bitmap bitmap = iq2Var.f20210k;
                        int i36 = iq2Var.f20192C;
                        int i37 = iq2Var.f20190A;
                        int i38 = iq2Var.f20193D;
                        int i39 = iq2Var.f20191B;
                        float f9 = i36 - i37;
                        float f10 = (iq2Var.f20214o * f9) + i37;
                        float f11 = i38 - i39;
                        float f12 = (iq2Var.f20211l * f11) + i39;
                        int round3 = Math.round(f9 * iq2Var.f20216q);
                        float f13 = iq2Var.f20217r;
                        if (f13 != -3.4028235E38f) {
                            round = Math.round(f11 * f13);
                        } else {
                            round = Math.round((bitmap.getHeight() / bitmap.getWidth()) * round3);
                        }
                        int i40 = iq2Var.f20215p;
                        if (i40 == 2) {
                            f2 = round3;
                        } else {
                            if (i40 == 1) {
                                f2 = round3 / 2;
                            }
                            int round4 = Math.round(f10);
                            i9 = iq2Var.f20213n;
                            if (i9 != 2) {
                                f3 = round;
                            } else {
                                if (i9 == 1) {
                                    f3 = round / 2;
                                }
                                int round5 = Math.round(f12);
                                iq2Var.f20199J = new Rect(round4, round5, round3 + round4, round + round5);
                            }
                            f12 -= f3;
                            int round52 = Math.round(f12);
                            iq2Var.f20199J = new Rect(round4, round52, round3 + round4, round + round52);
                        }
                        f10 -= f2;
                        int round42 = Math.round(f10);
                        i9 = iq2Var.f20213n;
                        if (i9 != 2) {
                        }
                        f12 -= f3;
                        int round522 = Math.round(f12);
                        iq2Var.f20199J = new Rect(round42, round522, round3 + round42, round + round522);
                    }
                    iq2Var.m5339a(canvas, z2);
                    i15 = i4 + 1;
                    canvasSubtitleOutput = this;
                    list = list2;
                    height = i17;
                    i14 = i2;
                    size = i3;
                    paddingLeft = i5;
                    paddingTop = i6;
                    width = i7;
                    paddingBottom = i8;
                    m5764b = f;
                }
            }
        }
    }
}

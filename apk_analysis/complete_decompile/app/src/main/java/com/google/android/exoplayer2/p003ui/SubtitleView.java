package com.google.android.exoplayer2.p003ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.span.LanguageFeatureSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.jq2;
import p000.kq2;

/* loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int VIEW_TYPE_CANVAS = 1;
    public static final int VIEW_TYPE_WEB = 2;

    /* renamed from: a */
    public List f12280a;

    /* renamed from: b */
    public CaptionStyleCompat f12281b;

    /* renamed from: c */
    public int f12282c;

    /* renamed from: d */
    public float f12283d;

    /* renamed from: e */
    public float f12284e;

    /* renamed from: f */
    public boolean f12285f;

    /* renamed from: g */
    public boolean f12286g;

    /* renamed from: h */
    public int f12287h;

    /* renamed from: i */
    public jq2 f12288i;

    /* renamed from: j */
    public View f12289j;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ViewType {
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.f12285f && this.f12286g) {
            return this.f12280a;
        }
        ArrayList arrayList = new ArrayList(this.f12280a.size());
        for (int i = 0; i < this.f12280a.size(); i++) {
            Cue.Builder buildUpon = ((Cue) this.f12280a.get(i)).buildUpon();
            if (!this.f12285f) {
                buildUpon.clearWindowColor();
                if (buildUpon.getText() instanceof Spanned) {
                    if (!(buildUpon.getText() instanceof Spannable)) {
                        buildUpon.setText(SpannableString.valueOf(buildUpon.getText()));
                    }
                    Spannable spannable = (Spannable) Assertions.checkNotNull(buildUpon.getText());
                    for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                        if (!(obj instanceof LanguageFeatureSpan)) {
                            spannable.removeSpan(obj);
                        }
                    }
                }
                kq2.m5763a(buildUpon);
            } else if (!this.f12286g) {
                kq2.m5763a(buildUpon);
            }
            arrayList.add(buildUpon.build());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (Util.SDK_INT < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        if (Util.SDK_INT >= 19 && !isInEditMode()) {
            CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
            if (captioningManager != null && captioningManager.isEnabled()) {
                return CaptionStyleCompat.createFromCaptionStyle(captioningManager.getUserStyle());
            }
            return CaptionStyleCompat.DEFAULT;
        }
        return CaptionStyleCompat.DEFAULT;
    }

    private <T extends View & jq2> void setView(T t) {
        removeView(this.f12289j);
        View view = this.f12289j;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).f12318b.destroy();
        }
        this.f12289j = t;
        this.f12288i = t;
        addView(t);
    }

    /* renamed from: a */
    public final void m2953a() {
        this.f12288i.mo2890a(getCuesWithStylingPreferencesApplied(), this.f12281b, this.f12283d, this.f12282c, this.f12284e);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.f12286g = z;
        m2953a();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.f12285f = z;
        m2953a();
    }

    public void setBottomPaddingFraction(float f) {
        this.f12284e = f;
        m2953a();
    }

    public void setCues(@Nullable List<Cue> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f12280a = list;
        m2953a();
    }

    public void setFixedTextSize(@Dimension int i, float f) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, resources.getDisplayMetrics());
        this.f12282c = 2;
        this.f12283d = applyDimension;
        m2953a();
    }

    public void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.f12281b = captionStyleCompat;
        m2953a();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i) {
        if (this.f12287h == i) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                setView(new WebViewSubtitleOutput(getContext(), null));
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            setView(new CanvasSubtitleOutput(getContext(), null));
        }
        this.f12287h = i;
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12280a = Collections.emptyList();
        this.f12281b = CaptionStyleCompat.DEFAULT;
        this.f12282c = 0;
        this.f12283d = 0.0533f;
        this.f12284e = 0.08f;
        this.f12285f = true;
        this.f12286g = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, null);
        this.f12288i = canvasSubtitleOutput;
        this.f12289j = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.f12287h = 1;
    }

    public void setFractionalTextSize(float f, boolean z) {
        this.f12282c = z ? 1 : 0;
        this.f12283d = f;
        m2953a();
    }
}

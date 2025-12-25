package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.LocaleList;
import android.os.Trace;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import p000.hm1;
import p000.q62;

/* loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {

    /* renamed from: e */
    public static final Object f3784e = new Object();

    /* renamed from: f */
    public static ExecutorService f3785f;

    /* renamed from: a */
    public final Spannable f3786a;

    /* renamed from: b */
    public final Params f3787b;

    /* renamed from: c */
    public final int[] f3788c;

    /* renamed from: d */
    public final PrecomputedText f3789d;

    public PrecomputedTextCompat(CharSequence charSequence, Params params, int[] iArr) {
        this.f3786a = new SpannableString(charSequence);
        this.f3787b = params;
        this.f3788c = iArr;
        this.f3789d = null;
    }

    @SuppressLint({"WrongConstant"})
    public static PrecomputedTextCompat create(@NonNull CharSequence charSequence, @NonNull Params params) {
        PrecomputedText.Params params2;
        PrecomputedText create;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(params);
        try {
            Trace.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params2 = params.f3794e) != null) {
                create = PrecomputedText.create(charSequence, params2);
                return new PrecomputedTextCompat(create, params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int indexOf = TextUtils.indexOf(charSequence, '\n', i, length);
                if (indexOf < 0) {
                    i = length;
                } else {
                    i = indexOf + 1;
                }
                arrayList.add(Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
            return new PrecomputedTextCompat(charSequence, params, iArr);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.core.text.a, java.lang.Object, java.util.concurrent.Callable] */
    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence charSequence, @NonNull Params params, @Nullable Executor executor) {
        ?? obj = new Object();
        obj.f3799a = params;
        obj.f3800b = charSequence;
        FutureTask futureTask = new FutureTask(obj);
        if (executor == null) {
            synchronized (f3784e) {
                try {
                    if (f3785f == null) {
                        f3785f = Executors.newFixedThreadPool(1);
                    }
                    executor = f3785f;
                } finally {
                }
            }
        }
        executor.execute(futureTask);
        return futureTask;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f3786a.charAt(i);
    }

    @IntRange(from = 0)
    public int getParagraphCount() {
        int paragraphCount;
        if (Build.VERSION.SDK_INT >= 29) {
            paragraphCount = this.f3789d.getParagraphCount();
            return paragraphCount;
        }
        return this.f3788c.length;
    }

    @IntRange(from = 0)
    public int getParagraphEnd(@IntRange(from = 0) int i) {
        int paragraphEnd;
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            paragraphEnd = this.f3789d.getParagraphEnd(i);
            return paragraphEnd;
        }
        return this.f3788c[i];
    }

    @IntRange(from = 0)
    public int getParagraphStart(@IntRange(from = 0) int i) {
        int paragraphStart;
        Preconditions.checkArgumentInRange(i, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            paragraphStart = this.f3789d.getParagraphStart(i);
            return paragraphStart;
        }
        if (i == 0) {
            return 0;
        }
        return this.f3788c[i - 1];
    }

    @NonNull
    public Params getParams() {
        return this.f3787b;
    }

    @Nullable
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.f3786a;
        if (hm1.m5118z(spannable)) {
            return hm1.m5106n(spannable);
        }
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f3786a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f3786a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f3786a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        Object[] spans;
        if (Build.VERSION.SDK_INT >= 29) {
            spans = this.f3789d.getSpans(i, i2, cls);
            return (T[]) spans;
        }
        return (T[]) this.f3786a.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f3786a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f3786a.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3789d.removeSpan(obj);
                return;
            } else {
                this.f3786a.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3789d.setSpan(obj, i, i2, i3);
                return;
            } else {
                this.f3786a.setSpan(obj, i, i2, i3);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f3786a.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    @NonNull
    public String toString() {
        return this.f3786a.toString();
    }

    public PrecomputedTextCompat(PrecomputedText precomputedText, Params params) {
        this.f3786a = q62.m7001a(precomputedText);
        this.f3787b = params;
        this.f3788c = null;
        this.f3789d = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    /* loaded from: classes.dex */
    public static final class Params {

        /* renamed from: a */
        public final TextPaint f3790a;

        /* renamed from: b */
        public final TextDirectionHeuristic f3791b;

        /* renamed from: c */
        public final int f3792c;

        /* renamed from: d */
        public final int f3793d;

        /* renamed from: e */
        public final PrecomputedText.Params f3794e;

        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a */
            public final TextPaint f3795a;

            /* renamed from: c */
            public int f3797c = 1;

            /* renamed from: d */
            public int f3798d = 1;

            /* renamed from: b */
            public TextDirectionHeuristic f3796b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public Builder(@NonNull TextPaint textPaint) {
                this.f3795a = textPaint;
            }

            @NonNull
            public Params build() {
                return new Params(this.f3795a, this.f3796b, this.f3797c, this.f3798d);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int i) {
                this.f3797c = i;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int i) {
                this.f3798d = i;
                return this;
            }

            public Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f3796b = textDirectionHeuristic;
                return this;
            }
        }

        public Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            PrecomputedText.Params.Builder breakStrategy;
            PrecomputedText.Params.Builder hyphenationFrequency;
            PrecomputedText.Params.Builder textDirection;
            PrecomputedText.Params build;
            if (Build.VERSION.SDK_INT >= 29) {
                breakStrategy = hm1.m5103k(textPaint).setBreakStrategy(i);
                hyphenationFrequency = breakStrategy.setHyphenationFrequency(i2);
                textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
                build = textDirection.build();
                this.f3794e = build;
            } else {
                this.f3794e = null;
            }
            this.f3790a = textPaint;
            this.f3791b = textDirectionHeuristic;
            this.f3792c = i;
            this.f3793d = i2;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (equalsWithoutTextDirection(params) && this.f3791b == params.getTextDirection()) {
                return true;
            }
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params params) {
            LocaleList textLocales;
            LocaleList textLocales2;
            boolean equals;
            int i = Build.VERSION.SDK_INT;
            if (this.f3792c != params.getBreakStrategy() || this.f3793d != params.getHyphenationFrequency()) {
                return false;
            }
            TextPaint textPaint = this.f3790a;
            if (textPaint.getTextSize() != params.getTextPaint().getTextSize() || textPaint.getTextScaleX() != params.getTextPaint().getTextScaleX() || textPaint.getTextSkewX() != params.getTextPaint().getTextSkewX() || textPaint.getLetterSpacing() != params.getTextPaint().getLetterSpacing() || !TextUtils.equals(textPaint.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()) || textPaint.getFlags() != params.getTextPaint().getFlags()) {
                return false;
            }
            if (i >= 24) {
                textLocales = textPaint.getTextLocales();
                textLocales2 = params.getTextPaint().getTextLocales();
                equals = textLocales.equals(textLocales2);
                if (!equals) {
                    return false;
                }
            } else if (!textPaint.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                return false;
            }
            if (textPaint.getTypeface() == null) {
                if (params.getTextPaint().getTypeface() != null) {
                    return false;
                }
                return true;
            }
            if (!textPaint.getTypeface().equals(params.getTextPaint().getTypeface())) {
                return false;
            }
            return true;
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            return this.f3792c;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.f3793d;
        }

        @Nullable
        public TextDirectionHeuristic getTextDirection() {
            return this.f3791b;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.f3790a;
        }

        public int hashCode() {
            LocaleList textLocales;
            TextDirectionHeuristic textDirectionHeuristic = this.f3791b;
            int i = Build.VERSION.SDK_INT;
            int i2 = this.f3793d;
            int i3 = this.f3792c;
            TextPaint textPaint = this.f3790a;
            if (i >= 24) {
                Float valueOf = Float.valueOf(textPaint.getTextSize());
                Float valueOf2 = Float.valueOf(textPaint.getTextScaleX());
                Float valueOf3 = Float.valueOf(textPaint.getTextSkewX());
                Float valueOf4 = Float.valueOf(textPaint.getLetterSpacing());
                Integer valueOf5 = Integer.valueOf(textPaint.getFlags());
                textLocales = textPaint.getTextLocales();
                return ObjectsCompat.hash(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, textLocales, textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i3), Integer.valueOf(i2));
            }
            return ObjectsCompat.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocale(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i3), Integer.valueOf(i2));
        }

        public String toString() {
            String fontVariationSettings;
            LocaleList textLocales;
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sb2 = new StringBuilder("textSize=");
            TextPaint textPaint = this.f3790a;
            sb2.append(textPaint.getTextSize());
            sb.append(sb2.toString());
            sb.append(", textScaleX=" + textPaint.getTextScaleX());
            sb.append(", textSkewX=" + textPaint.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
            sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
            if (i >= 24) {
                StringBuilder sb3 = new StringBuilder(", textLocale=");
                textLocales = textPaint.getTextLocales();
                sb3.append(textLocales);
                sb.append(sb3.toString());
            } else {
                sb.append(", textLocale=" + textPaint.getTextLocale());
            }
            sb.append(", typeface=" + textPaint.getTypeface());
            if (i >= 26) {
                StringBuilder sb4 = new StringBuilder(", variationSettings=");
                fontVariationSettings = textPaint.getFontVariationSettings();
                sb4.append(fontVariationSettings);
                sb.append(sb4.toString());
            }
            sb.append(", textDir=" + this.f3791b);
            sb.append(", breakStrategy=" + this.f3792c);
            sb.append(", hyphenationFrequency=" + this.f3793d);
            sb.append("}");
            return sb.toString();
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params params) {
            TextPaint textPaint;
            TextDirectionHeuristic textDirection;
            int breakStrategy;
            int hyphenationFrequency;
            textPaint = params.getTextPaint();
            this.f3790a = textPaint;
            textDirection = params.getTextDirection();
            this.f3791b = textDirection;
            breakStrategy = params.getBreakStrategy();
            this.f3792c = breakStrategy;
            hyphenationFrequency = params.getHyphenationFrequency();
            this.f3793d = hyphenationFrequency;
            this.f3794e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}

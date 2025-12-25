package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import p000.fp1;

/* loaded from: classes.dex */
public class MotionLabel extends View implements FloatLayout {

    /* renamed from: A */
    public float f3072A;

    /* renamed from: B */
    public float f3073B;

    /* renamed from: C */
    public Drawable f3074C;

    /* renamed from: D */
    public Matrix f3075D;

    /* renamed from: E */
    public Bitmap f3076E;

    /* renamed from: F */
    public BitmapShader f3077F;

    /* renamed from: G */
    public Matrix f3078G;

    /* renamed from: H */
    public float f3079H;

    /* renamed from: I */
    public float f3080I;

    /* renamed from: J */
    public float f3081J;

    /* renamed from: K */
    public float f3082K;

    /* renamed from: L */
    public final Paint f3083L;

    /* renamed from: M */
    public int f3084M;

    /* renamed from: N */
    public Rect f3085N;

    /* renamed from: O */
    public Paint f3086O;

    /* renamed from: P */
    public float f3087P;

    /* renamed from: Q */
    public float f3088Q;

    /* renamed from: R */
    public float f3089R;

    /* renamed from: S */
    public float f3090S;

    /* renamed from: T */
    public float f3091T;

    /* renamed from: a */
    public final TextPaint f3092a;

    /* renamed from: b */
    public Path f3093b;

    /* renamed from: c */
    public int f3094c;

    /* renamed from: d */
    public int f3095d;

    /* renamed from: e */
    public boolean f3096e;

    /* renamed from: f */
    public float f3097f;

    /* renamed from: g */
    public float f3098g;

    /* renamed from: h */
    public ViewOutlineProvider f3099h;

    /* renamed from: i */
    public RectF f3100i;

    /* renamed from: j */
    public float f3101j;

    /* renamed from: k */
    public float f3102k;

    /* renamed from: l */
    public int f3103l;

    /* renamed from: m */
    public int f3104m;

    /* renamed from: n */
    public float f3105n;

    /* renamed from: o */
    public String f3106o;

    /* renamed from: p */
    public boolean f3107p;

    /* renamed from: q */
    public final Rect f3108q;

    /* renamed from: r */
    public int f3109r;

    /* renamed from: s */
    public int f3110s;

    /* renamed from: t */
    public int f3111t;

    /* renamed from: u */
    public int f3112u;

    /* renamed from: v */
    public String f3113v;

    /* renamed from: w */
    public int f3114w;

    /* renamed from: x */
    public int f3115x;

    /* renamed from: y */
    public boolean f3116y;

    /* renamed from: z */
    public float f3117z;

    public MotionLabel(Context context) {
        super(context);
        this.f3092a = new TextPaint();
        this.f3093b = new Path();
        this.f3094c = 65535;
        this.f3095d = 65535;
        this.f3096e = false;
        this.f3097f = RecyclerView.f7068F0;
        this.f3098g = Float.NaN;
        this.f3101j = 48.0f;
        this.f3102k = Float.NaN;
        this.f3105n = RecyclerView.f7068F0;
        this.f3106o = "Hello World";
        this.f3107p = true;
        this.f3108q = new Rect();
        this.f3109r = 1;
        this.f3110s = 1;
        this.f3111t = 1;
        this.f3112u = 1;
        this.f3114w = 8388659;
        this.f3115x = 0;
        this.f3116y = false;
        this.f3079H = Float.NaN;
        this.f3080I = Float.NaN;
        this.f3081J = RecyclerView.f7068F0;
        this.f3082K = RecyclerView.f7068F0;
        this.f3083L = new Paint();
        this.f3084M = 0;
        this.f3088Q = Float.NaN;
        this.f3089R = Float.NaN;
        this.f3090S = Float.NaN;
        this.f3091T = Float.NaN;
        m622b(context, null);
    }

    private float getHorizontalOffset() {
        float f;
        float f2;
        if (Float.isNaN(this.f3102k)) {
            f = 1.0f;
        } else {
            f = this.f3101j / this.f3102k;
        }
        String str = this.f3106o;
        float measureText = this.f3092a.measureText(str, 0, str.length()) * f;
        if (Float.isNaN(this.f3072A)) {
            f2 = getMeasuredWidth();
        } else {
            f2 = this.f3072A;
        }
        return ((this.f3081J + 1.0f) * (((f2 - getPaddingLeft()) - getPaddingRight()) - measureText)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f;
        float f2;
        if (Float.isNaN(this.f3102k)) {
            f = 1.0f;
        } else {
            f = this.f3101j / this.f3102k;
        }
        Paint.FontMetrics fontMetrics = this.f3092a.getFontMetrics();
        if (Float.isNaN(this.f3073B)) {
            f2 = getMeasuredHeight();
        } else {
            f2 = this.f3073B;
        }
        float paddingTop = (f2 - getPaddingTop()) - getPaddingBottom();
        float f3 = fontMetrics.descent;
        float f4 = fontMetrics.ascent;
        return (((1.0f - this.f3082K) * (paddingTop - ((f3 - f4) * f))) / 2.0f) - (f * f4);
    }

    private void setUpTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int i = typedValue.data;
        this.f3094c = i;
        this.f3092a.setColor(i);
    }

    /* renamed from: a */
    public final void m621a(float f) {
        if (!this.f3096e && f == 1.0f) {
            return;
        }
        this.f3093b.reset();
        String str = this.f3106o;
        int length = str.length();
        TextPaint textPaint = this.f3092a;
        Rect rect = this.f3108q;
        textPaint.getTextBounds(str, 0, length, rect);
        this.f3092a.getTextPath(str, 0, length, RecyclerView.f7068F0, RecyclerView.f7068F0, this.f3093b);
        if (f != 1.0f) {
            Log.v("MotionLabel", Debug.getLoc() + " scale " + f);
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            this.f3093b.transform(matrix);
        }
        rect.right--;
        rect.left++;
        rect.bottom++;
        rect.top--;
        RectF rectF = new RectF();
        rectF.bottom = getHeight();
        rectF.right = getWidth();
        this.f3107p = false;
    }

    /* renamed from: b */
    public final void m622b(Context context, AttributeSet attributeSet) {
        Typeface typeface;
        Typeface create;
        int i;
        setUpTheme(context);
        boolean z = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_fontFamily) {
                    this.f3113v = obtainStyledAttributes.getString(index);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_scaleFromTextSize) {
                    this.f3102k = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f3102k);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_textSize) {
                    this.f3101j = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f3101j);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_textStyle) {
                    this.f3103l = obtainStyledAttributes.getInt(index, this.f3103l);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_typeface) {
                    this.f3104m = obtainStyledAttributes.getInt(index, this.f3104m);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_textColor) {
                    this.f3094c = obtainStyledAttributes.getColor(index, this.f3094c);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.f3098g);
                    this.f3098g = dimension;
                    setRound(dimension);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_borderRoundPercent) {
                    float f = obtainStyledAttributes.getFloat(index, this.f3097f);
                    this.f3097f = f;
                    setRoundPercent(f);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.f3115x = obtainStyledAttributes.getInt(index, 0);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textOutlineColor) {
                    this.f3095d = obtainStyledAttributes.getInt(index, this.f3095d);
                    this.f3096e = true;
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textOutlineThickness) {
                    this.f3105n = obtainStyledAttributes.getDimension(index, this.f3105n);
                    this.f3096e = true;
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackground) {
                    this.f3074C = obtainStyledAttributes.getDrawable(index);
                    this.f3096e = true;
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackgroundPanX) {
                    this.f3088Q = obtainStyledAttributes.getFloat(index, this.f3088Q);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackgroundPanY) {
                    this.f3089R = obtainStyledAttributes.getFloat(index, this.f3089R);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textPanX) {
                    this.f3081J = obtainStyledAttributes.getFloat(index, this.f3081J);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textPanY) {
                    this.f3082K = obtainStyledAttributes.getFloat(index, this.f3082K);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackgroundRotate) {
                    this.f3091T = obtainStyledAttributes.getFloat(index, this.f3091T);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textBackgroundZoom) {
                    this.f3090S = obtainStyledAttributes.getFloat(index, this.f3090S);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textureHeight) {
                    this.f3079H = obtainStyledAttributes.getDimension(index, this.f3079H);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textureWidth) {
                    this.f3080I = obtainStyledAttributes.getDimension(index, this.f3080I);
                } else if (index == androidx.constraintlayout.widget.R.styleable.MotionLabel_textureEffect) {
                    this.f3084M = obtainStyledAttributes.getInt(index, this.f3084M);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f3074C != null) {
            this.f3078G = new Matrix();
            int intrinsicWidth = this.f3074C.getIntrinsicWidth();
            int intrinsicHeight = this.f3074C.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                if (Float.isNaN(this.f3080I)) {
                    intrinsicWidth = 128;
                } else {
                    intrinsicWidth = (int) this.f3080I;
                }
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (Float.isNaN(this.f3079H)) {
                    intrinsicHeight = 128;
                } else {
                    intrinsicHeight = (int) this.f3079H;
                }
            }
            if (this.f3084M != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.f3076E = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f3076E);
            this.f3074C.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f3074C.setFilterBitmap(true);
            this.f3074C.draw(canvas);
            if (this.f3084M != 0) {
                Bitmap bitmap = this.f3076E;
                int width = bitmap.getWidth() / 2;
                int height = bitmap.getHeight() / 2;
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
                for (int i3 = 0; i3 < 4 && width >= 32 && height >= 32; i3++) {
                    width /= 2;
                    height /= 2;
                    createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
                }
                this.f3076E = createScaledBitmap;
            }
            Bitmap bitmap2 = this.f3076E;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f3077F = new BitmapShader(bitmap2, tileMode, tileMode);
        }
        this.f3109r = getPaddingLeft();
        this.f3110s = getPaddingRight();
        this.f3111t = getPaddingTop();
        this.f3112u = getPaddingBottom();
        String str = this.f3113v;
        int i4 = this.f3104m;
        int i5 = this.f3103l;
        TextPaint textPaint = this.f3092a;
        if (str != null) {
            typeface = Typeface.create(str, i5);
            if (typeface != null) {
                setTypeface(typeface);
                textPaint.setColor(this.f3094c);
                textPaint.setStrokeWidth(this.f3105n);
                textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                textPaint.setFlags(128);
                setTextSize(this.f3101j);
                textPaint.setAntiAlias(true);
            }
        } else {
            typeface = null;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        float f2 = RecyclerView.f7068F0;
        if (i5 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i5);
            } else {
                create = Typeface.create(typeface, i5);
            }
            setTypeface(create);
            if (create != null) {
                i = create.getStyle();
            } else {
                i = 0;
            }
            int i6 = (~i) & i5;
            if ((i6 & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            if ((i6 & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint.setTextSkewX(f2);
        } else {
            textPaint.setFakeBoldText(false);
            textPaint.setTextSkewX(RecyclerView.f7068F0);
            setTypeface(typeface);
        }
        textPaint.setColor(this.f3094c);
        textPaint.setStrokeWidth(this.f3105n);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setFlags(128);
        setTextSize(this.f3101j);
        textPaint.setAntiAlias(true);
    }

    /* renamed from: c */
    public final void m623c() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        boolean isNaN = Float.isNaN(this.f3088Q);
        float f7 = RecyclerView.f7068F0;
        if (isNaN) {
            f = 0.0f;
        } else {
            f = this.f3088Q;
        }
        if (Float.isNaN(this.f3089R)) {
            f2 = 0.0f;
        } else {
            f2 = this.f3089R;
        }
        if (Float.isNaN(this.f3090S)) {
            f3 = 1.0f;
        } else {
            f3 = this.f3090S;
        }
        if (!Float.isNaN(this.f3091T)) {
            f7 = this.f3091T;
        }
        this.f3078G.reset();
        float width = this.f3076E.getWidth();
        float height = this.f3076E.getHeight();
        if (Float.isNaN(this.f3080I)) {
            f4 = this.f3072A;
        } else {
            f4 = this.f3080I;
        }
        if (Float.isNaN(this.f3079H)) {
            f5 = this.f3073B;
        } else {
            f5 = this.f3079H;
        }
        if (width * f5 < height * f4) {
            f6 = f4 / width;
        } else {
            f6 = f5 / height;
        }
        float f8 = f3 * f6;
        this.f3078G.postScale(f8, f8);
        float f9 = width * f8;
        float f10 = f4 - f9;
        float f11 = f8 * height;
        float f12 = f5 - f11;
        if (!Float.isNaN(this.f3079H)) {
            f12 = this.f3079H / 2.0f;
        }
        if (!Float.isNaN(this.f3080I)) {
            f10 = this.f3080I / 2.0f;
        }
        this.f3078G.postTranslate((((f * f10) + f4) - f9) * 0.5f, (((f2 * f12) + f5) - f11) * 0.5f);
        this.f3078G.postRotate(f7, f4 / 2.0f, f5 / 2.0f);
        this.f3077F.setLocalMatrix(this.f3078G);
    }

    public float getRound() {
        return this.f3098g;
    }

    public float getRoundPercent() {
        return this.f3097f;
    }

    public float getScaleFromTextSize() {
        return this.f3102k;
    }

    public float getTextBackgroundPanX() {
        return this.f3088Q;
    }

    public float getTextBackgroundPanY() {
        return this.f3089R;
    }

    public float getTextBackgroundRotate() {
        return this.f3091T;
    }

    public float getTextBackgroundZoom() {
        return this.f3090S;
    }

    public int getTextOutlineColor() {
        return this.f3095d;
    }

    public float getTextPanX() {
        return this.f3081J;
    }

    public float getTextPanY() {
        return this.f3082K;
    }

    public float getTextureHeight() {
        return this.f3079H;
    }

    public float getTextureWidth() {
        return this.f3080I;
    }

    public Typeface getTypeface() {
        return this.f3092a.getTypeface();
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        boolean isNaN = Float.isNaN(this.f3102k);
        float f = isNaN ? 1.0f : this.f3101j / this.f3102k;
        this.f3072A = i3 - i;
        this.f3073B = i4 - i2;
        if (this.f3116y) {
            Rect rect = this.f3085N;
            TextPaint textPaint = this.f3092a;
            if (rect == null) {
                this.f3086O = new Paint();
                this.f3085N = new Rect();
                this.f3086O.set(textPaint);
                this.f3087P = this.f3086O.getTextSize();
            }
            Paint paint = this.f3086O;
            String str = this.f3106o;
            paint.getTextBounds(str, 0, str.length(), this.f3085N);
            int width = this.f3085N.width();
            int height = (int) (this.f3085N.height() * 1.3f);
            float f2 = (this.f3072A - this.f3110s) - this.f3109r;
            float f3 = (this.f3073B - this.f3112u) - this.f3111t;
            if (isNaN) {
                float f4 = width;
                float f5 = height;
                if (f4 * f3 > f5 * f2) {
                    textPaint.setTextSize((this.f3087P * f2) / f4);
                } else {
                    textPaint.setTextSize((this.f3087P * f3) / f5);
                }
            } else {
                float f6 = width;
                float f7 = height;
                f = f6 * f3 > f7 * f2 ? f2 / f6 : f3 / f7;
            }
        }
        if (this.f3096e || !isNaN) {
            float f8 = i;
            float f9 = i2;
            float f10 = i3;
            float f11 = i4;
            if (this.f3078G != null) {
                this.f3072A = f10 - f8;
                this.f3073B = f11 - f9;
                m623c();
            }
            m621a(f);
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        float f;
        if (Float.isNaN(this.f3102k)) {
            f = 1.0f;
        } else {
            f = this.f3101j / this.f3102k;
        }
        super.onDraw(canvas);
        boolean z = this.f3096e;
        TextPaint textPaint = this.f3092a;
        if (!z && f == 1.0f) {
            canvas.drawText(this.f3106o, this.f3117z + this.f3109r + getHorizontalOffset(), this.f3111t + getVerticalOffset(), textPaint);
            return;
        }
        if (this.f3107p) {
            m621a(f);
        }
        if (this.f3075D == null) {
            this.f3075D = new Matrix();
        }
        if (this.f3096e) {
            Paint paint = this.f3083L;
            paint.set(textPaint);
            this.f3075D.reset();
            float horizontalOffset = this.f3109r + getHorizontalOffset();
            float verticalOffset = this.f3111t + getVerticalOffset();
            this.f3075D.postTranslate(horizontalOffset, verticalOffset);
            this.f3075D.preScale(f, f);
            this.f3093b.transform(this.f3075D);
            if (this.f3077F != null) {
                textPaint.setFilterBitmap(true);
                textPaint.setShader(this.f3077F);
            } else {
                textPaint.setColor(this.f3094c);
            }
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setStrokeWidth(this.f3105n);
            canvas.drawPath(this.f3093b, textPaint);
            if (this.f3077F != null) {
                textPaint.setShader(null);
            }
            textPaint.setColor(this.f3095d);
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.f3105n);
            canvas.drawPath(this.f3093b, textPaint);
            this.f3075D.reset();
            this.f3075D.postTranslate(-horizontalOffset, -verticalOffset);
            this.f3093b.transform(this.f3075D);
            textPaint.set(paint);
            return;
        }
        float horizontalOffset2 = this.f3109r + getHorizontalOffset();
        float verticalOffset2 = this.f3111t + getVerticalOffset();
        this.f3075D.reset();
        this.f3075D.preTranslate(horizontalOffset2, verticalOffset2);
        this.f3093b.transform(this.f3075D);
        textPaint.setColor(this.f3094c);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setStrokeWidth(this.f3105n);
        canvas.drawPath(this.f3093b, textPaint);
        this.f3075D.reset();
        this.f3075D.preTranslate(-horizontalOffset2, -verticalOffset2);
        this.f3093b.transform(this.f3075D);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.f3116y = false;
        this.f3109r = getPaddingLeft();
        this.f3110s = getPaddingRight();
        this.f3111t = getPaddingTop();
        this.f3112u = getPaddingBottom();
        if (mode == 1073741824 && mode2 == 1073741824) {
            if (this.f3115x != 0) {
                this.f3116y = true;
            }
        } else {
            String str = this.f3106o;
            int length = str.length();
            this.f3092a.getTextBounds(str, 0, length, this.f3108q);
            if (mode != 1073741824) {
                size = (int) (r7.width() + 0.99999f);
            }
            size += this.f3109r + this.f3110s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (r6.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f3111t + this.f3112u + fontMetricsInt;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i) {
        if ((i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            i |= GravityCompat.START;
        }
        if ((i & 112) == 0) {
            i |= 48;
        }
        if (i != this.f3114w) {
            invalidate();
        }
        this.f3114w = i;
        int i2 = i & 112;
        if (i2 != 48) {
            if (i2 != 80) {
                this.f3082K = RecyclerView.f7068F0;
            } else {
                this.f3082K = 1.0f;
            }
        } else {
            this.f3082K = -1.0f;
        }
        int i3 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 8388611) {
                    if (i3 != 8388613) {
                        this.f3081J = RecyclerView.f7068F0;
                        return;
                    }
                }
            }
            this.f3081J = 1.0f;
            return;
        }
        this.f3081J = -1.0f;
    }

    @RequiresApi(21)
    public void setRound(float f) {
        boolean z;
        if (Float.isNaN(f)) {
            this.f3098g = f;
            float f2 = this.f3097f;
            this.f3097f = -1.0f;
            setRoundPercent(f2);
            return;
        }
        if (this.f3098g != f) {
            z = true;
        } else {
            z = false;
        }
        this.f3098g = f;
        if (f != RecyclerView.f7068F0) {
            if (this.f3093b == null) {
                this.f3093b = new Path();
            }
            if (this.f3100i == null) {
                this.f3100i = new RectF();
            }
            if (this.f3099h == null) {
                fp1 fp1Var = new fp1(this, 1);
                this.f3099h = fp1Var;
                setOutlineProvider(fp1Var);
            }
            setClipToOutline(true);
            this.f3100i.set(RecyclerView.f7068F0, RecyclerView.f7068F0, getWidth(), getHeight());
            this.f3093b.reset();
            Path path = this.f3093b;
            RectF rectF = this.f3100i;
            float f3 = this.f3098g;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f) {
        boolean z;
        if (this.f3097f != f) {
            z = true;
        } else {
            z = false;
        }
        this.f3097f = f;
        if (f != RecyclerView.f7068F0) {
            if (this.f3093b == null) {
                this.f3093b = new Path();
            }
            if (this.f3100i == null) {
                this.f3100i = new RectF();
            }
            if (this.f3099h == null) {
                fp1 fp1Var = new fp1(this, 0);
                this.f3099h = fp1Var;
                setOutlineProvider(fp1Var);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f3097f) / 2.0f;
            this.f3100i.set(RecyclerView.f7068F0, RecyclerView.f7068F0, width, height);
            this.f3093b.reset();
            this.f3093b.addRoundRect(this.f3100i, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f) {
        this.f3102k = f;
    }

    public void setText(CharSequence charSequence) {
        this.f3106o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f) {
        this.f3088Q = f;
        m623c();
        invalidate();
    }

    public void setTextBackgroundPanY(float f) {
        this.f3089R = f;
        m623c();
        invalidate();
    }

    public void setTextBackgroundRotate(float f) {
        this.f3091T = f;
        m623c();
        invalidate();
    }

    public void setTextBackgroundZoom(float f) {
        this.f3090S = f;
        m623c();
        invalidate();
    }

    public void setTextFillColor(int i) {
        this.f3094c = i;
        invalidate();
    }

    public void setTextOutlineColor(int i) {
        this.f3095d = i;
        this.f3096e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f) {
        this.f3105n = f;
        this.f3096e = true;
        if (Float.isNaN(f)) {
            this.f3105n = 1.0f;
            this.f3096e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f) {
        this.f3081J = f;
        invalidate();
    }

    public void setTextPanY(float f) {
        this.f3082K = f;
        invalidate();
    }

    public void setTextSize(float f) {
        float f2;
        this.f3101j = f;
        if (!Float.isNaN(this.f3102k)) {
            f = this.f3102k;
        }
        this.f3092a.setTextSize(f);
        if (Float.isNaN(this.f3102k)) {
            f2 = 1.0f;
        } else {
            f2 = this.f3101j / this.f3102k;
        }
        m621a(f2);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f) {
        this.f3079H = f;
        m623c();
        invalidate();
    }

    public void setTextureWidth(float f) {
        this.f3080I = f;
        m623c();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        TextPaint textPaint = this.f3092a;
        if (!Objects.equals(textPaint.getTypeface(), typeface)) {
            textPaint.setTypeface(typeface);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public void layout(float f, float f2, float f3, float f4) {
        int i = (int) (f + 0.5f);
        this.f3117z = f - i;
        int i2 = (int) (f3 + 0.5f);
        int i3 = i2 - i;
        int i4 = (int) (f4 + 0.5f);
        int i5 = (int) (0.5f + f2);
        int i6 = i4 - i5;
        float f5 = f3 - f;
        this.f3072A = f5;
        float f6 = f4 - f2;
        this.f3073B = f6;
        if (this.f3078G != null) {
            this.f3072A = f5;
            this.f3073B = f6;
            m623c();
        }
        if (getMeasuredHeight() == i6 && getMeasuredWidth() == i3) {
            super.layout(i, i5, i2, i4);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            super.layout(i, i5, i2, i4);
        }
        if (this.f3116y) {
            Rect rect = this.f3085N;
            TextPaint textPaint = this.f3092a;
            if (rect == null) {
                this.f3086O = new Paint();
                this.f3085N = new Rect();
                this.f3086O.set(textPaint);
                this.f3087P = this.f3086O.getTextSize();
            }
            this.f3072A = f5;
            this.f3073B = f6;
            Paint paint = this.f3086O;
            String str = this.f3106o;
            paint.getTextBounds(str, 0, str.length(), this.f3085N);
            float height = this.f3085N.height() * 1.3f;
            float f7 = (f5 - this.f3110s) - this.f3109r;
            float f8 = (f6 - this.f3112u) - this.f3111t;
            float width = this.f3085N.width();
            if (width * f8 > height * f7) {
                textPaint.setTextSize((this.f3087P * f7) / width);
            } else {
                textPaint.setTextSize((this.f3087P * f8) / height);
            }
            if (this.f3096e || !Float.isNaN(this.f3102k)) {
                m621a(Float.isNaN(this.f3102k) ? 1.0f : this.f3101j / this.f3102k);
            }
        }
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3092a = new TextPaint();
        this.f3093b = new Path();
        this.f3094c = 65535;
        this.f3095d = 65535;
        this.f3096e = false;
        this.f3097f = RecyclerView.f7068F0;
        this.f3098g = Float.NaN;
        this.f3101j = 48.0f;
        this.f3102k = Float.NaN;
        this.f3105n = RecyclerView.f7068F0;
        this.f3106o = "Hello World";
        this.f3107p = true;
        this.f3108q = new Rect();
        this.f3109r = 1;
        this.f3110s = 1;
        this.f3111t = 1;
        this.f3112u = 1;
        this.f3114w = 8388659;
        this.f3115x = 0;
        this.f3116y = false;
        this.f3079H = Float.NaN;
        this.f3080I = Float.NaN;
        this.f3081J = RecyclerView.f7068F0;
        this.f3082K = RecyclerView.f7068F0;
        this.f3083L = new Paint();
        this.f3084M = 0;
        this.f3088Q = Float.NaN;
        this.f3089R = Float.NaN;
        this.f3090S = Float.NaN;
        this.f3091T = Float.NaN;
        m622b(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3092a = new TextPaint();
        this.f3093b = new Path();
        this.f3094c = 65535;
        this.f3095d = 65535;
        this.f3096e = false;
        this.f3097f = RecyclerView.f7068F0;
        this.f3098g = Float.NaN;
        this.f3101j = 48.0f;
        this.f3102k = Float.NaN;
        this.f3105n = RecyclerView.f7068F0;
        this.f3106o = "Hello World";
        this.f3107p = true;
        this.f3108q = new Rect();
        this.f3109r = 1;
        this.f3110s = 1;
        this.f3111t = 1;
        this.f3112u = 1;
        this.f3114w = 8388659;
        this.f3115x = 0;
        this.f3116y = false;
        this.f3079H = Float.NaN;
        this.f3080I = Float.NaN;
        this.f3081J = RecyclerView.f7068F0;
        this.f3082K = RecyclerView.f7068F0;
        this.f3083L = new Paint();
        this.f3084M = 0;
        this.f3088Q = Float.NaN;
        this.f3089R = Float.NaN;
        this.f3090S = Float.NaN;
        this.f3091T = Float.NaN;
        m622b(context, attributeSet);
    }
}
